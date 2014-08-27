package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public interface SqlFieldBuilder {
	String criaCampoDeSql(Field field);

}
