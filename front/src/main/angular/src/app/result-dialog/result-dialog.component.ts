import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Etape, SupplyChain } from 'src/assets/model/model';

@Component({
  selector: 'app-result-dialog',
  templateUrl: './result-dialog.component.html',
  styleUrls: ['./result-dialog.component.css']
})
export class ResultDialogComponent implements OnInit {
  panelOpenState = false;

  constructor(
    public dialogRef: MatDialogRef<ResultDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: SupplyChain,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

  getSommeForPartiePrenant(partiePrenante: string): number{
    return this.data.suiviCouts.coutAssocies.filter(elt => elt.partiePrenante === partiePrenante).map(elt => elt.etape)
    .map(et => et.coutEtape.reduce((sum,current)=> sum + current.cout,0)).reduce((sum,current)=> sum+ current,0);
  }

  getEtapeForPartiePrenant(partiePrenante: string): Etape[]{
    return this.data.suiviCouts.coutAssocies.filter(elt => elt.partiePrenante === partiePrenante).map(elt => elt.etape);
  }

}
