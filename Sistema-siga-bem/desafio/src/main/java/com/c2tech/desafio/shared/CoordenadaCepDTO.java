package com.c2tech.desafio.shared;

public class CoordenadaCepDTO {
    
	private String cepOrigem;
    private String cepDestino;
    private Float peso;
    private String destinatario;
    private String ufOrigem;
    private String ufDestino;
    private String dddOrigem;
    private String dddDestino;
    
	public CoordenadaCepDTO() {
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

	public String getUfOrigem() {
		return ufOrigem;
	}

	public void setUfOrigem(String ufOrigem) {
		this.ufOrigem = ufOrigem;
	}

	public String getUfDestino() {
		return ufDestino;
	}

	public void setUfDestino(String ufDestino) {
		this.ufDestino = ufDestino;
	}

	public String getDddOrigem() {
		return dddOrigem;
	}

	public void setDddOrigem(String dddOrigem) {
		this.dddOrigem = dddOrigem;
	}

	public String getDddDestino() {
		return dddDestino;
	}

	public void setDddDestino(String dddDestino) {
		this.dddDestino = dddDestino;
	}

	@Override
	public String toString() {
		return "CoordenadaCepDTO [cepOrigem=" + cepOrigem + ", cepDestino=" + cepDestino + ", peso=" + peso
				+ ", destinatario=" + destinatario + ", ufOrigem=" + ufOrigem + ", ufDestino=" + ufDestino
				+ ", dddOrigem=" + dddOrigem + ", dddDestino=" + dddDestino + "]";
	}

}
