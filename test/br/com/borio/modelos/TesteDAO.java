package br.com.borio.modelos;

import br.com.weblogia.domain.dao.CreateDAO;
import br.com.weblogia.domain.utils.BorioClassLoader;

public class TesteDAO {
	
	public static void main(String[] args) {
		
		BorioClassLoader cl = new BorioClassLoader(); 
		Class<?> classe = cl.carregaClasse("C:\\Borius\\vendas\\tkl\\src\\main\\webapp\\WEB-INF\\classes", "br.com.weblogia.tkl.domain.NotaFiscal");
		
		CreateDAO createDAO = new CreateDAO(classe);
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
