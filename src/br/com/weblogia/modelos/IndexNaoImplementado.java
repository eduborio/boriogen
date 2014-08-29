package br.com.weblogia.modelos;

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
