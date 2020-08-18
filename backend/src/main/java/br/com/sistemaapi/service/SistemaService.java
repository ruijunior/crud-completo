package br.com.sistemaapi.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.sistemaapi.model.Sistema;
import br.com.sistemaapi.repository.SistemaRepository;
import br.com.sistemaapi.repository.filter.SistemaFilter;

@Service
public class SistemaService {

	
	@Autowired
	private SistemaRepository sistemaRepository;
	
	public Page<Sistema> pesquisar(SistemaFilter sistemaFilter, Pageable pageable) {
		return this.sistemaRepository.filtrar(sistemaFilter, pageable);
	}
	
	@Transactional
	public Sistema salvar(Sistema sistema) {
		return this.sistemaRepository.save(sistema);
	}
	
	public Optional<Sistema> buscarPeloId(Long id) {
		return this.sistemaRepository.findById(id);
	}

	public Sistema atualizar(Long id, @Valid Sistema sistema) {
		Sistema sistemaSalvo = this.buscarPeloId(id).get();
		
		BeanUtils.copyProperties(sistema, sistemaSalvo, "id");
		return this.sistemaRepository.save(sistemaSalvo);
	}

}
