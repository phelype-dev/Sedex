import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EstadoModel } from '../models/Estado.model';

@Injectable({
  providedIn: 'root'
})
export class EstadosService {

  constructor(
    private http: HttpClient
  ) {}

    HttpErrorResponse = {
      headers: new HttpHeaders({'Content-type': 'application/json'})
    }

  getAllEstados(): Observable<EstadoModel> {
    return this.http.get<EstadoModel>(`${environment.API}/estado`)
    .pipe(
      retry(2),
      catchError(this.handleError)
    )
  }
  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };
}
