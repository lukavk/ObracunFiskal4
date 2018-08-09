package com.example.ured3.obracunfiskal4;

public class Artikli {

    private String NazivA;
    private Double CijenaA;
    private Double Poreza;
    private Double ZalihaA;
    private Double DonosA;
    private Double OstatakA;
    private Double UkupnoA;
    private Double ProdanoA;
    private Double Iznos;
    public Artikli() {
    }
    public Artikli(String nazivA, Double cijenaA, Double poreza, Double zalihaA, Double donosA, Double ostatakA, Double ukupnoA, Double prodanoA, Double iznos) {
        NazivA = nazivA;
        CijenaA = cijenaA;
        Poreza = poreza;
        ZalihaA = zalihaA;
        DonosA = donosA;
        OstatakA = ostatakA;
        UkupnoA = ukupnoA;
        ProdanoA = prodanoA;
        Iznos = iznos;
    }

    public String getNazivA() {
        return NazivA;
    }

    public void setNazivA(String nazivA) {
        NazivA = nazivA;
    }

    public Double getCijenaA() {
        return CijenaA;
    }

    public void setCijenaA(Double cijenaA) {
        CijenaA = cijenaA;
    }

    public Double getPoreza() {
        return Poreza;
    }

    public void setPoreza(Double poreza) {
        Poreza = poreza;
    }

    public Double getZalihaA() {
        return ZalihaA;
    }

    public void setZalihaA(Double zalihaA) {
        ZalihaA = zalihaA;
    }

    public Double getDonosA() {
        return DonosA;
    }

    public void setDonosA(Double donosA) {
        DonosA = donosA;
    }

    public Double getOstatakA() {
        return OstatakA;
    }

    public void setOstatakA(Double ostatakA) {
        OstatakA = ostatakA;
    }

    public Double getUkupnoA() {
        return UkupnoA;
    }

    public void setUkupnoA(Double ukupnoA) {
        UkupnoA = ukupnoA;
    }

    public Double getProdanoA() {
        return ProdanoA;
    }

    public void setProdanoA(Double prodanoA) {
        ProdanoA = prodanoA;
    }

    public Double getIznos() {
        return Iznos;
    }

    public void setIznos(Double iznos) {
        Iznos = iznos;
    }
}