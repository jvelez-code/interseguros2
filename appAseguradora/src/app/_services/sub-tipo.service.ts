import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GenericService } from './generic.service';
import { environment } from '../../environments/environment';
import { SubtipoSeguro } from '../_model/subtipoSeguro';
import { ParametrosDTO } from '../_model/ParametrosDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubTipoService extends GenericService <SubtipoSeguro> {

  constructor ( protected override http: HttpClient) {
    super(
      http,
      `${environment.HOST}/subtipoSeguros`
    ) }


    obtenerSubtipo( parametrosDTO: ParametrosDTO ):Observable<SubtipoSeguro[]>{
      const headers = { 'content-type': 'application/json'}
      return this.http.post<SubtipoSeguro[]>(`${this.url}/obtener`,parametrosDTO,{'headers':headers});
     }

     descripSubtipo( parametrosDTO: ParametrosDTO ):Observable<SubtipoSeguro>{
      const headers = { 'content-type': 'application/json'}
      return this.http.post<SubtipoSeguro>(`${this.url}/obtenerDescrip`,parametrosDTO,{'headers':headers});
     }
}
