package Persistence;

import java.sql.SQLException;
import java.util.List;

import Model.GetAgendar;



public interface IAgendarDAO
{
	
	public GetAgendar agendar(GetAgendar Agen) throws SQLException;

	public  void InserirAgenda(GetAgendar agend) throws SQLException;
	
	List<GetAgendar>  ListaAgendamento(String cpf, String datas) throws SQLException;
	
	
	
}
