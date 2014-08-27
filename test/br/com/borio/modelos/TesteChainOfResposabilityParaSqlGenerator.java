package br.com.borio.modelos;

import java.lang.reflect.Field;

import br.com.weblogia.modelos.CorrenteDeTipos;

public class TesteChainOfResposabilityParaSqlGenerator {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		ClassLoader cl = ClassLoader.getSystemClassLoader();
        String nomeDaClasse = "br.com.weblogia.modelos.Produto";
        Class<?> clazz = cl.loadClass(nomeDaClasse);
        
        CorrenteDeTipos chain= null;
        
        for(Field field: clazz.getDeclaredFields()) {
        	chain = new CorrenteDeTipos(field);
        	System.out.println(chain.addSqlField());
        }
		
		
		
	}

}
