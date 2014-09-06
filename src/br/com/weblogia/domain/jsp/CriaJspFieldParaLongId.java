package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

public class CriaJspFieldParaLongId extends TemplateDeFieldsJsp{

	public CriaJspFieldParaLongId(JspFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Long.class) && field.getName().equals("id")) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeJsp(Field field) {
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName();
		
		StringBuilder sb = new StringBuilder();
		sb.append(" 							<input type=\"hidden\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" />");
		return sb.toString();
	}

}
