import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SuiviCoupListResponse, SuiviCouts, SupplyChain } from 'src/assets/model/model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SupplyChainService {

  constructor(private http: HttpClient) { }

  getTest(){
    return this.http.get(environment.baseUrl + "/test",{responseType :'text'});
  }

  getSupplyChainInit(){
    return this.http.get<SupplyChain>(environment.baseUrl + "/supply-chain?incoterm=FOB",{responseType :'json'});
  }

  getSimulationResult(supplyChain: SupplyChain){
    return this.http.post<SuiviCouts>(environment.baseUrl + "/supply-chain",supplyChain, {responseType : 'json'});
  }

  getComparaisonResult(supplyChain: SupplyChain,types:string[]){
    return this.http.post<SuiviCoupListResponse>(environment.baseUrl + "/supply-chain/compare?types="+types.join(','),supplyChain, {responseType : 'json'});
  }
}
