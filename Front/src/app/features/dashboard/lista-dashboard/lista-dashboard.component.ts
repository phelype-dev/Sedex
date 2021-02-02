import { RegItensService } from './../../../core/services/reg-itens.service';
import { RegItens } from './../../../core/models/regItens.model';
import { DestinatarioModel } from './../../../core/models/destinatario.model';
import { EstadoModel } from './../../../core/models/Estado.model';
import { DestinatariosService } from './../../../core/services/destinatarios.service';
import { EstadosService } from './../../../core/services/estados.service';
import { RemetenteService } from './../../../core/services/remetente.service';
import { RemetenteModel } from './../../../core/models/rememetente.model';
import { EmpresasService } from './../../../core/services/empresas.service';
import { EmpresaModel } from './../../../core/models/empresa.model';
import { CidadesService } from './../../../core/services/cidades.service';
import { CidadeModel } from './../../../core/models/Cidade.model';
import { disableCursor } from '@fullcalendar/core';
import { FormGroup, FormBuilder } from '@angular/forms';
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
  sedex: RegSedexModel;
  total: any;
  btnNovoRegistro: boolean;
  formIsAtivo: boolean;
  displayModal: boolean;
  idreg: any;
  reg: RegSedexModel;
  form: FormGroup;
  codBarras: any;
  displayObs = false;
  formulario: FormGroup;
  cidade: CidadeModel;
  empresa: EmpresaModel;
  remetente: RemetenteModel;
  estados: EstadoModel;
  destinatarios: DestinatarioModel;
  dataPostagem = new Date();
  displayDetails: boolean;
  detailsReg: RegSedexModel;
  regitens: RegItens;

  constructor(
    private regSedexService: RegsedexService,
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private cidadesService: CidadesService,
    private empresaService: EmpresasService,
    private remetenteService: RemetenteService,
    private estadoService: EstadosService,
    private destinatarioService: DestinatariosService,
    private regItenService: RegItensService
  ) {

    this.cidadesService.getAllCidades().subscribe(data => {
      this.cidade = data;
    });

    this.remetenteService.getAllRemetente().subscribe(data => {
      this.remetente = data;
    });

    this.estadoService.getAllEstados().subscribe(data => {
      this.estados = data;
    });

    this.destinatarioService.getAllDestinatarios().subscribe(data => {
      this.destinatarios = data;
    });

    this.empresaService.getAllEmpresa().subscribe(data => {
      this.empresa = data;
    });

    this.regSedexService.aguardandoEnvio().subscribe(regsedex => {
      this.regsedex = regsedex;
      console.log(this.regsedex);
    });
  }

  ngOnInit(): void {
    this.formInsert();
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

  showObs(event) {
    this.displayObs = true;
    this.idreg = event;
    this.pegaId(this.idreg);
  }

  pegaId(id: any) {
    this.regSedexService.buscaPorId(id).subscribe(data => {
      this.reg = data;
      this.formUpdate(this.reg);
    });
  }

  printPage() {
    window.print();
  }

  formInsert() {
    this.formulario = this.fb.group({
      sed_codigo: [null],
      sed_data_postagem: [null],
      emp_codigo: [null],
      rem_codigo: [null],
      cid_codigo: [null],
      est_codigo: [null],
      des_codigo: [null],
      sed_codigo_rastreio: [null],
      sed_valor: [null],
      sed_pago: [null],
      sed_extraviou: [null],
      sed_operador: [null],
      sed_data_modificacao: [this.dataPostagem],
    });
  }

  formUpdate(registro) {
    this.formulario.patchValue({
      sed_codigo: registro.sed_codigo,
      sed_data_postagem: registro.sed_data_postagem,
      emp_codigo: registro.emp_codigo,
      rem_codigo: registro.rem_codigo,
      cid_codigo: registro.cid_codigo,
      est_codigo: registro.est_codigo,
      des_codigo: registro.des_codigo,
      sed_codigo_rastreio: registro.sed_codigo_rastreio,
      sed_valor: registro.sed_valor,
      sed_pago: registro.sed_pago,
      sed_extraviou: registro.sed_extraviou,
      sed_operador: registro.sed_operador,
    });
  }

  updateForms() {
    this.regSedexService.updateRegSedex(this.idreg, this.formulario.value).subscribe(data => {
      this.sedex = data;
      console.log(this.sedex);
      this.displayObs = false;
      this.toDoList();
    });
  }

  toDoList() {
    this.regSedexService.aguardandoEnvio().subscribe(regsedex => {
      this.regsedex = regsedex;
    });
  }

  openDetails(event) {
    this.displayDetails = true;
    this.idreg = event;
    this.showDetails(this.idreg);
  }

  showDetails(id) {
    this.regSedexService.buscaPorId(id).subscribe(data => {
      this.detailsReg = data;
      console.log(this.detailsReg);
    });

    this.regItenService.getItenById(id).subscribe(data => {
      this.regitens = data;
      console.log(this.regitens);
    });
  }

  openSedexSends() {
    this.router.navigate(['/main/sedex-enviados']);
  }
}
