package br.com.weblogia.domain.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CreateDAO {
    	
	private List<String> linhas= new ArrayList<String>();
	private Class<?> classe;
	
	public void criaInterfacerepositorio(String className) {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		try {
			classe = cl.loadClass(className);
			
			linhas.add("public interface "+classe.getSimpleName()+"Repositorio{\r\n");
			linhas.add("    Long buscaPorId(Long id);\r\n");
			linhas.add("    List<"+classe.getSimpleName()+"> buscaTodos(int pagina);\r\n");
			linhas.add("    List<"+classe.getSimpleName()+"> buscaTodos();\r\n");
			linhas.add("    Long buscaTotalDeRegistrosDaLista();\r\n");
			linhas.add("    void salva("+classe.getSimpleName()+" "+ classe.getSimpleName().toLowerCase() +");\r\n");
			linhas.add("    void atualiza("+classe.getSimpleName()+" "+ classe.getSimpleName().toLowerCase() +");\r\n");
			
			
			for(Field field : classe.getDeclaredFields()) {
				System.out.println(field.getName());
				if(field.getName().equals("nome"))
					linhas.add("    List<"+classe.getSimpleName()+"> busca"+classe.getSimpleName()+"PorNome(String nome);\r\n");
				
				if(field.getName().equals("descricao"))
					linhas.add("    List<"+classe.getSimpleName()+"> busca"+classe.getSimpleName()+"PorDescricao(String descricao);\r\n");
					
			}
			linhas.add("    void setEmpresa(Empresa empresa);\r\n");
			linhas.add("}");
			
			System.out.println(classe.getPackage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<String> getLinhas() {
		return linhas;
	}
}
