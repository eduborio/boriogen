package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CorrenteDeTipos {

	SqlFieldBuilder string;
	SqlFieldBuilder booleano;
	SqlFieldBuilder semtipo;
	private Field field;

	public CorrenteDeTipos(Field field) {
		this.field = field;
		semtipo  = new TipoNaoImplementado(null);
		string   = new CriaSqlFieldParaString(semtipo);
		booleano = new CriaSqlFieldParaBoolean(string);
	}

	public String addSqlField() {
		return booleano.criaCampoDeSql(field);
	}
	
}
