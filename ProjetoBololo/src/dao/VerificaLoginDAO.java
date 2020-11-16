package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Verifica;
import sistema.Sistema;

public class VerificaLoginDAO implements DAOverifica<Verifica> {

	@Override
	public void verificarLogin(Verifica verifica) {
		
		try {
			//Verificação login Cliente
			Connection con = conn.getConnection();
			
			String sql = "select * from Clientes where email = ? and senha = ? and tipo = 0";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, verifica.getEmail());
			executor.setString(2, verifica.getSenha());
			ResultSet rs = executor.executeQuery();

			if (rs.next()){
				
				String sql1 = "select * from Clientes where email = ?";
				PreparedStatement executor1 = con.prepareStatement(sql1);
				executor1.setString(1, verifica.getEmail());
				ResultSet resultado = executor.executeQuery();
				
				while (resultado.next()) {
					
					//List<DadosCliente> listaDadosCliente = new ArrayList<>();
					int idCliente = resultado.getInt("idCliente");
					String cpf = resultado.getString("cpf");
					String nome = resultado.getString("nome");
					String sobrenome = resultado.getString("sobrenome"); 
					String email = resultado.getString("email");
					String senha = resultado.getString("senha");
					String tipo = resultado.getString("tipo");
					
					//DadosCliente p = new DadosCliente(cpf, nome, sobrenome, email, senha, tipo);
					//listaDadosCliente.add(p);
					PaginaClienteDAO.listarDados(idCliente, cpf, nome, sobrenome, email, senha, tipo);
					
				}
				
			}else {
			//Verificação ADM

				String sql2 = "select * from Clientes where email = ? and senha = ? and tipo = 1";
				PreparedStatement executor2 = con.prepareStatement(sql2);
				executor2.setString(1, verifica.getEmail());
				executor2.setString(2, verifica.getSenha());
				ResultSet rs1 = executor2.executeQuery();

				if (rs1.next()){
					String sql3 = "select * from Clientes where email = ?";
					PreparedStatement executor3 = con.prepareStatement(sql3);
					executor3.setString(1, verifica.getEmail());
					ResultSet resultado = executor3.executeQuery();
					
					while (resultado.next()) {
						
						//List<DadosCliente> listaDadosCliente = new ArrayList<>();
						 
						String cpf = resultado.getString("cpf");
						String nome = resultado.getString("nome");
						String sobrenome = resultado.getString("sobrenome"); 
						String email = resultado.getString("email");
						String senha = resultado.getString("senha");
						String tipo = resultado.getString("tipo");
						
						//DadosCliente p = new DadosCliente(cpf, nome, sobrenome, email, senha, tipo);
						//listaDadosCliente.add(p);
						PaginaAdmDAO.listarDados(cpf, nome, sobrenome, email, senha, tipo);
						
					}
					
				}else {
					System.out.println("III ALERTA! - Usuário ao senha incorreto! III");
					Sistema.main(null);
				}
			}

			executor.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("VerificaLoginDAO.criarConta() -> Erro no comando SQL!");
		}
	}


}
