import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppCommonModule } from 'src/app/app.common.module';
import { AtividadeRoutingModule } from './atividade.routing.module';
import {MatListModule} from '@angular/material/list';
import { AtividadeComponent } from './atividade.component';
import { CardModule } from 'primeng';



@NgModule({
  declarations: [AtividadeComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    AtividadeRoutingModule,
    MatListModule,
    CardModule
  ]
})
export class AtividadeModule { }
