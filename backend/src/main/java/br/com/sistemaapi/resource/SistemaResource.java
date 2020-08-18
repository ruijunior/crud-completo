package br.com.sistemaapi.resource;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistemaapi.model.Sistema;
import br.com.sistemaapi.repository.filter.SistemaFilter;
import br.com.sistemaapi.service.SistemaService;

@RestController
@RequestMapping("/sistemas")
public class SistemaResource {
	
	@Autowired
	private SistemaService sistemaService;

	@GetMapping
	public Page<Sistema> pesquisar(SistemaFilter sistemaFilter, Pageable pageable) {
		return this.sistemaService.pesquisar(sistemaFilter, pageable);
	}
	
	@PostMapping
	public ResponseEntity<Sistema> salvar(@Valid @RequestBody Sistema sistema, HttpServletResponse resp) {
		Sistema sistemaSalvo = this.sistemaService.salvar(sistema);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
			buildAndExpand(sistemaSalvo.getId()).toUri();
		
		resp.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(sistemaSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sistema> buscarPeloId(@PathVariable Long id) {
		Optional<Sistema> sistema = this.sistemaService.buscarPeloId(id);
		return sistema.isPresent() ? ResponseEntity.ok(sistema.get()) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Sistema> atualizar(@PathVariable Long id, @Valid @RequestBody Sistema sistema) {
		Sistema sistemaSalvo = this.sistemaService.atualizar(id, sistema);
		return ResponseEntity.ok(sistemaSalvo);
	}
	
}
