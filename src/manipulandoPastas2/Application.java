package manipulandoPastas2;

import java.io.File;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		
		System.out.println("Enter a file path: ");
		String strPath = ler.nextLine();
		
		File path = new File(strPath);
		
		System.out.println("Nome do Arquivo: " + path.getName());
		System.out.println("Diret�rio da Pasta que o arquivo est�: " + path.getParent());
		System.out.println("Diret�rio completo: " + path.getPath());
		
		
	}

}
