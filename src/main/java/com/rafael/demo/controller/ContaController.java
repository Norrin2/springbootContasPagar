package com.rafael.demo.controller;

import com.rafael.demo.model.Conta;
import com.rafael.demo.model.RegraCalculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;

@Controller
@CrossOrigin
@RequestMapping(path="/")
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private RegraCalculoRepository regraCalculoRepository;

    @PostMapping(path="/contas")
    public @ResponseBody
    ResponseEntity<Object> adicionaConta (@RequestBody Conta conta) {
        try {
            if (conta.getDataPagamento() == null || conta.getDataVencimento() == null) {
                return new ResponseEntity<>("É necessário informar a data de pagamento e vencimento!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            conta.setQuantidadeDiasAtraso(ChronoUnit.DAYS.between(conta.getDataVencimento().toInstant(), conta.getDataPagamento().toInstant()));
            if (conta.getQuantidadeDiasAtraso() > 0) {
                RegraCalculo regraCalculo = regraCalculoRepository.findFirstByQuantidadeDiasAtrasoIsLessThanEqualOrderByQuantidadeDiasAtrasoDesc(conta.getQuantidadeDiasAtraso());
                conta.setValorCorrigido(conta.getValorOriginal() +
                        (conta.getValorOriginal() * regraCalculo.getMulta() / 100) +
                        (conta.getValorOriginal() * (conta.getQuantidadeDiasAtraso() * regraCalculo.getJurosPorDia() / 100)));
            } else {
                conta.setValorCorrigido(conta.getValorOriginal());
            }
            repository.save(conta);
            return new ResponseEntity<>("Sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Algo de Errado Aconteceu!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path="/contas")
    public @ResponseBody ResponseEntity<Object> getContas(
            @RequestParam(defaultValue="0") Integer numeroDaPagina,
            @RequestParam(defaultValue="10") Integer tamanhoDaPagina) {
        Pageable pageable = PageRequest.of(numeroDaPagina, tamanhoDaPagina);
        try {
            return new ResponseEntity<>(repository.findAll(pageable),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Algo de Errado Aconteceu!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
