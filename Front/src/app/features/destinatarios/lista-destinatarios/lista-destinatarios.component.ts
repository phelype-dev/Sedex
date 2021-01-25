import { Router } from '@angular/router';
import { DestinatariosService } from './../../../core/services/destinatarios.service';
import { Component, OnInit } from '@angular/core';
import { DestinatarioModel } from 'src/app/core/models/destinatario.model';

@Component({
  selector: 'app-lista-destinatarios',
  templateUrl: './lista-destinatarios.component.html',
  styleUrls: ['./lista-destinatarios.component.css']
})
export class ListaDestinatariosComponent implements OnInit {

  destinatario: DestinatarioModel;

  constructor(
    private destinatarioService: DestinatariosService,
    private route: Router
  ) {

    this.destinatarioService.getAllDestinatarios().subscribe(data => {
      if (data == null) {
        alert('Não existe registro');
      } else {
        this.destinatario = data;
        console.log(this.destinatario);
      }
    });

  }

  ngOnInit(): void {
  }

  novoCadastro() {
    this.route.navigate(['main/destinatarios/novo-registro']);
  }

}
