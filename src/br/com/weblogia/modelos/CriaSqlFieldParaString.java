package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriaSqlFieldParaString extends TemplateDeTiposDeCampos{

	public CriaSqlFieldParaString(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType() != null) {
			System.out.println(field.getType().getSimpleName());
			if(field.getType().getSimpleName().equals("String")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String costroiCampoDeSql(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(field.getName());
		sb.append(" ");
		sb.append("VARCHAR(45) DEFAULT NULL,\r\n");
		return sb.toString();
	}

}
