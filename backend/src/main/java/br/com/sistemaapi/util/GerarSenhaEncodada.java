package br.com.sistemaapi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenhaEncodada {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder enco = new BCryptPasswordEncoder();
		System.out.println(enco.encode("1234"));
	}

}
