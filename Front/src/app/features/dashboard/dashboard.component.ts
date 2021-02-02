import { Router } from '@angular/router';
import { CidadeModel } from './../../core/models/Cidade.model';
import { RegItensService } from './../../core/services/reg-itens.service';
import { RegItens } from './../../core/models/regItens.model';
import { TipoItemService } from './../../core/services/tipo-item.service';
import { TipoItemModel } from './../../core/models/tipoItem.model';
import { RegsedexService } from './../../core/services/regsedex.service';
import { RegSedexModel } from './../../core/models/regSedexModel';
import { Validators } from '@angular/forms';
import { FormGroup, FormBuilder } from '@angular/forms';
import { DestinatariosService } from './../../core/services/destinatarios.service';
import { CidadesService } from './../../core/services/cidades.service';
import { DestinatarioModel } from './../../core/models/destinatario.model';
import { EstadoModel } from './../../core/models/Estado.model';
import { RemetenteService } from './../../core/services/remetente.service';
import { EmpresasService } from './../../core/services/empresas.service';
import { RemetenteModel } from 'src/app/core/models/rememetente.model';
import { EmpresaModel } from './../../core/models/empresa.model';
import { Component, OnInit } from '@angular/core';
import { EstadosService } from 'src/app/core/services/estados.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: 'dashboard.component.html',
  styleUrls: ['dashboard.component.css'],
})
export class DashboardComponent implements OnInit {

  empresaModel: EmpresaModel;
  remetenteModel: RemetenteModel;
  estadoModel: EstadoModel;
  cidadeModel: CidadeModel;
  destinatarioModel: DestinatarioModel;
  formRegSedex: FormGroup;
  regsedex: RegSedexModel;
  regsedexR: RegSedexModel;
  dataPostagem = new Date();
  formItens: FormGroup;
  reg_codigos: number;
  response: Response;
  tipoItemModel: TipoItemModel;
  formItensDisabled: boolean;
  teste: number;
  regItens: RegItens;
  itensArray: any[] = [];
  cidade: CidadeModel;
  idEstado: any;
  cidadeId: any;
  destNome: DestinatarioModel;

  constructor(
    private empresaService: EmpresasService,
    private remetenteService: RemetenteService,
    private estadoService: EstadosService,
    private cidadeService: CidadesService,
    private destinatarioService: DestinatariosService,
    private fb: FormBuilder,
    private regSedexService: RegsedexService,
    private fbs: FormBuilder,
    private tipoItemService: TipoItemService,
    private regItenService: RegItensService,
    private router: Router
  ) {

    this.empresaService.getAllEmpresaTransp().subscribe(data => {
      this.empresaModel = data;
    });

    this.remetenteService.getAllRemetente().subscribe(data => {
      this.remetenteModel = data;
    });

    this.estadoService.getAllEstados().subscribe(data => {
      this.estadoModel = data;
    });

    this.cidadeService.getAllCidades().subscribe(data => {
      this.cidadeModel = data;
    });

    this.destinatarioService.getAllDestinatarios().subscribe(data => {
      this.destinatarioModel = data;
    });

    this.tipoItemService.getAllTipoItem().subscribe(data => {
      this.tipoItemModel = data;
    });

  }

  ngOnInit() {
    this.formItensDisabled = true;
    this.configFormulario();
    this.configFormItens();
  }



  configFormulario() {
    this.formRegSedex = this.fb.group({
      emp_codigo: [null, Validators.required],
      des_codigo: [null, Validators.required],
      est_codigo: [null, Validators.required],
      cid_codigo: [null, Validators.required],
      rem_codigo: [null, Validators.required],
      sed_data_postagem: [this.dataPostagem]
    });
  }

  pegaCidadeId(event: CidadeModel) {
    this.cidadeId = event.cid_codigo;
    this.destinatarioService.getAllDestCidade(this.cidadeId).subscribe(data => {
      this.destNome = data;
    });
  }

  pegaId(event: EstadoModel) {
    this.idEstado = event.est_codigo;
    console.log(this.idEstado);
    this.cidadeService.getAllCidadeByEstado(this.idEstado).subscribe(data => {
      this.cidade = data;
    });
  }


  saveRegistro() {
    this.regSedexService.onSave(this.formRegSedex.value).subscribe(data => {
      this.regsedex = data;
      this.reg_codigos = this.regsedex.sed_codigo;
      console.log(this.regsedex);
      console.log(this.reg_codigos);
      this.formItensDisabled = false;
      this.configFormItens();
      this.buscarid(this.regsedex.sed_codigo);
    });

  }

  buscarid(id) {
    this.regSedexService.buscaPorId(id).subscribe(data => {
      this.regsedexR = data;
      console.log(this.regsedexR);
    });

  }

  configFormItens() {
    this.formItens = this.fbs.group({
      sed_codigo: [this.regsedex],
      tit_codigo: [null],
      ips_descricao: [null],
      equ_codigo: [null],
      ips_codigo_equip: [null],
      ips_cod_ra: [null],
    });
  }


  saveItens() {
    this.regItenService.save(this.formItens.value).subscribe(data => {
      this.regItens = data;
      this.itensArray.push(this.regItens);

      console.log(this.itensArray);
    });
  }

  sair() {
    this.router.navigate(['main/dashboard']);
  }
}
