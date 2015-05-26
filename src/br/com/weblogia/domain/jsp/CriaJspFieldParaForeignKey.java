package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

import javax.persistence.ManyToOne;

import br.com.weblogia.domain.utils.StringUtils;

public class CriaJspFieldParaForeignKey extends TemplateDeFieldsJsp {

	public CriaJspFieldParaForeignKey(JspFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		if(field.isAnnotationPresent(ManyToOne.class))
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeJsp(Field field) {
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName();
		
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">\r\n");
		sb.append("									<label class=\"col-md-2\">"+ StringUtils.capitaliza(field.getName())+"</label>\r\n");
		sb.append("									<div class=\"col-md-8\">\r\n");
		sb.append("									    <input id=\""+field.getName()+"-select\" type=\"hidden\" class=\"form-control\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("								</div>\r\n");
		return sb.toString();
	}

}
