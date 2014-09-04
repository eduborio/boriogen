package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

public class CorrenteDeFieldJsp {

	JspFieldBuilder semtipo;
	JspFieldBuilder string;
	JspFieldBuilder booleano;
	JspFieldBuilder longId;
	JspFieldBuilder integer;
	JspFieldBuilder date;
	JspFieldBuilder nome;
	JspFieldBuilder doubles;
	JspFieldBuilder foreignKey;
	JspFieldBuilder endereco;
	
	private Field field;

	public CorrenteDeFieldJsp(Field field) {
		this.field = field;
		semtipo  = new FieldNaoImplementadoJsp(null);
		//string   = new CriaSqlFieldParaInteger(semtipo);
		//booleano = new CriaSqlFieldParaBoolean(string);
		//integer = new CriaSqlFieldParaString(booleano);
		//longId = new CriaSqlFieldParaLongId(integer);
		//date = new CriaSqlFieldParaDate(longId);
		//nome = new CriaSqlFieldParaNomeOuDescricao(date);
		//doubles = new CriaSqlFieldParaDouble(nome);
		//foreignKey = new CriaSqlFieldParaForeignKey(doubles);
		//endereco = new CriaSqlFieldParaEndereco(foreignKey);
	}

	public String addJspField() {
		return endereco.criaCampoDeJsp(field);
	}
	
}
