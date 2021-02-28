package view;

import controller.RedesController;
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		RedesController redes = new RedesController();
		String os = System.getProperty("os.name");
		int option = 1;
			while (option != 0) {
			option = Integer.parseInt(JOptionPane.showInputDialog("Sistema operacional: " + os + "\n\nDigite a opcao desejada:\n1- Verificar adaptadores e seus respectivos IPs.\n2- Verificar o tempo medio do seu ping (aguardar alguns segundos)\n0- Encerrar a aplicacao"+"\n\n"));
		switch (option) {
		case 1:
			redes.ip(os);
			break;
		case 2: 
			redes.ping(os);
		case 0:
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opcao invalida." + "\nSelecione entre 1 e 2 para execucao ou 0 para encerrar a aplicacao");
			break;
		}
		
		
		
	}
  }
}