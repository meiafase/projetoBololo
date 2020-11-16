package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Conta;
import sistema.Sistema;

public class CriarContaDAO implements DAOconta<Conta> {

	public Conta criarConta(Conta conta) {
		try {
			// 1. Criar a conexão com o banco de dados.
			Connection con = conn.getConnection();

			// 2. Criar o executor e query. 
			String sql = "insert into Clientes (cpf, nome, sobrenome, email, senha, tipo) values (?, ?, ?, ?, ?, 0);";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, conta.getCpf());
			executor.setString(2, conta.getNome());
			executor.setString(3, conta.getSobrenome());
			executor.setString(4, conta.getEmail());
			executor.setString(5, conta.getSenha());

			int retorno = executor.executeUpdate();

			if(retorno == 1) {
				System.out.println("III ALERTA! Cadastro efetuado com sucesso! III");
				System.out.println("- Agora é só fazer o login! -");
				Sistema.main(null); 
			}else {
				System.out.println("III ALERTA! Houve um erro com seu cadastro! III");
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("CriarContaDAO.criarConta() -> Erro no comando SQL!");
		}
		return conta;
		
	}


}
