package com.container.container.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tipo_movimentacao" )
    private String tipoMovimentacao;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyy HH:mm:ss")
    @Column(name = "data_hora_inicio" )
    private LocalDateTime dataHoraInicio;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyy HH:mm:ss")
    @Column(name = "data_hora_fim" )
    private LocalDateTime dataHoraFim;

    @ManyToOne
    @JsonIgnoreProperties("movimentacao")
    private Container container;

}
