package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

import Entidades.Estado;
import Entidades.Modalidad;
import Entidades.Puntuacion;
import javafx.scene.control.RadioButton;

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
	
	public static List<Modalidad> getModalidad(int idModalidad) throws Exception{
		try {
			String query = "SELECT modal.id_deporte, modal.modalidad FROM database.competencia comp JOIN database.modalidad modal ON (comp.id_modalidad= modal.id_modalidad) WHERE id_modalidad = " + idModalidad + " ;";
			ArrayList<Modalidad> modalidad = (ArrayList<Modalidad>)((Object)Conexion.consultar(query, Modalidad.class));
			return modalidad;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	
	 
	
	
	public static List<Puntuacion> getPuntuacion(int idPuntuacion) throws Exception{
		try {
			String query = "SELECT punt.id_puntuacion, punt.puntuacion FROM database.competencia comp JOIN database.puntuacion punt ON (comp.id_puntuacion = punt.id_puntuacion ) WHERE id_puntuacion = " + idPuntuacion + " ";                            
			ArrayList<Puntuacion> puntuacion = (ArrayList<Puntuacion>)((Object)Conexion.consultar(query, Puntuacion.class));
			return puntuacion;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	
	public static List<Estado> getEstado(int idEstado) throws Exception{
		try {
			String query = "SELECT * FROM database.estado WHERE id_estado= " + idEstado + " ;";
			ArrayList<Estado> estado = (ArrayList<Estado>)((Object)Conexion.consultar(query, Estado.class));
			return estado;
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
