package com.container.container.repository;

import com.container.container.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    List<Movimentacao> findAllByTipoMovimentacao(String tipo);

    @Query(value = "select mov from Movimentacao mov where mov.container.id = :idContainer")
    List<Movimentacao> buscaMovimentacoesPorIdContainer(@Param("idContainer")Long idContainer);

    @Query(value = "select mov.tipoMovimentacao, to_char(mov.dataHoraInicio, 'DD/MM/YYYY HH:MI:SS'), to_char(mov.dataHoraFim, 'DD/MM/YYYY HH:MI:SS')," +
            " mov.container.cliente, mov.container.categoria, mov.container.numeroContainer" +
            " from Movimentacao mov" +
            " where mov.container.cliente = :cliente and mov.tipoMovimentacao = :tipo ")
    List<Object[]> buscaMovimentacaoPorClienteETipo(String cliente, String tipo);
}
