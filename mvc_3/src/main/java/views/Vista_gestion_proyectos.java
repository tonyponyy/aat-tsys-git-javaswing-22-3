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
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Vista_gestion_proyectos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tabla_proyecto;
	public static JTable tabla_proyecto2;
	private static String[] nombre_columnas = {"id", "Nombre", "Horas"};
    public static DefaultTableModel modelo_tabla = new DefaultTableModel(nombre_columnas, 0);
    public static DefaultTableModel modelo_tabla2 = new DefaultTableModel(nombre_columnas, 0);
    public static JLabel nombre_cientifico = new JLabel("nombre cientifico");
    public static JButton aniadir_proyecto_cientifico = new JButton("Añadir proyecto");
    public static JButton eliminar_proyecto_cientifico = new JButton("Eliminar proyecto");
    
	/**
	 * Create the frame.
	 */
	public Vista_gestion_proyectos() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 150, 766, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("New button");
		button.setBounds(0, 0, 0, 0);
		contentPane.add(button);
		
		//modelo tabla 
		tabla_proyecto = new JTable(modelo_tabla);
		tabla_proyecto.setBounds(1, 26, 579, 0);
		contentPane.add(tabla_proyecto);
	    JScrollPane scrollPane = new JScrollPane(tabla_proyecto);
	    scrollPane.setBounds(21, 92, 581, 124);
        contentPane.add(scrollPane);
        
        tabla_proyecto2 = new JTable(modelo_tabla2);
        tabla_proyecto2.setBounds(1, 26, 579, 0);
		contentPane.add(tabla_proyecto2);
	    JScrollPane scrollPane2 = new JScrollPane(tabla_proyecto2);
	    scrollPane2.setBounds(21, 261, 581, 124);
        contentPane.add(scrollPane2);
        nombre_cientifico.setBounds(21, 11, 336, 14);
        contentPane.add(nombre_cientifico);
        
        
        aniadir_proyecto_cientifico.setBounds(612, 264, 129, 23);
        contentPane.add(aniadir_proyecto_cientifico);
        
        
        eliminar_proyecto_cientifico.setBounds(612, 95, 129, 23);
        contentPane.add(eliminar_proyecto_cientifico);
        
        JLabel lblNewLabel = new JLabel("proyectos del cientifico");
        lblNewLabel.setBounds(21, 73, 581, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblproyectosDisponibles = new JLabel("proyectos disponibles");
        lblproyectosDisponibles.setBounds(21, 236, 581, 14);
        contentPane.add(lblproyectosDisponibles);

	}
}
