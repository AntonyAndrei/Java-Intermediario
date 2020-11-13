package arquivosDeTexto;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
	
public class Application {

	public static void main(String[] args) {

		File Arquivo = new File("C:\\Windows\\Temp\\in.txt");
		Scanner ler = null;

		try {
			ler = new Scanner(Arquivo);
			while (ler.hasNextLine()) {
				System.out.println(ler.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		finally {
			if (ler != null) {
				ler.close();
			}

		}

	}

}
