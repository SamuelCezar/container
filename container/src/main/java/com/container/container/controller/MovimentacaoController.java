package com.container.container.controller;

import com.container.container.exception.ContainerException;
import com.container.container.model.Movimentacao;
import com.container.container.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @GetMapping
    public Object listaTodos(){
        try {
            return ResponseEntity.ok(movimentacaoService.listaTodos());
        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR + e.getMessage() ;
        }
    }

    @GetMapping("/{id}")
    public Object listaMovimentacaoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(movimentacaoService.findById(id));
        } catch (ContainerException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/tipo/{tipo}")
    public Object listaMovimentacaoPorTipo(@PathVariable String tipo) {
        try {
            return ResponseEntity.ok(movimentacaoService.findAllByTipoMovimentacao(tipo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> criaMovimentacao(@RequestBody Movimentacao movimentacao){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoService.criaMovimentacao(movimentacao));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizaMovimentacao(@RequestBody Movimentacao movimentacao){
        try {
            return ResponseEntity.ok(movimentacaoService.atualizaMovimentacao(movimentacao));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public String deletaMovimentacao(@PathVariable Long id) {
        try {
            movimentacaoService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return "";
    }
}
