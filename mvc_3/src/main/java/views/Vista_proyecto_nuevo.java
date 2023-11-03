package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Vista_proyecto_nuevo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField nombre_proyecto= new JTextField();
	public JTextField cod_proyecto= new JTextField();
	public  JTextField horas_proyecto = new JTextField();
	public static JButton guardar = new JButton("guardar");
	


	


	public Vista_proyecto_nuevo() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 395, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		guardar.setVerticalAlignment(SwingConstants.TOP);
		guardar.setBounds(188, 100, 168, 23);
		contentPane.add(guardar);
		
		nombre_proyecto.setText("titulo proyecto");
		nombre_proyecto.setBounds(10, 12, 346, 20);
		contentPane.add(nombre_proyecto);
		nombre_proyecto.setColumns(10);
		
		cod_proyecto.setText("cod proyecto");
		cod_proyecto.setColumns(10);
		cod_proyecto.setBounds(10, 43, 100, 20);
		contentPane.add(cod_proyecto);
		horas_proyecto.setText("Horas");
		horas_proyecto.setColumns(10);
		horas_proyecto.setBounds(120, 43, 100, 20);
		
		contentPane.add(horas_proyecto);
	}

}
