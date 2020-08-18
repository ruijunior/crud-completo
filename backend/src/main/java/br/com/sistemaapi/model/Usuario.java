package br.com.sistemaapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name="usuario")
@Entity
@Data
@EqualsAndHashCode
public class Usuario implements Serializable {

	private static final long serialVersionUID = 3652061690489115958L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;
	private String email;
	private String senha;
	

}
