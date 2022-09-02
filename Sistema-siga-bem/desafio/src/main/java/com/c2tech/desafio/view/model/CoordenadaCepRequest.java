package com.c2tech.desafio.view.model;

import java.io.Serializable;

public class CoordenadaCepRequest {

	private String nomeDestinatario;
	private String cepOrigem;
	private String cepDestino;
	private Double peso;

	public CoordenadaCepRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "CoordenadaCepRequest [nomeDestinatario=" + nomeDestinatario + ", cepOrigem=" + cepOrigem
				+ ", cepDestino=" + cepDestino + ", peso=" + peso + "]";
	}
	
	

}
