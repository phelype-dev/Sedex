import { environment } from './../../../environments/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegItens } from '../models/regItens.model';

@Injectable({
  providedIn: 'root'
})
export class RegItensService {

  constructor(
    private http: HttpClient
  ) { }

  save(itens: RegItens): Observable<RegItens> {
    return this.http.post<RegItens>(`${environment.API}/regitens`, itens);
  }

  getItenById(id: RegItens): Observable<RegItens> {
    return this.http.get<RegItens>(`${environment.API}/regitens/itens/${id}`);
  }
}
