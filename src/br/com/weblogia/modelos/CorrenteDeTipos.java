package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CorrenteDeTipos {

	SqlFieldBuilder semtipo;
	SqlFieldBuilder string;
	SqlFieldBuilder booleano;
	SqlFieldBuilder longId;
	SqlFieldBuilder integer;
	SqlFieldBuilder date;
	SqlFieldBuilder nome;
	SqlFieldBuilder doubles;
	SqlFieldBuilder foreignKey;
	
	private Field field;

	public CorrenteDeTipos(Field field) {
		this.field = field;
		semtipo  = new TipoNaoImplementado(null);
		string   = new CriaSqlFieldParaInteger(semtipo);
		booleano = new CriaSqlFieldParaBoolean(string);
		integer = new CriaSqlFieldParaString(booleano);
		longId = new CriaSqlFieldParaLongId(integer);
		date = new CriaSqlFieldParaDate(longId);
		nome = new CriaSqlFieldParaNomeOuDescricao(date);
		doubles = new CriaSqlFieldParaDouble(nome);
		foreignKey = new CriaSqlFieldParaForeignKey(doubles);
	}

	public String addSqlField() {
		return foreignKey.criaCampoDeSql(field);
	}
	
}
