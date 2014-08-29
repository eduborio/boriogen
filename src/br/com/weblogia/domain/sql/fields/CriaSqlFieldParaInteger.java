package br.com.weblogia.domain.sql.fields;

import java.lang.reflect.Field;

public class CriaSqlFieldParaInteger extends TemplateDeFields{

	public CriaSqlFieldParaInteger(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Integer.class) || field.getType().getSimpleName().equals("int") ||
		   field.getType().equals(Long.class) || field.getType().getSimpleName().equals("long")	) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeSql(String nomeDoCampo) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(nomeDoCampo);
		sb.append(" ");
		sb.append("INT(10) UNSIGNED DEFAULT 0,\r\n");
		return sb.toString();
	}

}
