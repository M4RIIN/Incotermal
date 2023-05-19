import { Component, HostListener, Input, OnInit } from '@angular/core';
import Chart from 'chart.js/auto'
import { SupplyChain } from 'src/assets/model/model';
import { defaultBarDataSet } from 'src/assets/utils/chart.util';

@Component({
  selector: 'app-result-chart',
  templateUrl: './result-chart.component.html',
  styleUrls: ['./result-chart.component.css']
})
export class ResultChartComponent implements OnInit {

  public chart: any;

  @Input() supplyChain: SupplyChain = new SupplyChain();

  constructor() { }

  ngOnInit(): void {
    this.createChart();

  }

  @HostListener('window:resize', ['$event'])
onResize(event:any) {
  console.log("resize")
  this.chart.resize();
}

  createChart(){

    this.chart = new Chart("MyChart", {
      type: 'line', //this denotes tha type of chart

      data: {// values on X-Axis
        labels: this.getEtapesNameArray(),
        datasets: this.createDataSet()
	      //  datasets: [
        //   {
        //     // label: "Fournisseur",
        //     // data: this.getSumPartiePrenanteEtape("FOURNISSEUR"),
        //     // backgroundColor: 'blue'
        //     defaultLineDataSet
        //   },
        //   {
        //     label: "Acheteur",
        //     data: this.getSumPartiePrenanteEtape("ACHETEUR"),
        //     backgroundColor: 'limegreen'
        //   }
      },
      options: {
        aspectRatio:2.5
      }

    });
  }

  createDataSet(){
    let fournisseurData = {...defaultBarDataSet};
    fournisseurData.data = this.getSumPartiePrenanteEtape("FOURNISSEUR");
    fournisseurData.label = "Fournisseur"

    let acheteurData = {...defaultBarDataSet};
    acheteurData.data = this.getSumPartiePrenanteEtape("ACHETEUR")
    acheteurData.label = "Acheteur"

    let nonGereData = {...defaultBarDataSet};
    nonGereData.data = this.getSumPartiePrenanteEtape("UNDEFINED")
    nonGereData.label = "Non géré"
    const res = [fournisseurData,acheteurData,nonGereData]
    console.log(res);
    return res;
  }

  private getEtapesNameArray():string[]{
    return this.supplyChain.etapes.map(etape => etape.type);
  }

  private getSumPartiePrenanteEtape(partiePrenante:string) : number[] {
    // return this.supplyChain.suiviCouts.coutAssocies
    // .map(ca => ca.etape).map(etape => etape.coutEtape).map(ce => ce.reduce((sum,current)=> sum + current.cout,0));
    let etapeCostArray: number[] = [];
    this.supplyChain.etapes.forEach(etape => {
      etapeCostArray.push(
        this.supplyChain.suiviCouts.coutAssocies.filter(ca => ca.partiePrenante === partiePrenante && ca.etape.type === etape.type)
        .map(ca => ca.etape.coutEtape).reduce((sum,current)=>sum+ current.reduce((s,c)=>s+c.cout,0),0)
      )
    })
    return etapeCostArray;
  }

}
