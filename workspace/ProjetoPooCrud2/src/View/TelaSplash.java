package View;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JProgressBar;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaSplash extends JFrame {

	private JPanel contentPane  = new JPanel();
	private static JProgressBar progressBar = new JProgressBar();

	private LoginWinBuilder  log = new LoginWinBuilder();
	
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSplash frame = new TelaSplash();
					frame.setVisible(true);
							
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public TelaSplash() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(0, 0, 139));
		
		
		progressBar.setBounds(12, 357, 558, 33);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaSplash.class.getResource("/View/New-York-Knicks-Logo-WallpapersSplash600x450title.jpg")));
		lblNewLabel.setBounds(0, 0, 582, 403);
		contentPane.add(lblNewLabel);

		// Thread para fazer a barra de carregamento se utilizar do tempo  e criar o efeito de carregar
		new Thread()
		{
			
			
			public void run()
			{
				for(int i=0;i<=100;i++)
				{
					try 
					{
						
						sleep(50);
						progressBar.setValue(i);
						
						
						
					} 
					catch (InterruptedException e) 
					{
						
						e.printStackTrace();
						
						
					}
				}
				dispose();
				
			}
			
			
			
		}.start();
		
		dispose();
		
		
		log.setVisible(true); 
		
		
		
		
	}
	
	
	
//	public void fechar()
//	{
//		dispose();
//	}
	
	
}
