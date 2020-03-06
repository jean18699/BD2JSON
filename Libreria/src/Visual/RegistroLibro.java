package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Autor;
import Logico.Libreria;
import Logico.Libro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class RegistroLibro extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtEditorial;
	private JTextField txtSipnosis;
	private ArrayList<Autor> autores;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public RegistroLibro() {
		setTitle("Registrar libro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 461, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		autores = new ArrayList<Autor>();
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 11, 46, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(10, 47, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setBounds(10, 82, 59, 14);
		contentPane.add(lblEditorial);
		
		JLabel lblSipnosis = new JLabel("Sipnosis:");
		lblSipnosis.setBounds(10, 140, 81, 14);
		contentPane.add(lblSipnosis);
		
		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setBounds(156, 47, 43, 14);
		contentPane.add(lblIdioma);
		
		JLabel lblAoDeLa = new JLabel("A\u00F1o de la primera edicion:");
		lblAoDeLa.setBounds(10, 115, 133, 14);
		contentPane.add(lblAoDeLa);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(46, 8, 399, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JComboBox cmbGenero = new JComboBox();
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"Fantasia", "Drama", "Aventura", "Accion", "Comedia", "Romance", "Ciencia Ficcion", "Historia"}));
		cmbGenero.setBounds(56, 44, 87, 20);
		contentPane.add(cmbGenero);
		
		JComboBox cmbIdioma = new JComboBox();
		cmbIdioma.setModel(new DefaultComboBoxModel(new String[] {"Espa\u00F1ol", "Ingles", "Portugues", "Aleman", "Ruso", "Japones"}));
		cmbIdioma.setBounds(200, 44, 70, 20);
		contentPane.add(cmbIdioma);
		
		txtEditorial = new JTextField();
		txtEditorial.setBounds(66, 79, 136, 20);
		contentPane.add(txtEditorial);
		txtEditorial.setColumns(10);
		
		JSpinner spnPrimeraEdicion = new JSpinner();
		spnPrimeraEdicion.setBounds(144, 112, 70, 20);
		contentPane.add(spnPrimeraEdicion);
		
		txtSipnosis = new JTextField();
		txtSipnosis.setBounds(10, 165, 435, 85);
		contentPane.add(txtSipnosis);
		txtSipnosis.setColumns(10);
		
		JLabel lblAutores = new JLabel("Autor(es):");
		lblAutores.setBounds(222, 82, 59, 14);
		contentPane.add(lblAutores);
		
		JComboBox<String> cmbAutores = new JComboBox();
		cmbAutores.setToolTipText("Autores registrados en el sistema");
	//	cmbAutores.setModel(new DefaultComboBoxModel<Autor>(Libreria.getInstance().getAutores().toArray(new Autor[0])));
		//cmbAutores.setSelectedIndex(0);
		for(int i = 0; i < Libreria.getInstance().getAutores().size();i++)
		{
			cmbAutores.addItem(Libreria.getInstance().getAutores().get(i).getNombre());;	
		}
		cmbAutores.setBounds(280, 79, 120, 20);
		contentPane.add(cmbAutores);
		
		JButton btnAgregarAutor = new JButton("+");
		btnAgregarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Autor autor = Libreria.getInstance().getAutorByName(cmbAutores.getSelectedItem().toString());
				boolean agregar = true;
				for(int i = 0; i < autores.size();i++)
				{
					if(autores.get(i) == autor)
					{
						agregar = false;
					}
				}
				
				if(agregar == true)
				{
					autores.add(autor);		
				}
			}
		});
		btnAgregarAutor.setBounds(402, 78, 43, 23);
		contentPane.add(btnAgregarAutor);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					Libro libro = new Libro(txtTitulo.getText(),cmbIdioma.getSelectedItem().toString(),(int) spnPrimeraEdicion.getValue(),
							txtEditorial.getText(),cmbGenero.getSelectedItem().toString(),txtSipnosis.getText());
					
					for(int i = 0; i < autores.size();i++)
					{
						libro.addAutor(autores.get(i).getNombre());
					}
					
					Libreria.getInstance().addLibro(libro);
					
					//Agregando a los autores en sus clases que son autores de este libro:
					for(int i = 0; i < autores.size();i++)
					{
						
						for(int j = 0; j < Libreria.getInstance().getAutores().size();j++)
						{
							
							if(Libreria.getInstance().getAutores().get(j).getNombre().equalsIgnoreCase(autores.get(i).getNombre()))
							{
								Libreria.getInstance().getAutores().get(j).addLibroPublicado(libro.getTitulo());
							}
						}
							
					}
					
					Libreria.getInstance().SaveData();
					dispose();
					
			}
		});
		btnAgregar.setBounds(364, 255, 81, 23);
		contentPane.add(btnAgregar);
	}
}
