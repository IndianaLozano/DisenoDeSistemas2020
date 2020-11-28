package Gestores;

import java.util.List;

import DAO.DeporteDAO;
import DAO.LugarDeRealizacionDAO;
import Entidades.Deporte;
import Entidades.LugarDeRealizacion;

public class GestorLugaresDeRealizacion {

	//Metodos para consulta
	
	//Retorna lista de Deportes asociados a un idLugar
	public static List<Deporte> obtenerDeportesLugar (int idLugar) throws Exception{
		return DeporteDAO.getDeportesLugar(idLugar);
	} 
	
	////Retorna lista de LugardeRealizacion asociados a un idDeporte
	public static List<LugarDeRealizacion> obtenerLugaresDeporte(int idDeporte) throws Exception{
		return LugarDeRealizacionDAO.getLugaresDeporte(idDeporte);
	}
	
	public static List<LugarDeRealizacion> obtenerLugarDeRealizacion(int idLugar) throws Exception{
		return LugarDeRealizacionDAO.getLugarById(idLugar);
	}
	
}
