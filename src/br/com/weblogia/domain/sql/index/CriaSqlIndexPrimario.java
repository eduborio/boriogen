package br.com.weblogia.domain.sql.index;

import java.lang.reflect.Field;

public class CriaSqlIndexPrimario extends TemplateDeIndex{

	public CriaSqlIndexPrimario(SqlIndexBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Long.class) && field.getName().equals("id")) 
			return true;
		
		return false;
	}

	@Override
	public String costroiIndiceDeSql(Field field) {
		return "  primary key (id),\r\n";
	}

}
