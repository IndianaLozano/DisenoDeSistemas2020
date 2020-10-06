package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Deporte;
import Entidades.LugarDeRealizacion;

public class LugarDeRealizacionDAO {

	
	//M�todos de consulta
	
	public static List<LugarDeRealizacion> getLugaresDeporte(int idDeporte ) throws Exception{
		System.out.println(idDeporte);
		try {
			String query = "SELECT DISTINCT * FROM database.lugar_de_realizacion lr JOIN database.deporte_lugar dl ON (dl.id_lugar = lr.id_lugar) WHERE id_deporte= " + idDeporte + " ;";
		
			ArrayList<LugarDeRealizacion> lugares = (ArrayList<LugarDeRealizacion>)((Object)Conexion.consultar(query, LugarDeRealizacion.class));
			return lugares;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}

}
