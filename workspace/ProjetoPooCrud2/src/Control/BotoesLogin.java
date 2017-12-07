package Control;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;

import Model.GetLogin;
import Persistence.LoginDao;


public class BotoesLogin 
{
	
	JTextField txtUsuario, txtSenha;
	JButton btnLogin,btnSair;
	
	public BotoesLogin() 
	{
		
	}
	
	 public void Sair(JButton btnSair)
	 {
		 
		 System.exit(0);
		 
		 
	 }
	
	 //metodo que faz a consulta de usuário para logar
	 public GetLogin Logar(String usuario, String senha)
	 {
		 
		
		 
		 GetLogin gLogin = new GetLogin();
		 
		 gLogin.setUsuario(usuario);
		 gLogin.setSenha(senha);
		 
		 
		 LoginDao loDao;
		try {
			loDao = new  LoginDao();
			gLogin = loDao.Logar(gLogin);
			
		}
		catch (ClassNotFoundException | SQLException e) 
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		 
		return gLogin;
		
		
		
		 
	 }
	 
	 
	
}
