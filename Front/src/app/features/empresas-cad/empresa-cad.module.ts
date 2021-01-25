import { MessageModule } from 'primeng/message';
import { DropdownModule } from 'primeng/dropdown';
import { CardModule, InputMaskModule, MessagesModule } from 'primeng';
import { EmpresaCadRouting } from './empresas-cad.routing';
import { AppCommonModule } from './../../app.common.module';
import { CommonModule } from '@angular/common';
import { NgModule } from "@angular/core";
import { EmpresasCadComponent } from "./empresas-cad.component";


@NgModule({
  declarations: [EmpresasCadComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    EmpresaCadRouting,
    CardModule,
    InputMaskModule,
    DropdownModule,
    MessageModule,
    MessagesModule


  ]
})
export class EmpresaCadModule { }
