package br.com.borio.modelos;

import java.lang.reflect.Field;

import br.com.weblogia.modelos.CorrenteDeFieldSql;
import br.com.weblogia.modelos.CorrenteDeIndexSql;

public class TesteChainOfResposabilityParaSqlGenerator {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		ClassLoader cl = ClassLoader.getSystemClassLoader();
        String nomeDaClasse = "br.com.weblogia.modelos.Produto";
        Class<?> clazz = cl.loadClass(nomeDaClasse);
        
        CorrenteDeFieldSql chain= null;
        CorrenteDeIndexSql indexChain= null;
        
        for(Field field: clazz.getDeclaredFields()) {
        	chain = new CorrenteDeFieldSql(field);
        	System.out.print(chain.addSqlField());
        }
        for(Field field: clazz.getDeclaredFields()) {
        	indexChain = new CorrenteDeIndexSql(field);
        	System.out.print(indexChain.addSqlIndex());
        }
		
	}

}
