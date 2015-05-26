package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

import br.com.weblogia.domain.utils.StringUtils;

public class CriaJspFieldParaInteger extends TemplateDeFieldsJsp{

	public CriaJspFieldParaInteger(JspFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Integer.class) || field.getType().getSimpleName().equals("int")) 
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeJsp(Field field) {
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName();
		
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">\r\n");
		sb.append("									<label class=\"col-md-2\">"+ StringUtils.capitaliza(field.getName())+"</label>\r\n");
		sb.append("									<div class=\"col-md-3\">\r\n");
		sb.append("										<input type=\"text\" name=\""+fieldCompleto+"\" data-behaviour=\"integer\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("								</div>\r\n");
		return sb.toString();
	}

}
