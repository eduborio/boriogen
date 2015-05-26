package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;
import java.util.Date;

import br.com.weblogia.domain.utils.StringUtils;

public class CriaJspFieldParaDate extends TemplateDeFieldsJsp {

	public CriaJspFieldParaDate(JspFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.getType().equals(Date.class))
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeJsp(Field field) {
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName();
		
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">\r\n");
		sb.append("									<label class=\"col-md-2\">"+ StringUtils.capitaliza(field.getName())+"</label>\r\n");
		sb.append("									<div class=\"col-md-4\">\r\n");
		sb.append("									    <input type=\"text\" autocomplete=\"off\" class=\"form-control\" data-behaviour=\"datepicker\" name=\""+fieldCompleto+"\" id=\""+fieldCompleto+"\" value=\"<fmt:formatDate value='${"+fieldCompleto+"}' pattern='dd/MM/yyyy'/>\" />\r\n");
		sb.append("									</div>\r\n");
		sb.append("								</div>\r\n");
		return sb.toString();
	}

}
