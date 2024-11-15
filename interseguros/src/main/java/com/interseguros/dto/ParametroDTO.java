package com.interseguros.dto;

public class ParametroDTO {
	
  private Integer tipoSeguro;
  private Integer subtipoSeguro;
  
  public ParametroDTO() {
		 
	 }

	
	public ParametroDTO(Integer tipoSeguro, Integer subtipoSeguro) {
	super();
	this.tipoSeguro = tipoSeguro;
	this.subtipoSeguro = subtipoSeguro;
}


	public Integer getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(Integer tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}


	public Integer getSubtipoSeguro() {
		return subtipoSeguro;
	}


	public void setSubtipoSeguro(Integer subtipoSeguro) {
		this.subtipoSeguro = subtipoSeguro;
	}
	 
	
	 

}
