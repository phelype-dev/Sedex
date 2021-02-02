import { EtiquetaModule } from './features/etiqueta/etiqueta.module';
import { RemetentesModule } from './features/remetentes/remetentes.module';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from 'src/app/core/gaurds/auth.gaurd';
import { LayoutComponent } from 'src/app/shared/layout/layout.component';
import { ErrorComponent } from './shared/error/error.component';

const appRoutes: Routes = [
  {
    path: 'login',
    loadChildren: () => import('src/app/features/login/login.module').then(m => m.LoginModule)
  },
  {
    path: 'register',
    loadChildren: () => import('src/app/features/register-user/register-user.module').then(m => m.RegisterUserModule)
  },
  {
    path: 'main',
    component: LayoutComponent,
    children: [{
      path: 'dashboard',
      loadChildren: () => import('src/app/features/dashboard/dashboard.module').then(m => m.DashboardModule),
      canActivate: [AuthGuard]
    },
    {
      path: 'destinatarios',
      loadChildren: () => import('src/app/features/destinatarios/destinatarios.module').then(m => m.DestinatariosModule),
      canActivate: [AuthGuard]
    },
    {
      path: 'empresas',
      loadChildren: () => import('src/app/features/empresas-cad/empresa-cad.module').then(m => m.EmpresaCadModule),
      canActivate: [AuthGuard]
    },
    {
      path: 'remetentes',
      loadChildren: () => import('src/app/features/remetentes/remetentes.module').then(m => m.RemetentesModule),
      canActivate: [AuthGuard]
    },
    {
      path: 'etiqueta',
      loadChildren: () => import('src/app/features/etiqueta/etiqueta.module').then(m => m.EtiquetaModule),
      canActivate: [AuthGuard]
    },
    {
      path: 'sedex-enviados',
      loadChildren: () => import('src/app/features/sedexsends/sedexsends.module').then(m => m.SedexsendsModule),
      canActivate: [AuthGuard]
    }


    ]
  },
  {
    path: 'error',
    component: ErrorComponent,
    //loadChildren: () => import('src/app/shared/error/error.module').then(m => m.ErrorModule)
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
