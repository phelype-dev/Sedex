import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TipoEmpresaModel } from '../models/tipo-empresa.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TipoEmpresaService {

  constructor(
    private http: HttpClient
  ) { }

  getAllTipoEmpresa(): Observable<TipoEmpresaModel> {
    return this.http.get<TipoEmpresaModel>(`${environment.API}/tipoempresa`);
  }
}
