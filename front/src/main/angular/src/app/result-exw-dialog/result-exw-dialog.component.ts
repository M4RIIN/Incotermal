import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Etape, SupplyChain } from 'src/assets/model/model';


@Component({
  selector: 'app-result-exw-dialog',
  templateUrl: './result-exw-dialog.component.html',
  styleUrls: ['./result-exw-dialog.component.css']
})
export class ResultEXWDialogComponent implements OnInit {
  panelOpenState = false;

  constructor(
    public dialogRef: MatDialogRef<ResultEXWDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: number,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }
}
