package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

public interface JspFieldBuilder {
	String criaCampoDeJsp(Field field);
}
