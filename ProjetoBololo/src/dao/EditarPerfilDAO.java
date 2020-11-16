package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.EditarPerfil;

public class EditarPerfilDAO implements DAOEditar<EditarPerfil> {

	@Override
	public EditarPerfil atualizarNome(EditarPerfil editarPerfil) {
		try {

			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update Clientes set nome = ? where idCliente = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, editarPerfil.getNovoEditado());
			executor.setInt(2, editarPerfil.getIdCliente());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("Nome atualizado com sucesso!");
				PaginaClienteDAO.listarDados(editarPerfil.getIdCliente(), editarPerfil.getCpf(), editarPerfil.getNome(), editarPerfil.getSobrenome(), editarPerfil.getEmail(), editarPerfil.getSenha(), editarPerfil.getTipo());
			}else {
				System.out.println("Erro ao atualizar o Nome!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}

		return editarPerfil;
	}

	@Override
	public EditarPerfil atualizarSobrenome(EditarPerfil editarPerfil) {
		try {
			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update Clientes set sobrenome = ? where idCliente = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, editarPerfil.getNovoEditado());
			executor.setInt(2, editarPerfil.getIdCliente());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("Sobrenome atualizado com sucesso!");
				PaginaClienteDAO.listarDados(editarPerfil.getIdCliente(), editarPerfil.getCpf(), editarPerfil.getNome(), editarPerfil.getSobrenome(), editarPerfil.getEmail(), editarPerfil.getSenha(), editarPerfil.getTipo());
			}else {
				System.out.println("Erro ao atualizar o Nome!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}
		return editarPerfil;
	}

	@Override
	public EditarPerfil atualizarCpf(EditarPerfil editarPerfil) {
		try {

			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update Clientes set cpf = ? where idCliente = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, editarPerfil.getNovoEditado());
			executor.setInt(2, editarPerfil.getIdCliente());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("CPF atualizado com sucesso!");
				PaginaClienteDAO.listarDados(editarPerfil.getIdCliente(), editarPerfil.getCpf(), editarPerfil.getNome(), editarPerfil.getSobrenome(), editarPerfil.getEmail(), editarPerfil.getSenha(), editarPerfil.getTipo());
			}else {
				System.out.println("Erro ao atualizar o Nome!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}
		return editarPerfil;
	}

	@Override
	public EditarPerfil atualizarEmail(EditarPerfil editarPerfil) {
		try {

			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update Clientes set email = ? where idCliente = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, editarPerfil.getNovoEditado());
			executor.setInt(2, editarPerfil.getIdCliente());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("E-mail atualizado com sucesso!");
				PaginaClienteDAO.listarDados(editarPerfil.getIdCliente(), editarPerfil.getCpf(), editarPerfil.getNome(), editarPerfil.getSobrenome(), editarPerfil.getEmail(), editarPerfil.getSenha(), editarPerfil.getTipo());
			}else {
				System.out.println("Erro ao atualizar o Nome!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}
		return editarPerfil;
	}

	@Override
	public EditarPerfil atualizarRua(EditarPerfil editarPerfil) {
		try {

			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update Endereco set rua = ? where idClienteEndereco = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, editarPerfil.getNovoEditado());
			executor.setInt(2, editarPerfil.getIdCliente());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("Rua atualizada com sucesso!");
				PaginaClienteDAO.listarDados(editarPerfil.getIdCliente(), editarPerfil.getCpf(), editarPerfil.getNome(), editarPerfil.getSobrenome(), editarPerfil.getEmail(), editarPerfil.getSenha(), editarPerfil.getTipo());
			}else {
				System.out.println("Erro ao atualizar a Rua!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}
		return editarPerfil;
	}

	@Override
	public EditarPerfil atualizarNumeroCasa(EditarPerfil editarPerfil) {
		try {

			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update Endereco set numeroCasa = ? where idClienteEndereco = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, editarPerfil.getNovoEditado());
			executor.setInt(2, editarPerfil.getIdCliente());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("Número da casa atualizado com sucesso!");
				PaginaClienteDAO.listarDados(editarPerfil.getIdCliente(), editarPerfil.getCpf(), editarPerfil.getNome(), editarPerfil.getSobrenome(), editarPerfil.getEmail(), editarPerfil.getSenha(), editarPerfil.getTipo());
			}else {
				System.out.println("Erro ao atualizar o Número da casa!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}
		return editarPerfil;
	}

	@Override
	public EditarPerfil atualizarCep(EditarPerfil editarPerfil) {
		try {

			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update Endereco set cep = ? where idClienteEndereco = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, editarPerfil.getNovoEditado());
			executor.setInt(2, editarPerfil.getIdCliente());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("CEP atualizado com sucesso!");
				PaginaClienteDAO.listarDados(editarPerfil.getIdCliente(), editarPerfil.getCpf(), editarPerfil.getNome(), editarPerfil.getSobrenome(), editarPerfil.getEmail(), editarPerfil.getSenha(), editarPerfil.getTipo());
			}else {
				System.out.println("Erro ao atualizar o CEP!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}
		return editarPerfil;
	}

	@Override
	public EditarPerfil atualizarDdd(EditarPerfil editarPerfil) {
		try {

			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update Telefone set ddd = ? where idClienteTelefone = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, editarPerfil.getNovoEditado());
			executor.setInt(2, editarPerfil.getIdCliente());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("DDD atualizado com sucesso!");
				PaginaClienteDAO.listarDados(editarPerfil.getIdCliente(), editarPerfil.getCpf(), editarPerfil.getNome(), editarPerfil.getSobrenome(), editarPerfil.getEmail(), editarPerfil.getSenha(), editarPerfil.getTipo());
			}else {
				System.out.println("Erro ao atualizar o DDD!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}
		return editarPerfil;
	}

	@Override
	public EditarPerfil atualizarNumero(EditarPerfil editarPerfil) {
		try {

			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query.
			String sql = "update Telefone set numero = ? where idClienteTelefone = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, editarPerfil.getNovoEditado());
			executor.setInt(2, editarPerfil.getIdCliente());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("Número atualizado com sucesso!");
				PaginaClienteDAO.listarDados(editarPerfil.getIdCliente(), editarPerfil.getCpf(), editarPerfil.getNome(), editarPerfil.getSobrenome(), editarPerfil.getEmail(), editarPerfil.getSenha(), editarPerfil.getTipo());
			}else {
				System.out.println("Erro ao atualizar o Número!");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("PessoaDAO.atualizar() -> Erro no comando SQL!");
		}
		return editarPerfil;
	}




}
