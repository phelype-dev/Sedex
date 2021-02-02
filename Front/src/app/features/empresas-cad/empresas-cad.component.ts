import { CidadeModel } from './../../core/models/Cidade.model';

import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CidadesService } from './../../core/services/cidades.service';
import { TipoEmpresaService } from './../../core/services/tipo-empresa.service';
import { TipoEmpresaModel } from './../../core/models/tipo-empresa.model';
import { EstadoModel } from './../../core/models/Estado.model';
import { EmpresasService } from './../../core/services/empresas.service';
import { Component, OnInit } from '@angular/core';
import { EmpresaModel } from 'src/app/core/models/empresa.model';
import { EstadosService } from 'src/app/core/services/estados.service';
import { Message } from 'primeng/api';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-empresas-cad',
  templateUrl: './empresas-cad.component.html',
  styleUrls: ['./empresas-cad.component.css']
})
export class EmpresasCadComponent implements OnInit {

  cols: any;
  empresa: EmpresaModel;
  cidades: CidadeModel;
  cid: CidadeModel;
  estados: EstadoModel;
  tipoEmpresa: TipoEmpresaModel;
  formEmpresa: FormGroup;
  msg: Message[] = [];
  cidade: any[] = [];
  idEstado: any;

  constructor(
    private empresaService: EmpresasService,
    private tipoEmpresaService: TipoEmpresaService,
    private cidadesService: CidadesService,
    private estadoService: EstadosService,
    private fb: FormBuilder,
    private router: Router,
    private messageService: MessageService
  ) {

    this.empresaService.getAllEmpresa().subscribe(data => {
      this.empresa = data;
    });

    this.tipoEmpresaService.getAllTipoEmpresa().subscribe(data => {
      this.tipoEmpresa = data;
    });

    this.cidadesService.getAllCidades().subscribe(data => {
      this.cidades = data;
    });

    this.estadoService.getAllEstados().subscribe(data => {
      this.estados = data;
    });

  }

  pegaId(event: EstadoModel) {
    const myJSON = JSON.stringify(event);
    this.idEstado = event.est_codigo;
    console.log(myJSON + this.idEstado);
    this.cidadesService.getAllCidadeByEstado(this.idEstado).subscribe(data => {
      this.cid = data;
    });
  }

  ngOnInit(): void {

    this.cols = [
      { field: 'razao_social', header: 'Razão Social', width: '25px' },
      { field: 'emp.cnpj', header: 'CNPJ', width: '15px' },
      { field: 'emp.operacao', header: 'Modalidade', width: '15px' },
      { field: 'emp.logradouro', header: 'Logradoruro', width: '35px' },
      { field: '', header: '', width: '5px' }
    ];

    this.FormEmpresa();
  }

  FormEmpresa() {

    this.formEmpresa = this.fb.group({
      emp_cnpj: [null],
      emp_razao_social: [null, Validators.required],
      emp_operacoa: [null, Validators.required],
      emp_descricao: [null],
      emp_logradouro: [null, Validators.required],
      emp_numero: [null],
      emp_complemento: [null],
      emp_bairro: [null, Validators.required],
      emp_cidade: [null, Validators.required],
      emp_estado: [null, Validators.required],
      emp_cep: [null, Validators.required],
      emp_fixo: [null],
      tem_codigo: [null, Validators.required],
    });
  }


  showError() {
    this.msg = [];
    this.msg.push({ severity: 'error', summary: 'Atenção!', detail: 'Preencha os campos obrigatórios' });
  }

  showSuccess() {
    this.msg = [];
    this.msg.push({ severity: 'sucess', summary: '', detail: 'Registro cadastrado com sucesso!' });
  }

  saveEmpresa() {
    if (!this.formEmpresa.valid) {
      this.showError();
    } else {
      this.empresaService.saveToEmpresa(this.formEmpresa.value).subscribe(data => {
        this.empresa = data;
        this.formEmpresa.reset();
        this.toListReload();
      });
    }
  }

  toListReload() {
    this.empresaService.getAllEmpresa().subscribe(data => {
      this.empresa = data;
    });
  }

}
