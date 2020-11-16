package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class conn {
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalho_banco","root","Elisangela1");
	}
}
