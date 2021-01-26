import { FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { RegSedexModel } from './../../../core/models/regSedexModel';
import { RegsedexService } from './../../../core/services/regsedex.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-lista-dashboard',
  templateUrl: './lista-dashboard.component.html',
  styleUrls: ['./lista-dashboard.component.css']
})



export class ListaDashboardComponent implements OnInit {

  regsedex: RegSedexModel;
  total: any;
  btnNovoRegistro: boolean;
  formIsAtivo: boolean;
  displayModal: boolean;
  idreg: any;
  reg: RegSedexModel;
  form: FormGroup;
  codBarras: any;

  constructor(
    private regSedexService: RegsedexService,
    private router: Router,
    private route: ActivatedRoute
  ) {



    this.regSedexService.aguardandoEnvio().subscribe(regsedex => {
      this.regsedex = regsedex;
      console.log(this.regsedex);
    });
  }

  ngOnInit(): void {
  }

  click() {
    this.router.navigate(['/main/dashboard/novo-registro']);
  }

  imprimir() {
    this.router.navigate(['main/etiqueta']);
  }

  showModalDialog(event: any) {
    this.displayModal = true;
    this.idreg = event;
    this.pegaId(this.idreg);
  }

  pegaId(id: any) {
    this.regSedexService.buscaPorId(id).subscribe(data => {
      this.reg = data;
      console.log(this.codBarras);
    });
  }

  printPage() {
    window.print();
  }
}
