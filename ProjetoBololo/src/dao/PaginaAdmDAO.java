package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.BoloSimples;
import model.Clientes;
import model.PedidosAFazer;

public class PaginaAdmDAO {
	public static void main(String[] args) throws SQLException {
			
	}

	public static void listarDados(String cpf, String nome, String sobrenome, String email, String senha, String tipo) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+	     BEM-VINDO - ADM		 +");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("");
		
		System.out.println("~~~~ 1. Adicionar bolo simples ~~~");
		System.out.println("~~~~ 2. Editar bolo simples ~~~~~~");
		System.out.println("~~~~ 3. Deletar bolo simples ~~~~~");

		System.out.println("- - - - - - - - - - - - - - - - - - -");
		
		System.out.println("~~~~ 4. Pedidos a fazer ~~~~~~~~~~~");
		
		System.out.println("- - - - - - - - - - - - - - - - - - -");
		
		System.out.println("~~~~ 5. Nossos Clientes ~~~~~~~~~~~");
		
		System.out.println("- - - - - - - - - - - - - - - - - - -");
		
		System.out.println("~~~~ 6. Calcular Ingredientes ~~~~~");
		
		
		System.out.println(" ");
		System.out.print("Opção: ");
		int escolhaUm = ler.nextInt();
		
		if(escolhaUm == 1) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("--- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("--	 ADICIONAR - Bolo Simples	 --");
			System.out.println("--- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println(" ");
			System.out.print("Informe o tipo do bolo simples: ");
			String boloSimplesADD = ler.nextLine();
			boloSimplesADD = ler.nextLine();
			System.out.print("informe o preço do bolo:");
			Double precoBoloSimplesADD = ler.nextDouble();
			
			BoloSimplesDAO boloSimplesDAO = new BoloSimplesDAO();
			
			BoloSimples boloSimples = new BoloSimples(boloSimplesADD, precoBoloSimplesADD, nome);
			boloSimplesDAO.inserir(boloSimples);
		}else if(escolhaUm == 2) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("--	 EDITAR - Bolo Simples	 	--");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			
			
			BoloSimplesDAO boloSimplesDAO = new BoloSimplesDAO();
			
			List<BoloSimples> listaDeBoloSimples = boloSimplesDAO.listar();
			
			for (BoloSimples b : listaDeBoloSimples) {
				System.out.println(b);
			}
			
			System.out.println("informe o ID do Bolo a ser atualizado:");
			int idBoloSimples = ler.nextInt();
			
			System.out.println("informe o novo tipo do bolo: ");
			String novoBoloSimples = ler.nextLine();
			novoBoloSimples = ler.nextLine();
			System.out.println("informe o novo preço do bolo: ");
			Double novoPrecoBoloSimples = ler.nextDouble();
			
			BoloSimplesDAO boloSimplesDAO1 = new BoloSimplesDAO();
			
			BoloSimples boloSimples = new BoloSimples(idBoloSimples, novoBoloSimples, novoPrecoBoloSimples, nome);
			boloSimplesDAO1.atualizar(boloSimples);

		}else if(escolhaUm == 3) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("--	EXCLUIR - Bolo Simples		--");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			
			BoloSimplesDAO boloSimplesDAO = new BoloSimplesDAO();
			
			List<BoloSimples> listaDeBoloSimples = boloSimplesDAO.listar();
			
			for (BoloSimples b : listaDeBoloSimples) {
				System.out.println(b);
			}
			
			System.out.println("informe o ID do Bolo a ser excluido:");
			int idBoloSimples = ler.nextInt();
			
