package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriaSqlFieldParaBoolean extends TemplateDeFields{

	public CriaSqlFieldParaBoolean(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Boolean.class) || field.getType().getSimpleName().equals("boolean") )
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeSql(String fieldName) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(fieldName);
		sb.append(" ");
		sb.append("TINYINT(1) UNSIGNED DEFAULT \'0\',\r\n");
		return sb.toString();
	}
	

}
