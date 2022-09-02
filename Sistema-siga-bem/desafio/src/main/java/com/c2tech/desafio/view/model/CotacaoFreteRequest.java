package com.c2tech.desafio.view.model;

public class CotacaoFreteRequest {
    
    private String cepOrigem;
    private String cepDestino;
    private Float peso;
    private String destinatario;
    
    public CotacaoFreteRequest() {
		// TODO Auto-generated constructor stub
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

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	@Override
	public String toString() {
		return "CotacaoFreteRequest [cepOrigem=" + cepOrigem + ", cepDestino=" + cepDestino + ", peso=" + peso
				+ ", destinatario=" + destinatario + "]";
	}
    
    
}
