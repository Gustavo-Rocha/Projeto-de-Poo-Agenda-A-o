package Control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Model.GetAgendar;
import Persistence.AgendarDao;
import Persistence.IAgendarDAO;




public class TableControl implements TableModel {
	
	
	private List<GetAgendar> listAgenda = new ArrayList<GetAgendar>();
	
	
	private IAgendarDAO IAgen = new AgendarDao();
	

	
	
	public List<GetAgendar> Pesquisa(String cpf, String datas) throws SQLException
	{
		
		
		
			listAgenda=IAgen.ListaAgendamento(cpf, datas);
		
			// TODO Auto-generated catch block
		
		
		
		
		return listAgenda;
		
	}
	public GetAgendar getItem( int i ) { 
		return listAgenda.get(i);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		// TODO Auto-generated method stub
		
		switch( coluna ) { 
		case 0 : return String.class;
		case 1 : return String.class;
		
	}
	return String.class;
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getColumnName(int coluna) {
		// TODO Auto-generated method stub
		
		switch( coluna ) { 
		case 0 : return "CPF";
		case 1 : return "DATA";
		
	}
	return "";
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listAgenda.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// TODO Auto-generated method stub
		GetAgendar age= listAgenda.get(linha);
		
		switch( coluna ) { 
		case 0 : return age.getCpf();
		case 1 : return age.getDataHora();		
	}
	return "";
		
		
		
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

}
