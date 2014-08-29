create table produtos(
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(65) NOT NULL,
  foraDeLinha TINYINT(1) UNSIGNED DEFAULT '0',
  emPromocao TINYINT(1) UNSIGNED DEFAULT '0',
  euSouInt INT(10) UNSIGNED DEFAULT 0,
  euSouInteger INT(10) UNSIGNED DEFAULT 0,
  euSouDate  DATETIME DEFAULT NULL,
  euSouDouble DECIMAL(15,2) DEFAULT 0,
  euSoudoublePrimitivo DECIMAL(15,2) DEFAULT 0,
  euSouLong INT(10) UNSIGNED DEFAULT 0,
  euSouLongPrimitivo INT(10) UNSIGNED DEFAULT 0,
  cliente_id INT(10) UNSIGNED DEFAULT NULL,
  usuario_maroto VARCHAR(45) DEFAULT NULL,
  logradouro varchar(55) DEFAULT NULL,
  numero varchar(9) DEFAULT NULL,
  bairro varchar(20) DEFAULT NULL,
  cep varchar(8) DEFAULT NULL,
  telefone varchar(14) DEFAULT NULL,
  municipio_id int(10) unsigned default null,
  primary key (id),
  KEY fk_produto_cliente (cliente_id),
  constraint fk_produto_cliente foreign key (cliente_id) references cliente (id) on update restrict on delete restrict
 )ENGINE=InnoDB CHARSET=latin1;