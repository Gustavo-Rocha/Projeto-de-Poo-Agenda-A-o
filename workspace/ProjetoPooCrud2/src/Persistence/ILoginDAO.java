package Persistence;

import java.sql.SQLException;

import Model.GetLogin;



public interface ILoginDAO 
{
	public GetLogin Logar(GetLogin gLogin)throws SQLException;
}
