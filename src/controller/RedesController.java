package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
		public RedesController() {
		super();
		}
		
		public void ip(String os) {
		 if (os.contains("Windows")) { //validando S.O para Windows
			 try {
		Process p = Runtime.getRuntime().exec("ipconfig"); //comando para configuração ip em windows
		InputStream fluxo = p.getInputStream(); // trazendo os dados do processo "ipconfig"
		InputStreamReader leitor = new InputStreamReader(fluxo); //efetuando leitura dos dados
		BufferedReader buffer = new BufferedReader(leitor); //
	    String linha = buffer.readLine();
		    while (linha != null) {
			    if (linha.contains("Adaptador")) { // condição para exibir adptador
				String adapt = linha;
				for (int i=0; i<=5; i++) {
					linha = buffer.readLine();
					if (linha.contains("IPv4")) { // condição para exibir IPv4
					System.out.println(adapt);
					System.out.println(linha);
					} // do IPv4
			} // do for
			    }// do adaptador
				else { //else do adptador
					linha = buffer.readLine();
				} // do else
				} // do while
		buffer.close();
		leitor.close();
		fluxo.close();
		} catch (IOException e) { //catch - saída do try
			e.printStackTrace();
	}// fim do catch
			 
} // do if (S.O)
		 else { // do s.o
			 try {
			 Process p = Runtime.getRuntime().exec("ifconfig"); //comando para configuração ip em Linux
			 InputStream fluxo = p.getInputStream(); // trazendo os dados do processo "ifconfig"
			 InputStreamReader leitor = new InputStreamReader(fluxo); //efetuando leitura dos dados
			 BufferedReader buffer = new BufferedReader(leitor); //
			 String linha = buffer.readLine();
			  while (linha != null) {
				if (linha.contains("mtu")) { // condição para exibir adptador
				  String adapt = linha;
				  linha = buffer.readLine();
				  String inet = linha;
				  String[] vetorInet = inet.split(" "); // criando split com a variavel inet (linha do inet linux)
				 System.out.println(adapt);
				 System.out.println(vetorInet[1]); // imprimindo "2ª" posição do vetor (onde fica localizado o inet)"
			   } // do if
			 else { //else do adptador
					linha = buffer.readLine();
				} // do else
			} // do while
					buffer.close();
					leitor.close();
					fluxo.close();
					} catch (IOException e) { //catch - saída do try
					e.printStackTrace();
				}// fim do catch
		 } // do else (s.o)
	}//do método ip
} // da classe
						
						
			
			
			
		
	
		
