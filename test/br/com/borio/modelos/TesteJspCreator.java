package br.com.borio.modelos;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import br.com.weblogia.domain.jsp.CreateNovoJsp;

public class TesteJspCreator {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		File file = new File("C:\\Borius\\vendas\\tkl\\src\\main\\webapp\\WEB-INF\\classes");

		try {
		    // Convert File to a URL
			URL url = file.toURI().toURL();          // file:/c:/myclasses/
		    URL[] urls = new URL[]{url};

		    // Create a new class loader with the directory
		    ClassLoader cl = new URLClassLoader(urls);

		    // Load in the class; MyClass.class should be located in
		    // the directory file:/c:/myclasses/com/mycompany
		    Class<?> cls = cl.loadClass("br.com.weblogia.tkl.domain.NotaFiscal");
		    
		    CreateNovoJsp jsp = new CreateNovoJsp(cls);
		    jsp.criaJspNovo();
		    for(String linha : jsp.getLinhas()) {
		    	System.out.print(linha);
		    }
		    
		    
		} catch (MalformedURLException e) {
		} catch (ClassNotFoundException e) {
		}
	}
	
	

}
