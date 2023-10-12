package com.sistema.reembolso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class Controller {
    @GetMapping("/ola")
    public String dizerOla() {
        return "Olá, Mundo!";
    }

    @RequestMapping("/reembolso")
    public class ReembolsoController {

        @Autowired
        private ReembolsoRepository reembolsoRepository;

        @PostMapping
        public ResponseEntity<String> createReembolso(@RequestParam String descricao, @RequestParam String data, @RequestParam Double valor) {
            Reembolso reembolso = new Reembolso();
            // id will be auto-generated if you're using an auto-increment column in the database
            reembolso.setDescricao(descricao);
            reembolso.setData(data);  // Assuming data is in 'yyyy-MM-dd' format
            reembolso.setValor(valor);
            reembolso.setStatus("PENDENTE");

            reembolsoRepository.save(reembolso);
            return ResponseEntity.ok("Reembolso saved successfully!");
        }
    }
}

