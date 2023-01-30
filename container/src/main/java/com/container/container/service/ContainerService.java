package com.container.container.service;

import com.container.container.exception.ContainerException;
import com.container.container.model.Container;
import com.container.container.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    MovimentacaoService movimentacaoService;

    public Container findContainerById(Container container) {
        return containerRepository.findContainerById(container.getId());
    }

    public List<String> buscaClientes() {
        return containerRepository.buscaClientes();
    }

    public Container findById(Long id) throws ContainerException {
        return containerRepository.findById(id).orElseThrow(()-> new ContainerException("Container de id " + id + " não foi encontrado."));
    }

    public Object atualizaContainer(Container container) {
        container.setMovimentacao(movimentacaoService.buscaMovimentacoesPorIdContainer(container.getId()));
        return containerRepository.save(container);
    }

    public List<Container> listaContainerPorCliente(String cliente) {
        return containerRepository.findByCliente(cliente);
    }

    public List<Container> findAllByCategoria(String categoria) {
        return containerRepository.findAllByCategoria(categoria);
    }

    public Object criaContainer(Container container) {
        return containerRepository.save(container);
    }

    public Object listaTodos() {
        return containerRepository.findAll();
    }

    public String deleteById(Long id) {
        try{
            containerRepository.deleteById(id);
        }catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return "";
    }
}
