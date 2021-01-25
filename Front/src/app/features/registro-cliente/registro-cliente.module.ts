import { InputMaskModule } from 'primeng/inputmask';
import { ToolbarModule } from 'primeng/toolbar';
import { MenuItem } from 'primeng/api';
import { StepsModule } from 'primeng/steps';
import { RegistroClienteComponent } from './registro-cliente.component';
import { RegistroClienteRoutingModule } from './registro-cliente.routing';
import { AppCommonModule } from './../../app.common.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteListaComponent } from './cliente-lista/cliente-lista.component';
import {FieldsetModule} from 'primeng/fieldset';
import { PasswordModule } from 'primeng/password';
import { ClienteDetailsComponent } from './cliente-details/cliente-details.component';
import { ClienteUpdateComponent } from './cliente-update/cliente-update.component';

@NgModule({
  declarations: [ClienteListaComponent, RegistroClienteComponent, ClienteDetailsComponent, ClienteUpdateComponent ],
  imports: [
    CommonModule,
    AppCommonModule,
    RegistroClienteRoutingModule,
    StepsModule,
    ToolbarModule,
    FieldsetModule,
    InputMaskModule,
    PasswordModule,
    ToolbarModule
  ]
})
export class RegistroClienteModule { }
