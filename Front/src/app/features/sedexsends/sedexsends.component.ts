import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder } from '@angular/forms';
import { RegSedexModel } from './../../core/models/regSedexModel';
import { RegsedexService } from './../../core/services/regsedex.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sedexsends',
  templateUrl: './sedexsends.component.html',
  styleUrls: ['./sedexsends.component.css']
})
export class SedexsendsComponent implements OnInit {
  [x: string]: any;

  regSedexModel: RegSedexModel;
  showDetail: boolean;
  sedex: RegSedexModel;
  formulario: FormGroup;
  codigo: any;

  constructor(
    private regSedexService: RegsedexService,
    private fb: FormBuilder,
    private http: HttpClient,
    private route: Router
  ) {

    this.regSedexService.sedexEnviados().subscribe(data => {
      this.regSedexModel = data;
    });
  }

  ngOnInit(): void {
    this.formRegSedex();
  }

  showDetails(id: any) {
    this.showDetail = true;
    this.pegaId(id);
  }

  pegaId(id: any){
    this.regSedexService.buscaPorId(id).subscribe(data => {
      this.sedex = data;
      console.log(this.sedex);
      this.updateRegSedex(this.sedex);
    });
  }

  updateRegSedex(registro) {
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
      sed_data_modificacao: registro.sed_data_modificacao
    });
  }

  formRegSedex() {
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
      sed_data_modificacao: [null],
    });
  }

  rastreio(codigo: RegSedexModel) {
    this.codigo = codigo;
      window.open('https://www.linkcorreios.com.br/?id=' + codigo);
  }
}
