package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CorrenteDeTipos {

	SqlFieldBuilder semtipo;
	SqlFieldBuilder string;
	SqlFieldBuilder booleano;
	SqlFieldBuilder longId;
	SqlFieldBuilder integer;
	
	private Field field;

	public CorrenteDeTipos(Field field) {
		this.field = field;
		semtipo  = new TipoNaoImplementado(null);
		string   = new CriaSqlFieldParaInteger(semtipo);
		booleano = new CriaSqlFieldParaBoolean(string);
		integer = new CriaSqlFieldParaString(booleano);
		longId = new CriaSqlFieldParaLongId(integer);
	}

	public String addSqlField() {
		return longId.criaCampoDeSql(field);
	}
	
}
