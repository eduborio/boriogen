package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriaSqlFieldParaLongId extends TemplateDeTiposDeCampos{

	public CriaSqlFieldParaLongId(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Long.class) && field.getName().equals("id")) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeSql(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(field.getName());
		sb.append(" ");
		sb.append("INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,\r\n");
		return sb.toString();
	}

}
