package controllers;

import views.Vista_cientifico;
import views.Vista_cientifico_nuevo;
import views.Vista_cientifico_proyectos;
import views.Vista_gestion_proyectos;
import views.Vista_proyecto;
import views.Vista_proyecto_nuevo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import models.Cientifico;
import models.Proyecto;

public class Controlador {
	String id_cientifico_temp = "0";
	String id_proyecto_temp = "0";
	Cientifico cientificos = new Cientifico();
	Proyecto proyectos = new Proyecto();
	Vista_gestion_proyectos vista_gestion_proyectos = new Vista_gestion_proyectos();
	Vista_proyecto_nuevo vista_proyecto_nuevo = new Vista_proyecto_nuevo();
	Vista_cientifico_proyectos vista_cientifico_proyectos = new Vista_cientifico_proyectos();
	Vista_cientifico_nuevo vista_nuevo = new Vista_cientifico_nuevo();
	Vista_proyecto vista_proyecto = new Vista_proyecto();
	

	public Controlador() {
		inicio();

	}

	private void aniadir_fila_cientifico() {
		List<Object[]> filas = (List<Object[]>) cientificos.mostrar_todos();
		for (Object[] fila : filas) {
			Vista_cientifico.modelo_tabla.addRow(fila);
		}
	}
	
	private void aniadir_fila_proyecto() {
		List<Object[]> filas = (List<Object[]>) proyectos.mostrar_todos();
		for (Object[] fila : filas) {
			Vista_proyecto.modelo_tabla.addRow(fila);
		}
	}

	private void inicio() {
		try {
			Vista_cientifico.ver_cientifico.addActionListener(ver_cientificos);
			Vista_cientifico.nuevo_cientifico.addActionListener(nuevo_cientificos);
			Vista_cientifico.eliminar_cientifico.addActionListener(borrar_cientificos);
			Vista_cientifico.editar_cientifico.addActionListener(editar_cientificos);
			Vista_cientifico.ver_proyecto.addActionListener(ver_proyectos);
			Vista_cientifico.gestionar_proyectos.addActionListener(gestonar_proyectos);
			Vista_cientifico frame = new Vista_cientifico();
			// vista proyectos
			Vista_proyecto.eliminar_proyecto.addActionListener(eliminar_proyectos);
			Vista_proyecto.nuevo_proyecto.addActionListener(nuevo_proyectos);
			Vista_proyecto.editar_proyecto.addActionListener(editar_proyectos);
			//vista gestion proyectos
			Vista_gestion_proyectos.aniadir_proyecto_cientifico.addActionListener(nuevo_proyecto_cientifico);
			Vista_gestion_proyectos.eliminar_proyecto_cientifico.addActionListener(eliminar_proyecto_cientifico);
			
			aniadir_fila_cientifico();
			aniadir_fila_proyecto();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ver_proyecto() {
		
		vista_proyecto.setVisible(true);
	}
	private void ver_cientifico() {
		
		try {
			int pos = Vista_cientifico.tabla_cientifico.getSelectedRow();
			String id =  (String) Vista_cientifico.tabla_cientifico.getValueAt(pos, 0);
			String nombre = Vista_cientifico.tabla_cientifico.getValueAt(pos, 1) + "";
			vista_cientifico_proyectos.nombre_cientifico.setText("Nombre: "+nombre+"");
			vista_cientifico_proyectos.dni_cientifico.setText("Dni: "+id);
			vista_cientifico_proyectos.modelo_tabla.setRowCount(0);
			List<Object[]> filas = (List<Object[]>) proyectos.mostrar_proyectos_cientifico(id);
			for (Object[] fila : filas) {
				vista_cientifico_proyectos.modelo_tabla.addRow(fila);
			}
			
			vista_cientifico_proyectos.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}

	}

	private void nuevo_cientifico() {
		resetear_boton_guardar();
		resetear_nombres();
		Vista_cientifico_nuevo.guardar.addActionListener(guardar_cientificos);
		vista_nuevo.setVisible(true);
	}

	private void resetear_boton_guardar() {
		Vista_proyecto_nuevo.guardar.removeActionListener(guardar_proyectos);
		Vista_proyecto_nuevo.guardar.removeActionListener(update_proyectos);
		Vista_cientifico_nuevo.guardar.removeActionListener(guardar_cientificos);
		Vista_cientifico_nuevo.guardar.removeActionListener(update_cientifico);
	}

	private void editar_cientifico() {
		try {
			resetear_boton_guardar();
			Vista_cientifico_nuevo.guardar.addActionListener(update_cientifico);
			int pos = Vista_cientifico.tabla_cientifico.getSelectedRow();
			String id = (String) Vista_cientifico.tabla_cientifico.getValueAt(pos, 0);
			id_cientifico_temp = id ;
			vista_nuevo.nombre_y_apellidos.setText(Vista_cientifico.tabla_cientifico.getValueAt(pos, 1) + "");
			vista_nuevo.dni.setText(Vista_cientifico.tabla_cientifico.getValueAt(pos, 0) + "");
			vista_nuevo.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}

	private void resetear_nombres() {
		vista_nuevo.nombre_y_apellidos.setText("Nombre y apellidos");
		vista_nuevo.dni.setText("Dni cientifico");
	}
	
	private void resetear_proyectos() {
		vista_proyecto_nuevo.nombre_proyecto.setText("Nombre proyecto");
		vista_proyecto_nuevo.horas_proyecto.setText("Horas proyecto");
		vista_proyecto_nuevo.cod_proyecto.setText("Codigo proyecto");
	}

	private void update_cientifico() {
		String nombre = vista_nuevo.nombre_y_apellidos.getText();
		String dni = vista_nuevo.dni.getText();

		if (Cientifico.editar(id_cientifico_temp, dni,nombre )) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			actualizar_index();
			vista_nuevo.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Revise los valores y intentelo de nuevo");
		}
	}
	
	private void update_proyecto() {
		String id_proyecto = vista_proyecto_nuevo.cod_proyecto.getText();
		String nombre_proyecto = vista_proyecto_nuevo.nombre_proyecto.getText();
		String horas_proyecto = vista_proyecto_nuevo.horas_proyecto.getText();
		if (proyectos.editar(id_proyecto_temp,id_proyecto,nombre_proyecto,horas_proyecto)) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			actualizar_index();
			vista_proyecto_nuevo.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Revise los valores y intentelo de nuevo");
		}
	}
	
	

	private void guardar_cientifico() {
		String nombre = vista_nuevo.nombre_y_apellidos.getText();
		String dni = vista_nuevo.dni.getText();

		if (cientificos.guardar(dni, nombre)) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			actualizar_index();
			vista_nuevo.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Revise los valores y intentelo de nuevo");
		}
	}
	
