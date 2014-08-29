package br.com.weblogia.modelos;

import java.lang.reflect.Field;

import javax.persistence.ManyToOne;

public class CriaSqlIndexParaForeignKey extends TemplateDeIndex{

	public CriaSqlIndexParaForeignKey(SqlIndexBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		
		if(field.isAnnotationPresent(ManyToOne.class))
			return true;
		
		return false;
	}

	@Override
	public String costroiIndiceDeSql(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append(field.getName()+"_id");
		sb.append(" ");
		sb.append("INT(10) UNSIGNED DEFAULT NULL,\r\n");
		return sb.toString();
	}

}
