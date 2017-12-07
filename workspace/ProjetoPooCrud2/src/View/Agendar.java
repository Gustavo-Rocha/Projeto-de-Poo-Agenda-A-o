package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.BotoesAgendar;
import Control.TableControl;
import Model.GetAgendar;
import javax.swing.JComboBox;



public class Agendar extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agendar frame = new Agendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	
	
	
//	formatando  o TXT da data para  o formato americano
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");	
	JFormattedTextField frmtdtxtfldDigiteAData = new JFormattedTextField(sdf);
	
	

	public void agendaToForm(GetAgendar a) { 
		
		
		
		txtCpf.setText(a.getCpf());
		
		Date d;
		try {
			d = sdf.parse(a.getDataHora());
			frmtdtxtfldDigiteAData.setValue(d );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public GetAgendar formToAgenda() { 
	GetAgendar a = new GetAgendar();
	    
	a.setCpf(txtCpf.getText());
		
	a.setDataHora( (String) frmtdtxtfldDigiteAData.getValue());
		
		return a;
	}
	
	
	
	
	
	public Agendar() throws SQLException  {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblDataEHora = new JLabel("Data e Hora:");
		lblDataEHora.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataEHora.setForeground(Color.WHITE);
		lblDataEHora.setBounds(42, 208, 107, 16);
		contentPane.add(lblDataEHora);
		
		
		
		txtCpf = new JTextField();
		txtCpf.setDocument(new ValidaCampo(11,"[aA-zZ]"));
		txtCpf.setBounds(161, 133, 148, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 88, 270, 156);
		getContentPane().add(scrollPane);

		TableControl tabelaControle = new TableControl();
		table = new JTable();
		
		table.setModel(tabelaControle);
		scrollPane.setViewportView(table);
		
		String formData = frmtdtxtfldDigiteAData.getText();
		
		//chamando o método que  faz o select para trazer a Jtable na view
		List<GetAgendar> LstAgenda = tabelaControle.Pesquisa(txtCpf.getText(),formData);
		
		if(LstAgenda.size() > 0)
		{
			GetAgendar recebeAgen = LstAgenda.get(0);
			agendaToForm(recebeAgen);
			
		}
		table.invalidate();
		table.revalidate();
		table.repaint();

		BotoesAgendar agendare = new  BotoesAgendar();

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setBounds(45, 136, 56, 16);
		contentPane.add(lblCpf);
		
		
		//botão que leva para tela de cadastro do cliente
		
		JButton btnCadastrar = new JButton("Cliente");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Agendar agen;
				
					try {
						agen = new Agendar();
						CadastraCliente cadCli = new CadastraCliente();
						agen.dispose();
						
						cadCli.setLocale(null);
						cadCli.setVisible(true);
						cadCli.setResizable(false);
						
						agen.setDefaultCloseOperation(EXIT_ON_CLOSE);
						
						dispose();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
			}
		});
		btnCadastrar.setBounds(84, 326, 118, 44);
		contentPane.add(btnCadastrar);
		
		//botão que chama os metodos de inserção na tabela do banco de dados
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String formData = frmtdtxtfldDigiteAData.getText();
				agendare.Agendar(txtCpf.getText(), formData);
				
				
			}
		});
		btnAgendar.setBounds(438, 326, 118, 44);
		contentPane.add(btnAgendar);

		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				GetAgendar getAgen = new GetAgendar();
				
				String formData = frmtdtxtfldDigiteAData.getText();
				
				getAgen= agendare.VerificarDisponibilidade(formData);
				
			}
		});
		btnVerificar.setBounds(407, 267, 97, 25);
		btnVerificar.setVisible(false);
		contentPane.add(btnVerificar);
		
		JLabel lblAgendarHorrio = new JLabel("AGENDAR HOR\u00C1RIO");
		lblAgendarHorrio.setForeground(Color.WHITE);
		lblAgendarHorrio.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAgendarHorrio.setBounds(207, 13, 216, 62);
		contentPane.add(lblAgendarHorrio);
		
		
		frmtdtxtfldDigiteAData.setBounds(161, 205, 148, 19);
		contentPane.add(frmtdtxtfldDigiteAData);
		
		//Botão para sair da aplicação
		JButton button = new JButton("Sair");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		button.setBounds(260, 326, 118, 44);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Agendar.class.getResource("/View/df7b090260fb4980aecafd8c66cc978f--free-photoshop-dana.jpg")));
		lblNewLabel.setBounds(0, 0, 642, 453);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
