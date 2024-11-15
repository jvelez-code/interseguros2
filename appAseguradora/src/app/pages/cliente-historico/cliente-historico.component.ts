import { Component, OnInit } from '@angular/core';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatCardActions, MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import { Cliente } from '../../_model/cliente';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { ClienteService } from '../../_services/cliente.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { TipoSeguro } from '../../_model/tipoSeguro';
import { TipoSeguroService } from '../../_services/tipo-seguro.service';
import { SubTipoService } from '../../_services/sub-tipo.service';
import { MatFormField, MatLabel } from '@angular/material/form-field';
import { MatInput } from '@angular/material/input';
import { MatButton } from '@angular/material/button';
import { MatOption, MatSelect } from '@angular/material/select';
import { MatIcon } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { MatDividerModule } from '@angular/material/divider';
import { SubtipoSeguro } from '../../_model/subtipoSeguro';
import { ParametrosDTO } from '../../_model/ParametrosDTO';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-cliente-historico',
  standalone: true,
  imports: [ CommonModule,
            MatCardModule,
            MatChipsModule,
            MatProgressBarModule,
            MatTableModule,
            MatFormField,
            MatLabel,
            MatInput,
            MatCardActions,
            MatButton,
            MatSelect,
            MatOption,
            MatIcon,
            MatDividerModule,
            FormsModule,
            ReactiveFormsModule],
  templateUrl: './cliente-historico.component.html',
  styleUrl: './cliente-historico.component.scss'
})
export class ClienteHistoricoComponent implements OnInit {

  tipoSeguro !: number;
  subtipoSeguro !: number;
  clienteSel!: Cliente;
  parametrosDTO!: ParametrosDTO;
  tipoSeguro$!: Observable<TipoSeguro[]>;
  subtipoSeguro$!: Observable<SubtipoSeguro[]>;
  observacionTipo!: string;

  formPoliza!: FormGroup;

  displayedColumns: string[] = ['cedulaCliente', 'tipoDocumento', 'correoCliente', 'nroCelular', 'ubicacion'];
  dataSource = new MatTableDataSource<Cliente>(); // Inicialización correcta

  constructor(
    private clienteService: ClienteService,
    private tipoSeguroService: TipoSeguroService,
    private subTipoService: SubTipoService,
    private fb: FormBuilder,
    private router: Router,
    private snackBar: MatSnackBar

  ) {
    this.crearFormulario();
  }

  ngOnInit(): void {
  this.clienteService.getClienteCambio().subscribe(data =>{
    if(data){
      this.dataSource.data = [data];
    }
  })
  this.tipoSeguro$ = this.tipoSeguroService.listar();
  }

  irACliente() {
    this.router.navigate(['/cliente']);
  }

  subtipoGestion(tipoSeguro: number){

    this.parametrosDTO = { tipoSeguro : tipoSeguro}

    this.subtipoSeguro$= this.subTipoService.obtenerSubtipo(this.parametrosDTO);
    console.log(this.subtipoSeguro)

  }

  descripSubtipo(subtipoSeguro: number){

    console.log(subtipoSeguro)

    this.parametrosDTO = { subtipoSeguro : subtipoSeguro}

    this.subTipoService.descripSubtipo(this.parametrosDTO).subscribe(data =>{
      console.log(data.descripcion)
      this.observacionTipo=data.descripcion;
    });

  }

  crearFormulario(){

    this.formPoliza = this.fb.group({
      reclamacion: ['',[Validators.required]],
      duracion:['',[Validators.required]],      
      monto:['',[Validators.required]],
      exclusiones:['',[Validators.required]],
      prima:['',[Validators.required]],
      subtipo:['',[Validators.required]],
    });

  }

  guardarCliente(){
    console.log('holaMundo')
  }
  
    
}
