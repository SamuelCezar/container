package com.container.container.controller;
import com.container.container.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;

    @GetMapping("/consultarClientes")
    public Object consultarClientes() {
        try {
            return ResponseEntity.ok(this.relatorioService.consultarClientes());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/gerarRelatorio")
    public Object gerarRelatorio(
            @RequestParam(name = "cliente") String cliente,
            @RequestParam(name = "tipo") String tipo
    ) {
        try {
             return ResponseEntity.ok(this.relatorioService.gerarRelatorio(cliente, tipo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
