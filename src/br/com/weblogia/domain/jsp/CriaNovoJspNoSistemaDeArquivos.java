package br.com.weblogia.domain.jsp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CriaNovoJspNoSistemaDeArquivos {

	public void criaArquivo(Class<?> classe, String rootDoProjeto,	boolean isMaven) throws IOException {
		CreateNovoJsp createJsp = new CreateNovoJsp(classe);
		createJsp.criaJspNovo();
		
		String caminhoDosSqls;
		
		if(isMaven){
			caminhoDosSqls = "\\src\\main\\webapp\\WEB-INF\\jsp";
		}else{
			caminhoDosSqls = "\\WebContent\\WEB-INF\\jsp";
		}
		
		File mainDir = new File(rootDoProjeto);
		File sqls = new File(mainDir.getCanonicalPath()+caminhoDosSqls);
		
		if(!sqls.exists()) {
			System.out.println("Pasta: sqls nao encontrada!!");
			//sqls.mkdirs();
		}
		
		File novoArquivo = new File(mainDir.getCanonicalPath()+caminhoDosSqls+"\\novo.jsp");
		
		PrintWriter writer = new PrintWriter(novoArquivo);
		for(String linha: createJsp.getLinhas()) {
			writer.print(linha);
		}
		writer.close();
		
	}

}
