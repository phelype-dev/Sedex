import { TipoItemModel } from './../models/tipoItem.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TipoItemService {

  constructor(
    private http: HttpClient
  ) { }

  getAllTipoItem(): Observable<TipoItemModel> {
    return this.http.get<TipoItemModel>(`${environment.API}/tipoitem`);
  }
}
