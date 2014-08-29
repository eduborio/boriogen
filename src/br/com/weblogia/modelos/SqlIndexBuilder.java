package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public interface SqlIndexBuilder {
	String criaIndexDeSql(Field field);
}
