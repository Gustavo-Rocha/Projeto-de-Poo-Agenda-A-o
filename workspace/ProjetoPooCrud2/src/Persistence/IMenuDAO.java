package Persistence;


import java.util.List;

import Model.GetAgendar;

public interface IMenuDAO 
{
	void adicionar(GetAgendar a);
	 List<GetAgendar>  ListaAgendamento(String cpf, String datas);
}
