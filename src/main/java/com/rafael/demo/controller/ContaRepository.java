package com.rafael.demo.controller;

import com.rafael.demo.model.Conta;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContaRepository extends PagingAndSortingRepository<Conta, Long> {

}
