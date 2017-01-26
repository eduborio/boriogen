package br.com.weblogia.domain.utils;

public class StringUtils {
	
	public static String capitaliza(String string) {
		return string.substring(0,1).toUpperCase() + string.substring(1,string.length());
	}

}
