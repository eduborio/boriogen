package br.com.weblogia.domain.sql.index;

import java.lang.reflect.Field;

public class IndexNaoImplementado extends TemplateDeIndex{

	public IndexNaoImplementado(SqlIndexBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		return true;
	}

	@Override
	public String costroiIndiceDeSql(Field field) {
		return "";
	}

}
