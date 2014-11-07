package br.com.weblogia.domain.sql.constraints;

import java.lang.reflect.Field;

public class ConstraintNaoImplementado extends TemplateDeConstraint{

	public ConstraintNaoImplementado(SqlConstraintBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		return true;
	}

	@Override
	public String costroiConstraintDeSql(Field field) {
		return "";
	}

}
