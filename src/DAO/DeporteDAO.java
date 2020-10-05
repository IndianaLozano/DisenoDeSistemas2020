package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Deporte;

public class DeporteDAO {
	
	//metodo para consultas
	
	public static List<Deporte> getAllDeportes() throws Exception{
		try {
			String query = "SELECT * FROM database.deporte";
			ArrayList<Deporte> deportes = (ArrayList<Deporte>)((Object)Conexion.consultar(query, Deporte.class));
			return deportes;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	//m�todo para ejecuciones
	
	public static void altaActividad (String nombre, long idProfesor) throws Exception{
		String query="" ;
		try {
			Conexion.ejecutar(query);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
