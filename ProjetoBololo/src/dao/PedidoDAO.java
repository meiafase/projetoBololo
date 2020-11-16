package dao;

import java.sql.Connection;    
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.ConcluirCadastro;

public class PedidoDAO {

	public static void fazerPedidoBoloSimples(int idCliente, int idBoloSimples, String cpf, String nome, String sobrenome, String email, String senha, String tipo) {
		Scanner ler = new Scanner(System.in);
		
		try {
			Connection con = conn.getConnection();
			
			String sql = "select * from Endereco where idClienteEndereco = ?";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setInt(1, idCliente);
			ResultSet rs = executor.executeQuery();

			if (rs.next()){
				
				try {
					
					// 1. Criar a conexão com o banco de dados.

					// 2. Criar o executor e query.
					String sql1 = "insert into PedidoBoloSimples (idClientePedidoBoloSimples, idBoloSimplesPedidoBoloSimples, statusPedidoBoloSimples) values (?, ?, 0);";
					PreparedStatement executor1 = con.prepareStatement(sql1);
					executor1.setInt(1, idCliente);
					executor1.setInt(2, idBoloSimples);

					int retorno = executor1.executeUpdate();

					if(retorno == 1) {
						System.out.println("Pedido realizado com seucesso!");
						PaginaClienteDAO.listarDados(idCliente, cpf, nome, sobrenome, email, senha, tipo);
					}else {
						System.out.println("Erro ao inserir o pedido!");
					}

					executor1.close();
					con.close();

				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("PedidoDAO.inserir() -> Erro no comando SQL!");
				}
					
			}else {
				System.out.println("+--> Parece que é a sua primeira vez conosco!! <--+");
				System.out.println("");
				System.out.println("	Conclua o cadastro para proseguir");
				System.out.println("");
				System.out.println("==== + == ETAPA - CONCLUIR CADASTRO == + ====");
				System.out.print("Sua rua: ");
				String rua = ler.nextLine();
				System.out.print("O número da casa: ");
				String numero = ler.nextLine();
				System.out.print("O CEP: ");
				String cep = ler.nextLine();
				System.out.print("DDD: ");
				String ddd = ler.nextLine();
				System.out.print("Número para contato(celular): ");
				String numeroCelular = ler.nextLine();
				
				ConcluirCadastroDAO concluirCadastroDAO = new ConcluirCadastroDAO();
				
				ConcluirCadastro concluirCadastro = new ConcluirCadastro(idCliente, rua, numero, cep, ddd, numeroCelular, idBoloSimples, cpf, nome, sobrenome, email, senha, tipo);
				concluirCadastroDAO.concluirCadastro(concluirCadastro);

				
			}
		}catch(SQLException e) {
			System.out.println("Banana");
		}
		
		
		ler.close();
		
	}

}
