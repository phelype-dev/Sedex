import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EmpresaModel } from '../models/empresa.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  constructor(
    private http: HttpClient
  ) { }

  getAllEmpresaTransp(): Observable<EmpresaModel>{
    return this.http.get<EmpresaModel>(`${environment.API}/empresa/transportadora`);
  }

  getAllEmpresa(): Observable<EmpresaModel> {
    return this.http.get<EmpresaModel>(`${environment.API}/empresa`);
  }

  saveToEmpresa(empresa: EmpresaModel): Observable<EmpresaModel> {
    return this.http.post<EmpresaModel>(`${environment.API}/empresa`,empresa);
  }
}
