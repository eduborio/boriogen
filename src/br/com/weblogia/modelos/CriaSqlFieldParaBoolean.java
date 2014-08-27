package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriaSqlFieldParaBoolean extends TemplateDeTiposDeCampos{

	public CriaSqlFieldParaBoolean(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType() != null) {
			System.out.println(field.getType().getSimpleName());
			if(field.getType().getSimpleName().equals("Boolean")) {
				System.out.println("SIM Booleano");
				return true;
			}
		}
		System.out.println("Nao Booleano");
		return false;
	}

	@Override
	public String costroiCampoDeSql(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(field.getName());
		sb.append(" ");
		sb.append("TINYINT(1) UNSIGNED DEFAULT \'0\',\r\n");
		return sb.toString();
	}
	

}
