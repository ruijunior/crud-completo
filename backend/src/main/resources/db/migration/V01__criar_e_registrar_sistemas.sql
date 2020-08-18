create table sistema (
	id bigint(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(100) not null,
	sigla varchar(10) not null,
	email_atendimento varchar(100),
	url varchar(50), 
	status boolean not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into sistema (descricao, sigla, email_atendimento, url, status) values
('Sistema UM','SUM','rbs@teste1.com','http://www.teste1.com', true),
('Sistema DOIS','SDO','rbs@teste2.com','http://www.teste2.com', true),
('Sistema TRES','STR','rbs@teste3.com','http://www.teste3.com', true),
('Sistema QUATRO','SQUA','rbs@teste4.com','http://www.teste4.com', true),
('Sistema CINCO','SCIN','rbs@teste5.com','http://www.teste5.com', true),
('Sistema SEIS','SSEIS','rbs@teste6.com','http://www.teste6.com', true),
('Sistema SETE','SST','rbs@teste7.com','http://www.teste7.com', true),
('Sistema OITO','SOITO','rbs@teste8.com','http://www.teste8.com', true),
('Sistema NOVE','SNV','rbs@teste9.com','http://www.teste9.com', true),
('Sistema DEZ','SDZ','rbs@teste0.com','http://www.teste0.com', true);