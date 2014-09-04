package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

import br.com.weblogia.domain.utils.StringUtils;

public class CriaSqlFieldParaBoolean extends TemplateDeFieldsJsp{

	public CriaSqlFieldParaBoolean(JspFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Boolean.class) || field.getType().getSimpleName().equals("boolean") )
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeJsp(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">");
		sb.append("									<label class=\"col-md-2\">"+ StringUtils.capitaliza(field.getName())+"</label>");
		sb.append(" 								<div class=\"col-md-7\">");
		sb.append(" 									<input type=\"text\" name=\""+field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName()+"\" value=\"${cliente.nome}\" class=\"form-control\"/>");
		sb.append("									</div>");
		sb.append("								</div>");
		return sb.toString();
	}
	

}
