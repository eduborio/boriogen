package br.com.weblogia.modelos;

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