	private void guardar_proyecto() {
		String id_proyecto = vista_proyecto_nuevo.cod_proyecto.getText();
		String nombre_proyecto = vista_proyecto_nuevo.nombre_proyecto.getText();
		String horas_proyecto = vista_proyecto_nuevo.horas_proyecto.getText();
		
		if (proyectos.guardar(id_proyecto, nombre_proyecto,horas_proyecto)) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			actualizar_index();
			vista_proyecto_nuevo.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Revise los valores y intentelo de nuevo");
		}
	}

	private void actualizar_index() {
		Vista_cientifico.modelo_tabla.setRowCount(0);
		Vista_proyecto.modelo_tabla.setRowCount(0);
		aniadir_fila_cientifico();
		aniadir_fila_proyecto();
	}

	private void borrar_cientifico() {

		try {
		int pos = Vista_cientifico.tabla_cientifico.getSelectedRow();
		String id = (String) Vista_cientifico.tabla_cientifico.getValueAt(pos, 0);
		if (Cientifico.borrar(id + "")) {
			actualizar_index();
			JOptionPane.showMessageDialog(null, "Registro con Dni " + id + " borrado");
		} else {
			JOptionPane.showMessageDialog(null, "Error al borrar el registro");
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}

	
	private void borrar_proyecto() {
		try {
			int pos = Vista_proyecto.tabla_proyecto.getSelectedRow();
			String id = (String) Vista_proyecto.tabla_proyecto.getValueAt(pos, 0);
			if (Proyecto.borrar(id)) {
				actualizar_index();
				JOptionPane.showMessageDialog(null, "Registro con id " + id + " borrado");
			} else {
				JOptionPane.showMessageDialog(null, "Error al borrar el registro");
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Seleccione una opción");
			}
		
	}
	
	private void nuevo_proyecto() {
		resetear_boton_guardar();
		resetear_proyectos();
		Vista_proyecto_nuevo.guardar.addActionListener(guardar_proyectos);
		vista_proyecto_nuevo.setVisible(true);
		
	}
	private void editar_proyecto() {
		
		try {
			int pos = Vista_proyecto.tabla_proyecto.getSelectedRow();
			String id = (String) Vista_proyecto.tabla_proyecto.getValueAt(pos, 0);
			resetear_boton_guardar();
			resetear_proyectos();
			Vista_proyecto_nuevo.guardar.addActionListener(update_proyectos);
			id_proyecto_temp = id;
			vista_proyecto_nuevo.nombre_proyecto.setText(vista_proyecto.tabla_proyecto.getValueAt(pos, 1) + "");
			vista_proyecto_nuevo.horas_proyecto.setText(vista_proyecto.tabla_proyecto.getValueAt(pos, 2) + "");
			vista_proyecto_nuevo.cod_proyecto.setText(id);
			vista_proyecto_nuevo.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}
	
	private void gestionar_proyecto() {
		
		try {
			int pos = Vista_cientifico.tabla_cientifico.getSelectedRow();
			String id = (String) Vista_cientifico.tabla_cientifico.getValueAt(pos, 0);
			
			String nombre = Vista_cientifico.tabla_cientifico.getValueAt(pos, 1) + "";
			String dni = Vista_cientifico.tabla_cientifico.getValueAt(pos, 0) + "";
			vista_gestion_proyectos.nombre_cientifico.setText("Nombre: "+nombre+"  ("+dni+")");
			vista_gestion_proyectos.modelo_tabla.setRowCount(0);
			id_cientifico_temp = id+"";
			actualizar_vista_gestion();
			vista_gestion_proyectos.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
		
	}
	
	private void eliminar_proyecto_cientifico() {
		try {
			int pos = Vista_gestion_proyectos.tabla_proyecto.getSelectedRow();
			String id = (String) Vista_gestion_proyectos.tabla_proyecto.getValueAt(pos, 0);
			if (Proyecto.quitar_cientifico(id,id_cientifico_temp)) {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");	
			actualizar_vista_gestion();	
			}else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}
	
	private void nuevo_proyecto_cientifico() {
		try {
			int pos = Vista_gestion_proyectos.tabla_proyecto2.getSelectedRow();
			String id = (String) Vista_gestion_proyectos.tabla_proyecto2.getValueAt(pos, 0);
			if (Proyecto.aniadir_cientifico(id, id_cientifico_temp)) {
			actualizar_vista_gestion();	
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");	
			}else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Seleccione una opción");
		}
	}
	
	private void actualizar_vista_gestion() {
		vista_gestion_proyectos.modelo_tabla.setRowCount(0);
		List<Object[]> filas = (List<Object[]>) proyectos.mostrar_proyectos_cientifico(id_cientifico_temp);
		for (Object[] fila : filas) {
			vista_gestion_proyectos.modelo_tabla.addRow(fila);
		}
		vista_gestion_proyectos.modelo_tabla2.setRowCount(0);
		List<Object[]> filas_sin_vincular = (List<Object[]>) proyectos.mostrar_proyectos_sin_vincular(id_cientifico_temp);
		for (Object[] fila : filas_sin_vincular) {
			vista_gestion_proyectos.modelo_tabla2.addRow(fila);
		}
		
	}
	
	//action listeners
	
	ActionListener borrar_cientificos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			borrar_cientifico();
		}
	};
	
	ActionListener ver_proyectos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ver_proyecto();
		}
	};


	ActionListener nuevo_cientificos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nuevo_cientifico();
		}
	};

	ActionListener guardar_cientificos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			guardar_cientifico();
		}
	};

	ActionListener editar_cientificos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			editar_cientifico();
		}
	};

	ActionListener update_cientifico = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			update_cientifico();
		}
	};
	
	ActionListener ver_cientificos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ver_cientifico();
		}
	};

	ActionListener eliminar_proyectos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			borrar_proyecto();
		}
	};
	
	ActionListener nuevo_proyectos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nuevo_proyecto();
		}
	};
	ActionListener editar_proyectos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			editar_proyecto();
		}
	};
	
	ActionListener guardar_proyectos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			guardar_proyecto();
		}
	};
	
	ActionListener update_proyectos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			update_proyecto();
		}
	};
	
	ActionListener gestonar_proyectos = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			gestionar_proyecto();
		}
	};

	ActionListener eliminar_proyecto_cientifico = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			eliminar_proyecto_cientifico();
		}
	};
	ActionListener nuevo_proyecto_cientifico = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nuevo_proyecto_cientifico();
		}
	};
	


	
	
	
}


