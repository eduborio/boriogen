package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CorrenteDeIndexSql {

	SqlIndexBuilder semtipo;
	SqlIndexBuilder primaryKey;
	
	private Field field;

	public CorrenteDeIndexSql(Field field) {
		this.field = field;
		semtipo    = new IndexNaoImplementado(null);
		primaryKey = new CriaSqlIndexPrimario(semtipo);
	}

	public String addSqlIndex() {
		return primaryKey.criaIndexDeSql(field);
	}
	
}
