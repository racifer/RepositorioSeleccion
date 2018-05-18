package Presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TrayIcon.MessageType;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import Businnes.ABMAlumnosControlador;
import Entities.Alumno;
import Entities.Carrera;
import Entities.InscripcionCarrera;
import Entities.Persona;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class MAltaAlumno extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public MAltaAlumno(ABMAlumnosControlador control) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 12, 70, 15);
		contentPanel.add(lblNombre);
		
		JFormattedTextField txtNombre = new JFormattedTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(72, 10, 113, 19);
		contentPanel.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(203, 12, 70, 15);
		contentPanel.add(lblApellido);
		
		JFormattedTextField txtApellido = new JFormattedTextField();
		txtApellido.setBounds(267, 10, 161, 19);
		contentPanel.add(txtApellido);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 39, 70, 15);
		contentPanel.add(lblDireccion);
		
		JFormattedTextField txtDireccion = new JFormattedTextField();
		txtDireccion.setBounds(82, 39, 286, 19);
		contentPanel.add(txtDireccion);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(12, 66, 114, 15);
		contentPanel.add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LC", "LE"}));
		comboBox.setBounds(135, 61, 52, 24);
		contentPanel.add(comboBox);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(193, 66, 80, 15);
		contentPanel.add(lblDocumento);

		JFormattedTextField txtDocumento = new JFormattedTextField(NumberFormat.getNumberInstance());
		txtDocumento.setBounds(282, 64, 146, 19);
		contentPanel.add(txtDocumento);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(12, 93, 136, 15);
		contentPanel.add(lblFechaNacimiento);

		DateFormat format=new SimpleDateFormat("dd - M - yyyy");
		JFormattedTextField txtFecNac = new JFormattedTextField(format);
		txtFecNac.setBounds(145, 97, 128, 19);
		contentPanel.add(txtFecNac);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(12, 131, 70, 15);
		contentPanel.add(lblCarrera);
		
		JComboBox cmbCarrera = new JComboBox();
		Collection<Carrera> carrera=control.listaCarreras();
		Collection<Alumno> alumnos=control.listaAlumnos();
		DefaultComboBoxModel<String> model=new DefaultComboBoxModel<String>();
		for (Carrera carrera2 : carrera) {
			model.addElement(carrera2.getNombre());
		}
		cmbCarrera.setModel(model);
		cmbCarrera.setBounds(94, 126, 304, 24);
		contentPanel.add(cmbCarrera);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtApellido.getValue()==null) {
							JOptionPane.showMessageDialog( txtApellido.getParent(), "Ingrese apellido", "Falta Apellido",JOptionPane.WARNING_MESSAGE);
						}else {
							if(txtNombre.getValue()==null ) {
								JOptionPane.showMessageDialog( txtNombre.getParent(), "Ingrese nombre", "Falta Nombre",JOptionPane.WARNING_MESSAGE);
							}else {
								if(txtDocumento.getValue()==null) {
									JOptionPane.showMessageDialog( txtDocumento.getParent(), "Ingrese documento", "Falta documento",JOptionPane.WARNING_MESSAGE);
								}else {
									if(txtFecNac.getValue()==null) {
										JOptionPane.showMessageDialog( txtFecNac.getParent(), "Ingrese fecha nacimiento", "Falta fecha nacimiento",JOptionPane.WARNING_MESSAGE);
									}else {
										Carrera carr=carrera.stream().findFirst().filter(s->s.getNombre()==cmbCarrera.getSelectedItem().toString()).get();
										
										Persona per=new Persona();
										Alumno al=new Alumno();
										Alumno[] array=new Alumno[alumnos.size()];
										InscripcionCarrera inscar= new InscripcionCarrera();
										Alumno[] aArray= alumnos.toArray(array);
										al.setIdentificador(aArray[alumnos.size()-1].getIdentificador());
										al.setLegajo(new Random().nextInt());
										per.setApellido(txtApellido.getText());
										per.setNombre(txtNombre.getText());
										per.setDireccion(txtDireccion.getText());
										per.setDocumento((Long)txtDocumento.getValue());
										per.setTipoDocumento(comboBox.getSelectedItem().toString());
										per.setFechaNac((Date)txtFecNac.getValue());
										per.setIdentificador(aArray[alumnos.size()-1].getPers().getIdentificador());
										Carrera carr1=carrera.stream().findFirst().filter(s->s.getNombre()==cmbCarrera.getSelectedItem().toString()).get();
										inscar.setAlumno(al);
										inscar.setCarrera(carr1);
										inscar.setFechaInscripcion(new Date());
										inscar.setCarrera(carr1);
										int p=control.insertarAlumno(al, inscar);
										if(p==-1) {
											JOptionPane.showMessageDialog( txtNombre.getParent(), "error", "Falta Nombre",JOptionPane.WARNING_MESSAGE);
										}	
									}
								}
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

}
