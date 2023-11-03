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

public class Vista_cientifico_proyectos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tabla_proyecto;
	private static String[] nombre_columnas = {"id", "Nombre", "Horas"};
    public static DefaultTableModel modelo_tabla = new DefaultTableModel(nombre_columnas, 0);
    public static JLabel nombre_cientifico = new JLabel("nombre cientifico");
    public static JLabel dni_cientifico = new JLabel("direccion cientifico");
	/**
	 * Create the frame.
	 */
	public Vista_cientifico_proyectos() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 733, 387);
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
		tabla_proyecto.setBounds(21, 11, 422, 292);
		contentPane.add(tabla_proyecto);
	    JScrollPane scrollPane = new JScrollPane(tabla_proyecto);
        scrollPane.setBounds(21, 112, 680, 218);
        contentPane.add(scrollPane);
        

        nombre_cientifico.setBounds(21, 11, 336, 14);
        contentPane.add(nombre_cientifico);
        
        dni_cientifico.setBounds(21, 36, 669, 14);
        contentPane.add(dni_cientifico);
        
        JLabel lblNewLabel = new JLabel("Proyectos :");
        lblNewLabel.setBounds(21, 79, 314, 14);
        contentPane.add(lblNewLabel);

	}
}
