import { Component, OnInit } from '@angular/core';
import { ExwService } from '../services/exw.service';
import { MatDialog } from '@angular/material/dialog';
import { CoutRevientMargeCommercialeRest, PrixVenteProduitEtEmballageRest, PrixVenteUnitaireRest } from 'src/assets/model/model';
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

  masseBruteProduitEtEmballage = 0;
  masseBruteEmballage =0 ;
  prixProduitUnitaire =0;
  prixEmballageUnitaire =0;

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

    this.exwService.getCrAndMc(coutRevientMargeCommercialeRest).subscribe(res =>{
      this.displayResEXW(res);
    });
     
  }

  calculPVUAndQ(){
    let cout = new PrixVenteUnitaireRest();
    cout.prixVenteUnitaire = this.prixVenteUnitaire;
    cout.quantite = this.quantity;
    this.exwService.getPVUAdnQ(cout).subscribe(res => {
      this.displayResEXW(res);
    })
  }

  calculPVPAndE(){
    let cout = new PrixVenteProduitEtEmballageRest();
    cout.quantite = this.quantity;
    cout.masseBruteProduitEtEmballage = this.masseBruteProduitEtEmballage;
    cout.masseBruteEmballage = this.masseBruteEmballage;
    cout.prixProduitUnitaire = this.prixProduitUnitaire;
    cout.prixEmballageUnitaire = this.prixEmballageUnitaire;
    this.exwService.getPVAndPE(cout).subscribe(res => {
      this.displayResEXW(res);
    })
  }

  private displayResEXW(res:any){
    console.log(res);
    const dialogRef = this.dialog.open(ResultEXWDialogComponent, {
      data: res,
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}
