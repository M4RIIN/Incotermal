import { AfterViewInit, Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import Chart from 'chart.js/auto';

@Component({
  selector: 'app-donot-comparaison',
  templateUrl: './donot-comparaison.component.html',
  styleUrls: ['./donot-comparaison.component.css']
})
export class DonotComparaisonComponent implements OnInit, AfterViewInit,OnChanges {
  doughnutChart:any = {};
  @Input() name = ""
  @Input() val1 = 0
  @Input() pp = ""
  @Input() inco = ""
  val2 =0;
  dataSet:any = {data : {dataSet: []}};
  mot : string = "";
  constructor() { }


  ngOnChanges(changes: SimpleChanges): void {
    if(changes["val1"]?.currentValue !== undefined && changes ){
      console.log("hooooooooooooo" + this.inco + this.pp,this.val1);
      let color = "rgba(100,100,100,0.2)";
      if(this.val1 < 0){
       color = "rgba(99,168,133,0.8)"
       this.val1 = this.val1 * (-1);
       this.mot = "Gain"
      }else{
        color = "rgba(250,110,102,0.8)"
        this.mot = "Perte"
      }
      this.val2 = 100 - this.val1;
      this.dataSet ={
        data: [this.val1, this.val2], // Remplacez ces valeurs par vos propres données
        backgroundColor: [color, 'rgba(100,100,100,0.2)'  ], // Couleurs de fond pour chaque tranche
        borderWidth: 1 // Largeur de la bordure du graphique
      }
      if(this.doughnutChart?.data){
        this.doughnutChart.data.datasets.push(this.dataSet);
      }
    }
  }


  ngAfterViewInit(): void {
      const canvas = document.getElementById(this.name) as HTMLCanvasElement;
      const ctx = canvas.getContext('2d');
      this.doughnutChart = new Chart((ctx as CanvasRenderingContext2D), {
        type: 'doughnut',
        data: {
          labels: ['Label 1', 'Label 2'],
          datasets: [this.dataSet]
        },
        options: {
          responsive: true,
          maintainAspectRatio: false,
          plugins:{
            legend:{
              display:false
            }
          }
        }
      });
  }

  ngOnInit(): void {

  }

}
