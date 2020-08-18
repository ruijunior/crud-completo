package br.com.sistemaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistemaapi.model.Sistema;
import br.com.sistemaapi.repository.sistema.SistemaRepositoryQuery;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Long>, SistemaRepositoryQuery{

}
