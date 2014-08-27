package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public abstract class TemplateDeTiposDeCampos implements SqlFieldBuilder {
	
	private final SqlFieldBuilder proximo;

	public TemplateDeTiposDeCampos(SqlFieldBuilder builder) {
		this.proximo = builder;
	}

	@Override
	public String criaCampoDeSql(Field field) {
		if(ehDoTipoEsperado(field) ){
			return this.costroiCampoDeSql(field);
		}else {
			return proximo.criaCampoDeSql(field);
		}
	}
	
	public abstract boolean ehDoTipoEsperado(Field field);
	public abstract String  costroiCampoDeSql(Field field);

}
