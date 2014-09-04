package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

public abstract class TemplateDeFieldsJsp implements JspFieldBuilder {
	
	private final JspFieldBuilder proximo;

	public TemplateDeFieldsJsp(JspFieldBuilder builder) {
		this.proximo = builder;
	}

	@Override
	public String criaCampoDeJsp(Field field) {
		if(ehDoTipoEsperado(field) ){
			return this.costroiCampoDeJsp(field);
		}else {
			return proximo.criaCampoDeJsp(field);
		}
	}
	
	public abstract boolean ehDoTipoEsperado(Field field);
	public abstract String  costroiCampoDeJsp(Field nomeDoCampo);

}
