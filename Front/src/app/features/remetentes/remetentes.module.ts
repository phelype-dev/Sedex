import { MessagesModule } from 'primeng/messages';
import { CardModule, InputMaskModule, PanelModule } from 'primeng';
import { RemetentesComponent } from './remetentes.component';
import { AppCommonModule } from './../../app.common.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RemetentesRoutingModule } from './remetentes-routing.module';


@NgModule({
  declarations: [RemetentesComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    RemetentesRoutingModule,
    CardModule,
    InputMaskModule,
    PanelModule,
    MessagesModule,
  ]
})
export class RemetentesModule { }
