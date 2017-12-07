package Persistence;

import java.sql.SQLException;
import java.util.List;

import Model.GetCliente;

public interface IClienteDAO 
{
		
	public void InserirCliente(GetCliente cli)throws SQLException;
	public void AtualizaCLiente(GetCliente cli)throws SQLException;
	public void ExcluiCLiente(GetCliente cli)throws SQLException;
	
	public GetCliente ConsultaCliente(GetCliente cli)throws SQLException;
	public List<GetCliente> ConsultaCliente() throws SQLException;
	public int ProxID() throws SQLException;
	
}
