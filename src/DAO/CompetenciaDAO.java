package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Modalidad;

public class CompetenciaDAO {

	
	//Metodos de consulta
	
	public static List<Modalidad> getAllModalidades() throws Exception{
		try {
			String query = "SELECT * FROM database.modalidad";
			ArrayList<Modalidad> modalidades = (ArrayList<Modalidad>)((Object)Conexion.consultar(query, Modalidad.class));
			return modalidades;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	//Metodo para ejecuciones
	
	public static void altaActividad (String nombre, long idProfesor) throws Exception{
		String query="" ;
		try {
			Conexion.ejecutar(query);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
