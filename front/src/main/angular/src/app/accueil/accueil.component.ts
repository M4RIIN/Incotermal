import { Component, OnInit } from '@angular/core';
import { ExwService } from '../services/exw.service';
import { MatDialog } from '@angular/material/dialog';
import { CoutRevientMargeCommercialeRest } from 'src/assets/model/model';
import { ResultEXWDialogComponent } from '../result-exw-dialog/result-exw-dialog.component';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  quantity:number = 0;
  coutAchatMatierePremiere: number = 0;
  mainOeuvre: number = 0;
  autreChargeVariables:number = 0;
  chargesFixes:number = 0;
  conditionnement:number = 0;
  margeCommercialeDepartUsine:number = 0;

  prixVenteUnitaire:number = 0;

  constructor(private exwService: ExwService, private dialog: MatDialog) { }

  ngOnInit(): void {
  }

  calculCRMC(){
    let coutRevientMargeCommercialeRest = new CoutRevientMargeCommercialeRest();
    coutRevientMargeCommercialeRest.autreChargeVariables = this.autreChargeVariables;
    coutRevientMargeCommercialeRest.chargesFixes = this.chargesFixes;
    coutRevientMargeCommercialeRest.conditionnement = this.conditionnement;
    coutRevientMargeCommercialeRest.coutAchatMatierePremiere = this.coutAchatMatierePremiere;
    coutRevientMargeCommercialeRest.mainOeuvre = this.mainOeuvre;
    coutRevientMargeCommercialeRest.margeCommercialeDepartUsine = this.margeCommercialeDepartUsine;
    coutRevientMargeCommercialeRest.quantite = this.quantity;

    this.exwService.getSimulationResult(coutRevientMargeCommercialeRest).subscribe(res =>{
      console.log(res);
      const dialogRef = this.dialog.open(ResultEXWDialogComponent, {
        data: res,
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
      });
    })
  }

}
