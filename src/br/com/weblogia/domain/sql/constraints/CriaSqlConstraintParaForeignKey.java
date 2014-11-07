package br.com.weblogia.domain.sql.constraints;

import java.lang.reflect.Field;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class CriaSqlConstraintParaForeignKey extends TemplateDeConstraint{

	public CriaSqlConstraintParaForeignKey(SqlConstraintBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		
		if(field.isAnnotationPresent(ManyToOne.class))
			return true;
		
		return false;
	}

	@Override
	public String costroiConstraintDeSql(Field field) {
		
		String fieldName = field.getName() + "_id";
		if(field.isAnnotationPresent(JoinColumn.class)) 
			fieldName = field.getAnnotation(JoinColumn.class).name();
		
		String classe = field.getDeclaringClass().getSimpleName().toLowerCase();
		
		String references = field.getType().getSimpleName().toLowerCase();
		if(field.getType().isAnnotationPresent(Table.class))
			references = field.getType().getAnnotation(Table.class).name();
		
		StringBuilder sb = new StringBuilder();
		sb.append("  constraint ");
		sb.append("fk_");
		sb.append(classe.toLowerCase());
		sb.append("_");
		sb.append(references.toLowerCase());
		sb.append(" foreign key (");
		sb.append(fieldName);
		sb.append(") references ");
		sb.append(references);
		sb.append(" (id) on update restrict on delete restrict,\r\n ");
		return sb.toString();
	}

}
