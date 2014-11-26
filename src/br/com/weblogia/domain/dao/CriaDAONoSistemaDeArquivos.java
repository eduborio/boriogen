package br.com.weblogia.domain.dao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CriaDAONoSistemaDeArquivos {
	
	public void criaArquivo(Class<?> classe,String rootDoProjeto,boolean isMaven) throws ClassNotFoundException, IOException {
		CreateDAO  builder = new CreateDAO(classe);

		builder.criaInterfaceRepositorio();
		builder.criaClasseDAO();
		
		String caminhoDoRepositorio;
		
		if(isMaven){
			caminhoDoRepositorio = "\\src\\main\\java\\";
		}else{
			caminhoDoRepositorio = "\\src\\";
		}
		
		caminhoDoRepositorio += "\\"+builder.montaDiretoriosDaClasse(classe.getPackage().toString());
		caminhoDoRepositorio += "\\repositorios";
		
		File mainDir = new File(rootDoProjeto);
		File pastaRepositorios = new File(mainDir.getCanonicalPath()+caminhoDoRepositorio);
		
		if( !pastaRepositorios.exists()) {
			System.out.println("Pasta: repositorios nao encontrada!!");
		}
		
		File novoArquivoRepositorio = new File(mainDir.getCanonicalPath()+caminhoDoRepositorio+"\\"+classe.getSimpleName()+"Repositorio.java");
		
		if( novoArquivoRepositorio.exists()) {
			throw new RuntimeException("Arquivo "+classe.getSimpleName()+"Repositorio.class já existe");
		}
		PrintWriter writer = new PrintWriter(novoArquivoRepositorio);
		for(String linha: builder.getLinhasRepositorio()){
			writer.print(linha);
		}
		writer.close();
		
		File novoArquivoDAO = new File(mainDir.getCanonicalPath()+caminhoDoRepositorio+"\\daos\\"+classe.getSimpleName()+"DAO.java");
		
		if( novoArquivoDAO.exists()) {
			throw new RuntimeException("Arquivo "+classe.getSimpleName()+"DAO.class já existe");
		}
		PrintWriter writerDao = new PrintWriter(novoArquivoDAO);
		for(String linha: builder.getLinhasDAO()){
			writerDao.print(linha);
		}
		writerDao.close();
		
	}

}
