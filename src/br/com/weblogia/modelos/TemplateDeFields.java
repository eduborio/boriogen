package br.com.weblogia.modelos;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

public abstract class TemplateDeFields implements SqlFieldBuilder {
	
	private final SqlFieldBuilder proximo;

	public TemplateDeFields(SqlFieldBuilder builder) {
		this.proximo = builder;
	}

	@Override
	public String criaCampoDeSql(Field field) {
		if(ehDoTipoEsperado(field) ){
			
			if(field.isAnnotationPresent(Column.class)) 
				return  this.costroiCampoDeSql(field.getAnnotation(Column.class).name());
			
			if(field.isAnnotationPresent(JoinColumn.class)) 
				return  this.costroiCampoDeSql(field.getAnnotation(JoinColumn.class).name());
			
			return this.costroiCampoDeSql(field.getName());
		}else {
			return proximo.criaCampoDeSql(field);
		}
	}
	
	public abstract boolean ehDoTipoEsperado(Field field);
	public abstract String  costroiCampoDeSql(String nomeDoCampo);

}
