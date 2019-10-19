package com.rafael.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="regra_calculo")
public class RegraCalculo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_conta")
    private Integer id;

    @Column
    @NotNull
    private Long quantidadeDiasAtraso;

    @Column
    @NotNull
    private Long multa;

    @Column
    @NotNull
    private Float jurosPorDia;

    public Long getQuantidadeDiasAtraso() {
        return quantidadeDiasAtraso;
    }

    public void setQuantidadeDiasAtraso(Long quantidadeDiasAtraso) {
        this.quantidadeDiasAtraso = quantidadeDiasAtraso;
    }

    public Long getMulta() {
        return multa;
    }

    public void setMulta(Long multa) {
        this.multa = multa;
    }

    public Float getJurosPorDia() {
        return jurosPorDia;
    }

    public void setJurosPorDia(Float jurosPorDia) {
        this.jurosPorDia = jurosPorDia;
    }

}
