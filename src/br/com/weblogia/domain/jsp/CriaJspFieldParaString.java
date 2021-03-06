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
		sb.append("						<div class=\"row\">\r\n");
		sb.append("							<div class=\"col-md-3\">\r\n");
		sb.append("								<label>"+ StringUtils.capitaliza(field.getName())+"</label>\r\n");
		sb.append("								<input type=\"text\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>\r\n");
		sb.append("							</div>\r\n");
		sb.append("						</div>\r\n");
		return sb.toString();
	}
}
