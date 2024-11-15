import { Routes } from '@angular/router';
import { ClienteComponent } from './pages/cliente/cliente.component';
import { ClienteHistoricoComponent } from './pages/cliente-historico/cliente-historico.component';
import { PresentacionComponent } from './pages/presentacion/presentacion.component';

export const routes: Routes = [
    { path: 'presentacion', component: PresentacionComponent},
    { path: 'cliente', component: ClienteComponent},
    { path: 'clienteHistorico', component: ClienteHistoricoComponent},
    { path: '', redirectTo: '/presentacion', pathMatch: 'full' } 
];


  
