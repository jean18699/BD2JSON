package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Libreria La Famosa");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		menuBar.add(mnRegistrar);
		
		JMenuItem mntmRegistrarLibro = new JMenuItem("Registrar Libro");
		mntmRegistrarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				RegistroLibro registroLibro = new RegistroLibro();
				registroLibro.setVisible(true);
				
			
			}
		});
		mnRegistrar.add(mntmRegistrarLibro);
		
		JMenuItem mntmRegistrarAutor = new JMenuItem("Registrar Autor");
		mntmRegistrarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistroAutor registroAutor = new RegistroAutor();
				registroAutor.setVisible(true);
				
			}
		});
		mnRegistrar.add(mntmRegistrarAutor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
