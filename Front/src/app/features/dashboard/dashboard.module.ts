import { DropdownModule } from 'primeng/dropdown';
import { CEPPipe } from '../PipeMask/cep.pipe';
import { FieldsetModule, ButtonModule } from 'primeng';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppCommonModule } from 'src/app/app.common.module';
import { DashboardRoutingModule } from 'src/app/features/dashboard/dashboard.routing';
import { DashboardComponent } from 'src/app/features/dashboard/dashboard.component';
import { ListaDashboardComponent } from './lista-dashboard/lista-dashboard.component';
import { DialogModule } from 'primeng/dialog';
import { NgxBarcodeModule } from 'ngx-barcode';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputNumberModule} from 'primeng/inputnumber';


@NgModule({
  imports: [
    CommonModule,
    DashboardRoutingModule,
    AppCommonModule,
    FieldsetModule,
    DialogModule,
    NgxBarcodeModule,
    FieldsetModule,
    InputSwitchModule,
    DropdownModule,
    InputNumberModule,
    ButtonModule
  ],
  declarations: [DashboardComponent, ListaDashboardComponent, CEPPipe]
})
export class DashboardModule { }
