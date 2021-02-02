import { Observable } from 'rxjs';
import { RegSedexModel } from './../models/regSedexModel';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegsedexService {

  constructor(
    private http: HttpClient
  ) { }

  onSave(regsedex: RegSedexModel): Observable<RegSedexModel> {
    return this.http.post<RegSedexModel>(`${environment.API}/regsedex`, regsedex);
  }

  buscaPorId(id: RegSedexModel): Observable<RegSedexModel> {
    return this.http.get<RegSedexModel>(`${environment.API}/regsedex/${id}`);
  }

  aguardandoEnvio(): Observable<RegSedexModel> {
    return this.http.get<RegSedexModel>(`${environment.API}/regsedex/semdespacho`);
  }

  sedexEnviados(): Observable<RegSedexModel> {
    return this.http.get<RegSedexModel>(`${environment.API}/regsedex/enviados`);
  }

  updateForm(regsedex: RegSedexModel): Observable<RegSedexModel> {
    return this.http.put<RegSedexModel>(`${environment.API}/regsedex/update/`, regsedex);
  }

  updateRegSedex(id: number, value: RegSedexModel): Observable<RegSedexModel> {
    return this.http.put<RegSedexModel>(`${environment.API}/regsedex/update/${id}`, value);
  }
}
