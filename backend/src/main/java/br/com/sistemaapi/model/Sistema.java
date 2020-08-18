package br.com.sistemaapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Table(name = "sistema")
@Data
@EqualsAndHashCode
public class Sistema implements Serializable{

	
	
	private static final long serialVersionUID = 8665051346553065377L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@Size(max = 100, min = 5)
	@Column(name = "descricao", length = 100, nullable = false)
	private String descricao;
	
	@NotNull
	@Size(max = 10, min = 2)
	@Column(name = "sigla", length = 10, nullable = false)
	private String sigla;
	
	@Column(name = "email_atendimento", length = 100)
	private String emailAtendimento;
	
	@Column(name = "url", length = 50)
	private String url;
	
	@Column(name = "status", nullable = false)
	private boolean status = true;
	
}
