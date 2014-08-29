package br.com.weblogia.domain.sql.fields;

import java.lang.reflect.Field;

public interface SqlFieldBuilder {
	String criaCampoDeSql(Field field);
}
