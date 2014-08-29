package br.com.weblogia.domain.sql.constraints;

import java.lang.reflect.Field;

public class CorrenteDeConstraintSql {

	SqlConstraintBuilder semtipo;
	SqlConstraintBuilder foreignKey;
	
	private Field field;

	public CorrenteDeConstraintSql(Field field) {
		this.field = field;
		semtipo    = new ConstraintNaoImplementado(null);
		foreignKey = new CriaSqlConstraintParaForeignKey(semtipo);
	}

	public String addConstraint() {
		return foreignKey.criaConstraintDeSql(field);
	}
	
}
