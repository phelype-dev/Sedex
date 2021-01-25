import { ListaDashboardComponent } from './lista-dashboard/lista-dashboard.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from 'src/app/features/dashboard/dashboard.component';

const routes: Routes = [
  {
    path: '',
    component: ListaDashboardComponent
  },
  {
    path: 'novo-registro',
    component: DashboardComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
