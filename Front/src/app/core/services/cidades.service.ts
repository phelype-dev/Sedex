import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CidadeModel } from '../models/Cidade.model';

@Injectable({
  providedIn: 'root'
})
export class CidadesService {

  constructor(
    private http: HttpClient
  ) { }

  getAllCidades(): Observable<CidadeModel>{
    return this.http.get<CidadeModel>(`${environment.API}/cidade`);
  }

  getAllCidadeByEstado(est_codigo:CidadeModel): Observable<CidadeModel>{
    return this.http.get<CidadeModel>(`${environment.API}/cidade/estados/${est_codigo}`);
  }
}
