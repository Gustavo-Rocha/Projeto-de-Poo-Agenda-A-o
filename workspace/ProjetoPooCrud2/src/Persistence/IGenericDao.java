package Persistence;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public interface IGenericDao 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException;
	
}
