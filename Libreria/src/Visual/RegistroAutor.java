package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import Logico.Autor;
import Logico.Libreria;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RegistroAutor extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaNacimiento;
	private JLabel lblLugarDeNacimiento;
	private JTextField txtLugarNacimiento;
	private JTextField txtNombre;
	private JTextField txtDefuncion;
	Gson gson;
	

	
	/**
	 * Create the frame.
	 */
	public RegistroAutor() {
		setTitle("Registrar autor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 266, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 11, 56, 14);
		contentPane.add(lblNombre);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setBounds(10, 37, 116, 14);
		contentPane.add(lblFechaNacimiento);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(121, 34, 114, 20);
		contentPane.add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		lblLugarDeNacimiento = new JLabel("Lugar de nacimiento:");
		lblLugarDeNacimiento.setBounds(10, 68, 126, 14);
		contentPane.add(lblLugarDeNacimiento);
		
		txtLugarNacimiento = new JTextField();
		txtLugarNacimiento.setBounds(131, 65, 104, 20);
		contentPane.add(txtLugarNacimiento);
		txtLugarNacimiento.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(65, 8, 170, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(10, 108, 81, 14);
		contentPane.add(lblNacionalidad);
		
		JComboBox cmbNacionalidad = new JComboBox();
		cmbNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"Estados Unidos", "Republica Dominicana", "Peru", "Cuba", "Chile", "Panama", "Mexico", "Espa\u00F1a", "Italia", "Venezuela", "Colombia", "Costa Rica", "Panama", "Inglaterra", "Francia"}));
		cmbNacionalidad.setBounds(94, 105, 122, 20);
		contentPane.add(cmbNacionalidad);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 144, 39, 14);
		contentPane.add(lblSexo);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		cmbSexo.setBounds(45, 141, 89, 20);
		contentPane.add(cmbSexo);
		
		JLabel lblFechaDefuncion = new JLabel("Fecha defuncion:");
		lblFechaDefuncion.setBounds(10, 183, 116, 20);
		contentPane.add(lblFechaDefuncion);
		
		txtDefuncion = new JTextField();
		txtDefuncion.setBounds(121, 183, 114, 20);
		contentPane.add(txtDefuncion);
		txtDefuncion.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gson = new Gson();	

			    Date dateNacimiento = null;
				try {
					dateNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaNacimiento.getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    Date dateDefuncion = null;
				try {
					dateDefuncion = new SimpleDateFormat("dd/MM/yyyy").parse(txtDefuncion.getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
				Autor autor = new Autor(dateNacimiento,txtNombre.getText(),dateDefuncion,txtLugarNacimiento.getText(),
						cmbNacionalidad.getSelectedItem().toString(),cmbSexo.getSelectedItem().toString());
				
				Libreria.getInstance().addAutor(autor);
				
				Libreria.getInstance().SaveData();
				dispose();
			
			}
		});
		btnRegistrar.setBounds(161, 237, 89, 23);
		contentPane.add(btnRegistrar);
	}
}
