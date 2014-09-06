package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CreateNovoJsp {
	
	private CorrenteDeFieldJsp chain;
    private List<String> linhas = new ArrayList<String>();
    private Class<?> classe;
     
    public CreateNovoJsp(Class<?> classe) {
		this.classe = classe;
    }
    
    public void criaJspNovo() {
			String instancia = classe.getSimpleName().toLowerCase();
			
			criaHead(instancia);
			iniciaBody(instancia);
			preencheDadosDaClasse(instancia);
			finalizaBody(instancia);
    }

	private void criaHead(String instancia) {
		this.linhas.add("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>\r\n");
		this.linhas.add("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/fmt\" prefix=\"fmt\"%>\r\n");
		this.linhas.add("<!DOCTYPE html>\r\n");
		this.linhas.add("<html>\r\n");
		this.linhas.add("<head>\r\n");
		this.linhas.add("<title>"+ classe.getSimpleName()+"-Novo</title>\r\n");
		this.linhas.add("</head>\r\n");
	}
	
	private void iniciaBody(String instancia) {
		this.linhas.add("<body>\r\n");
		this.linhas.add("	<div id=\"content-cadastro\">\r\n");
		this.linhas.add("		<div id=\"content-header\">\r\n");
		this.linhas.add("			<h1>Novo "+classe.getSimpleName()+"</h1>\r\n");
		this.linhas.add("		</div>\r\n");
		
		this.linhas.add("		<div id=\"content-container\">\r\n");
		this.linhas.add("			<div class=\"row\">\r\n");
		this.linhas.add("				<c:forEach var=\"error\" items=\"${errors}\">\r\n");
		this.linhas.add("					<div class=\"alert alert-danger\">\r\n");
		this.linhas.add("						<a class=\"close\" data-dismiss=\"alert\" href=\"#\" aria-hidden=\"true\">&times;</a>\r\n");
		this.linhas.add("						<strong>Erro!</strong> ${error.message}\r\n");
		this.linhas.add("					</div>\r\n");
		this.linhas.add("				</c:forEach>\r\n");

		this.linhas.add("				<div class=\"col-md-2 col-sm-3\">\r\n");
		this.linhas.add("				</div>\r\n");
		this.linhas.add("				<div class=\"col-md-10 col-sm-9\">\r\n");
		this.linhas.add("					<div class=\"tab-content stacked-content\">\r\n");
		this.linhas.add("						<div class=\"tab-pane fade in active\" id=\"identif-tab\">\r\n");
		this.linhas.add("							<form method=\"POST\" action=\"<c:url value=\'/"+instancia+"s"+"/salvar\'/>\" class=\"form-horizontal\">\r\n");
	}
	
	private void preencheDadosDaClasse(String instancia) {
		
		String linha = null;
		
		for(Field field: classe.getDeclaredFields()) {
        	chain = new CorrenteDeFieldJsp(field);
        	linha = chain.addJspField();
        	if(linha!=null)
        		linhas.add(linha);
        }
		
	}
	
	private void finalizaBody(String instancia) {
		linhas.add("							</form>\r\n");
		linhas.add("						</div>\r\n");
		linhas.add("					</div>\r\n");
		linhas.add("				</div>\r\n");
		linhas.add("			</div>\r\n");	
		linhas.add("		</div>\r\n");
		linhas.add("	</div>\r\n");
	}

	public List<String> getLinhas() {
		return linhas;
	}
	
	public Class<?> getClasse() {
		return this.classe;
	}

}
