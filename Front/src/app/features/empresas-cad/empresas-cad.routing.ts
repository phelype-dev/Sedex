import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpresasCadComponent } from './empresas-cad.component';

const routes: Routes = [
  {
    path: '',
    component: EmpresasCadComponent
  }

]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmpresaCadRouting { }
