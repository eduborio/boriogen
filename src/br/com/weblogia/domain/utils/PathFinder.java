package br.com.weblogia.domain.utils;

import java.io.IOException;
import java.nio.file.Path;

public class PathFinder {
	
	private Path path;
	private String nomeDaClasse;
	private String rootDoProjeto;
	private String pastaClasses;
	private String classeComPackage;

	public PathFinder(Path path) throws IOException{
		this.path = path;
		processa();
	}

	private void processa() throws IOException {
		nomeDaClasse = path.getFileName().toString();
		
		rootDoProjeto = path.toAbsolutePath().toString();
        rootDoProjeto = rootDoProjeto.substring(0, rootDoProjeto.indexOf("."));
        
        String canonicPath = path.toFile().getCanonicalPath().toString();
        pastaClasses = canonicPath.substring(0,canonicPath.indexOf("classes")+7);
        
        classeComPackage = canonicPath.substring(canonicPath.indexOf("classes")+"classes".length(),canonicPath.length()-6);
        classeComPackage = classeComPackage.substring(1).replace("\\", ".");//Pula primeiro \ e troca por ponto
	}

	public Path getPath() {
		return path;
	}

	public String getNomeDaClasse() {
		return nomeDaClasse;
	}

	public String getRootDoProjeto() {
		return rootDoProjeto;
	}

	public String getPastaClasses() {
		return pastaClasses;
	}

	public String getClasseComPackage() {
		return classeComPackage;
	}
	
	

}
