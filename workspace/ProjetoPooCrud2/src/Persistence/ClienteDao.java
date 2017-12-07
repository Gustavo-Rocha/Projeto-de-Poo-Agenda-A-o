package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import Model.GetCliente;

public class ClienteDao implements  IClienteDAO {
	
	private Connection c;
	
	public  ClienteDao() throws ClassNotFoundException, SQLException
	{
		IGenericDao gDao =new GenericDao();
		c = gDao.getConnection();
		
		System.out.println("instanciou o GENERICO DAO");
	}
	
	//metodos de crud que são chamados pelas respectivas classes de controle, utilizando-se preparedStatement para evitar SQL Injecion

	@Override
	public void InserirCliente(GetCliente cli) throws SQLException 
	{
		
		System.out.println("ENTROU NO METODO INSERIR CLIENTE");
		
		String  sql=	"INSERT INTO TB_CLIENTES (CPF, NOME, TELEFONE, CELULAR, EMAL,  CEP, BAIRRO, CIDADE, UF, OBSERVACAO)"
					    +" VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		System.out.println("ARMAZENOU A QUERY DE INSERT");
		
		PreparedStatement ps =  c.prepareStatement(sql);
		ps.setString(1, cli.getCpf());
		ps.setString(2, cli.getNome() );
		ps.setString(3, cli.getTelefone());
		ps.setString(4,cli.getCelular());
		ps.setString(5, cli.getEmail());
		ps.setString(6, cli.getCep());
		ps.setString(7, cli.getBairro());
		ps.setString(8, cli.getCidade());
		ps.setString(9, cli.getUf());
		ps.setString(10, cli.getObservacao());
		
		ps.execute();
		System.out.println("EXECUTOU A QUERY");
		ps.close();
		System.out.println("FECHOU");
	}

	@Override
	public void AtualizaCLiente(GetCliente cli) throws SQLException 
	{
		
		String sql="UPDATE TB_CLIENTES SET NOME=?, TELEFONE=?, CELULAR=?, EMAL=?,  CEP=?, BAIRRO=?, CIDADE=?, UF=?, OBSERVACAO=? WHERE CPF=?"	;
		PreparedStatement ps= c.prepareStatement(sql);
		ps.setString(1, cli.getNome() );
		ps.setString(2, cli.getTelefone());
		ps.setString(3,cli.getCelular());
		ps.setString(4, cli.getEmail());
		ps.setString(5, cli.getCep());
		ps.setString(6, cli.getBairro());
		ps.setString(7, cli.getCidade());
		ps.setString(8, cli.getUf());
		ps.setString(9, cli.getObservacao());
		ps.setString(10, cli.getCpf());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void ExcluiCLiente(GetCliente cli) throws SQLException 
	{
	
		String sql="DELETE FROM TB_CLIENTES WHERE CPF=?"	;
		PreparedStatement ps= c.prepareStatement(sql);
		
	    ps.setString(1, cli.getCpf());
	    
	    ps.execute();
		ps.close();
	}

	@Override
	public GetCliente ConsultaCliente(GetCliente cli) throws SQLException {
		
		//Não precisa buscar o CPF em si, ele entra no WHERE
		System.out.println("entrou na consulta cliente");
		String sql ="SELECT NOME, TELEFONE, CELULAR, EMAL,  CEP, BAIRRO, CIDADE, UF, OBSERVACAO  FROM TB_CLIENTES WHERE CPF=?";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, cli.getCpf());
						
		ResultSet rs = ps.executeQuery();
		System.out.println("EXECUTOU A QUERY");
		
		if(rs.next())
		{
			cli.setNome(rs.getString("NOME"));
			cli.setTelefone(rs.getString("TELEFONE"));
			cli.setCelular(rs.getString("CELULAR"));
			cli.setEmail(rs.getString("EMAL"));
			cli.setCep(rs.getString("CEP"));
			cli.setBairro(rs.getString("BAIRRO"));
			cli.setCidade(rs.getString("CIDADE"));
			cli.setUf(rs.getString("UF"));
			cli.setObservacao(rs.getString("OBSERVACAO"));
			System.out.println("NOME"+cli.getNome());
		}
		rs.close();
		ps.close();
		System.out.println("Fechou a conexão e a o resultado");
		return cli;
	}

	@Override
	public List<GetCliente> ConsultaCliente() throws SQLException {
		
		List<GetCliente> listaCliente = new ArrayList<GetCliente>();
		String sql ="SELECT CPF, NOME, TELEFONE, CELULAR, EMAL,  CEP, BAIRRO, CIDADE, UF, OBSERVACAO  FROM TB_CLIENTES";
		PreparedStatement ps= c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			GetCliente cliente = new GetCliente();
			
			cliente.setCpf(rs.getString("CPF"));
			cliente.setNome(rs.getString("NOME"));
			cliente.setTelefone(rs.getString("TELEFONE"));
			cliente.setCelular(rs.getString("CELULAR"));
			cliente.setEmail(rs.getString("EMAL"));
			cliente.setCep(rs.getString("CEP"));
			cliente.setBairro(rs.getString("BAIRRO"));
			cliente.setCidade(rs.getString("CIDADE"));
			cliente.setUf(rs.getString("UF"));
			cliente.setObservacao(rs.getString("OBSERVACAO"));
			
			listaCliente.add(cliente);
		}
		rs.close();
		ps.close();
		return listaCliente;
	}



	@Override
	public int ProxID() throws SQLException {

		String sql = "SELECT MAX(id)+1  AS proxmo id FROM TB_CLIENTES";
		
		PreparedStatement ps= c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();	
		if(rs.next())
		{
			return rs.getInt("proximo id");	
		}
		else
		{
			return 1;
		}
	}

}
