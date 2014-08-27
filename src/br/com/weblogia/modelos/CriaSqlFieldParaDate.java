package br.com.weblogia.modelos;

import java.lang.reflect.Field;
import java.util.Date;

public class CriaSqlFieldParaDate extends TemplateDeTiposDeCampos{

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
	public String costroiCampoDeSql(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(field.getName());
		sb.append(" ");
		sb.append(" DATETIME DEFAULT NULL,\r\n");
		return sb.toString();
	}

}
