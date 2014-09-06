package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;

public class CriaJspFieldParaEndereco extends TemplateDeFieldsJsp{

	public CriaJspFieldParaEndereco(JspFieldBuilder builder) {
		super(builder);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		
		if(field.getType().getSimpleName().equals("Endereco"))
			return true;
		
		return false;
	}

	@Override
	public String costroiCampoDeJsp(Field field) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(logradouro(field));
		sb.append(numero(field));
		sb.append(complemento(field));
		sb.append(bairro(field));
		sb.append(cidadeMaisUf(field));
		sb.append(cepMaisFone(field));
		return sb.toString();
	}
	
	

	private String logradouro(Field field) {
		
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName()+".logradouro";
		
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">\r\n");
		sb.append("									<label class=\"col-md-2\">Logradouro</label>\r\n");
		sb.append(" 								<div class=\"col-md-7\">\r\n");
		sb.append(" 									<input type=\"text\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("								</div>\r\n");
		
		return sb.toString();
	}
	private String numero(Field field) {
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName()+".numero";
		
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">\r\n");
		sb.append("									<label class=\"col-md-2\">Numero</label>\r\n");
		sb.append(" 								<div class=\"col-md-2\">\r\n");
		sb.append(" 									<input type=\"text\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		
		return sb.toString();
	}
	
	private String complemento(Field field) {
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName()+".complemento";
		
		StringBuilder sb = new StringBuilder();
		sb.append("									<label class=\"col-md-1\">Complemento</label>\r\n");
		sb.append(" 								<div class=\"col-md-4\">\r\n");
		sb.append(" 									<input type=\"text\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("								</div>\r\n");
		
		return sb.toString();
	}
	
	private String bairro(Field field) {
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName()+".bairro";
		
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">\r\n");
		sb.append("									<label class=\"col-md-2\">Bairro</label>\r\n");
		sb.append(" 								<div class=\"col-md-7\">\r\n");
		sb.append(" 									<input type=\"text\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("								</div>\r\n");
		
		return sb.toString();
	}
	
	private String cidadeMaisUf(Field field) {
		
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName()+".municipio.id";
		String uf = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName()+".municipio.estado.sigla";
		String id = field.getDeclaringClass().getSimpleName().toLowerCase()+"-"+"municipio-id";
		
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">\r\n");
		sb.append("									<label class=\"col-md-2\">Cidade</label>\r\n");
		sb.append(" 								<div class=\"col-md-5\">\r\n");
		sb.append(" 									<input id=\""+id+"\" type=\"hidden\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("									<label class=\"col-md-1\">UF</label>\r\n");
		sb.append(" 								<div class=\"col-md-1\">\r\n");
		sb.append(" 									<input id=\"\" type=\"text\" name=\""+uf+"\" value=\"${"+uf+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("								</div>\r\n");
		
		return sb.toString();
	}
	
	private String cepMaisFone(Field field) {
		
		String fieldCompleto = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName()+".cep";
		String fone = field.getDeclaringClass().getSimpleName().toLowerCase()+"."+field.getName()+".telefone";
		
		StringBuilder sb = new StringBuilder();
		sb.append("								<div class=\"form-group\">\r\n");
		sb.append("									<label class=\"col-md-2\">Cep</label>\r\n");
		sb.append(" 								<div class=\"col-md-3\">\r\n");
		sb.append(" 									<input type=\"text\" name=\""+fieldCompleto+"\" value=\"${"+fieldCompleto+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("									<label class=\"col-md-1\">Telefone</label>\r\n");
		sb.append(" 								<div class=\"col-md-3\">\r\n");
		sb.append(" 									<input type=\"text\" name=\""+fone+"\" value=\"${"+fone+"}\" class=\"form-control\"/>\r\n");
		sb.append("									</div>\r\n");
		sb.append("								</div>\r\n");
		
		return sb.toString();
	}

}
