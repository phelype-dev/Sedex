import { async } from '@angular/core/testing';
import { Router, ActivatedRoute } from '@angular/router';
import { MessagesModule } from 'primeng';
import { RemetenteService } from './../../core/services/remetente.service';
import { FormGroup, FormBuilder, Validator, Validators } from '@angular/forms';
import { EmpresasService } from './../../core/services/empresas.service';
import { EmpresaModel } from './../../core/models/empresa.model';
import { Component, OnInit } from '@angular/core';
import { RemetenteModel } from 'src/app/core/models/rememetente.model';
import {Message} from 'primeng/api';

@Component({
  selector: 'app-remetentes',
  templateUrl: './remetentes.component.html',
  styleUrls: ['./remetentes.component.css']
})
export class RemetentesComponent implements OnInit {

  empresa: EmpresaModel;
  form: FormGroup;
  remetente: RemetenteModel;
  remetentes: RemetenteModel;
  msg: Message[] = [];

  constructor(
    private empresaService: EmpresasService,
    private fb: FormBuilder,
    private remetenteService: RemetenteService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.empresaService.getAllEmpresa().subscribe(data => {
      this.empresa = data;
      console.log(this.empresa)
    });

    this.remetenteService.getAllRemetente().subscribe(data => {
      this.remetentes = data;
      console.log(this.remetentes)
    })
  }

  ngOnInit(): void {
    this.formEmpresa();
  }

  formEmpresa(){
    this.form = this.fb.group({

	    rem_remetente: [null, Validators.required],
	    rem_abreviado: [null, Validators.required],
	    rem_fixo: [null],
	    rem_movel: [null],
	    emp_codigo: [null, Validators.required],
      rem_ativo: [true],
    });
  }

  showMessage() {
    this.msg = [];
    this.msg.push({severity: 'success', summary:'Atenção!', detail:'Registro cadastrado com sucesso !'});
  }

  showError(){
    this.msg = [];
    this.msg.push({severity: 'error', summary:'Atenção!', detail:'preencha os campos!'});
  }

  showErrorInterno(){
    this.msg = [];
    this.msg.push({severity: 'error', summary:'Atenção!', detail:'preencha os campos!'});
  }


  onSave() {
    if(!this.form.valid){
      this.showError();
    }else{
      this.remetenteService.saveRementente(this.form.value).subscribe(data => {
        this.remetente = data;
        this.showMessage();
        this.form.reset();
        this.toDoList();
      });
    }
  }

  toDoList(){
    this.remetenteService.getAllRemetente().subscribe(data => {
      this.remetentes = data;
    });
  }

}
