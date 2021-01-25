import { ToolbarModule } from 'primeng/toolbar';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DestinatariosComponent } from './destinatarios.component';
import { AppCommonModule } from 'src/app/app.common.module';
import { DestinatariosRouting } from './destinatarios.routing';
import { CardModule, FieldsetModule, GMapModule, InputMaskModule, RadioButtonModule } from 'primeng';
import { CampoControlErroComponent } from '../campo-control-erro/campo-control-erro.component';
import { ListaDestinatariosComponent } from './lista-destinatarios/lista-destinatarios.component';

@NgModule({
  declarations: [DestinatariosComponent, CampoControlErroComponent, ListaDestinatariosComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    DestinatariosRouting,
    CardModule,
    GMapModule,
    FieldsetModule,
    InputMaskModule,
    RadioButtonModule,
    ToolbarModule


  ]
})
export class DestinatariosModule { }
