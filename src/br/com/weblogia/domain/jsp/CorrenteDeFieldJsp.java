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
		semtipo    = new FieldNaoImplementadoJsp(null);
		string     = new CriaJspFieldParaString(semtipo);
		booleano   = new CriaJspFieldParaBoolean(string);
		longId     = new CriaJspFieldParaLongId(booleano);
		endereco   = new CriaJspFieldParaEndereco(longId);
		integer    = new CriaJspFieldParaInteger(endereco);
		date       = new CriaJspFieldParaDate(longId);
		doubles    = new CriaJspFieldParaDouble(date);
		foreignKey = new CriaJspFieldParaForeignKey(doubles);
	}

	public String addJspField() {
		return foreignKey.criaCampoDeJsp(field);
	}
	
}
