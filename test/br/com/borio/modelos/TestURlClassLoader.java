package br.com.borio.modelos;

import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class TestURlClassLoader {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		File file = new File("C:/Borius/vendas/tkl/src/main/webapp/web-inf/classes");

		try {
		    // Convert File to a URL
		    @SuppressWarnings("deprecation")
			URL url = file.toURL();          // file:/c:/myclasses/
		    URL[] urls = new URL[]{url};

		    // Create a new class loader with the directory
		    ClassLoader cl = new URLClassLoader(urls);

		    // Load in the class; MyClass.class should be located in
		    // the directory file:/c:/myclasses/com/mycompany
		    Class<?> cls = cl.loadClass("br.com.weblogia.tkl.domain.Produto");
		    for(Field field: cls.getDeclaredFields()) {
		    	System.out.println(field.getName());
		    }
		    
		    
		} catch (MalformedURLException e) {
		} catch (ClassNotFoundException e) {
		}
	}

}
