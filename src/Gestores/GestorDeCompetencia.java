package Gestores;

import java.util.List;

import DAO.CompetenciaDAO;
import DAO.DeporteDAO;
import Entidades.Deporte;
import Entidades.Modalidad;

public class GestorDeCompetencia {
	
	public static List<Deporte> obtenerDeportes () throws Exception{	
		return DeporteDAO.getAllDeportes();
		
	}
	
	public static List<Modalidad> obtenerModalidades() throws Exception {
		return CompetenciaDAO.getAllModalidades();
	}

}
