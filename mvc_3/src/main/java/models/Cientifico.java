package models;

import java.util.List;

import mysql.Conection;

public class Cientifico {
	static Conection conexion = new Conection();
	private String ATRIBUTOS = "Dni,NomApels";
	private static String DATABASE_NAME = "cientificos";
	private static String TABLE_NAME = "cientificos";
	
	public List<Object[]> mostrar_todos() {
		conexion.usar_esquema(DATABASE_NAME);
		return conexion.mostrar_tabla(TABLE_NAME);
	}
	
	public boolean guardar(String Dni,String NomApels) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.agregar_registro(TABLE_NAME, ATRIBUTOS, "'"+Dni+"','"+NomApels+"'")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean borrar(String Dni) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.ejecuta_sentencia("delete from "+TABLE_NAME+" where Dni ="+Dni)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean editar(String Dni, String Dni_nuevo,String NomApels) {
		conexion.usar_esquema(DATABASE_NAME);
		if (conexion.ejecuta_sentencia("update "+TABLE_NAME+" set Dni ='"+Dni_nuevo+"',NomApels ='"+NomApels+"' where Dni="+Dni)) {
			return true;
		}else {
			return false;
		}
	}
	


}