			BoloSimplesDAO boloSimplesDAO1 = new BoloSimplesDAO();
			boloSimplesDAO1.deletar(idBoloSimples);	
		}else if(escolhaUm == 4) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("--	PEDIDOS - A Fazer		--");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println(" ");
			PedidosAFazerDAO pedidosAFazerDAO = new PedidosAFazerDAO();
			
			List<PedidosAFazer> listaDePedidosAFazer = pedidosAFazerDAO.listar();
			
			for (PedidosAFazer b : listaDePedidosAFazer) {
				System.out.println(b);
			}
			System.out.println("");
			System.out.println("Concluir algum pedido = 1 / Voltar = 0");
			int escolha = ler.nextInt();
			
			if(escolha == 1) {
				System.out.println("Digite o ID do pedido a ser concluido:");
				int idPedidoConcluido = ler.nextInt();
				
				PedidosAFazerDAO pedidosAFazerDAO1 = new PedidosAFazerDAO();
				pedidosAFazerDAO1.concluir(idPedidoConcluido);
			}else if(escolha == 0) {
				PaginaAdmDAO.listarDados(cpf, nome, sobrenome, email, senha, tipo);
			}
			
			
		}else if(escolhaUm == 5) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("--	CLIENTES - Nossos Clientes	--");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			
			NossosClientesDAO nossosClientesDAO = new NossosClientesDAO();
			
			List<Clientes> listaDeClientes = nossosClientesDAO.listarClientes();
			
			for (Clientes b : listaDeClientes) {
				System.out.println(b);
				System.out.println(" ");
			}
			System.out.println("");
			System.out.println("Mais Sobre = 1 / Voltar = 0");
			int escolha = ler.nextInt();
			if(escolha == 1){
				System.out.println("");
				System.out.print("Digite o ID do Cliente: ");
				int escolhaCliente = ler.nextInt();
				
				try {
					Connection con = conn.getConnection();
					// 1. Criar a conexão com o banco de dados.
					String sql1 = "SELECT idCliente, nome, sobrenome, cpf, email, ddd, numero, rua, numeroCasa, cep\r\n" + 
							"FROM Telefone\r\n" + 
							"INNER JOIN Clientes ON Telefone.idClienteTelefone = Clientes.idCliente\r\n" + 
							"INNER JOIN Endereco ON Endereco.idClienteEndereco = Clientes.idCliente where idCliente = ?;";
					PreparedStatement executor1 = con.prepareStatement(sql1);
					executor1.setInt(1, escolhaCliente);
					ResultSet resultado = executor1.executeQuery();
					
					while (resultado.next()) {
						//int idCliente = resultado.getInt("idCliente"); 
						String nome1 = resultado.getString("nome");
						String sobrenome1 = resultado.getString("sobrenome");
						String cpf1 = resultado.getString("cpf"); 
						String email1 = resultado.getString("email");
						String ddd = resultado.getString("ddd");
						String numero = resultado.getString("numero"); 
						String rua = resultado.getString("rua");
						String numeroCasa = resultado.getString("numeroCasa");
						String cep = resultado.getString("cep");
						
						System.out.println(" ");
						System.out.println(" ");
						System.out.println("==== DADOS DO CLIENTE ==== ");
						System.out.println(" ");
						System.out.println("------------------------------------------------");
						System.out.println(" ** Nome Completo: " + nome1 + " " + sobrenome1);
						System.out.println(" ** E-mail: " + email1);
						System.out.println(" ** CPF: " + cpf1);
						System.out.println("------------------------------------------------");
						System.out.println(" ** Telefone: (" + ddd + ") " + numero);
						System.out.println("------------------------------------------------");
						System.out.println(" ** Rua: " + rua + ", " + numeroCasa);
						System.out.println(" ** CEP: " + cep);
						System.out.println("------------------------------------------------");
						
					}
					executor1.close();
					con.close();

				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("PaginaAdmDAO.inserir() -> Erro no comando SQL!");
				}
				System.out.println("Voltar = 0");
				int voltar = ler.nextInt();
				
				if(voltar == 0) {
					PaginaAdmDAO.listarDados(cpf, nome, sobrenome, email, senha, tipo);
				}
				
			}else if(escolha == 0) {
				PaginaAdmDAO.listarDados(cpf, nome, sobrenome, email, senha, tipo);
			}
		}else if(escolhaUm == 6) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			System.out.println("--	CARCULAR - Ingredientes		--");
			System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- ---");
			
			
			try {
				Connection con = conn.getConnection();
				// 1. Criar a conexão com o banco de dados.
				String sql1 = "SELECT COUNT('idPedidoBoloSimples') as qtdPedidos FROM PedidoBoloSimples where statusPedidoBoloSimples = ?;";
				PreparedStatement executor1 = con.prepareStatement(sql1);
				executor1.setInt(1, 0);
				ResultSet resultado = executor1.executeQuery();
				
				int trigoPraUmBoloSimples = 450; 
				int ovoPraUmBoloSimples = 3;
				int gorduraPraUmBoloSimples = 100;
				int aguaPraUmBoloSimples = 200;
				int acucarPraUmBoloSimples = 250;
				while (resultado.next()) {
					int qtdPedidos = resultado.getInt("qtdPedidos");
					
					System.out.println("Quantidade de pedidos (Bolo Simples): " + qtdPedidos);
					System.out.println(" ");
					
					int qtdFrinha = trigoPraUmBoloSimples * qtdPedidos;
					System.out.println("*Farinha de Trigo: " + qtdFrinha + "g");
					
					int qtdOvo = ovoPraUmBoloSimples * qtdPedidos;
					System.out.println("*Ovos: " + qtdOvo + " UND");
					
					int qtdAcucar = acucarPraUmBoloSimples * qtdPedidos;
					System.out.println("*Açucar: " + qtdAcucar + "g");
					
					int qtdOleo = gorduraPraUmBoloSimples * qtdPedidos;
					System.out.println("*Óleo: " + qtdOleo + "ml");
					
					int qtdAgua = aguaPraUmBoloSimples * qtdPedidos;
					System.out.println("*Água: " + qtdAgua + "ml");
				}
				executor1.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("PáginaAdmDAO.inserir() -> Erro no comando SQL!");
			}
			System.out.println("");
			System.out.println("Voltar = 0");
			int voltar = ler.nextInt();
			
			if(voltar == 0) {
				PaginaAdmDAO.listarDados(cpf, nome, sobrenome, email, senha, tipo);
			}
		}
		
		
		ler.close();
	}
}
