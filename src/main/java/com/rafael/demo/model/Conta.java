package com.rafael.demo.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="contas")
public class Conta {	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_conta")
    private Integer id;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private Float valorOriginal;

    @Column
    @NotNull
    private Float valorCorrigido;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private Calendar dataVencimento;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private Calendar dataPagamento;

    @Column
    private Long quantidadeDiasAtraso;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValorOriginal() {
        return this.valorOriginal;
    }

    public void setValorOriginal(Float valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public Float getValorCorrigido() {
        return this.valorCorrigido;
    }

    public void setValorCorrigido(Float valorCorrigido) {
        this.valorCorrigido = valorCorrigido;
    }

    public Calendar getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Calendar getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Long getQuantidadeDiasAtraso() {
        return quantidadeDiasAtraso;
    }

    public void setQuantidadeDiasAtraso(Long quantidadeDiasAtraso) {
        this.quantidadeDiasAtraso = quantidadeDiasAtraso;
    }
}