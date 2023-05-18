import { Component, OnInit } from '@angular/core';
import { SupplyChainService } from '../services/supply-chain.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 backRestult = "None"

  constructor(private supplyChainService: SupplyChainService) { }

  ngOnInit(): void {
    this.supplyChainService.getTest().subscribe(res => {
      this.backRestult = res;
      console.log("fin appel")
    })
  }

}
