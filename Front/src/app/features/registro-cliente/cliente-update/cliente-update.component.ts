import { ToastService } from 'src/app/core/services/toast.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "app-cliente-update",
  templateUrl: "./cliente-update.component.html",
  styleUrls: ["./cliente-update.component.css"],
})
export class ClienteUpdateComponent implements OnInit {
  id: any;
  formulario: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder,
    private toastService: ToastService
  ) {

  }

  ngOnInit(): void {
    this.configFormulario();
  }

  configFormulario(){
    this.formulario = this.fb.group({
      idCliente: [null, Validators.required],
      login: [null, Validators.required],
      senha: [null, Validators.required],
      status: [null, Validators.required],
      loja: [null, Validators.required],
      dataCadastro: [null, Validators.required],
      nome: [null, Validators.required],
      cpf: [null, Validators.required],
      dataNascimento: [null, Validators.required],
      estadoCivil: [null, Validators.required],
      sexo: [null, Validators.required],
      email:[null, Validators.required],
      telefone: [null, Validators.required],
      cidade: [null, Validators.required],
      complemento: [null, Validators.required],
      bairro: [null, Validators.required],
      cep: [null, Validators.required],
      logradouro: [null, Validators.required],
    })
  }


  onBack(): void {

    this.router.navigate(['main/clientes']);
  }

  recuperaFormulario(cliente){
    this.formulario.patchValue({
      idCliente: cliente.idCliente,
      login: cliente.usuario.login,
      senha: cliente.usuario.senha,
      status: cliente.usuario.status,
      loja: cliente.usuario.loja.nomeLoja,
      dataCadastro: [cliente.usuario.dataCadastro],
      nome: cliente.usuario.pessoa.nome,
      cpf: cliente.usuario.pessoa.cpf,
      dataNascimento: cliente.usuario.pessoa.dataNascimento,
      estadoCivil: cliente.usuario.pessoa.estadoCivil,
      sexo: cliente.usuario.pessoa.sexo,
      email: cliente.usuario.pessoa.email,
      telefone: cliente.usuario.pessoa.telefone,
      cidade: cliente.usuario.pessoa.endereco.cidade.nomeCidade,
      complemento: cliente.usuario.pessoa.endereco.complemento,
      bairro: cliente.usuario.pessoa.endereco.bairro,
      cep: cliente.usuario.pessoa.endereco.cep,
      logradouro: cliente.usuario.pessoa.endereco.logradouro,
    })
  }

}
