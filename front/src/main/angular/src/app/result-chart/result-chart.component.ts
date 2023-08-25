
import { Component, HostListener, Input, OnInit } from '@angular/core';
import Chart from 'chart.js/auto'
import { SupplyChain } from 'src/assets/model/model';
import { defaultBarDataSet, defaultLineDataSet } from 'src/assets/utils/chart.util';
import { SupplyChainService } from '../services/supply-chain.service';

@Component({
  selector: 'app-result-chart',
  templateUrl: './result-chart.component.html',
  styleUrls: ['./result-chart.component.css']
})
export class ResultChartComponent implements OnInit {

  public chart: any ;
   options = {
    plugins: {
    legend: {
      display: false  // Cacher la légende
      }
    },
    responsive:true,

  };

  incoterms = ["FOB","CIF","FAS"]

  @Input() supplyChain: SupplyChain = new SupplyChain();

  typesComparaison = [];


  constructor(private supplyChainService: SupplyChainService) { }

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
      //this denotes tha type of chart

      data: {// values on X-Axis
        labels: this.getEtapesNameArray(),
        datasets:   this.createDataSet(this.supplyChain,"0.8","bar",this.supplyChain.incoterm.type),

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
      options: this.options

    });

  }

  createDataSet(supplyChain:SupplyChain,transparency:string,type:string,incoterm:string){
    let fournisseurData = this.createDataSetForPartiePrenant("FOURNISSEUR","rgba(99,168,133,"+transparency+")",supplyChain,type,incoterm)
    //let acheteurDataa = this.createDataSetForPartiePrenant("ACHETEUR","rgba(0,120,0,0.5)")
    let acheteurData = this.createDataSetForPartiePrenant("ACHETEUR","rgba(108,165,245,0"+transparency+")",supplyChain,type,incoterm)
    let nonGereData = this.createDataSetForPartiePrenant("UNDEFINED","rgba(245,170,120,"+transparency+")",supplyChain,type,incoterm)

    const res = [fournisseurData,acheteurData,nonGereData]

    return res;
  }

  createDataSetForPartiePrenant(partiePrenante:string, color:string,supplyChain:SupplyChain,type:string,incoterm:string){
    let dataSet:any = {};
    dataSet.thickness = 20;
    dataSet.type = type;
    if(type === 'line'){
      dataSet.fill = true;
    }
    dataSet.data = this.getSumPartiePrenanteEtape(partiePrenante,supplyChain);
    dataSet.label = partiePrenante[0] + partiePrenante.toLowerCase().slice(1) + ' - ' + incoterm;
    dataSet.backgroundColor = color;
    return dataSet;
  }

  private getEtapesNameArray():string[]{
    return this.supplyChain.etapes.map(etape => etape.type);
  }

  private getSumPartiePrenanteEtape(partiePrenante:string,supplyChain: SupplyChain) : number[] {
    // return this.supplyChain.suiviCouts.coutAssocies
    // .map(ca => ca.etape).map(etape => etape.coutEtape).map(ce => ce.reduce((sum,current)=> sum + current.cout,0));
    let etapeCostArray: number[] = [];
    supplyChain.etapes.forEach(etape => {
      etapeCostArray.push(
        supplyChain.suiviCouts.coutAssocies.filter(ca => ca.partiePrenante === partiePrenante && ca.etape.type === etape.type)
        .map(ca => ca.etape.coutEtape).reduce((sum,current)=>sum+ current.reduce((s,c)=>s+c.cout,0),0)
      )
    })
    return etapeCostArray;
  }


  compare(){
    this.chart.data.datasets = this.createDataSet(this.supplyChain,"0.8","bar",this.supplyChain.incoterm.type);
    this.chart.update();
    this.supplyChainService.getComparaisonResult(this.supplyChain,this.typesComparaison).subscribe(res =>{
      res.suivisCouts.forEach((sc,index) =>{
        let newSupply = {...this.supplyChain}
        newSupply.suiviCouts = sc;
        const newDatasets = this.createDataSet(newSupply,"0.3",'bar',this.typesComparaison[index]);
        newDatasets.forEach((ds) =>{

          this.chart.data.datasets.push(ds);
          this.chart.update();
        })
        console.log("new chart",this.chart.data)
        this.getTotalFournisseur('CIF');
      })
    })
  }

  getIncotermListWithoutActual(){
    return this.incoterms.filter(i => i !== this.supplyChain.incoterm.type)
  }

  getTotalFournisseur(incoterm:string){
  let totalFournisseur = this.chart.data.datasets[0].data.reduce((sum:any,current:any)=> sum + current,0)
  let totalnewFournisseur = this.chart.data?.datasets?.filter((elt:any) => elt.label.includes(incoterm) && elt.label.toLowerCase().includes('fournisseur') )[0]?.data.reduce((sum:any,current:any)=> sum + current,0)
  let surCent = (totalnewFournisseur * 100)/totalFournisseur;
  return (surCent-100);
  }

  getTotalAcheteur(incoterm:string){
    let totalFournisseur = this.chart.data.datasets[0].data.reduce((sum:any,current:any)=> sum + current,0)
    let totalnewFournisseur = this.chart.data?.datasets?.filter((elt:any) => elt.label.includes(incoterm) && elt.label.toLowerCase().includes('acheteur') )[0]?.data.reduce((sum:any,current:any)=> sum + current,0)
    let surCent = (totalnewFournisseur * 100)/totalFournisseur;
    return (surCent-100);
    }

}
