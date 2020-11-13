package manipulandoPastas;

import java.io.File;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		System.out.println("Enter a folder path: ");
		String strPath = ler.nextLine();
		
		File path = new File(strPath);
		
		//para listar as pastar do diretorio
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("Folders: ");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		//para listar os arquivos do diretorio
		File[] files = path.listFiles(File::isFile);
		System.out.println("Files: ");
		for (File file: files) {
			System.out.println(file);
		}
		
		//para criar uma subpasta na pasta 
		boolean sucess = new File(strPath + "\\PastaTeste").mkdir();
		if (sucess == true) {
			System.out.println("Diretorio criado com sucesso!");
		} else {
			System.out.println("Error");
		}
		
		ler.close();
		
	}

}
