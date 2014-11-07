package br.com.borio.modelos;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.weblogia.domain.Produto;
import br.com.weblogia.domain.sql.CreateSql;

public class TesteSqlCreate {
	
	public static void main(String[] args) throws IOException {
		
		
		CreateSql createSql = new CreateSql(Produto.class);
		createSql.criaSqlCreateStatement();
		
		File mainDir = new File(".");
		File sqls = new File(mainDir.getCanonicalPath()+"\\"+"WebContent\\sqls");
		
		if(!sqls.exists()) {
			System.out.println("Pasta:\\WebContent\\sqls não encontrada!!");
			sqls.mkdirs();
		}
		
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".sql");
			}
		};
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd_HHmm");		
		
		List<File> files = Arrays.asList(sqls.listFiles(filter));
		File novoArquivo;
		
		if(files.size()==0) {
			novoArquivo = new File(mainDir.getCanonicalPath()+"\\"+"WebContent\\sqls\\"+fmt.format(new Date())+"_0_Cria"+createSql.getClasse().getSimpleName()+".sql");
		}else {
			novoArquivo = new File(mainDir.getCanonicalPath()+"\\"+"WebContent\\sqls\\"+fmt.format(new Date())+"_"+getVersionFromLastFile(files.get(files.size()-1)) +"_Cria"+createSql.getClasse().getSimpleName()+".sql");
		}
		
		//System.out.println(files.get(files.size()-1));
		//System.out.println(getVersionFromLastFile(files.get(files.size()-1)));
		
		PrintWriter writer = new PrintWriter(novoArquivo);
		for(String linha: createSql.getLinhas()) {
			writer.print(linha);
		}
		writer.close();
		
	}
	
	
	private static String getVersionFromLastFile(File file) {
		
		Integer version= 0;
		int cont = 0;
		String nome = file.getName();
		String nova = "";
		
		for(char c : nome.toCharArray()) {
			
			if(cont == 2) {
				nova += c;
			}
			
			if(c == '_') {
				cont++;
			}
		}
		
		version = Integer.parseInt(nova.substring(0,nova.length()-1));
		version ++;
		
		return version.toString();
		
	}

}
