package br.com.gi.resource.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private static String username = "rm88468";
	private static String password = "fiap21";

	private static Connection connection;

	public static Connection createConnection() throws SQLException {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				if(connection == null) {
					connection = DriverManager.getConnection(url, username, password);
				}
				
				return connection;
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		return null;
	}
}