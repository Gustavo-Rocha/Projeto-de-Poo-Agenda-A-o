package Control;


import java.sql.SQLException;


import javax.swing.JOptionPane;


import Model.GetCliente;
import Persistence.ClienteDao;

public class BotoesCadastra
{

	//Essa classe era uma classe que implementava ActionListener, removi esse actione coloquei na classe VIEW 
	

	public BotoesCadastra() 
	{
		// TODO Auto-generated constructor stub
	}


	//Esse metodo pega as informações que vem da tela e coloca no modelo Cliente para passar ao DAO para inserir no banco
	//Estou pegando apenas as strings para facilitar ao inves de mandar o componente inteiro
	public void InsertCliente(String Cep,String Nome,String Telefone,String Email, String Celular,
			String Cidade, String Estado,String Cpf, String Bairro,String Sexo, String Observacao) 
	{
		
		System.out.println("entrou no BotoesCadastra ActionPerformed");
		
		GetCliente gCliente =new GetCliente();
		
		//Passando as strings para a classe modelo
		gCliente.setNome(Nome);
		gCliente.setBairro(Bairro);
		gCliente.setCelular(Celular);
		gCliente.setCep(Cep);
		gCliente.setCidade(Cidade);
		gCliente.setCpf(Cpf);
		gCliente.setEmail(Email);
		
		gCliente.setObservacao(Observacao);
		gCliente.setTelefone(Telefone);
		gCliente.setUf(Estado);
		
		
		
		System.out.println("instanciou o model GetCliente");
		
			
			CadastraCliente(gCliente);
		

	}


	private void CadastraCliente(GetCliente cli) 
	{
		
		
		
		try 
		{
			ClienteDao clDao =new ClienteDao();
			clDao.InserirCliente(cli);
			
			
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado");
		}
		
		catch (ClassNotFoundException | SQLException e)
		
		{
	
			JOptionPane.showMessageDialog(null, "Cliente Já Cadastrado");

		}
		
	}
	//metodo que deleta os dados do cliente
	public void DeleteCliente(String Cep,String Nome,String Telefone,String Email, String Celular,
			String Cidade, String Estado,String Cpf, String Bairro,String Sexo, String Observacao)
	{
		
		System.out.println("entrou no BotoesCadastra ActionPerformed DELETA");
		
		GetCliente gCliente =new GetCliente();
		
		//Passando as strings para a classe modelo
		gCliente.setNome(Nome);
		gCliente.setBairro(Bairro);
		gCliente.setCelular(Celular);
		gCliente.setCep(Cep);
		gCliente.setCidade(Cidade);
		gCliente.setCpf(Cpf);
		gCliente.setEmail(Email);
		gCliente.setObservacao(Observacao);
		gCliente.setTelefone(Telefone);
		gCliente.setUf(Estado);
		
		
		
			
			DeletaCliente(gCliente);
		

	}

	private void DeletaCliente( GetCliente cli) 
	{
		
		
		
		try 
		{
			
			ClienteDao clDao = new ClienteDao();
			clDao.ExcluiCLiente(cli);
			
			JOptionPane.showMessageDialog(null, "Cliente Deletado");
		} 
		
		catch (ClassNotFoundException | SQLException e)
		
		{
			
			
			JOptionPane.showMessageDialog(null, "Cliente Inexistente");
		}
		
	}
	//metodo que consulta os dados do cliente
	public GetCliente SelectCliente(String Cpf)
	{
		
		
		
		GetCliente gCliente = new GetCliente();
		
		//Passando as strings para a classe modelo
		
		//Como você quer o CPF só precisa setar ele apra trazer no Update
		gCliente.setCpf(Cpf);
		
		
		try 
		{
			ClienteDao clDao = new ClienteDao();
			gCliente = clDao.ConsultaCliente(gCliente);
			
			JOptionPane.showMessageDialog(null, "Pesquisa realizada");
		} 
		
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Dados Inexistentes");
		}
		
		return gCliente;

	}
	//metodo que altera os dados do cliente
	public void UpdateCliente(String Cep,String Nome,String Telefone,String Email, String Celular,
			String Cidade, String Estado,String Cpf, String Bairro,String Sexo, String Observacao)
	{
		
		
		
		GetCliente gCliente =new GetCliente();
		
		//Passando as strings para a classe modelo
		gCliente.setNome(Nome);
		gCliente.setBairro(Bairro);
		gCliente.setCelular(Celular);
		gCliente.setCep(Cep);
		gCliente.setCidade(Cidade);
		gCliente.setCpf(Cpf);
		gCliente.setEmail(Email);
		gCliente.setObservacao(Observacao);
		gCliente.setTelefone(Telefone);
		gCliente.setUf(Estado);
		
		System.out.println("instanciou o model GetCliente");
		
			
			AlteraCliente(gCliente);
		

	}

	private void AlteraCliente( GetCliente cli) {
		
		
		try 
		{
			ClienteDao clDao = new ClienteDao();
			clDao.AtualizaCLiente(cli);
			JOptionPane.showMessageDialog(null, "Cliente Alterado");
		} 
		
		catch (ClassNotFoundException | SQLException e) 
		{
			
			//e.printStackTrace();
			
			JOptionPane.showMessageDialog(null, "Ops... Ocorreu um erro inesperado,\n"
					+ "Tente mais tarde");
		}
		
	}

	
	
}
