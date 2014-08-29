package br.com.weblogia.domain.sql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

import br.com.weblogia.domain.sql.constraints.CorrenteDeConstraintSql;
import br.com.weblogia.domain.sql.fields.CorrenteDeFieldSql;
import br.com.weblogia.domain.sql.index.CorrenteDeIndexSql;

public class CreateSql {
	
	private String className;
	private CorrenteDeFieldSql chain;
    private CorrenteDeIndexSql indexChain;
    private CorrenteDeConstraintSql constraintChain;
    private List<String> linhas = new ArrayList<String>();
     
    public CreateSql(String className) {
		this.className = className;
    }
    
    public void criaSqlCreateStatement() {
    	ClassLoader cl = ClassLoader.getSystemClassLoader();
        try {
        	String linha = null;
        	
			Class<?> classe = cl.loadClass(className);
			
			String nomeDaTabela = classe.getSimpleName().toLowerCase();
			
			if(classe.isAnnotationPresent(Table.class))
				nomeDaTabela = classe.getAnnotation(Table.class).name();
			
			linhas.add("create table "+nomeDaTabela+"(\r\n");
				
			
			for(Field field: classe.getDeclaredFields()) {
	        	chain = new CorrenteDeFieldSql(field);
	        	linha = chain.addSqlField();
	        	if(linha!=null)
	        		linhas.add(linha);
	        }
	        
	        for(Field field: classe.getDeclaredFields()) {
	        	indexChain = new CorrenteDeIndexSql(field);
	        	linha = indexChain.addSqlIndex();
	        	if(linha!=null)
	        		linhas.add(linha);
	        }
	        
	        for(Field field: classe.getDeclaredFields()) {
	        	constraintChain = new CorrenteDeConstraintSql(field);
	        	linha = constraintChain.addConstraint();
	        	if(linha!=null)
	        		linhas.add(linha);
	        }
	        
	        linhas.set(linhas.size()-1,tiraUltimaVirgula());
	        linhas.add(")ENGINE=InnoDB CHARSET=latin1;");
	        
	        for(String str:linhas) {
	        	System.out.print(str);
	        }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    private String tiraUltimaVirgula() {
    	return linhas.get(linhas.size()-1).replace(",","");
    }
	
	

}
