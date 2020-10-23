package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.ConsultaGenerica;
import Entidades.Deporte;

public class DeporteDAO {
	
	//Metodo de consulta
	
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
	
	public static List<Deporte> getDeporte(int idDeporte) throws Exception{
		//Obtiene UN deporte
		try {
			String query = "SELECT * FROM database.deporte WHERE id_deporte = " + idDeporte + " ;";
			ArrayList<Deporte> deportes = (ArrayList<Deporte>)((Object)Conexion.consultar(query, Deporte.class));
			return deportes;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	
	
	
public static int getIdDeporte(String deporte) throws Exception {
		
		try {
			List<ConsultaGenerica> ls1 = (List<ConsultaGenerica>)(Object)Conexion.consultar("SELECT id_deporte FROM database.deporte WHERE nombre = '"+ deporte +"' ;", ConsultaGenerica.class);
			return Integer.parseInt(ls1.get(0).getValor("id_deporte"));
		} catch (Exception ex) {
			
			throw ex;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
