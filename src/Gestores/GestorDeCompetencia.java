package Gestores;

import java.util.List;

import DAO.DeporteDAO;
import Entidades.Deporte;

public class GestorDeCompetencia {
	
	public static List<Deporte> obtenerDeportes () throws Exception{
		
		
		return DeporteDAO.getAllDeportes();
		
		
	}

}
