import { ResourceLoader } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { AtividadeModel } from 'src/app/core/models/atividade';
import { AtividadesService } from 'src/app/core/services/atividades.service';

@Component({
  selector: 'app-atividade',
  templateUrl: './atividade.component.html',
  styleUrls: ['./atividade.component.css']
})
export class AtividadeComponent implements OnInit {

  atividades: Observable<AtividadeModel>;
  atividade: AtividadeModel;
  formGroup: FormGroup;
  formulario: any;
  msg: any;
  constructor(
    private atividadeService: AtividadesService,
    private fb: FormBuilder
  ) {

    
  
   }

  ngOnInit(): void {
    this.confFormAtividade();
    this.listAtividades();
  }

  confFormAtividade() {
     
    this.formGroup = this.fb.group({
      nomeAtividade: [null, Validators.compose([Validators.required])],
      descricaoAtividade: [null],
      dataInicio: [null, Validators.required],
      dataTermino: [null, Validators.compose([Validators.required])],
      status: [true]
    });
  }


  onSave(){

    if(this.formGroup.valid == false){
       this.msg = "Preencha os campos";
    }else{
      this.atividadeService.save(this.formGroup.value).subscribe(data => {
        this.atividade = data
        console.log(this.atividade);
        this.listAtividades();
        this.formGroup.reset();
      })
    }
  }

  listAtividades(){
    this.atividadeService.getAllAtividades().subscribe(data => {
      this.atividade = data;
    })
  }

  onDelete(id){
    this.atividadeService.delete(id).subscribe(data => {
      this.atividade = data;

      this.listAtividades();
    })
  }
  /****************************** */

  get descricaoAtividade(){
    return this.formGroup.get('descricaoAtividade');
  }
}
