package Persistence;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;


public class GenericDao implements IGenericDao 
{
	
	
	// classe feita especialmente para conexão com o banco de dados ,sendo assim  utilizando o padrão de projeto DAO.
	
	private Connection c;
	Properties properties = new Properties();
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		properties.setProperty("user", "root");
		properties.setProperty("password", "240497gu");
		properties.setProperty("useSSL", "false");
		properties.setProperty("autoReconnect", "true");
		
		Class.forName("com.mysql.jdbc.Driver");
		c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJETO_POO", properties);
		
		return c;
	}

}
