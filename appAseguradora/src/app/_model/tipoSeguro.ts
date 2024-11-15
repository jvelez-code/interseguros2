export class TipoSeguro {
    idTipoSeguro: number;  
    tipoSeguro: string;
  
    // Constructor para inicializar la clase
    constructor(idTipoSeguro: number, tipoSeguro: string) {
      this.idTipoSeguro = idTipoSeguro;
      this.tipoSeguro = tipoSeguro;
    }
  }

  let tipoSeguro : TipoSeguro;