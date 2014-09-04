package br.com.weblogia.domain.jsp;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CreateNovoJsp {
	
	private String className;
	private CorrenteDeFieldJsp chain;
    private List<String> linhas = new ArrayList<String>();
    private Class<?> classe;
     
    public CreateNovoJsp(String className) {
		this.className = className;
    }
    
    public void criaJspNovo() {
    	ClassLoader cl = ClassLoader.getSystemClassLoader();
        try {
        	
			Class<?> classe = cl.loadClass(className);
			this.classe = classe; 
			
			String instancia = classe.getSimpleName().toLowerCase();
			
			criaHead(instancia);
			iniciaBody(instancia);
			preencheDadosDaClasse(instancia);
			finalizaBody(instancia);
	        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

	private void criaHead(String instancia) {
		this.linhas.add("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>");
		this.linhas.add("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/fmt\" prefix=\"fmt\"%>");
		this.linhas.add("<!DOCTYPE html>");
		this.linhas.add("<html>");
		this.linhas.add("<head>");
		this.linhas.add("<title>"+ classe.getSimpleName()+"-Novo</title>");
		this.linhas.add("</head>");
	}
	
	private void iniciaBody(String instancia) {
		this.linhas.add("<body>");
		this.linhas.add("	<div id=\"content-cadastro\">");
		this.linhas.add("		<div id=\"content-header\">");
		this.linhas.add("			<h1>Novo "+classe.getSimpleName()+"</h1>");
		this.linhas.add("		</div>");
		
		this.linhas.add("		<div id=\"content-container\">");
		this.linhas.add("			<div class=\"row\">");
		this.linhas.add("				<c:forEach var=\"error\" items=\"${errors}\">");
		this.linhas.add("					<div class=\"alert alert-danger\">");
		this.linhas.add("						<a class=\"close\" data-dismiss=\"alert\" href=\"#\" aria-hidden=\"true\">&times;</a>");
		this.linhas.add("						<strong>Erro!</strong> ${error.message}");
		this.linhas.add("					</div>");
		this.linhas.add("				</c:forEach>");

		this.linhas.add("				<div class=\"col-md-2 col-sm-3\">");
		this.linhas.add("				</div>");
		this.linhas.add("				<div class=\"col-md-10 col-sm-9\">");
		this.linhas.add("					<div class=\"tab-content stacked-content\">");
		this.linhas.add("						<div class=\"tab-pane fade in active\" id=\"identif-tab\">");
		this.linhas.add("							<form method=\"POST\" action=\"<c:url value=\'/"+instancia+"s"+"/salvar\'/>\" class=\"form-horizontal\">");
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
		linhas.add("							</form>");
		linhas.add("						</div>");
		linhas.add("					</div>");
		linhas.add("				</div>");
		linhas.add("			</div>");	
		linhas.add("		</div>");
		linhas.add("	</div>");
	}

	public List<String> getLinhas() {
		return linhas;
	}
	
	public Class<?> getClasse() {
		return this.classe;
	}

}
