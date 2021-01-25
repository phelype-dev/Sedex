import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuariosComponent } from './usuarios.component';
import { AppCommonModule } from 'src/app/app.common.module';
import { UsuarioRoutingModule } from './usuario.routing.module';
import { CardModule, FieldsetModule, InputMaskModule, PanelModule } from 'primeng';
import { CampoControlErroComponent } from '../campo-control-erro/campo-control-erro.component';



@NgModule({
  declarations: [UsuariosComponent, CampoControlErroComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    UsuarioRoutingModule,
    CardModule,
    PanelModule,
    InputMaskModule,
    FieldsetModule
  ]
})
export class UsuarioModule { }
