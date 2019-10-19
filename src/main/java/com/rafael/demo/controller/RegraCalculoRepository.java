package com.rafael.demo.controller;

import com.rafael.demo.model.RegraCalculo;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;

public interface RegraCalculoRepository extends CrudRepository<RegraCalculo, Long> {

    RegraCalculo findFirstByQuantidadeDiasAtrasoIsLessThanEqualOrderByQuantidadeDiasAtrasoDesc(@NotNull Long quantidadeDiasAtraso);
}
