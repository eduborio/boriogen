package br.com.weblogia.domain.sql.index;

import java.lang.reflect.Field;

public abstract class TemplateDeIndex implements SqlIndexBuilder {
	
	private final SqlIndexBuilder proximo;

	public TemplateDeIndex(SqlIndexBuilder builder) {
		this.proximo = builder;
	}

	@Override
	public String criaIndexDeSql(Field field) {
		if(ehDoTipoEsperado(field) ){
			return this.costroiIndiceDeSql(field);
		}else {
			return proximo.criaIndexDeSql(field);
		}
	}
	
	public abstract boolean ehDoTipoEsperado(Field field);
	public abstract String  costroiIndiceDeSql(Field field);

}
