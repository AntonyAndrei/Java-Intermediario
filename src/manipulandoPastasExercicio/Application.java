package manipulandoPastasExercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		
		List<Product> listaProdutos = new ArrayList<>();
		
		System.out.println("Digite o diretório do arquivo: ");
		
		// coloca o diretorio do arquivo numa string
		String diretorioArquivo = ler.nextLine(); 
		
		//cria uma variavel file com o diretorio do arquivo
		File diretorio = new File(diretorioArquivo); 
		
		//coloca o diretorio pai numa string
		String diretorioPai = diretorio.getParent();
		
		//cria a pasta out a partir do diretorio pai
		boolean sucess = new File(diretorioPai + "\\out").mkdir(); 
		
		//cria o arquivo .csv vazio na pasta out a partir do diretorio pai
		String arquivoOut = diretorioPai + "\\out\\summary.csv"; //cria
		
		try (BufferedReader br = new BufferedReader(new FileReader(diretorioArquivo))) {
			
			//faz a leitura da primeira linha do arquivo .csv indicado no inicio do programa
			String linha = br.readLine();

			//enquanto houver linhas escritas (não nulas)
			while (linha != null) {
				//divide a String em 3 separando cada parte por uma virgula e coloca cada parte em um espaço do vetor
				String[] campos = linha.split(","); 
				//Insere apenas o nome do produto, que esta no primeiro espaco do vetor, na String nome
				String nome = campos[0];
				//converte o segundo espaço do vetor de string para double e o insere na variavel preco
				double preco = Double.parseDouble(campos[1]);
				//converte o terceiro espaço do vetor de string para int e o insere na variavel quantidade
				int quantidade = Integer.parseInt(campos[2]);
				
				//estancia o primeiro produto com as informações obtidas
				listaProdutos.add(new Product(nome, preco, quantidade));
				
				//faz a leitura da proxima linha do arquivo .csv, se estiver nulo o metodo pula fora
				linha = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoOut))) {
				for (Product item : listaProdutos) {
					bw.write(item.getNome() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}
				System.out.println(arquivoOut + " Criado!");

			} catch (IOException e) {
				System.out.println("Erro ao escrever arquivo: " + e.getMessage());
			}

		}
	
		catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
	
		
		ler.close();
		
		
	}

}
