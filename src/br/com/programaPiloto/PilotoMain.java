package br.com.programaPiloto;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.controledepiloto.dao.PilotoDAO;
import br.com.controledepiloto.domain.Piloto;



public class PilotoMain {

	public static void main(String[] args) throws SQLException {
		// IMPORTS
		PilotoDAO piloto = new PilotoDAO();
		Piloto 	  objPiloto = new Piloto();
		//MINHAS VARIAVEIS LOCAIS
		Scanner input = new Scanner(System.in);
		int escolha = 0;
		
		//programa principal
		
		System.out.println("###################################################################################\r\n" + 
				"#######        ####################################################################\r\n" + 
				"#######  ####   ###   ###   ##########        ####             #####        #######\r\n" + 
				"#######  ####   ###   ###   ########    ####    #######   ########    ####    #####\r\n" + 
				"#######        ##########   #######   ########   ######   #######   ########   ####\r\n" + 
				"#######   #########   ###   #######   ########   ######   #######   ########   ####\r\n" + 
				"#######   #########   ###   #######   ########   ######   #######   ########   ####\r\n" + 
				"#######   #########   ###   ########    ####    #######   ########    ####    #####\r\n" + 
				"#######   #########   ###        #####        #########   ##########        #######\r\n" + 
				"###################################################################################\r\n" + 
				"########################################################################by rotiv92#");
		System.out.println("[1] Salvar Piloto e o Carro do Piloto");
		System.out.println("[2] Editar Carro do Piloto");
		System.out.println("[3] Excluir o Piloto");
		System.out.println("[4] Listar Todos os Pilotos e seus Carros");
		System.out.println("[5] Consultar Pilotos ");
		System.out.println("[6] EXIT");

		System.out.println("################################# PROGRAMA PILOTO #################################");
		System.out.println("###################################################################################");
		
		System.out.println();
		System.out.println("Escolha uma opção");
		escolha = input.nextInt();
		
		if ( escolha == 1 ) {
			System.out.println("Nome do Piloto :");
			objPiloto.setNomeDoPiloto(input.next());
			System.out.println("Modelo do Carro  : ");
			objPiloto.setModeloDoCarro(input.next());
			piloto.salvar(objPiloto);
		} else if ( escolha == 2 ) {
			System.out.println("lista atual");
			piloto.listar();
			System.out.println();
			System.out.println("Informe o nome do piloto para editar o novo modelo do carro: ");
			objPiloto.setNomeDoPiloto(input.next());
			System.out.println("Informe o novo modelo do carro");
			objPiloto.setModeloDoCarro(input.next());
			piloto.editar(objPiloto);
			System.out.println();
			System.out.println();
			System.out.println("lista att");
			piloto.listar();
		} else if ( escolha == 3 ) {
			System.out.println("Lista atual de piloto:");
			System.out.println();
			piloto.listar();
			System.out.println();
			System.out.println("Informe o nome do piloto que deseja excluir ! ");
			objPiloto.setNomeDoPiloto(input.next());
			piloto.excluir(objPiloto);
			System.out.println();
			System.out.println("Lista de Pilotos att!!");
			piloto.listar();
			
		} else if ( escolha == 4 ) {
			System.out.println("Lista...");
			System.out.println();
			piloto.listar();
		} else if ( escolha == 5 ) {
			System.out.println("Menu de busca !");
			System.out.println("[1] ID !");
			System.out.println("[2] NOME !");
			escolha = input.nextInt();
			if ( escolha == 1 ) {
				//busca por id
				System.out.println("Informe o ID do Piloto que deseja consultar");
				objPiloto.setIdPiloto(input.nextLong());
				System.out.println();
				piloto.ConsultaAvancadaid(objPiloto);
				//chama metodo de buscar por ID passando como parametro a escolha
			} else {
				//busca por nome
				System.out.println("Informe o Nome do Piloto que deseja consultar");
				objPiloto.setNomeDoPiloto(input.next());
				System.out.println();
				piloto.ConsultaAvancadanome(objPiloto);
				//chama metodo de buscar por Nome passando como parametro a escolha
			}
		} else if ( escolha == 6 ) {
			System.out.println("Saindo...");
			System.exit(0);
		}
	
		input.close();
	}

}
