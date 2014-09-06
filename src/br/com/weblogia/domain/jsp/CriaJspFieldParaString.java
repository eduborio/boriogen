package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

import br.com.weblogia.domain.utils.StringUtils;

public class CriaJspFieldParaString extends TemplateDeFieldsJsp{

	public CriaJspFieldParaString(JspFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().getSimpleName().equals("String")) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeJsp(Field field) {
		
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName();
		
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">");
		sb.append("									<label class=\"col-md-2\">"+ StringUtils.capitaliza(field.getName())+"</label>");
		sb.append(" 								<div class=\"col-md-7\">");
		sb.append(" 									<input type=\"text\" name=\""+fieldCompleto+"."+field.getName()+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>");
		sb.append("									</div>");
		sb.append("								</div>");
		return sb.toString();
	}
}
