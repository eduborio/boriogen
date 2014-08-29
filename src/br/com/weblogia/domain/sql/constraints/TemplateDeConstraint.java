package br.com.weblogia.domain.sql.constraints;

import java.lang.reflect.Field;

public abstract class TemplateDeConstraint implements SqlConstraintBuilder {
	
	private final SqlConstraintBuilder proximo;

	public TemplateDeConstraint(SqlConstraintBuilder builder) {
		this.proximo = builder;
	}

	@Override
	public String criaConstraintDeSql(Field field) {
		if(ehDoTipoEsperado(field) ){
			return this.costroiConstraintDeSql(field);
		}else {
			return proximo.criaConstraintDeSql(field);
		}
	}
	
	public abstract boolean ehDoTipoEsperado(Field field);
	public abstract String  costroiConstraintDeSql(Field field);

}
