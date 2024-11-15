import { Injectable } from '@angular/core';
import { TipoSeguro } from '../_model/tipoSeguro';
import { GenericService } from './generic.service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TipoSeguroService  extends GenericService <TipoSeguro> {

  constructor ( protected override http: HttpClient) {
    super(
      http,
      `${environment.HOST}/tipoSeguros`
    ) }

}
