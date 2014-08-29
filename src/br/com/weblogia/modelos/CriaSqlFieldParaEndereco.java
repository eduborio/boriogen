package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriaSqlFieldParaEndereco extends TemplateDeFields{

	public CriaSqlFieldParaEndereco(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		
		if(field.getType().getSimpleName().equals("Endereco"))
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeSql(String nomeDocampo) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(logradouro());
		sb.append(numero());
		sb.append(bairro());
		sb.append(cep());
		sb.append(telefone());
		sb.append(cidade());
		return sb.toString();
	}
	
	private String logradouro() {
		return "  logradouro varchar(55) DEFAULT NULL,\r\n";
	}
	private String numero() {
		return "  numero varchar(9) DEFAULT NULL,\r\n";
	}
	private String bairro() {
		return "  bairro varchar(20) DEFAULT NULL,\r\n";
	}
	private String cep() {
		return "  cep varchar(8) DEFAULT NULL,\r\n";
	}
	private String telefone() {
		return "  telefone varchar(14) DEFAULT NULL,\r\n";
	}
	private String cidade() {
		return "  municipio_id int(10) unsigned default null,\r\n";
	}

}
