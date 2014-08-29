package br.com.borio.modelos;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import br.com.weblogia.domain.sql.CreateSql;

public class TesteSqlCreate {
	
	public static void main(String[] args) throws IOException {
		
		
		CreateSql createSql = new CreateSql("br.com.weblogia.domain.Produto");
		createSql.criaSqlCreateStatement();
		
		File file = new File(".");
		File sqls = new File(file.getCanonicalPath()+"\\"+"WebContent\\sqls");
		
		if(!sqls.exists()) {
			System.out.println("Pasta:\\WebContent\\sqls não encontrada!!");
			sqls.mkdirs();
		}
		
		//BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/racepower/log.txt")));
		
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".sql");
			}
		};
		
		
		List<File> files = Arrays.asList(sqls.listFiles(filter));
		
		System.out.println(files.size());
		
		
	}

}
