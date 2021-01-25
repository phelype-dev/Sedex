import { environment } from './../../../environments/environment';
import { RemetentesModule } from './../../features/remetentes/remetentes.module';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RemetenteModel } from '../models/rememetente.model';

@Injectable({
  providedIn: 'root'
})
export class RemetenteService {

  constructor(
    private http: HttpClient
  ) { }

  getAllRemetente(): Observable<RemetenteModel> {
    return this.http.get<RemetenteModel>(`${environment.API}/remetente`);
  }

  saveRementente(remetente: RemetenteModel): Observable<RemetenteModel> {
    return this.http.post<RemetenteModel>(`${environment.API}/remetente`,remetente);
  }

}
