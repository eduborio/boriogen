package br.com.weblogia.domain.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CreateDAO {
    	
	private List<String> linhasRepositorio= new ArrayList<String>();
	private List<String> linhasDAO= new ArrayList<String>();
	private Class<?> classe;
	
	public CreateDAO(Class<?> classe) {
		this.classe = classe;
	}
	
	public void criaInterfaceRepositorio() {
		
		linhasRepositorio.add(montaPackage(classe.getPackage().toString())+"repositorios;\r\n");
		linhasRepositorio.add("\r\n");
		linhasRepositorio.add("import java.util.List;\r\n");
		linhasRepositorio.add("import "+classe.getPackage().getName()+"."+classe.getSimpleName() +";\r\n");
			
		linhasRepositorio.add("public interface "+classe.getSimpleName()+"Repositorio{\r\n");
		linhasRepositorio.add("    "+classe.getSimpleName()+" buscaPorId(Long id);\r\n");
		linhasRepositorio.add("    List<"+classe.getSimpleName()+"> buscaTodos(int pagina);\r\n");
		linhasRepositorio.add("    List<"+classe.getSimpleName()+"> buscaTodos();\r\n");
		linhasRepositorio.add("    Long buscaTotalDeRegistrosDaLista();\r\n");
		linhasRepositorio.add("    void salva("+classe.getSimpleName()+" "+ classe.getSimpleName().toLowerCase() +");\r\n");
		linhasRepositorio.add("    void atualiza("+classe.getSimpleName()+" "+ classe.getSimpleName().toLowerCase() +");\r\n");
			
		for(Field field : classe.getDeclaredFields()) {

			if(field.getName().equals("nome"))
				linhasRepositorio.add("    List<"+classe.getSimpleName()+"> busca"+classe.getSimpleName()+"PorNome(String nome);\r\n");
			
			if(field.getName().equals("descricao"))
				linhasRepositorio.add("    List<"+classe.getSimpleName()+"> busca"+classe.getSimpleName()+"PorDescricao(String descricao);\r\n");
					
		}
		linhasRepositorio.add("    void setEmpresa(Empresa empresa);\r\n");
		linhasRepositorio.add("}\r\n");
	}
	
	public void criaClasseDAO() {
		
		linhasDAO.add(montaPackage(classe.getPackage().toString())+"repositorios.daos;\r\n");
		linhasDAO.add("\r\n");
		linhasDAO.add("import java.util.List;\r\n");
		linhasDAO.add("import "+classe.getPackage().getName()+"."+classe.getSimpleName() +";\r\n");
		linhasDAO.add("import javax.enterprise.context.RequestScoped;\r\n");
		linhasDAO.add("import javax.persistence.Query;\r\n");
		linhasDAO.add("\r\n");
		linhasDAO.add("@SuppressWarnings(\"unchecked\")\r\n");
		linhasDAO.add("@RequestScoped\r\n");
			
		linhasDAO.add("public class "+classe.getSimpleName()+"DAO extends DAO<"+classe.getSimpleName()+"> implements "+ classe.getSimpleName()+"Repositorio{\r\n");
		linhasDAO.add("\r\n");
		linhasDAO.add("    public "+classe.getSimpleName()+"DAO(){\r\n");
		linhasDAO.add("        super("+classe.getSimpleName()+".class);\r\n");
		linhasDAO.add("    }\r\n");
		linhasDAO.add("\r\n");
		
		for(Field field : classe.getDeclaredFields()) {
			
			if(field.getName().equals("nome")) {
				
				String alias = classe.getSimpleName().toLowerCase();
				
				linhasDAO.add("    @Override\r\n");
				linhasDAO.add("    public List<"+classe.getSimpleName()+"> busca"+classe.getSimpleName()+"PorNome(String nome) {\r\n");
				linhasDAO.add("        StringBuilder hql = new StringBuilder()\r\n");
				linhasDAO.add("        hql.append(\" From "+ classe.getSimpleName() +" "+alias+" \"); \r\n");
				linhasDAO.add("        hql.append(\" where "+alias+ ".nome like :nome \"); \r\n");
				linhasDAO.add("        hql.append(\" and "+alias+".empresa = :empresa \");\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("        hql.append(\" order by "+alias+".nome \");\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("        Query query = entityManager.createQuery(hql.toString());\r\n");
				linhasDAO.add("        query.setParameter(\"nome\", \"%\" + nome + \"%\");\r\n");
				linhasDAO.add("        query.setParameter(\"empresa\", this.empresa);\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("        return query.getResultList();\r\n");
				linhasDAO.add("    }\r\n");
			}
			
			if(field.getName().equals("descricao")) {
				String alias = classe.getSimpleName().toLowerCase();
				
				linhasDAO.add("    @Override\r\n");
				linhasDAO.add("    public List<"+classe.getSimpleName()+"> busca"+classe.getSimpleName()+"PorDescricao(String descricao) {\r\n");
				linhasDAO.add("        StringBuilder hql = new StringBuilder()\r\n");
				linhasDAO.add("        hql.append(\" From "+ classe.getSimpleName() +" "+alias+" \"); \r\n");
				linhasDAO.add("        hql.append(\" where "+alias+ ".descricao like :descricao \"); \r\n");
				linhasDAO.add("        hql.append(\" and "+alias+".empresa = :empresa \");\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("        hql.append(\" order by "+alias+".descricao \");\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("        Query query = entityManager.createQuery(hql.toString());\r\n");
				linhasDAO.add("        query.setParameter(\"descricao\", \"%\" + descricao + \"%\");\r\n");
				linhasDAO.add("        query.setParameter(\"empresa\", this.empresa);\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("\r\n");
				linhasDAO.add("        return query.getResultList();\r\n");
				linhasDAO.add("    }\r\n");
			}
		}
		linhasDAO.add("}\r\n");
	}

	public List<String> getLinhasRepositorio() {
		return linhasRepositorio;
	}
	
	public List<String> getLinhasDAO() {
		return linhasDAO;
	}

	public Class<?> getClasse() {
		return classe;
	}
	
	private String montaPackage(String packageDaClasseDeDominio) {
		int totalPontos = 0;
		for(char c : packageDaClasseDeDominio.toCharArray()) {
			if(c == '.') {
				totalPontos++;
			}
		}
		
		int pontos = 0;
		int index = 0;
		
		for(char c : packageDaClasseDeDominio.toCharArray()) {
			
			if(pontos == totalPontos)
				break;
			
			if(c == '.') {
				pontos++;
			}
			index++;
		}
		
		return packageDaClasseDeDominio.substring(0, index);
		
	}
	
}
