package br.com.capitalplanningtech.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CPTechManagerBD {
	public static Connection obterConexao() {
		Connection conexao = null;
		
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		String user = "RM550692";
		String password = "Winchesters$2112";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("Não foi possível estabelecer conexão");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Não foi possível localizar o driver JDBC");
			e.printStackTrace();
		}
		return conexao;
	}
}
