package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Deporte;
import Entidades.LugarDeRealizacion;

public class LugarDeRealizacionDAO {

	
	//Metodos de consulta
	
	public static List<LugarDeRealizacion> getLugaresDeporte(int idDeporte ) throws Exception{
		try {
			String query = "SELECT DISTINCT * FROM database.lugar_de_realizacion lr JOIN database.deporte_lugar dl ON (dl.id_lugar = lr.id_lugar) WHERE id_deporte= " + idDeporte + " ;";
		
			ArrayList<LugarDeRealizacion> lugares = (ArrayList<LugarDeRealizacion>)((Object)Conexion.consultar(query, LugarDeRealizacion.class));
			return lugares;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	public static List<LugarDeRealizacion> getLugarById(int idLugar ) throws Exception{
		try {
			String query = "SELECT * FROM database.lugar_de_realizacion WHERE id_lugar = " + idLugar +" ;" ;
		
			ArrayList<LugarDeRealizacion> lugar = (ArrayList<LugarDeRealizacion>)((Object)Conexion.consultar(query, LugarDeRealizacion.class));
			return lugar;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	

}
