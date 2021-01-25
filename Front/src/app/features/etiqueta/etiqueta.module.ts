import { EtiquetaComponent } from './etiqueta.component';
import { AppCommonModule } from './../../app.common.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EtiquetaRoutingModule } from './etiqueta-routing.module';



@NgModule({
  declarations: [EtiquetaComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    EtiquetaRoutingModule
  ]
})
export class EtiquetaModule { }
