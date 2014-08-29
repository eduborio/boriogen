package br.com.weblogia.domain.sql.fields;

import java.lang.reflect.Field;

public class CriaSqlFieldParaString extends TemplateDeFields{

	public CriaSqlFieldParaString(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().getSimpleName().equals("String")) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeSql(String nomeDoCampo) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(nomeDoCampo);
		sb.append(" ");
		sb.append("VARCHAR(45) DEFAULT NULL,\r\n");
		return sb.toString();
	}
}
