package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.GetLogin;
import View.Agendar;


public class LoginDao implements ILoginDAO
{
	
	
	boolean acesso;
	private Connection c;
	
	public LoginDao() throws ClassNotFoundException, SQLException
	{
		IGenericDao gDao =new GenericDao();
		c = gDao.getConnection();
		
		
	}
	
	// metodo de consulta para verificar a exstencia do usuário no banco de dados
	@Override
	public GetLogin Logar(GetLogin gLogin) throws SQLException 
	{
		
		
		String sql = "SELECT USUARIO , SENHA FROM TB_LOGIN WHERE USUARIO =? AND SENHA=?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, gLogin.getUsuario());
		ps.setString(2, gLogin.getSenha());
		
		ResultSet rs = ps.executeQuery();
		
		
		
		
		if(rs.next())
		{
			
			gLogin.setUsuario(rs.getString("USUARIO"));
			gLogin.setSenha(rs.getString("SENHA"));
			
			
			 
			Agendar agen = new Agendar();
			
			agen.setVisible(true);
			
		}
		else
		{
			
			JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
			
			
		}
		rs.close();
		ps.close();
		
		
		return gLogin;
		
	}
	
	
	
}
