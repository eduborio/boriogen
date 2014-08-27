package br.com.borio.modelos;

import java.lang.reflect.Field;

public class TesteClassLoaderDuds {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader myClassLoader = ClassLoader.getSystemClassLoader();
        String classNameToBeLoaded = "br.com.borio.modelos.CorrenteDeTipos";
        Class myClass = myClassLoader.loadClass(classNameToBeLoaded);
        //Object obj = myClass.newInstance();
        
        for(Field field: myClass.getDeclaredFields()) {
        	System.out.println(field.getType().getSimpleName() + " " +field.getName());
        }
        
        
        
        
        
	}

}
