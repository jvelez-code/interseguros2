import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatCard, MatCardHeader, MatCardTitle, MatCardContent, MatCardActions } from '@angular/material/card';
import { AsyncPipe, CommonModule } from '@angular/common';
import { MatIcon } from '@angular/material/icon';
import { MatOption } from '@angular/material/core';
import { MatFormField, MatLabel, MatSelect } from '@angular/material/select';
import { MatButton } from '@angular/material/button';
import { MatInput } from '@angular/material/input';
import { ClienteService } from '../../_services/cliente.service';
import { Cliente } from '../../_model/cliente';
import { Ubicacion } from '../../_model/ubicacion';
import { UbicacionService } from '../../_services/ubicacion.service';
import { Observable } from 'rxjs';
import { Router, RouterLink } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-cliente',
  standalone: true,
  imports:[
    CommonModule, 
    MatCard,
    MatCardHeader,
    MatCardTitle,
    MatCardContent,
    ReactiveFormsModule,
    MatFormField,
    MatLabel,
    MatInput,
    MatCardActions,
    MatButton,
    MatSelect,
    MatOption,
    MatIcon,
  ],
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.scss'
})
export class ClienteComponent implements OnInit{

  formAsignar!: FormGroup;
  formCrear!: FormGroup;
  cardBuscar !: boolean;
  cedula !: number;
  ubicacion$ !: Observable<Ubicacion[]>;


  constructor(
    private clienteService: ClienteService,
    private ubicacionService: UbicacionService,
    private router: Router,
    private fb: FormBuilder,
  ){    
    this.crearFormulario();
  }


  ngOnInit(): void {
    this.cardBuscar= false;
    this.ubicacion$ = this.ubicacionService.listar();
  }

  crearFormulario(){

    this.formAsignar = this.fb.group({
      'cedula': ['', [Validators.required]]
    });

    this.formCrear = this.fb.group({
      'tipoDocu': ['',[Validators.required]],
      'nrocedula': ['' ,[Validators.required,Validators.maxLength(16)]],
      'correoElec': ['@gmail.com', [ Validators.required, Validators.pattern('[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,3}$')]],
      'celular': ['', [Validators.required,Validators.minLength(10),Validators.maxLength(10),Validators.pattern('^[0-9]+$')]],
      'ubicacion': ['', [Validators.required]],
    });



  }

  buscarCliente(){
    this.cedula= this.formAsignar.value['cedula'];
    this.clienteService.listarPorId(this.cedula).subscribe(data =>{
      if(data){
      console.log(data,'cedulas')
      this.clienteService.setClienteCambio(data);
      this.router.navigate(['/clienteHistorico']);
      } else {
        this.cardBuscar= !this.cardBuscar;
        console.log('nocedulas')

        this.formCrear.patchValue({
          nrocedula: this.cedula
        });
      }
    })

  }
  guardarCliente(){
     
      let ubi = new Ubicacion();
      ubi.codUbicacion = 2;   

      let cli = new Cliente();
      cli.cedulaCliente = this.formCrear.value['nrocedula'];
      cli.tipoDocumento = this.formCrear.value['tipoDocu'];
      cli.correoCliente = this.formCrear.value['correoElec'];
      cli.nroCelular = this.formCrear.value['celular'];
      cli.ubicacion = ubi;
      console.log(cli,'cliente')      
      this.clienteService.registrar(cli).subscribe(data =>{
        console.log('se registro')
      })

     

      

  }

  cancelar(){
    this.cardBuscar= !this.cardBuscar;
  }

  
  

}
