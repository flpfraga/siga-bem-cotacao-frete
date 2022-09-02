package com.c2tech.desafio.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CotacaoFrete implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 10, nullable = false)
	private String cepOrigem;
	@Column(length = 10, nullable = false)
	private String cepDestino;
	@Column(scale = 3, nullable = false)
	private Float peso;
	@Column(length = 40, nullable = false)
	private String destinatario;
	@Column(name = "precoFrete", scale = 2, nullable = false)
	private Double vlTotalFrete;
	@Column(length = 20, nullable = false)
	private LocalDate dataPrevistaEntrega;
	@Column(length = 20, nullable = false)
	private LocalDate dataConsulta;

	public CotacaoFrete() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(Double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	@Override
	public String toString() {
		return "CotacaoFrete [id=" + id + ", cepOrigem=" + cepOrigem + ", cepDestino=" + cepDestino + ", peso=" + peso
				+ ", destinatario=" + destinatario + ", vlTotalFrete=" + vlTotalFrete + ", dataPrevistaEntrega="
				+ dataPrevistaEntrega + ", dataConsulta=" + dataConsulta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cepDestino, cepOrigem, dataConsulta, dataPrevistaEntrega, destinatario, id, peso,
				vlTotalFrete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoFrete other = (CotacaoFrete) obj;
		return Objects.equals(cepDestino, other.cepDestino) && Objects.equals(cepOrigem, other.cepOrigem)
				&& Objects.equals(dataConsulta, other.dataConsulta)
				&& Objects.equals(dataPrevistaEntrega, other.dataPrevistaEntrega)
				&& Objects.equals(destinatario, other.destinatario) && Objects.equals(id, other.id)
				&& Objects.equals(peso, other.peso) && Objects.equals(vlTotalFrete, other.vlTotalFrete);
	}

}
