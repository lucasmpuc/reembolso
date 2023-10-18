package com.sistema.reembolso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/reembolso")
public class Controller {

    @Autowired
    private ReembolsoRepository reembolsoRepository;

    @PostMapping
    public ResponseEntity<String> createReembolso(@RequestBody Reembolso reembolsoRequest) {
        Reembolso reembolso = new Reembolso();
        reembolso.setDescricao(reembolsoRequest.getDescricao());
        reembolso.setData(reembolsoRequest.getData());
        reembolso.setValor(reembolsoRequest.getValor());
        reembolso.setStatus("PENDENTE");

        reembolsoRepository.save(reembolso);
        return ResponseEntity.ok("Reembolso saved successfully!");
    }
}


