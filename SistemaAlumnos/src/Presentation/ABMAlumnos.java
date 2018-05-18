package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JButton;
import Entities.*;
import Businnes.ABMAlumnosControlador;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ABMAlumnos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ABMAlumnosControlador control;
	private Collection<Alumno> lista;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMAlumnos frame = new ABMAlumnos();
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
	public ABMAlumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		DefaultTableModel modelo = new DefaultTableModel(new String[] {"Legajo","Tipo Documento","Documento","Nombre","Apellido","Fecha Nacimiento","Direccion"},0);
		
		control=new ABMAlumnosControlador();
		lista=control.listaAlumnos();
		for (Alumno alumno : lista) {
			String[] datos= new String[7];
			datos[0] = ""+alumno.getLegajo();
			datos[1] = alumno.getPers().getTipoDocumento();
			datos[2]=""+alumno.getPers().getDocumento();
			datos[3]=alumno.getPers().getNombre();
			datos[4]=alumno.getPers().getApellido();
			datos[5]=alumno.getPers().getFechaNac().toString();
			datos[6]=alumno.getPers().getDireccion();
			modelo.addRow(datos);
		}
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		MAltaAlumno alt=new MAltaAlumno(control);
		JButton btnAgregarAlumno = new JButton("Agregar Alumno");
		btnAgregarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alt.setVisible(true);
			}
		});
		panel_1.add(btnAgregarAlumno);
		
		JButton btnModificarAlumno = new JButton("Modificar alumno");
		panel_1.add(btnModificarAlumno);
		JButton btnEliminarAlumno = new JButton("Eliminar alumno");
		panel_1.add(btnEliminarAlumno);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.NORTH);
	
	}

}
