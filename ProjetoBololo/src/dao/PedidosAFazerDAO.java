package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.PedidosAFazer;


public class PedidosAFazerDAO implements DAOPedidoAFazer<PedidosAFazer>{

	@Override
	public List<PedidosAFazer> listar() {
		List<PedidosAFazer> listaDePedidosAFazer = new ArrayList<>();

		try {
			Connection con = conn.getConnection();

			Statement executor = con.createStatement();
			String sql = "SELECT idPedidoBoloSimples, idCliente, nome, sobrenome, tipoBoloSimples, precoBoloSimples\r\n" + 
						 "FROM PedidoBoloSimples\r\n" + 
						 "INNER JOIN Clientes ON PedidoBoloSimples.idClientePedidoBoloSimples = Clientes.idCliente\r\n" + 
						 "INNER JOIN BoloSimples ON PedidoBoloSimples.idBoloSimplesPedidoBoloSimples = BoloSimples.idBoloSimples where statusPedidoBoloSimples = 0;";
			ResultSet resultado = executor.executeQuery(sql);

				while (resultado.next()) {
					int id = resultado.getInt("idPedidoBoloSimples"); 
					int idCliente = resultado.getInt("idCliente"); 
					String nome = resultado.getString("nome");
					String pedido = resultado.getString("tipoBoloSimples");
					double preco = resultado.getDouble("precoBoloSimples");

					PedidosAFazer p = new PedidosAFazer(id, idCliente, nome, pedido, preco);
					listaDePedidosAFazer.add(p);
				}

			executor.close();
			con.close(); 
 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("PedidosAFazerDAO.listar() -> Erro no comando SQL!");
		}
		return listaDePedidosAFazer;
	}

	@Override
	public void concluir(Integer id) {
		try {
			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update PedidoBoloSimples set statusPedidoBoloSimples = 1 where idPedidoBoloSimples = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setInt(1, id);

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("Parabéns por ter Concluido o pedido!");
				PaginaAdmDAO.listarDados(sql, sql, sql, sql, sql, sql);
			}else {
				System.out.println("Erro ao Concluir o pedido!");
			}

			executor.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("PedidosAFazerDAO.apagar() -> Erro no comando SQL!");
		}
		
	}


}
