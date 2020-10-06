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
	
	public static List<Deporte> getDeportesLugar(int idLugar) throws Exception{
		try {
			String query = "SELECT dep.id_deporte, dep.nombre FROM database.deporte_lugar deplug JOIN database.deporte dep ON (deplug.id_deporte = dep.id_deporte) WHERE id_lugar = " + idLugar +" ;" ;
			ArrayList<Deporte> deportes = (ArrayList<Deporte>)((Object)Conexion.consultar(query, Deporte.class));
			return deportes;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	
	//método para ejecuciones
	
	public static void altaActividad (String nombre, long idProfesor) throws Exception{
		String query="" ;
		try {
			Conexion.ejecutar(query);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
