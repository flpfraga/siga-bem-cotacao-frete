package com.c2tech.desafio.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CotacaoFrete {

    // #region atributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cepOrigem;
    private String cepDestino;
    private Double peso;
    private String destinatario;
    private Double vlTotalFrete;
    private String dataPrevistaEntrega;
    private String dataConsulta;
    // #endregion atributes

    // public CotacaoFrete(String cepOrigem,String cepDestino,Float peso,String
    // destinatario,Double vlTotalFrete,String dataPrevistaEntrega,String
    // dataConsulta) {
    // this.cepOrigem = cepOrigem;
    // this.cepDestino = cepDestino;
    // this.peso =
    // }

    // #region get and set
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
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

    public void setDataConsulta(Calendar dataConsulta) {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.dataConsulta = dateFormat.format(dataConsulta.getTime());
    }

    // #endregion get and set
    public void calculaDataPrevistaEntrega(boolean dddIgual, boolean ufIgual, Calendar cal) {
        if (dddIgual) {
            cal.add(Calendar.DATE, 1);
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            setDataPrevistaEntrega(dateFormat.format(cal.getTime()));
            return;
        }
        if (ufIgual) {
            cal.add(Calendar.DATE, 3);
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            setDataPrevistaEntrega(dateFormat.format(cal.getTime()));
            return;
        }
        cal.add(Calendar.DATE, 10);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        setDataPrevistaEntrega(dateFormat.format(cal.getTime()));
    }

    public void calculaValorFrete(boolean dddIgual, boolean ufIgual) {
        Double valor = this.peso;
        if (ufIgual) {
            setVlTotalFrete(valor * 0.5);
            return;
        }
        if (dddIgual) {
            setVlTotalFrete(valor * 0.25);
            return;
        }
        setVlTotalFrete(valor);
    }

}
