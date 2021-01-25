import { ListaDestinatariosComponent } from './lista-destinatarios/lista-destinatarios.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { DestinatariosComponent } from './destinatarios.component';

const routes: Routes = [
  {
    path: '',
    component: ListaDestinatariosComponent
  },
  {
    path: 'novo-registro',
    component: DestinatariosComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DestinatariosRouting { }
