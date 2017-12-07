package Persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;



import Model.GetAgendar;


public class AgendarDao implements IAgendarDAO {

	private Connection c;
	// método instanciando a classe genérica  de conexão  do banco de dados
	 public AgendarDao() 
	 {
		// TODO Auto-generated constructor stub
		 
		
		 try {
			 IGenericDao gDao =new GenericDao();
			c = gDao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		 
	 }
	
	 //Select de verificação da disponibilidade do horário
	 
	@Override
	public GetAgendar agendar(GetAgendar agen) throws SQLException 
	{

		
		String sql = "SELECT  CPF, DATAS FROM TB_AGENDAR WHERE DATAS = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);

		
		ps.setString(1,   agen.getDataHora());
		
		ResultSet  rs = ps.executeQuery();
	
		return agen;

		
	}
//método de inserir o horário no banco de dados
	@Override
	public void InserirAgenda(GetAgendar agend) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		
		String sql= "INSERT INTO TB_AGENDAR (CPF, DATAS) VALUES(?,?) ";
		
		PreparedStatement ps =  c.prepareStatement(sql);
				
		
		ps.setString(1, agend.getCpf());
		ps.setString(2, agend.getDataHora());
		
		
		ps.execute();
		 
		ps.close();
		
	}

	
	

// método  do tipo List que traz os dados ordenados direto do banco de dados e mostra na Jtable
	@Override
	public List<GetAgendar> ListaAgendamento(String cpf, String datas) throws SQLException 
	{

	
	List<GetAgendar> listaAgenda = new ArrayList<GetAgendar>();
	String sql ="SELECT CPF, DATAS  FROM TB_AGENDAR  ORDER BY DATAS DESC";
	PreparedStatement ps= c.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next())
	{
		GetAgendar agendar = new  GetAgendar();
		
		agendar.setCpf(rs.getString("CPF"));
		agendar.setDataHora(rs.getString("DATAS"));
		
		listaAgenda.add(agendar);
	}
	rs.close();
	ps.close();
	return listaAgenda;
	
	}
	
	

}
