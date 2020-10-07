package Gestores;

import java.util.List;

import DAO.DeporteDAO;
import DAO.LugarDeRealizacionDAO;
import Entidades.Deporte;
import Entidades.LugarDeRealizacion;

public class GestorLugaresDeRealizacion {

	//Metodos para consulta
	
	
	public static List<Deporte> obtenerDeportesLugar (int idLugar) throws Exception{
		return DeporteDAO.getDeportesLugar(idLugar);
	} 
	
	public static List<LugarDeRealizacion> obtenerLugaresDeporte(int idDeporte) throws Exception{
		return LugarDeRealizacionDAO.getLugaresDeporte(idDeporte);
	}
	
	
}
