package br.com.weblogia.domain.sql.index;

import java.lang.reflect.Field;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
		
		System.out.println(field);
		
		String fieldName = field.getName() + "_id";
		if(field.isAnnotationPresent(JoinColumn.class)) 
			fieldName = field.getAnnotation(JoinColumn.class).name();
		
		String classe = field.getDeclaringClass().getSimpleName();
		
		String references = field.getType().getSimpleName();
		if(field.getType().isAnnotationPresent(Table.class))
			references = field.getType().getAnnotation(Table.class).name();
		
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		sb.append("KEY fk_");
		sb.append(classe.toLowerCase());
		sb.append("_");
		sb.append(references.toLowerCase());
		sb.append(" (");
		sb.append(fieldName);
		sb.append("),\r\n");
		return sb.toString();
	}

}
