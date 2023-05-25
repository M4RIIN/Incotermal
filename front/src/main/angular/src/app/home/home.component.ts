import { Component, OnInit } from '@angular/core';
import { SupplyChainService } from '../services/supply-chain.service';
import { SupplyChain } from 'src/assets/model/model';
import { MatDialog } from '@angular/material/dialog';
import { ResultDialogComponent } from '../result-dialog/result-dialog.component';
import { cif_desc, fas_desc, fob_desc } from 'src/assets/const';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 supplyChain: SupplyChain = new SupplyChain();
 panelOpenState = true;
  definitionIncoterm = "";


  constructor(private supplyChainService: SupplyChainService,public dialog: MatDialog) {
    this.supplyChainService.getSupplyChainInit().subscribe(res => {
      this.supplyChain = res;
      this.onIncotermChange({value: this.supplyChain.incoterm.type});
      console.log("fin appel")
    })
   }

  ngOnInit(): void {

  }

  simulate(){
    console.log(this.supplyChain)
    this.supplyChainService.getSimulationResult(this.supplyChain).subscribe(res =>{
      this.supplyChain.suiviCouts = res;
      const dialogRef = this.dialog.open(ResultDialogComponent, {
        data: this.supplyChain,
        width: "100%",
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
      });
    })
  }

  onIncotermChange(incoterm:any){
    switch (incoterm.value) {
      case "CIF":
         this.definitionIncoterm =  cif_desc;
        break;
      case "FAS":
        this.definitionIncoterm = fas_desc;
      break;
      case "FOB":
       this.definitionIncoterm = fob_desc;
      break;
      default:
         this.definitionIncoterm = "Selectionnez un incoterm"
        break;
    }
  }

  getFirstCharDesc(){
    return this.definitionIncoterm[0];
  }

  getSlicedCharDesc(){
    return this.definitionIncoterm.slice(1);
  }

  randomData(){
    this.supplyChain.etapes.forEach(etape =>{
      etape.coutEtape.forEach(coutEtape =>{
        let randomValue =Math.floor(Math.random() * 5000);
        coutEtape.cout = randomValue;
      })
    })
  }

}
