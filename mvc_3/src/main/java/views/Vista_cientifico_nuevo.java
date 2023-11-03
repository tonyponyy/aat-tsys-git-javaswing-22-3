package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Vista_cientifico_nuevo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField nombre_y_apellidos= new JTextField();
	public JTextField dni= new JTextField();
	public static JButton guardar = new JButton("guardar");


	


	public Vista_cientifico_nuevo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 395, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		guardar.setVerticalAlignment(SwingConstants.TOP);
		guardar.setBounds(188, 73, 168, 23);
		contentPane.add(guardar);
		
		nombre_y_apellidos.setText("Nombre y Apellidos");
		nombre_y_apellidos.setBounds(10, 12, 168, 20);
		contentPane.add(nombre_y_apellidos);
		nombre_y_apellidos.setColumns(10);
		
		dni.setText("dni");
		dni.setColumns(10);
		dni.setBounds(188, 12, 168, 20);
		contentPane.add(dni);
	}

}
