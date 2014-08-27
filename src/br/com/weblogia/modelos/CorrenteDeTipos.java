package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CorrenteDeTipos {

	SqlFieldBuilder string;
	SqlFieldBuilder booleano;
	private Field field;

	public CorrenteDeTipos(Field field) {
		this.field = field;
		string = new CriaSqlFieldParaString(null);
		booleano = new CriaSqlFieldParaBoolean(string);
	}

	public String addSqlField() {
		return booleano.criaCampoDeSql(field);
	}
	
}
