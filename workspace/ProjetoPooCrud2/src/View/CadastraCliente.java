package View;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.BotoesCadastra;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


import Model.GetCliente;


public class CadastraCliente extends JFrame {
	

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTelelone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JLabel lblGnero;
	private JTextField txtCep;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtCpf;
	private JTextPane txtObservacao = new JTextPane();
	String sexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraCliente frame = new CadastraCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void preencheCampos(GetCliente cli) 
	{
		// TODO Auto-generated method stub	
		
		txtNome.setText(cli.getNome());
		txtTelelone.setText(String.valueOf(cli.getTelefone()));
		txtCelular.setText(String.valueOf(cli.getCelular()));
		txtCep.setText(String.valueOf(cli.getCep()));
		txtEmail.setText(cli.getEmail());
		txtBairro.setText(cli.getBairro());
		txtCidade.setText(cli.getCidade());
		txtEstado.setText(cli.getUf());
		txtObservacao.setText(cli.getObservacao());
		
		
	}

	/**
	 * Create the frame.
	 */
	public CadastraCliente() 
	{
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1220, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(410, 32, 66, 16);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setDocument(new ValidaCampo(45,"[0-9]"));
		txtNome.setBounds(522, 29, 514, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setBounds(39, 88, 76, 16);
		contentPane.add(lblTelefone);
		
		txtTelelone = new JTextField();
		txtTelelone.setDocument(new ValidaCampo(10,"[aA-zZ]"));
		txtTelelone.setBounds(156, 85, 189, 22);
		contentPane.add(txtTelelone);
		txtTelelone.setColumns(10);
		
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setBounds(410, 91, 66, 16);
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setDocument(new ValidaCampo(11,"[aA-zZ]"));
		txtCelular.setBounds(519, 85, 189, 22);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(522, 205, 66, 16);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setDocument(new ValidaCampo(45,""));
		txtEmail.setBounds(626, 202, 410, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		
		lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGnero.setForeground(Color.WHITE);
		lblGnero.setBounds(741, 88, 66, 16);
		contentPane.add(lblGnero);
		
		JRadioButton rdbtnMaculino = new JRadioButton("Maculino");
		rdbtnMaculino.setBounds(825, 84, 127, 25);
		contentPane.add(rdbtnMaculino);
		
		JRadioButton rdbtnFeminido = new JRadioButton("Feminino");
		rdbtnFeminido.setBounds(956, 84, 127, 25);
		contentPane.add(rdbtnFeminido);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnFeminido);
		bg.add(rdbtnMaculino);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setBounds(39, 205, 66, 16);
		contentPane.add(lblCidade);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCep.setForeground(Color.WHITE);
		lblCep.setBounds(39, 153, 66, 16);
		contentPane.add(lblCep);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setBounds(410, 153, 66, 16);
		contentPane.add(lblBairro);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEstado.setBounds(39, 266, 65, 16);
		contentPane.add(lblEstado);

		
		txtCep = new JTextField();
		txtCep.setDocument(new ValidaCampo(8,"[aA-zZ]"));
		txtCep.setBounds(156, 150, 189, 22);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setDocument(new ValidaCampo(45,"[0-9]"));
		txtBairro.setBounds(522, 150, 514, 22);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setDocument(new ValidaCampo(45,"[0-9]"));
		txtCidade.setBounds(156, 202, 310, 22);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setDocument(new ValidaCampo(2,"[0-9]"));
		txtEstado.setBounds(156, 262, 200, 28);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblObeservao = new JLabel("Obeserva\u00E7\u00E3o:");
		lblObeservao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblObeservao.setForeground(Color.WHITE);
		lblObeservao.setBounds(45, 315, 200, 116);
		contentPane.add(lblObeservao);
		
		
		txtObservacao.setBounds(156, 329, 806, 102);
		contentPane.add(txtObservacao);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(72, 473, 127, 32);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(283, 473, 127, 32);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(522, 473, 127, 32);
		contentPane.add(btnExcluir);
		
		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.setBounds(754, 473, 127, 32);
		contentPane.add(btnPesquisa);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setBounds(39, 32, 56, 16);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setText("Digite aqui o CPF");
		txtCpf.setDocument(new ValidaCampo(11,"[aA-zZ]"));
		
		txtCpf.setColumns(10);
		txtCpf.setBounds(156, 29, 189, 22);
		contentPane.add(txtCpf);
		//botão de voltar para tela de agendamento
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Agendar age;
				try {
					age = new Agendar();
					age.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button.setBounds(975, 473, 127, 32);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CadastraCliente.class.getResource("/View/textura 1220x600.jpg")));
		lblNewLabel.setBounds(0, 0, 1217, 594);
		contentPane.add(lblNewLabel);
		
		repaint();
		
		sexo = "Indefinido";
		if (rdbtnFeminido.isSelected()){
			sexo = rdbtnFeminido.getText();
		}
		else if (rdbtnMaculino.isSelected()) {
			sexo = rdbtnMaculino.getText();
		}
		BotoesCadastra btnCadastra = new BotoesCadastra();
		
		//Adicionando o action listener e chamando o metodo da classe btnCadastra  para todas as funções
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				btnCadastra.InsertCliente(txtCep.getText(), txtNome.getText(), txtTelelone.getText(), txtEmail.getText(), txtCelular.getText(),
						txtCidade.getText(), txtEstado.getText(),txtCpf.getText(),txtBairro.getText(),sexo, txtObservacao.getText());
				
				
			}
		});
		System.out.println("chamou o cadastro");
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnCadastra.DeleteCliente(txtCep.getText(), txtNome.getText(), txtTelelone.getText(), txtEmail.getText(), txtCelular.getText(),
						txtCidade.getText(), txtEstado.getText(),txtCpf.getText(),txtBairro.getText(),sexo, txtObservacao.getText());
				
			}
		});
		
	
		btnPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GetCliente cli = new GetCliente();
				cli = btnCadastra.SelectCliente(txtCpf.getText());
				preencheCampos(cli);
			}
		});
		
		
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCadastra.UpdateCliente(txtCep.getText(), txtNome.getText(), txtTelelone.getText(), txtEmail.getText(), txtCelular.getText(),
						txtCidade.getText(), txtEstado.getText(),txtCpf.getText(),txtBairro.getText(),sexo, txtObservacao.getText());
			}
		});
		
		
	}
	
	
}
