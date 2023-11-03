package views;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Vista_proyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tabla_proyecto;
	private static String[] nombre_columnas = {"id", "titulo", "Horas"};
    public static DefaultTableModel modelo_tabla = new DefaultTableModel(nombre_columnas, 0);
    public static JButton nuevo_proyecto = new JButton("nuevo proyecto");
    public static JButton editar_proyecto = new JButton("Editar proyecto");
	public static JButton eliminar_proyecto = new JButton("Eliminar proyecto");
	private final JLabel lblNewLabel = new JLabel("proyectos");

	/**
	 * Create the frame.
	 */
	public Vista_proyecto() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 876, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("New button");
		button.setBounds(0, 0, 0, 0);
		contentPane.add(button);
		
		
		nuevo_proyecto.setBounds(711, 41, 149, 23);
		contentPane.add(nuevo_proyecto);
		
		editar_proyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editar_proyecto.setBounds(711, 75, 149, 23);
		contentPane.add(editar_proyecto);
		

		eliminar_proyecto.setBounds(711, 109, 149, 23);
		contentPane.add(eliminar_proyecto);
		
		//modelo tabla 
		tabla_proyecto = new JTable(modelo_tabla);
		tabla_proyecto.setBounds(21, 11, 422, 292);
		contentPane.add(tabla_proyecto);
	    JScrollPane scrollPane = new JScrollPane(tabla_proyecto);
        scrollPane.setBounds(21, 38, 680, 292);
        contentPane.add(scrollPane);
        lblNewLabel.setBounds(21, 11, 367, 14);
        
        contentPane.add(lblNewLabel);

	}

}
