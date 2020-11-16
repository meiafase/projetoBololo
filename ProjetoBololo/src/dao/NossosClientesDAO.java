package dao;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Clientes;

public class NossosClientesDAO implements DAOclientes<Clientes> {

	@Override
	public List<Clientes> listarClientes() {
		List<Clientes> listaDeClientes = new ArrayList<>();

		try {
			Connection con = conn.getConnection();

			Statement executor = con.createStatement();
			String sql = "select * from Clientes where tipo = 0;";
			ResultSet resultado = executor.executeQuery(sql);

			while (resultado.next()) {
				int idCliente = resultado.getInt("idCliente"); 
				String cpf = resultado.getString("cpf");
				String nome = resultado.getString("nome");
				String sobrenome = resultado.getString("sobrenome");
				String email = resultado.getString("email");
				String tipo = resultado.getString("tipo");

				Clientes p = new Clientes(idCliente, cpf, nome, sobrenome, email, tipo);
				listaDeClientes.add(p);
			}

			executor.close();
			con.close(); 
 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NossosClientesDAO.listar() -> Erro no comando SQL!");
		}
		return listaDeClientes;
	}


}
