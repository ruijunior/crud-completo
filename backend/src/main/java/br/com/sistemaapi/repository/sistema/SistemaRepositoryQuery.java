package br.com.sistemaapi.repository.sistema;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.sistemaapi.model.Sistema;
import br.com.sistemaapi.repository.filter.SistemaFilter;

public interface SistemaRepositoryQuery {
	
	public Page<Sistema> filtrar(SistemaFilter sistemaFilter, Pageable pageable);

}
