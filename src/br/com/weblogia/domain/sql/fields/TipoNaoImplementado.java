package br.com.weblogia.domain.sql.fields;

import java.lang.reflect.Field;

public class TipoNaoImplementado extends TemplateDeFields{

	public TipoNaoImplementado(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		return true;
	}

	@Override
	public String costroiCampoDeSql(String nomeDoCampo) {
		StringBuilder sb = new StringBuilder();
		sb.append(" Nao há implementacao para o campo: ");
		sb.append(nomeDoCampo);
		sb.append(",\r\n");
		return sb.toString();
	}
}
