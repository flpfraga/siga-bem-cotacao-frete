package com.c2tech.desafio.view.model;

public class CotacaoFreteRequest {
    
    private Integer id;
    private String cepOrigem;
    private String cepDestino;
    private Float peso;
    private String destinatario;
    private Double vlTotalFrete;
    private String dataPrevistaEntrega;
    private String dataConsulta;

    
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
    public String getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }
    public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }
    public String getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    
}
