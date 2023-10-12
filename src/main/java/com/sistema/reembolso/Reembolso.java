package com.sistema.reembolso;

public class Reembolso {
    public Reembolso(Long id, String descricao, Double valor, String data, String status) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.status = status;
    }

    public Reembolso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String data;
    private Long id;
    private String descricao;
    private Double valor;
    private String status;
}
