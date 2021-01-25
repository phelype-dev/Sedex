import { ClienteUpdateComponent } from './cliente-update/cliente-update.component';
import { ClienteDetailsComponent } from './cliente-details/cliente-details.component';
import { RegistroClienteComponent } from './registro-cliente.component';
import { ClienteListaComponent } from './cliente-lista/cliente-lista.component';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

const routes: Routes =[
  {
    path: '',
    component: ClienteListaComponent
  },
  {
    path: 'cadastro',
    component: RegistroClienteComponent
  },
  {
    path: 'details/:id',
    component: ClienteDetailsComponent
  },
  {
    path: 'update/:id',
    component: ClienteUpdateComponent
  }


]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegistroClienteRoutingModule { }
