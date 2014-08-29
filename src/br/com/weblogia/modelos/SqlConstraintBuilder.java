package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public interface SqlConstraintBuilder {
	String criaConstraintDeSql(Field field);
}
