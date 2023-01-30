package com.container.container.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    ContainerService containerService;

    @Autowired
    MovimentacaoService movimentacaoService;

    public List<String> consultarClientes() {
        return containerService.buscaClientes();
    }

    public List<Object[]> gerarRelatorio(String cliente, String tipo) {
        return movimentacaoService.buscaMovimentacaoPorClienteETipo(cliente, tipo);
    }
}
