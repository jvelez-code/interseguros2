import { Injectable } from '@angular/core';
import { GenericService } from './generic.service';
import { Ubicacion } from '../_model/ubicacion';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UbicacionService extends GenericService <Ubicacion> {

  constructor ( protected override http: HttpClient) {
    super(
      http,
      `${environment.HOST}/ubicacion`
    ) }
}
