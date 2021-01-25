import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SelectItem } from 'primeng';
import { CidadeModel } from 'src/app/core/models/cidade.model';
import { ConsultCep } from 'src/app/core/models/consultCep';
import { SexoModel } from 'src/app/core/models/sexoModel';
import { UsuarioModel } from 'src/app/core/models/usuario.model';
import { CidadesService } from 'src/app/core/services/cidades.service';
import { SexoService } from 'src/app/core/services/sexo.service';
import { UsuarioService } from 'src/app/core/services/usuario.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  formUsuario: FormGroup;
  dateAtual = Date.now();
  cidades: CidadeModel;
  consult: ConsultCep;
  cep: String;
  usuarioModel: UsuarioModel;

  sexo: any;
  estCivil: any;
  cargo: any;

  constructor(
    private fb: FormBuilder,
    private cidadeService: CidadesService,
    private http: HttpClient,
    private usuarioService: UsuarioService,
    private sexoService: SexoService
  ) {

    this.cidadeService.getAllCidades().subscribe(data => {
      this.cidades = data;
      console.log(this.cidades)
    });

    this.sexoService.getAllSexo().subscribe(data=> {
      this.sexo = data;
      console.log(this.sexo);
    }),
    this.sexoService.getAllEstCivil().subscribe(data=> {
      this.estCivil = data;
      console.log(this.estCivil);
    }),
    this.sexoService.getAllCargos().subscribe(data=> {
      this.cargo = data;
      console.log(this.cargo);
    })

   }

  ngOnInit(): void {
    this.configFormUsuario();
  }

  configFormUsuario() {
    this.formUsuario = this.fb.group({
     nomeLogin: [null, [Validators.required, Validators.maxLength(20)]],
     password: [null, [Validators.required, Validators.minLength(5)]],
     status: [true],
     dateCadastro: [this.dateAtual],
     cargo: [null, Validators.required],
     idPessoa: this.fb.group({
       nomeCompleto: [null, Validators.required],
       cpf: [null],
       sexo: [null, Validators.required],
       estCivil: [null, Validators.required],
       dataNascimento: [null, Validators.required],
       email: [null, Validators.email],
       numCelular: [null],
       numFixo: [null],
       idEndereco: this.fb.group({
          logradouro: [null, Validators.required],
          numero: [null],
          complemento: [null],
          setorBairro: [null, Validators.required],
          cep: [null, Validators.required],
          idCidade: [null, Validators.required],

       }),
     }),
    })
  }

  verificaValid(campo) {
    return !this.formUsuario.get(campo).valid && this.formUsuario.get(campo).touched;
  }

  verificaValidaPessoa(campo){
    return !this.formUsuario.addControl['idPessoa']['campo'].valid;
  }

  aplicaCssErro(campo){
    return {
      'has-error': this.verificaValid(campo),
      'has-feedback': this.verificaValid(campo)
    }
  }

  onSave() {
      this.usuarioService.onSave(this.formUsuario.value).subscribe(data => {
        this.usuarioModel = data;
        console.log(this.usuarioModel)
      })
    }
    

}
