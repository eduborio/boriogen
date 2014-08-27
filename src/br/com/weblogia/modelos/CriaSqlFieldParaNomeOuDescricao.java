package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriaSqlFieldParaNomeOuDescricao extends TemplateDeTiposDeCampos{

	public CriaSqlFieldParaNomeOuDescricao(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(String.class) && 
		  (field.getName().equals("nome") || field.getName().equals("descricao")) ) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeSql(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(field.getName());
		sb.append(" ");
		sb.append("VARCHAR(65) NOT NULL,\r\n");
		return sb.toString();
	}

}
