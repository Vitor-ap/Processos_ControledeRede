package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {
		public RedesController() {
		super();
		}
		
		
		
		
		public void ip(String os) {
		String adapt = " ";
		if (os.contains("Windows")) { //validando S.O para Windows
			try {
			Process p = Runtime.getRuntime().exec("ipconfig"); //comando para configuracao ip em windows
			InputStream fluxo = p.getInputStream(); // trazendo os dados do processo "ipconfig"
			InputStreamReader leitor = new InputStreamReader(fluxo); //efetuando leitura dos dados
			BufferedReader buffer = new BufferedReader(leitor); //
			String linha = buffer.readLine();
			StringBuffer tela = new StringBuffer();
				while (linha != null) {
					if (linha.contains("Adaptador")) { // condicao para exibir adptador
					adapt = linha;
					linha = buffer.readLine();
					}
						if (linha.contains("IPv4")) { // condicao para exibir IPv4
						String vetIp[] = linha.split(": ");
						tela.append(adapt);
						tela.append("\n");
						tela.append("Endereco do IPv4: " +vetIp[1]);
						tela.append("\n\n");
						linha = buffer.readLine();
						} 
						else {
						linha = buffer.readLine();
						} 
				} 
			JOptionPane.showMessageDialog(null, tela);
			buffer.close();
			leitor.close();
			fluxo.close();
			} catch (IOException e) { 
			e.printStackTrace();
			}
		} // do if (S.O)
		 else { // do s.o
			try {
			Process p = Runtime.getRuntime().exec("ifconfig"); //comando para configuracao ip em Linux
			InputStream fluxo = p.getInputStream(); // trazendo os dados do processo "ifconfig"
			InputStreamReader leitor = new InputStreamReader(fluxo); //efetuando leitura dos dados
			BufferedReader buffer = new BufferedReader(leitor); //
			String linha = buffer.readLine();
			StringBuffer tela = new StringBuffer();
				while (linha != null) {
				 	if (linha.contains("mtu")) { 
				 	adapt = linha;
				 	linha = buffer.readLine();
					String inet = linha;
					String[] vetorInet = inet.split(" "); // criando split com a variavel inet (linha do inet linux)
					tela.append("Adaptador: "+ adapt);
					tela.append("\n");
					tela.append("Endereco do IPv4 (iNet): " +vetorInet[9]);
					tela.append("\n\n");
				 	} 
				 	else { 
				 	linha = buffer.readLine();
				 		} 
				} 
			JOptionPane.showMessageDialog(null, tela);
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
					String vetorMedia[] = linha.split("=");
					JOptionPane.showMessageDialog(null, "Tempo medio de:"+vetorMedia[3]);
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
					JOptionPane.showMessageDialog(null,"Tempo medio do ping: " + vetorMedia[4] + " ms.");
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
			
			
		
	
		
