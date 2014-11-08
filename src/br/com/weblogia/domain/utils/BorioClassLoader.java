package br.com.weblogia.domain.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class BorioClassLoader {

	@SuppressWarnings("resource")
	public Class<?> carregaClasse(String pastaClasses, String classeComPackage) {

		File file = new File(pastaClasses);
		Class<?> classe = null;

		try {
			URL url = file.toURI().toURL();
			URL[] urls = new URL[] { url };

			
			ClassLoader cl = new URLClassLoader(urls);
			classe = cl.loadClass(classeComPackage);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return classe;
	}

}
