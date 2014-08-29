package br.com.borio.modelos;

import br.com.weblogia.domain.sql.CreateSql;

public class TesteSqlCreate {
	
	public static void main(String[] args) {
		
		
		CreateSql createSql = new CreateSql("br.com.weblogia.domain.Produto");
		createSql.criaSqlCreateStatement();
	}

}
