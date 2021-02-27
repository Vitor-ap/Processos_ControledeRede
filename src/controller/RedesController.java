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
		Process p = Runtime.getRuntime().exec("ipconfig"); //comando para configuracao ip em windows
		InputStream fluxo = p.getInputStream(); // trazendo os dados do processo "ipconfig"
		InputStreamReader leitor = new InputStreamReader(fluxo); //efetuando leitura dos dados
		BufferedReader buffer = new BufferedReader(leitor); //
	    String linha = buffer.readLine();
		    while (linha != null) {
			    if (linha.contains("Adaptador")) { // condicao para exibir adptador
				String adapt = linha;
				for (int i=0; i<=5; i++) {
					linha = buffer.readLine();
					if (linha.contains("IPv4")) { // condicao para exibir IPv4
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
		} catch (IOException e) { //catch - sa�da do try
			e.printStackTrace();
	}// fim do catch
			 
} // do if (S.O)
		 else { // do s.o
			 try {
			 Process p = Runtime.getRuntime().exec("ifconfig"); //comando para configuracao ip em Linux
			 InputStream fluxo = p.getInputStream(); // trazendo os dados do processo "ifconfig"
			 InputStreamReader leitor = new InputStreamReader(fluxo); //efetuando leitura dos dados
			 BufferedReader buffer = new BufferedReader(leitor); //
			 String linha = buffer.readLine();
			  while (linha != null) {
				if (linha.contains("mtu")) { // condicao para exibir adptador
				  String adapt = linha;
				  linha = buffer.readLine();
				  if (linha.contains("inet")) {
				  String inet = linha;
				  String[] vetorInet = inet.split(" "); // criando split com a variavel inet (linha do inet linux)
				 System.out.println("Adaptador: " + adapt);
				 System.out.println("Ipv4 [inet]: " + vetorInet[9]); // imprimindo "decima" posi��o do vetor (onde fica localizado o inet)"
				  } // do if contains inet
				  } // do if mtu.
			 else { //else do adptador
					linha = buffer.readLine();
				} // do else
			} // do while
					buffer.close();
					leitor.close();
					fluxo.close();
					} catch (IOException e) { //catch - saida do try
					e.printStackTrace();
				}// fim do catch
		 } // do else (s.o)
	}//do metodo ip
						
	public void ping(String os) {
	if (os.contains("Windows")) {
		try {
			Process p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains("M")) {
					String vetorMedia[] = linha.split(",");
					System.out.println(vetorMedia[2]);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
					} catch (IOException e) {
			e.printStackTrace();
		}
				
	} // do if s.o
	else { 
		try {
			Process p = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains("mdev")) {
					String vetorMedia[] = linha.split("/");
					System.out.println("Tempo medio do ping: " + vetorMedia[4] + " ms.");
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
					} catch (IOException e) {
			e.printStackTrace();
		}
	}
	} //do metodo ping
} //da classe
			
			
		
	
		
