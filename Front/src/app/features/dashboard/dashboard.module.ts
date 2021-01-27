import { CEPPipe } from '../PipeMask/cep.pipe';
import { FieldsetModule } from 'primeng';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppCommonModule } from 'src/app/app.common.module';
import { DashboardRoutingModule } from 'src/app/features/dashboard/dashboard.routing';
import { DashboardComponent } from 'src/app/features/dashboard/dashboard.component';
import { ListaDashboardComponent } from './lista-dashboard/lista-dashboard.component';
import { DialogModule } from 'primeng/dialog';
import { NgxBarcodeModule } from 'ngx-barcode';

@NgModule({
  imports: [
    CommonModule,
    DashboardRoutingModule,
    AppCommonModule,
    FieldsetModule,
    DialogModule,
    NgxBarcodeModule
  ],
  declarations: [DashboardComponent, ListaDashboardComponent, CEPPipe]
})
export class DashboardModule { }
