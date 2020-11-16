package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BoloSimples;


public class BoloSimplesDAO implements DAOBoloSimples<BoloSimples>{

	@Override
	public List<BoloSimples> listar() {
		List<BoloSimples> listaDeBoloSimples = new ArrayList<>();

		try {
			Connection con = conn.getConnection();

			Statement executor = con.createStatement();
			String sql = "select * from BoloSimples;";
			ResultSet resultado = executor.executeQuery(sql);

			while (resultado.next()) {
				int idBoloSimples = resultado.getInt("idBoloSimples"); 
				String tipoBoloSimples = resultado.getString("tipoBoloSimples");
				Double precoBoloSimples = resultado.getDouble("precoBoloSimples");

				BoloSimples p = new BoloSimples(idBoloSimples, tipoBoloSimples, precoBoloSimples);
				listaDeBoloSimples.add(p);
			}

			executor.close();
			con.close(); 
 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoloSimplesDAO.listar() -> Erro no comando SQL!");
		}

		return listaDeBoloSimples;
	}


	public BoloSimples inserir(BoloSimples boloSimples) {
		try {
			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "insert into BoloSimples (tipoBoloSimples, precoBoloSimples) values (?, ?);";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, boloSimples.getTipoBoloSimples());
			executor.setDouble(2, boloSimples.getPrecoBoloSimples());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("- Bolo simples inserido com sucesso! -");
				PaginaAdmDAO.listarDados(sql, boloSimples.getNome(), sql, sql, sql, sql);
			}else {
				System.out.println("Erro ao inserir o bolo simples!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("BoloSimplesDAO.inserir() -> Erro no comando SQL!");
		}
		return boloSimples;
	}

	@Override
	public BoloSimples atualizar(BoloSimples boloSimples) {
		try {

			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update BoloSimples set tipoBoloSimples = ?, precoBoloSimples = ? where idBoloSimples = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setInt(3, boloSimples.getId());
			executor.setString(1, boloSimples.getTipoBoloSimples());
			executor.setDouble(2, boloSimples.getPrecoBoloSimples());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("Bolo atualizado com sucesso!");
				PaginaAdmDAO.listarDados(sql, boloSimples.getNome(), sql, sql, sql, sql);
			}else {
				System.out.println("Erro ao atualizar o bolo!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}
		return boloSimples;
	}

	@Override
	public void deletar(Integer id) {
		try {
			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "delete from BoloSimples where idBoloSimples = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setInt(1, id);

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("Bolo deletado com sucesso!");
				PaginaAdmDAO.listarDados(sql, sql, sql, sql, sql, sql);
			}else {
				System.out.println("Erro ao deletar o bolo!");
			}

			executor.close();
			con.close();
			
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("PessoaDAO.apagar() -> Erro no comando SQL!");
		}
		
	}



}
