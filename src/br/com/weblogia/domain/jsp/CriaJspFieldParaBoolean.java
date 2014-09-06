package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

import br.com.weblogia.domain.utils.StringUtils;

public class CriaJspFieldParaBoolean extends TemplateDeFieldsJsp{

	public CriaJspFieldParaBoolean(JspFieldBuilder builder) {
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
		
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName();
      
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">");
		sb.append("									<label class=\"col-md-2\">"+ StringUtils.capitaliza(field.getName())+"</label>");
		sb.append(" 								<div class=\"col-md-2\">");
		sb.append(" 									<select name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>");
		sb.append(" 										<option value=\"false\" <c:if test=\"${"+fieldCompleto+" == false}\">selected=\"selected\"</c:if>>Não</option>");
		sb.append(" 										<option value=\"true\" <c:if test=\"${"+fieldCompleto+" == true}\">selected=\"selected\"</c:if>>Sim</option>");
		sb.append(" 									</select>");
		sb.append("									</div>");
		sb.append("								</div>");
		return sb.toString();
	}
	

}
