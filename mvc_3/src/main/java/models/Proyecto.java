package models;

import java.util.List;

import mysql.Conection;

public class Proyecto {
	static Conection conexion = new Conection();
	private static String ATRIBUTOS = "id,Nombre,Horas";
	private static String DATABASE_NAME = "cientificos";
	private static String TABLE_NAME = "proyecto";
	
	public List<Object[]> mostrar_todos() {
		conexion.usar_esquema(DATABASE_NAME);
		return conexion.mostrar_tabla(TABLE_NAME);
	}
	
	public List<Object[]> mostrar_proyectos_cientifico(String Dni) {
		conexion.usar_esquema(DATABASE_NAME);
		return conexion.mostrar_tabla(TABLE_NAME+" where id in ( select proyecto from asignado_a where cientifico = '"+Dni+"')");
	}
	
	public List<Object[]> mostrar_proyectos_sin_vincular(String Dni) {
		conexion.usar_esquema(DATABASE_NAME);
		return conexion.mostrar_tabla(TABLE_NAME+" where id not in ( select proyecto from asignado_a where cientifico = '"+Dni+"')");
	}
	
	public boolean guardar(String id,String Nombre,String Horas) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.agregar_registro(TABLE_NAME, ATRIBUTOS,"'"+id+"','"+Nombre+"','"+Horas+"'")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean borrar(String id) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.ejecuta_sentencia(" delete from "+TABLE_NAME+" where id ='"+id+"'")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean editar(String id, String id_nuevo,String nombre,String horas) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.ejecuta_sentencia(" update "+TABLE_NAME+" set id='"+id_nuevo+"', nombre ='"+nombre+"',horas ='"+horas+"' where id='"+id+"'")) {
			
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean aniadir_cientifico(String proyecto_id,String cientifico_dni) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.agregar_registro("asignado_a","cientifico,proyecto","'"+cientifico_dni+"','"+proyecto_id+"'")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean quitar_cientifico(String proyecto_id,String cientifico_dni) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.ejecuta_sentencia("DELETE FROM asignado_a WHERE cientifico = '"+cientifico_dni+"' AND proyecto = '"+proyecto_id+"'")) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
