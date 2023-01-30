package com.container.container.repository;

import com.container.container.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

    List<Container> findAllByCategoria(String categoria);

    List<Container> findByCliente(String cliente);

    @Query(value = "select * from Container where Container.id = :id", nativeQuery = true)
    Container findContainerById(Long id);

    @Query(value = "select distinct c.cliente from Container c")
    List<String> buscaClientes();
}
