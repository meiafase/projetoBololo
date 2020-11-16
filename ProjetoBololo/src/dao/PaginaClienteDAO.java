package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;    
import java.util.List;
import java.util.Scanner;

import model.BoloSimples;
import model.EditarPerfil;


public class PaginaClienteDAO {

	public static void main(String[] args) throws SQLException {
		
	}
	@SuppressWarnings("static-access")
	static void listarDados(int idCliente, String cpf, String nome, String sobrenome, String email, String senha, String tipo) throws SQLException {
		 
		Scanner ler = new Scanner(System.in);
		
		System.out.println(">> Bem Vindo " + nome + " <<");
		System.out.println(" ");
		
		System.out.println("~~ 1. Fazer Pedido ~~");
		System.out.println("~~ 2. Perfil ~~~~~~~~");
		System.out.println("~~ 3. Meus Pedidos ~~");
		System.out.print("Opção: ");
		int escolhaUm = ler.nextInt();
		 
		if(escolhaUm == 1) {
			System.out.println(" ");
			System.out.println("-- Página Bolos --");
			System.out.println(" ");

			System.out.println(" ");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("--	  BOLO SIMPLES			--");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");

			BoloSimplesDAO boloSimplesDAO = new BoloSimplesDAO();
			
			List<BoloSimples> listaDeBoloSimples = boloSimplesDAO.listar();
			
			for (BoloSimples b : listaDeBoloSimples) {
				System.out.println(b);
			}
			System.out.println(" ");
			System.out.println("informe o ID do bolo desejado:");
			int idBoloSimples = ler.nextInt();
			
			PedidoDAO pedidoDAO = new PedidoDAO();
			pedidoDAO.fazerPedidoBoloSimples(idCliente, idBoloSimples, cpf, nome, sobrenome, email, senha, tipo); 

		}else if(escolhaUm == 2) {
			System.out.println(" ");
			System.out.println("-- Página Perfil--");
			System.out.println(" ");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("--		  DADOS			--");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("** Nome: " + nome);
			System.out.println("** Sobrenome: " + sobrenome);
			System.out.println("** CPF: " + cpf);
			System.out.println("** E-mail: " + email);
			
			
			try {
				Connection con = conn.getConnection();
				// 1. Criar a conexão com o banco de dados.
				String sql1 = "select * from Endereco where idClienteEndereco = ?";
				PreparedStatement executor1 = con.prepareStatement(sql1);
				executor1.setInt(1, idCliente);
				ResultSet resultado = executor1.executeQuery();
				
				while (resultado.next()) {
					String rua = resultado.getString("rua"); 
					String numeroCasa = resultado.getString("numeroCasa");
					String cep = resultado.getString("cep");
					
					System.out.println(" ");
					System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
					System.out.println("--		  DADOS - Endereço	--");
					System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
					System.out.println("** Nome Rua : " + rua);
					System.out.println("** Número casa: " + numeroCasa);
					System.out.println("** CEP: " + cep);

				}

				

				executor1.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("BoloSimplesDAO.inserir() -> Erro no comando SQL!");
			}
			
			
			
			try {
				Connection con = conn.getConnection();
				// 1. Criar a conexão com o banco de dados.
				String sql1 = "select * from Telefone where idClienteTelefone = ?";
				PreparedStatement executor1 = con.prepareStatement(sql1);
				executor1.setInt(1, idCliente);
				ResultSet resultado = executor1.executeQuery();
				
				while (resultado.next()) {
					String ddd = resultado.getString("ddd"); 
					String numero = resultado.getString("numero");
					
					System.out.println(" ");
					System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
					System.out.println("--		  DADOS - Contato	--");
					System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
					System.out.println("** DDD: " + ddd);
					System.out.println("** Número: " + numero);

				}

				

				executor1.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("BoloSimplesDAO.inserir() -> Erro no comando SQL!");
			}
			
			
			System.out.println(" ");
			System.out.println("-- Editar dados? (S=1 / N=0)");
			int escolhaEditar = ler.nextInt();
			
			if(escolhaEditar == 1) {
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("-- EDITAR --");
				System.out.println("1. Editar Dados Perfil");
				System.out.println("2. Editar Dados Endereço");
				System.out.println("3. Editar Dados Contato");
				int editar = ler.nextInt();
				
				if(editar == 1) {
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
					System.out.println("--		  Editar - Perfil	--");
					System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
					System.out.println("");
					System.out.println("** (1) Nome: " + nome);
					System.out.println("** (2) Sobrenome: " + sobrenome);
					System.out.println("** (3) CPF: " + cpf);
					System.out.println("** (4) E-mail: " + email);
					System.out.print("Digite o número do campo a ser editado: ");
					int numeroCampo = ler.nextInt();
					
					if(numeroCampo == 1) {
						System.out.println("");
						System.out.println("");
						System.out.print("Informe o novo nome: ");
						String novoNome = ler.nextLine();
						novoNome = ler.nextLine();
						
						EditarPerfilDAO editarPerfilDAO = new EditarPerfilDAO();
						
						EditarPerfil editarPerfil = new EditarPerfil(idCliente, novoNome, cpf, nome, sobrenome, email, senha, tipo);
						editarPerfilDAO.atualizarNome(editarPerfil);
					}else if(numeroCampo == 2) {
						System.out.println("");
						System.out.println("");
						System.out.print("Informe o novo sobrenome: ");
						String novoSobrenome = ler.nextLine();
						novoSobrenome = ler.nextLine();
						
						EditarPerfilDAO editarPerfilDAO = new EditarPerfilDAO();
						
						EditarPerfil editarPerfil = new EditarPerfil(idCliente, novoSobrenome, cpf, nome, sobrenome, email, senha, tipo);
						editarPerfilDAO.atualizarSobrenome(editarPerfil);
						
					}else if(numeroCampo == 3) {
						System.out.println("");
						System.out.println("");
						System.out.print("Informe o novo CPF: ");
						String novoCpf = ler.nextLine();
						novoCpf = ler.nextLine();
						
						EditarPerfilDAO editarPerfilDAO = new EditarPerfilDAO();
						
						EditarPerfil editarPerfil = new EditarPerfil(idCliente, novoCpf, cpf, nome, sobrenome, email, senha, tipo);
						editarPerfilDAO.atualizarCpf(editarPerfil);
						
					}else if(numeroCampo == 4) {
						System.out.println("");
						System.out.println("");
						System.out.print("Informe o novo E-mail: ");
						String novoEmail = ler.nextLine();
						novoEmail = ler.nextLine();
						
						EditarPerfilDAO editarPerfilDAO = new EditarPerfilDAO();
						
						EditarPerfil editarPerfil = new EditarPerfil(idCliente, novoEmail, cpf, nome, sobrenome, email, senha, tipo);
						editarPerfilDAO.atualizarEmail(editarPerfil);
						
					}
					
					
				}else if(editar == 2) {
					try {
						Connection con = conn.getConnection();
						// 1. Criar a conexão com o banco de dados.
						String sql1 = "select * from Endereco where idClienteEndereco = ?";
						PreparedStatement executor1 = con.prepareStatement(sql1);
						executor1.setInt(1, idCliente);
						ResultSet resultado = executor1.executeQuery();
						
						while (resultado.next()) {
							String rua = resultado.getString("rua"); 
							String numeroCasa = resultado.getString("numeroCasa");
							String cep = resultado.getString("cep");
							
							System.out.println(" ");
							System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
							System.out.println("--		  EDITAR - Endereço	--");
							System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
							System.out.println("** (1)Nome Rua : " + rua);
							System.out.println("** (2)Número casa: " + numeroCasa);
							System.out.println("** (3)CEP: " + cep);
						}
						executor1.close();
						con.close();

					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("BoloSimplesDAO.inserir() -> Erro no comando SQL!");
					}
					System.out.print("Digite o número do campo a ser editado: ");
					int numeroCampo = ler.nextInt();
					
					if(numeroCampo == 1) {
						System.out.println("");
						System.out.println("");
						System.out.print("Informe o novo nome da rua: ");
						String novaRua = ler.nextLine();
						novaRua = ler.nextLine();
						
						EditarPerfilDAO editarPerfilDAO = new EditarPerfilDAO();
						
						EditarPerfil editarPerfil = new EditarPerfil(idCliente, novaRua, cpf, nome, sobrenome, email, senha, tipo);
						editarPerfilDAO.atualizarRua(editarPerfil);
					}else if(numeroCampo == 2) {
						System.out.println("");
						System.out.println("");
						System.out.print("Informe o novo Número da casa: ");
						String novoNumero = ler.nextLine();
						novoNumero = ler.nextLine();
						
						EditarPerfilDAO editarPerfilDAO = new EditarPerfilDAO();
						
						EditarPerfil editarPerfil = new EditarPerfil(idCliente, novoNumero, cpf, nome, sobrenome, email, senha, tipo);
						editarPerfilDAO.atualizarNumeroCasa(editarPerfil);
					}else if(numeroCampo == 3) {
						System.out.println("");
						System.out.println("");
						System.out.print("Informe o novo CEP: ");
						String novoCep = ler.nextLine();
						novoCep = ler.nextLine();
						
						EditarPerfilDAO editarPerfilDAO = new EditarPerfilDAO();
						
						EditarPerfil editarPerfil = new EditarPerfil(idCliente, novoCep, cpf, nome, sobrenome, email, senha, tipo);
						editarPerfilDAO.atualizarCep(editarPerfil);
					}
					
				}else if(editar == 3) {
					try {
						Connection con = conn.getConnection();
						// 1. Criar a conexão com o banco de dados.
						String sql1 = "select * from Telefone where idClienteTelefone = ?";
						PreparedStatement executor1 = con.prepareStatement(sql1);
						executor1.setInt(1, idCliente);
						ResultSet resultado = executor1.executeQuery();
						
						while (resultado.next()) {
							String ddd = resultado.getString("ddd"); 
							String numero = resultado.getString("numero");
							
							System.out.println(" ");
							System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
							System.out.println("--		  EDITAR - Telefone	--");
							System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
							System.out.println("** (1)DDD : " + ddd);
							System.out.println("** (2)Número celular: " + numero);
						}
						executor1.close();
						con.close();

					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("BoloSimplesDAO.inserir() -> Erro no comando SQL!");
					}
					System.out.print("Digite o número do campo a ser editado: ");
					int numeroCampo = ler.nextInt();
					
					if(numeroCampo == 1) {
						System.out.println("");
						System.out.println("");
						System.out.print("Informe o novo DDD: ");
						String novoDdd = ler.nextLine();
						novoDdd = ler.nextLine();
						
						EditarPerfilDAO editarPerfilDAO = new EditarPerfilDAO();
						
						EditarPerfil editarPerfil = new EditarPerfil(idCliente, novoDdd, cpf, nome, sobrenome, email, senha, tipo);
						editarPerfilDAO.atualizarDdd(editarPerfil);
					}else if(numeroCampo == 2) {
						System.out.println("");
						System.out.println("");
						System.out.print("Informe o novo número para contato: ");
						String novaNumero = ler.nextLine();
						novaNumero = ler.nextLine();
						
						EditarPerfilDAO editarPerfilDAO = new EditarPerfilDAO();
						
						EditarPerfil editarPerfil = new EditarPerfil(idCliente, novaNumero, cpf, nome, sobrenome, email, senha, tipo);
						editarPerfilDAO.atualizarNumero(editarPerfil);
					}
				}
			}else if(escolhaEditar == 0){
				PaginaClienteDAO.listarDados(idCliente, cpf, nome, sobrenome, email, senha, tipo);
			}			
		}else if(escolhaUm == 3) {
			System.out.println(" ");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("--	  PEDIDO - Meus Pedidos		--");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			
			try {
				Connection con = conn.getConnection();
				// 1. Criar a conexão com o banco de dados.
				String sql1 = "SELECT idPedidoBoloSimples, idCliente, tipoBoloSimples, precoBoloSimples, statusPedidoBoloSimples\r\n" + 
						      "FROM PedidoBoloSimples\r\n" + 
						      "INNER JOIN Clientes ON PedidoBoloSimples.idClientePedidoBoloSimples = Clientes.idCliente\r\n" + 
						      "INNER JOIN BoloSimples ON PedidoBoloSimples.idBoloSimplesPedidoBoloSimples = BoloSimples.idBoloSimples where idCliente = ?;";
				PreparedStatement executor1 = con.prepareStatement(sql1);
				executor1.setInt(1, idCliente);
				ResultSet resultado = executor1.executeQuery();
				
				while (resultado.next()) {
					int idPedido = resultado.getInt("idPedidoBoloSimples"); 
					String tipoBoloSimples = resultado.getString("tipoBoloSimples");
					Double preco = resultado.getDouble("precoBoloSimples");
					int status = resultado.getInt("statusPedidoBoloSimples"); 
					
					if(status == 1) {
						System.out.println("");
						System.out.println("");
						System.out.println(">>>>>> ALERTA! Pedido Concluído. <<<<<<");
						System.out.println(" ");
						System.out.println("Resumo do Pedido");
						System.out.println("----------------");
						System.out.println("ID Pedido: " + idPedido);
						System.out.println("Pedido: " + tipoBoloSimples);
						System.out.println("Total: R$" + preco);
					}else {
						System.out.println("");
						System.out.println("");
						System.out.println("<<<<<< Pedido Realizado (Embreve estará pronto!) >>>>>>");
						System.out.println(" ");
						System.out.println("Resumo do Pedido");
						System.out.println("----------------");
						System.out.println("ID Pedido: " + idPedido);
						System.out.println("Pedido: " + tipoBoloSimples);
						System.out.println("Total: R$" + preco);
					}
				}
				executor1.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("PáginaClienteDAO.inserir() -> Erro no comando SQL!");
			}
			
			System.out.println("");
			System.out.println("Voltar = 0");
			int voltar = ler.nextInt();
			if(voltar == 0) {
				PaginaClienteDAO.listarDados(idCliente, cpf, nome, sobrenome, email, senha, tipo);
			}
		}
		
		
		ler.close();
	}

}
