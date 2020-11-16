package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ConcluirCadastro;

public class ConcluirCadastroDAO {

	public void concluirCadastro(ConcluirCadastro concluirCadastro) {
		
		try {
			Connection con = conn.getConnection();
			
			String sql2 = "insert into Endereco (idClienteEndereco, rua, numeroCasa, cep) values (?, ?, ?, ?);";
            PreparedStatement executor2 = con.prepareStatement(sql2);
            executor2.setInt(1, concluirCadastro.getIdCliente());
            executor2.setString(2, concluirCadastro.getRua());
            executor2.setString(3, concluirCadastro.getNumero());
            executor2.setString(4, concluirCadastro.getCep());

            int retorno = executor2.executeUpdate();

            if(retorno == 1) {
            	try {
        			
        			String sql3 = "insert into Telefone (idClienteTelefone, ddd, numero) values (?, ?, ?);";
                    PreparedStatement executor3 = con.prepareStatement(sql3);
                    executor3.setInt(1, concluirCadastro.getIdCliente());
                    executor3.setString(2, concluirCadastro.getDdd());
                    executor3.setString(3, concluirCadastro.getNumeroCelular());
                    
                    int idBoloSimples = concluirCadastro.getIdBoloSimples();
                    int idCliente = concluirCadastro.getIdCliente();
                    
                    int retorno3 = executor3.executeUpdate();

                    if(retorno3 == 1) {
                        System.out.println("ETAPA CONCLUIDA!");
                        PedidoDAO.fazerPedidoBoloSimples(idCliente, idBoloSimples, concluirCadastro.getCpf(), concluirCadastro.getNome(), concluirCadastro.getSobrenome(), concluirCadastro.getEmail(), concluirCadastro.getSenha(), concluirCadastro.getTipo());
                    }else {
                        System.out.println("Erro na ETAPA CONCLUIR CADASTRO!");
                    }
        		}catch(SQLException e) {
        			
        		}
            }else {
                System.out.println("Erro na ETAPA CONCLUIR CADASTRO!");
            }
		}catch(SQLException e) {
			
		}
		
	}

}
