package br.com.borio.modelos;

import br.com.weblogia.domain.dao.CreateDAO;

public class TesteDAO {
	
	public static void main(String[] args) {
		
		CreateDAO createDAO = new CreateDAO();
		createDAO.criaInterfacerepositorio("br.com.weblogia.domain.Produto");
		
		for(String linha: createDAO.getLinhas()) {
			System.out.print(linha);
		}
		
		
	}

}
