package sistema;

import java.sql.SQLException;
import java.util.Scanner;

import dao.CriarContaDAO;
import dao.VerificaLoginDAO;
import model.Conta;
import model.Verifica;


public class Sistema {

	public static void main(String[] args) throws SQLException {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+	   BEM-VINDO ao Bololo		+");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		System.out.println("");
		System.out.println("1. Acessar contar");
		System.out.println("");
		System.out.println("2. Criar conta");
		System.out.println("Não possui uma conta? Então crie!");
		int menuUm = ler.nextInt();
		
		if(menuUm == 1) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+	   PÁGINA - Login		+");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("");
			
			System.out.println("Informe seu E-mail: ");
			String email = ler.nextLine();
			email = ler.nextLine();
			System.out.println("Agora informe a senha: ");
			String senha = ler.nextLine();
			
			VerificaLoginDAO verificaLoginDAO = new VerificaLoginDAO();
			
			Verifica verifica = new Verifica(email, senha);
			verificaLoginDAO.verificarLogin(verifica);
			
		}else if(menuUm == 2) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+	   PÁGINA - Cadastrar		+");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("");
			System.out.println("Informe seu CPF: ");
			String cpf = ler.nextLine();
			cpf = ler.nextLine();
			System.out.println("Informe seu nome: ");
			String nome = ler.nextLine();
			System.out.println("Informe seu sobrenome: ");
			String sobrenome = ler.nextLine();
			System.out.println("Informe seu E-mail: ");
			String email = ler.nextLine();
			System.out.println("Para finalizar, informe sua senha: ");
			String senha = ler.nextLine();
			
			CriarContaDAO criarContaDAO = new CriarContaDAO();
			
			Conta conta = new Conta(cpf, nome, sobrenome, email, senha);
			criarContaDAO.criarConta(conta);
		}
		ler.close();
	}
}

