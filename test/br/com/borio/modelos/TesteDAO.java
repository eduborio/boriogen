package br.com.borio.modelos;

import br.com.weblogia.domain.dao.CreateDAO;

public class TesteDAO {
	
	public static void main(String[] args) {
		
		CreateDAO createDAO = new CreateDAO("br.com.weblogia.domain.Produto");
		createDAO.criaInterfaceRepositorio();
		createDAO.criaClasseDAO();
		
		for(String linha: createDAO.getLinhasRepositorio()) {
			System.out.print(linha);
		}
		
		for(String linha: createDAO.getLinhasDAO()) {
			System.out.print(linha);
		}
		
	}

}
