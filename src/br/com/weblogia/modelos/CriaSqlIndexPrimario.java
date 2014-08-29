package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriaSqlIndexPrimario extends TemplateDeFields{

	public CriaSqlIndexPrimario(SqlFieldBuilder builder) {
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
		return "  primary key (id),\r\n";
	}

}
