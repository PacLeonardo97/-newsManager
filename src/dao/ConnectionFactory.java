package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private final static Properties config = new Properties();
    private final static String arquivo = "config.ini";
    
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.err.println("O driver não foi encontrado.");
		}
	}
	
	public static Connection conectar() {
		try { 
			config.load(new FileInputStream(arquivo));
			
			String servidor = "127.0.0.1";
			String porta = config.getProperty("porta");
			String database = config.getProperty("database");
			String usuario = config.getProperty("usuario");
			String senha = config.getProperty("senha");
			
			String conexao = "jdbc:mysql://" + servidor + ":" + porta + 
					"/" + database + "?useTimezone=true&serverTimezone=UTC";
			
			return DriverManager.getConnection(conexao, usuario, senha);
			
		} catch (SQLException ex) {
			System.err.println("Não foi possível conectar!");
			ex.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void desconect(Connection conn) throws SQLException {
		conn.close();
	}
	
}
