package br.com.sistemaapi.repository.sistema;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.com.sistemaapi.model.Sistema;
import br.com.sistemaapi.repository.filter.SistemaFilter;

public class SistemaRepositoryImpl implements SistemaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Sistema> filtrar(SistemaFilter sistemaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Sistema> criteria = builder.createQuery(Sistema.class);
		Root<Sistema> root = criteria.from(Sistema.class);
		
		Predicate[] predicates = criarRestricoes(sistemaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Sistema> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(sistemaFilter));
	}

	private Predicate[] criarRestricoes(SistemaFilter filter, CriteriaBuilder builder,
			Root<Sistema> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(filter.getDescricao())) {
			predicates.add(builder.like(
					builder.lower(root.get("descricao")), "%" + filter.getDescricao().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(filter.getEmail())) {
			predicates.add(builder.like(
					builder.lower(root.get("emailAtendimento")), "%" + filter.getEmail().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(filter.getSigla())) {
			predicates.add(builder.like(
					builder.lower(root.get("sigla")), "%" + filter.getSigla().toLowerCase() + "%"));
		}
		
	
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Sistema> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(SistemaFilter SistemaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Sistema> root = criteria.from(Sistema.class);
		
		Predicate[] predicates = criarRestricoes(SistemaFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
