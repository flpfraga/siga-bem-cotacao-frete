package com.c2tech.desafio.view.model;

public class CoordenadaCepResponse {
    
    private String cep;
    private String uf;
    private String ddd;
    
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getDdd() {
        return ddd;
    }
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    
    public void print(){
        System.out.println("cep " + cep);
        System.out.println("uf " + uf);
        System.out.println("ddd" + ddd);
    }
}
