package br.com.desafio.jokenpo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty
	private String[] vencedores = new String[] {};
	
	@JsonProperty
	private String[] perdedores = new String[] {};
	
	@JsonProperty
	private String[] empates = new String[] {};

	
	
	public String[] getVencedores() {
		return vencedores;
	}

	public void setVencedores(String[] vencedores) {
		this.vencedores = vencedores;
	}

	public String[] getPerdedores() {
		return perdedores;
	}

	public void setPerdedores(String[] perdedores) {
		this.perdedores = perdedores;
	}

	public String[] getEmpates() {
		return empates;
	}

	public void setEmpates(String[] empates) {
		this.empates = empates;
	}

}
