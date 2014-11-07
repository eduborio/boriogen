
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.*;
import java.nio.file.attribute.*;

import br.com.weblogia.domain.sql.CriaSqlNoSistemaDeArquivos;
import br.com.weblogia.domain.utils.PathFinder;
import static java.nio.file.FileVisitResult.*;


public class App {

    public static class Finder
        extends SimpleFileVisitor<Path> {

        private final PathMatcher matcher;
        private int numMatches = 0;
        private Path arquivoEncontrado;

        Finder(String pattern) {
            matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        }

        // Compares the glob pattern against
        // the file or directory name.
        void find(Path file) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name)) {
                numMatches++;
                //System.out.println(file);
                arquivoEncontrado = file;
            }
        }

        // Prints the total number of
        // matches to standard out.
        void done() {
            System.out.println("Matched: "
                + numMatches);
        }

        // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file,
                BasicFileAttributes attrs) {
            find(file);
            return CONTINUE;
        }

        // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                BasicFileAttributes attrs) {
            find(dir);
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file,
                IOException exc) {
            System.err.println(exc);
            return CONTINUE;
        }
    }

    static void usage() {
        System.err.println("app create all|sql|dao|repositorio|jsp-list|jsp-novo <NomeDaClasse>");
        System.err.println("voce deve estar no diretorio raiz do seu projeto");
        System.exit(-1);
    }

    public static void main(String[] args)
        throws IOException, ClassNotFoundException {
    	
    	boolean isMaven = false;
    	
    	verificaSeEhRaizDoProjeto();
    	if(usandoMaven()){
    		System.out.println("Estrutura maven detectada...");
    		isMaven = true;
    	}
    	
    	String comandosPermitidos = "|all|sql|dao|repositorio|jsp-list|jsp-novo|";
        if (args.length < 3 || !args[0].equals("create") || !comandosPermitidos.contains(args[1])|| args[2] == null)
            usage();

        Path startingDir = Paths.get(".");
        String pattern = args[2]+".class";
        
        Finder finder = new Finder(pattern);
        Files.walkFileTree(startingDir, finder);
        
        if(finder.numMatches == 0 && args[2]!= null){
        	System.out.println("Classe "+args[2] + " nao encontrada");
        }else{
        	System.out.println(finder.arquivoEncontrado);
        	Class<?> classe =carregaClasse(finder.arquivoEncontrado);
        	PathFinder pathFinder = new PathFinder(finder.arquivoEncontrado);
        	
        	if(args[1].equals("sql") || args[1].equals("all")){
        		CriaSqlNoSistemaDeArquivos creator = new CriaSqlNoSistemaDeArquivos();
        		creator.criaArquivo(classe, pathFinder.getRootDoProjeto(), isMaven);
        	}
        }
    }

	@SuppressWarnings("resource")
	private static Class<?> carregaClasse(Path arquivoEncontrado) throws IOException {
		
		PathFinder pathFinder = new PathFinder(arquivoEncontrado);
        
		File file = new File(pathFinder.getPastaClasses());
		
		Class<?> classe = null;

		try {
		    @SuppressWarnings("deprecation")
			URL url = file.toURL();          
		    URL[] urls = new URL[]{url};

		    ClassLoader cl = new URLClassLoader(urls);

		    classe = cl.loadClass(pathFinder.getClasseComPackage());
		    
		} catch (MalformedURLException e) {
		} catch (ClassNotFoundException e) {
		}
		return classe;
		
	}

	private static boolean usandoMaven() throws IOException {
		File mainDir = new File(".");
		File pom = new File(mainDir.getCanonicalPath()+"\\pom.xml");
		
		if(pom.exists()) {
			return true;
		};
		return false;
	}

	private static void verificaSeEhRaizDoProjeto() throws IOException {
		
		File mainDir = new File(".");
		File classpath = new File(mainDir.getCanonicalPath()+"\\.classpath");
		
		if(!classpath.exists()) {
			System.out.println("Vc nao esta no raiz do seu projeto!!!");
			System.exit(-1);
		};
		
	}
}