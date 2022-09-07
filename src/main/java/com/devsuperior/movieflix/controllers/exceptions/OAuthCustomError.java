package com.devsuperior.movieflix.controllers.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuthCustomError implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private String erro;
	
	
	@JsonProperty("error_description")
	private String erroDescription;
	
	public OAuthCustomError() {
	}

	public OAuthCustomError(String erro, String erroDescription) {
		this.erro = erro;
		this.erroDescription = erroDescription;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getErroDescription() {
		return erroDescription;
	}

	public void setErroDescription(String erroDescription) {
		this.erroDescription = erroDescription;
	}
	
	

}