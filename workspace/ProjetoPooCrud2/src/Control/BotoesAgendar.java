package Control;

import java.sql.SQLException;




import javax.swing.JOptionPane;

import Model.GetAgendar;
import Persistence.AgendarDao;

public class BotoesAgendar 
{
	
	public BotoesAgendar()
	{
		
	}

	
	public GetAgendar VerificarDisponibilidade(String dataHora)
	{
		
		String dataVerifica = null;
		
		GetAgendar gagenda= new GetAgendar();
		
		gagenda.setDataHora(dataVerifica);
		
		
		try {
			AgendarDao  agenDao = new AgendarDao();
			gagenda=agenDao.agendar(gagenda);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return gagenda;
		
	}
	// método que passa as variaveis a serem adicionadas ao banco, para o método do insert
	public void Agendar(String cpf, String dataHora)
	{
		GetAgendar getAgen= new GetAgendar();
	
		getAgen.setCpf(cpf);
		getAgen.setDataHora(dataHora);
			
		agendaHrario(getAgen);
	}

	private void agendaHrario(GetAgendar getA) 
	{
		// TODO Auto-generated method stub
		
		try
		{
			
			AgendarDao ageDao = new AgendarDao();
			ageDao.InserirAgenda(getA);
			JOptionPane.showMessageDialog(null, "Horário  agendado com sucesso!");
		} 
		catch (SQLException e)
		{
			
			JOptionPane.showMessageDialog(null, "                        Horário já agendado.\n"
					+ " Insira um horario com acréscimo mínimo de uma hora ");
			
			
		}
		
		
	}
	
	
}
