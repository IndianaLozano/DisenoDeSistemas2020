package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Localidad;
import Entidades.LugarDeRealizacion;

public class LocalidadDAO {
	
	
	public static List<Localidad> getLocalidad(int idLocalidad ) throws Exception{
		try {
			String query = "SELECT * FROM database.Localidad WHERE localidad.id_localidad= " + idLocalidad + " ;";
		
			ArrayList<Localidad> lugares = (ArrayList<Localidad>)((Object)Conexion.consultar(query, Localidad.class));
			return lugares;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}

}
