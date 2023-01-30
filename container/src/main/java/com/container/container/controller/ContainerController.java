package com.container.container.controller;

import com.container.container.exception.ContainerException;
import com.container.container.model.Container;
import com.container.container.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/container")
public class ContainerController {

    @Autowired
    private ContainerService containerService;

    @GetMapping
    public Object listaTodos(){
        try {
            return ResponseEntity.ok(containerService.listaTodos());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Object listaContainerPorId(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(containerService.findById(id));
        } catch (ContainerException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("nome/{cliente}")
    public Object listaContainerPorCliente(@PathVariable String cliente) {
        try {
            return ResponseEntity.ok(containerService.listaContainerPorCliente(cliente));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @GetMapping("categoria/{categoria}")
    public Object listaContainerPorCategoria(@PathVariable String categoria) {
        try{
            return ResponseEntity.ok(containerService.findAllByCategoria(categoria));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> criaContainer(@RequestBody Container container){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(containerService.criaContainer(container));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizaContainer(@RequestBody Container container){
        try {
            return ResponseEntity.ok(containerService.atualizaContainer(container));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }

    }

    @DeleteMapping(path = "/{id}")
    public String deletaContainer(@PathVariable Long id) {
        try{
            return containerService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao deletar o container" + e.getMessage();
        }
    }
}
