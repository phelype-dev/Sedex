import { Router } from '@angular/router';
import { DestinatarioModel } from './../../core/models/destinatario.model';
import { DestinatariosService } from './../../core/services/destinatarios.service';
import { EmpresaModel } from './../../core/models/empresa.model';
import { EmpresasService } from './../../core/services/empresas.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { CidadeModel } from 'src/app/core/models/Cidade.model';
import { EstadoModel } from 'src/app/core/models/Estado.model';
import { CidadesService } from 'src/app/core/services/cidades.service';
import { EstadosService } from 'src/app/core/services/estados.service';

@Component({
  templateUrl: './destinatarios.component.html',
  styleUrls: ['./destinatarios.component.css']
})
export class DestinatariosComponent implements OnInit {

  estados: EstadoModel;
  cidades: CidadeModel;
  empTransp: EmpresaModel;
  destinatario: DestinatarioModel;
  options: any;
  codigo: any;
  formDest: FormGroup;
  estado: null;

  constructor(
    private estadoService: EstadosService,
    private cidadeService: CidadesService,
    private fb: FormBuilder,
    private empresaService: EmpresasService,
    private destinatarioService: DestinatariosService,
    private route: Router
  ) {

    this.estadoService.getAllEstados().subscribe(data => {
      this.estados = data;
      console.log(this.estados);
    });

    this.empresaService.getAllEmpresaTransp().subscribe(data =>{
      this.empTransp = data;
      console.log(this.empTransp);
    });

    this.cidadeService.getAllCidades().subscribe(data => {
      this.cidades = data;
    })

  }

  getCidade(){
    this.cidadeService.getAllCidadeByEstado(this.estado).subscribe(data => {
      this.cidades = data;
    })
  }

  ngOnInit(): void {

    this.options = {
      center: {lat: 36.890257, lng: 30.707417},
      zoom: 12
  };
  this.formDestinatario();
  }

  /*buscarCidadePorEstado(id_estado: any){
    this.cidadeService.getAllCidadeByEstado(id_estado).pipe(
     map((cidades: CidadeModel[]) => cidades.filter(c => c.est_codigo === id_estado))
    )

  }*/

  formDestinatario(){
    this.formDest = this.fb.group({
      des_destinatario: [null, Validators.required],
      des_aos_cuidados: [null, Validators.required],
      des_aos_cuidados_abrev: [null, Validators.required],
      des_cpf: [null],
      des_logradouro: [null, Validators.required],
      des_numero: [null],
      des_complemento: [null],
      des_bairro: [null, Validators.required],
      cid_cidade: [null, Validators.required],
      est_estado: [null, Validators.required],
      des_cep: [null, Validators.required],
      des_fixo: [null],
      des_movel: [null],
      des_transpotadora: [null, Validators.required],
      des_ativo: [true],
      des_data_alteracao: [null],
      des_latitude: [null],
      des_longitude: [null],
    });
  }


  saveDestinatario() {

    this.destinatarioService.onSave(this.formDest.value).subscribe(data => {
      this.destinatario = data;
      this.formDest.reset();
    });

  }

  calcelar() {
    this.route.navigate(['main/destinatarios']);
  }

}
