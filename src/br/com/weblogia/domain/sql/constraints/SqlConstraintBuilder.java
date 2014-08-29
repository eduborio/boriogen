package br.com.weblogia.domain.sql.constraints;

import java.lang.reflect.Field;

public interface SqlConstraintBuilder {
	String criaConstraintDeSql(Field field);
}
