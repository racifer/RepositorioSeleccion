package Presentation;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AltaAlumno extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaAlumno frame = new AltaAlumno();
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
	public AltaAlumno() {
		setTitle("Alta Alumno");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 12, 70, 15);
		getContentPane().add(lblNombre);
		
		JFormattedTextField txtNombre = new JFormattedTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(72, 10, 113, 19);
		getContentPane().add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(203, 12, 70, 15);
		getContentPane().add(lblApellido);
		
		JFormattedTextField txtApellido = new JFormattedTextField();
		txtApellido.setBounds(267, 10, 161, 19);
		getContentPane().add(txtApellido);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 39, 70, 15);
		getContentPane().add(lblDireccion);
		
		JFormattedTextField txtDireccion = new JFormattedTextField();
		txtDireccion.setBounds(82, 39, 286, 19);
		getContentPane().add(txtDireccion);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(12, 66, 114, 15);
		getContentPane().add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LC", "LE"}));
		comboBox.setBounds(135, 61, 52, 24);
		getContentPane().add(comboBox);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(193, 66, 80, 15);
		getContentPane().add(lblDocumento);
		
		JFormattedTextField txtDocumento = new JFormattedTextField();
		txtDocumento.setBounds(282, 64, 146, 19);
		getContentPane().add(txtDocumento);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(12, 93, 136, 15);
		getContentPane().add(lblFechaNacimiento);
		
		JFormattedTextField txtFecNac = new JFormattedTextField();
		txtFecNac.setBounds(145, 97, 128, 19);
		getContentPane().add(txtFecNac);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(12, 131, 70, 15);
		getContentPane().add(lblCarrera);
		
		JComboBox cmbCarrera = new JComboBox();
		cmbCarrera.setBounds(94, 126, 179, 24);
		getContentPane().add(cmbCarrera);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(12, 218, 117, 25);
		getContentPane().add(btnIngresar);

	}
}
