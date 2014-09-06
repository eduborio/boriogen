package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

import br.com.weblogia.domain.utils.StringUtils;

public class FieldNaoImplementadoJsp extends TemplateDeFieldsJsp{

	public FieldNaoImplementadoJsp(JspFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		return true;
	}

	@Override
	public String costroiCampoDeJsp(Field field) {
		
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName();
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">\r\n");
		sb.append("									<label class=\"col-md-2\">"+ StringUtils.capitaliza(field.getName())+"</label>\r\n");
		sb.append("									<div class=\"col-md-7\">\r\n");
		sb.append("										<input type=\"text\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("								</div>\r\n");
		return sb.toString();
	}
}
