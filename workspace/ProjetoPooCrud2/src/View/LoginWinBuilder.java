package View;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


import Control.BotoesLogin;
import Model.GetLogin;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class LoginWinBuilder extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
				try {
					LoginWinBuilder frame = new LoginWinBuilder();
					frame.setVisible(true);
					
					Agendar age = new Agendar();
					age.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
//				}
			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public LoginWinBuilder() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblLogin.setBounds(177, 0, 78, 66);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio :");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(79, 69, 78, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(79, 126, 78, 16);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("Digite aqui o Login");
		txtUsuario.setDocument(new ValidaCampo(15,""));
		txtUsuario.setBounds(204, 66, 116, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setDocument(new ValidaCampo(8,""));
		txtSenha.setDropMode(DropMode.INSERT);
		txtSenha.setColumns(10);
		txtSenha.setBounds(204, 123, 116, 22);
		contentPane.add(txtSenha);
		
		BotoesLogin fLogar = new BotoesLogin();
 
		//metodo que verifica a existencia do usuário no banco de dados e se houver ele efetuara login
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				GetLogin glogin = new GetLogin();
				glogin = fLogar.Logar(txtUsuario.getText(),txtSenha.getText());
				
				
						
				dispose();
			}
		});
		btnOk.setBounds(79, 183, 97, 25);
		contentPane.add(btnOk);
		
		
		// metodo  criado com a finalidade de para a execução  do programa
		JButton btnSair = new JButton("Sair");
		
		btnSair.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			fLogar.Sair(btnSair);
			
			}
		}
		);
		
		btnSair.setBounds(223, 183, 97, 25);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginWinBuilder.class.getResource("/View/df7b090260fb4980aecafd8c66cc978f--free-photoshop-dana.jpg")));
		lblNewLabel.setBounds(0, 0, 432, 253);
		contentPane.add(lblNewLabel);
		

		
	}
}
