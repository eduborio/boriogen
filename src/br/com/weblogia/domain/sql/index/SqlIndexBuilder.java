package br.com.weblogia.domain.sql.index;

import java.lang.reflect.Field;

public interface SqlIndexBuilder {
	String criaIndexDeSql(Field field);
}
