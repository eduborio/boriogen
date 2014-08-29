package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CorrenteDeIndexSql {

	SqlIndexBuilder semtipo;
	SqlIndexBuilder primaryKey;
	SqlIndexBuilder foreignKey;
	
	private Field field;

	public CorrenteDeIndexSql(Field field) {
		this.field = field;
		semtipo    = new IndexNaoImplementado(null);
		primaryKey = new CriaSqlIndexPrimario(semtipo);
		foreignKey = new CriaSqlIndexParaForeignKey(primaryKey);
	}

	public String addSqlIndex() {
		return foreignKey.criaIndexDeSql(field);
	}
	
}
