package com.container.container.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Entity
@Table(name = "container")
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(min =3, max = 150)
    private String cliente;

    @NotNull
    @Pattern(regexp = "[A-Z]{4}\\d{7}")
    @Column(name = "numero_container" )
    private String numeroContainer;

    @Range(min = 20, max = 40)
    @Column(name = "tipo_container" )
    private int tipoContainer;

    @NotNull
    private boolean cheio;

    @NotNull String categoria;

    @OneToMany(mappedBy = "container", cascade =CascadeType.ALL)
    @JsonIgnoreProperties("container")
    private List<Movimentacao> movimentacao;


}
