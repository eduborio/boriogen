package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class TipoNaoImplementado extends TemplateDeTiposDeCampos{

	public TipoNaoImplementado(SqlFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		return true;
	}

	@Override
	public String costroiCampoDeSql(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append(" Nao há implementacao para o Tipo: ");
		sb.append(field.getType().getSimpleName());
		sb.append(" ");
		sb.append(field.getName());
		sb.append(",\r\n");
		return sb.toString();
	}

}
