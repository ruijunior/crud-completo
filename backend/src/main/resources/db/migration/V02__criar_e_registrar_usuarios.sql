CREATE TABLE usuario (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	email VARCHAR(100) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO usuario (nome, email, senha) values ('Administrador', 'admin@sistemas.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO usuario (nome, email, senha) values ('Rui Junior', 'rui@sistemas.com', '$2a$10$uFV9M5JVtFw/YkfEuDyvZOnjdtooUAKgtRMguJDBouMmUe630zH3i');