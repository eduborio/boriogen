package br.com.weblogia.domain.sql.fields;

import java.lang.reflect.Field;

public class CriaSqlFieldParaLongId extends TemplateDeFields{

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
	public String costroiCampoDeSql(String nomeDoCampo) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(nomeDoCampo);
		sb.append(" ");
		sb.append("INT NOT NULL AUTO_INCREMENT,\r\n");
		return sb.toString();
	}

}
