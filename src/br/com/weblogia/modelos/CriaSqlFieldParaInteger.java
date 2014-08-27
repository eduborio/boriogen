package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriaSqlFieldParaInteger extends TemplateDeTiposDeCampos{

	public CriaSqlFieldParaInteger(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Integer.class) || field.getType().getSimpleName().equals("int")) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeSql(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(field.getName());
		sb.append(" ");
		sb.append("INT(10) DEFAULT 0,\r\n");
		return sb.toString();
	}

}
