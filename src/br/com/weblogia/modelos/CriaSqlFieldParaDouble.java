package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriaSqlFieldParaDouble extends TemplateDeTiposDeCampos{

	public CriaSqlFieldParaDouble(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Double.class) || field.getType().getSimpleName().equals("double")) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeSql(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(field.getName());
		sb.append(" ");
		sb.append("DECIMAL(15,2) DEFAULT 0,\r\n");
		return sb.toString();
	}

}
