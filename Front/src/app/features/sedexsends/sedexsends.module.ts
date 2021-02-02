import { FieldsetModule } from 'primeng/fieldset';
import { SedexsendsComponent } from './sedexsends.component';
import { AppCommonModule } from './../../app.common.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SedexsendsRoutingModule } from './sedexsends-routing.module';
import {DialogModule} from 'primeng/dialog';


@NgModule({
  declarations: [SedexsendsComponent],
  imports: [
    CommonModule,
    SedexsendsRoutingModule,
    AppCommonModule,
    DialogModule,
    FieldsetModule
  ]
})
export class SedexsendsModule { }
