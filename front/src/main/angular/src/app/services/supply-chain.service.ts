import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SupplyChainService {

  constructor(private http: HttpClient) { }

  getTest(){
    return this.http.get(environment.baseUrl + "/test",{responseType :'text'});
  }
}
