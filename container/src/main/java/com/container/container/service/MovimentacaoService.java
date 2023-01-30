package com.container.container.service;

import com.container.container.exception.ContainerException;
import com.container.container.model.Movimentacao;
import com.container.container.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public List<Movimentacao> buscaMovimentacoesPorIdContainer(Long idContainer) {
        return movimentacaoRepository.buscaMovimentacoesPorIdContainer(idContainer);
    }

    public List<Object[]> buscaMovimentacaoPorClienteETipo(String cliente, String tipo) {
        return  movimentacaoRepository.buscaMovimentacaoPorClienteETipo(cliente, tipo);
    }

    public Object listaTodos() {
        return movimentacaoRepository.findAll();
    }

    public Object criaMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public Object findById(Long id) throws ContainerException {
        return movimentacaoRepository.findById(id).orElseThrow(()-> new ContainerException("Movimentacao de id " + id + " não foi encontrada."));
    }

    public Object findAllByTipoMovimentacao(String tipo) {
        return movimentacaoRepository.findAllByTipoMovimentacao(tipo);
    }

    public Object atualizaMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public String deleteById(Long id) {
        try {
            movimentacaoRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
