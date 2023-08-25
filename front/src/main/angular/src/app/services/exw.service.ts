import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CoutRevientMargeCommercialeRest } from 'src/assets/model/model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ExwService {

  constructor(private http: HttpClient) { }

  getCrAndMc(cout: CoutRevientMargeCommercialeRest){
    return this.http.post<number>(environment.baseUrl + "/cout-revient-marge-com",cout);
  }

  getPVUAdnQ(cout:any){
    return this.http.post<number>(environment.baseUrl + "/vente-unitaire",cout);
  }

  getPVAndPE(cout:any){
    return this.http.post<number>(environment.baseUrl + "/vente-produit",cout);
  }
}
