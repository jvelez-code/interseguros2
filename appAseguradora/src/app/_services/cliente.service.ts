import { Injectable } from '@angular/core';
import { GenericService } from './generic.service';
import { Cliente } from '../_model/cliente';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService extends GenericService <Cliente> {

  private mensajeCambio = new Subject<string>();
  private ClienteCambio = new BehaviorSubject<Cliente| null>(null); 

  constructor ( protected override http: HttpClient) {
    super(
      http,
      `${environment.HOST}/clientes`
    ) }

      ////////////////// get, set ////////////////


   getClienteCambio() {
    return this.ClienteCambio.asObservable();
  }

  setClienteCambio(cliente: Cliente) {
    this.ClienteCambio.next(cliente);
  }


  getMensajeCambio(){
    return this.mensajeCambio.asObservable();
  }

  setMensajecambio(mensaje: string){
    return this.mensajeCambio.next(mensaje);
  }




}
