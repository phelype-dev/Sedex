import { Observable } from 'rxjs';
import { DestinatarioModel } from './../models/destinatario.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DestinatariosService {

  constructor(
    private http: HttpClient
  ) { }

  onSave(destinatario: DestinatarioModel): Observable<DestinatarioModel> {
    return this.http.post<DestinatarioModel>(`${environment.API}/destinatario`, destinatario);
  }

  getAllDestinatarios(): Observable<DestinatarioModel> {
    return this.http.get<DestinatarioModel>(`${environment.API}/destinatario`);
  }
}
