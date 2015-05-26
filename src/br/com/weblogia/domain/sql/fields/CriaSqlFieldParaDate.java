package br.com.weblogia.domain.sql.fields;

import java.lang.reflect.Field;
import java.util.Date;

public class CriaSqlFieldParaDate extends TemplateDeFields{

	public CriaSqlFieldParaDate(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Date.class)) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeSql(String nomeDoCampo) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(nomeDoCampo);
		sb.append(" ");
		sb.append(" DATE DEFAULT NULL,\r\n");
		return sb.toString();
	}

}
