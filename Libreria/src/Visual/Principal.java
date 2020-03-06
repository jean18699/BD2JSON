package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Autor;
import Logico.Libreria;
import Logico.Libro;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

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
		Libreria myLib  = Libreria.getInstance(); 
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
			
				RegistroLibro registroLibro = new RegistroLibro(myLib);
				registroLibro.setVisible(true);
				
			
			}
		});
		mnRegistrar.add(mntmRegistrarLibro);
		
		JMenuItem mntmRegistrarAutor = new JMenuItem("Registrar Autor");
		mntmRegistrarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistroAutor registroAutor = new RegistroAutor(myLib);
				registroAutor.setVisible(true);
				
			}
		});
		mnRegistrar.add(mntmRegistrarAutor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("AUTORES: ");
				for(int i = 0; i < Libreria.getInstance().getAutores().size();i++)
				{
				Autor autor = Libreria.getInstance().getAutores().get(i);
				System.out.println("Nombre: "+autor.getNombre()+ ", Nacionalidad: "+ autor.getNacionalidad() + ", Sexo: " +
				autor.getSexo() + ", Fecha de nacimiento: "+ autor.getFechaNacimiento() + ", Lugar de nacimiento: "+
				autor.getLugarNacimiento() + ", Fecha defuncion: " + autor.getFechaFuncion());
				}

				System.out.println("\n\nLIBROS: ");
				for(int i = 0; i < Libreria.getInstance().getLibros().size();i++)
				{
				Libro libro = Libreria.getInstance().getLibros().get(i);
				System.out.println("Titulo: "+libro.getTitulo()+ ", Genero: "+ libro.getGenero() + ", Editorial: " +
				libro.getCasaEditora() + ", Año primera edicion: "+ libro.getAgnoPrimeraEdicion() + ", Idioma: "+
				libro.getIdioma() + ", Sipnosis: " + libro.getSipnosis() + ", Autores: " + libro.getAutores()
				);
				}
				
			}
		});
		contentPane.add(btnListar, BorderLayout.CENTER);
	}

}
