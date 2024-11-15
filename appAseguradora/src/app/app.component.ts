import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { ClienteComponent } from "./pages/cliente/cliente.component";

import { MatDivider } from '@angular/material/divider';
import { MatSidenavContainer, MatSidenav, MatSidenavContent } from '@angular/material/sidenav';
import { MatMenuTrigger, MatMenu, MatMenuItem, MatMenuModule } from '@angular/material/menu';
import { MatIcon } from '@angular/material/icon';
import { MatButtonModule, MatIconButton } from '@angular/material/button';
import { MatToolbar } from '@angular/material/toolbar';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    ClienteComponent,
    MatToolbar, MatIconButton, MatIcon, MatMenuTrigger, MatMenu, MatMenuItem, RouterLink, MatSidenavContainer, MatSidenav, MatDivider, MatSidenavContent, 
    RouterOutlet,
    MatMenuModule,
    MatButtonModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'appAseguradora';
}
