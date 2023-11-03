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
import java.awt.Font;

public class Vista_cientifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tabla_cientifico;
	private static String[] nombre_columnas = {"Dni", "nombre y apellidos"};
    public static DefaultTableModel modelo_tabla = new DefaultTableModel(nombre_columnas, 0);
    public static JButton nuevo_cientifico = new JButton("Nuevo cientifico");
    public static JButton editar_cientifico = new JButton("Editar cientifico");
	public static JButton eliminar_cientifico = new JButton("Eliminar cientifico");
	public static JButton ver_proyecto = new JButton("Ver proyectos");
	private final JLabel lblNewLabel = new JLabel("Cientificos");
	public final static JButton gestionar_proyectos = new JButton("Gestionar proyectos del cientifico");
	public final static JButton ver_cientifico = new JButton("Ver cientifico");
	

	/**
	 * Create the frame.
	 */
	public Vista_cientifico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("New button");
		button.setBounds(0, 0, 0, 0);
		contentPane.add(button);
		
		
		nuevo_cientifico.setBounds(711, 119, 180, 23);
		contentPane.add(nuevo_cientifico);
		
		editar_cientifico.setBounds(711, 153, 180, 23);
		contentPane.add(editar_cientifico);
		

		eliminar_cientifico.setBounds(711, 187, 180, 23);
		contentPane.add(eliminar_cientifico);
		
		//modelo tabla 
		tabla_cientifico = new JTable(modelo_tabla);
		tabla_cientifico.setBounds(21, 11, 422, 292);
		contentPane.add(tabla_cientifico);
	    JScrollPane scrollPane = new JScrollPane(tabla_cientifico);
        scrollPane.setBounds(21, 38, 680, 292);
        contentPane.add(scrollPane);
        lblNewLabel.setBounds(21, 11, 263, 14);
        
        contentPane.add(lblNewLabel);
        gestionar_proyectos.setFont(new Font("Tahoma", Font.PLAIN, 10));
        gestionar_proyectos.setBounds(711, 38, 180, 42);
        
        contentPane.add(gestionar_proyectos);
        ver_proyecto.setBounds(752, 307, 139, 23);
        
        contentPane.add(ver_proyecto);
        ver_cientifico.setBounds(711, 85, 180, 23);
        
        contentPane.add(ver_cientifico);

	}

}
