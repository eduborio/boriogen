package br.com.borio.modelos;

import br.com.weblogia.domain.dao.CreateDAO;
import br.com.weblogia.domain.utils.BorioClassLoader;

public class TesteDAO {
	
	public static void main(String[] args) {
		
		BorioClassLoader cl = new BorioClassLoader(); 
		Class<?> classe = cl.carregaClasse("C:\\Borius\\vendas\\vendas\\build\\classes", "br.com.vendas.domain.NFeComplementar");
		
		CreateDAO createDAO = new CreateDAO(classe);
		createDAO.criaInterfaceRepositorio();
		createDAO.criaClasseDAO();
		
		for(String linha: createDAO.getLinhasRepositorio()) {
			System.out.print(linha);
		}
		
		for(String linha: createDAO.getLinhasDAO()) {
			System.out.print(linha);
		}
		
		System.out.println(createDAO.montaDiretoriosDaClasse(classe.getPackage().toString()));
	}

}
