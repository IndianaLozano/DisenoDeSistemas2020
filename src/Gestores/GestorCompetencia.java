package Gestores;

import java.util.ArrayList;
import java.util.List;

import DAO.CompetenciaDAO;
import DAO.DeporteDAO;
import Entidades.Competencia;
import Entidades.Deporte;
import Entidades.Disponibilidad;
import Entidades.Estado;
import Entidades.Modalidad;
import Entidades.Participante;
import Entidades.Puntuacion;
import Entidades.TipoDocumento;

public class GestorCompetencia {
	
	public static List<Deporte> obtenerDeportes() throws Exception{	
		return DeporteDAO.getAllDeportes();
	}
	
	public static List<Integer> obtenerIdModalidades() throws Exception {
		return CompetenciaDAO.getIdModalidades();
	}
	
	public static List<Participante> obtenerParticipantesCompetencia(int idCompetencia) throws Exception{
		return CompetenciaDAO.getParticipantesCompetencia(idCompetencia);
	}
	
	public static List<Deporte> obtenerDeporte(int idDeporte) throws Exception{
		return DeporteDAO.getDeporte(idDeporte);
	}
	
	public static List<Disponibilidad> obtenerDisponibilidadesCompetencia(int idCompetencia) throws Exception{
		return CompetenciaDAO.getDisponibilidadesCompetencia(idCompetencia);
	}
	 
	 public static List<String> obtenerNombresCompetencias() throws Exception {
		return CompetenciaDAO.getNombresCompetencias();
	}

	
	public static List<Competencia> obtenerCompetenciasUsuario(int idUsuario) throws Exception{
		return CompetenciaDAO.getCompetenciasUsuario(idUsuario);
	}
	
   public static TipoDocumento obtenerTipoDocEnum (int idTipo) {
	   
		TipoDocumento tipo= null;
		
		switch(idTipo) {
		case 1: tipo = TipoDocumento.DNI;
		break;
		case 2: tipo = TipoDocumento.CUIT;
		break;
		case 3: tipo = TipoDocumento.CUIL;
		break;
		case 4: tipo = TipoDocumento.libretaCivica;
		break;
		case 5: tipo = TipoDocumento.Pasaporte;
		}
		return tipo;
	}
	
   
	public static Puntuacion obtenerPuntuacionEnum (int idPuntuacion) {
		
		Puntuacion pun= null;
		
		switch(idPuntuacion) {
		case 1: pun = Puntuacion.Puntuacion;
		break;
		case 2: pun = Puntuacion.ResultadoFinal;
		break;
		case 3: pun = Puntuacion.Sets;
		break;		
		}
		return pun;
	}
	
	
	public static Modalidad obtenerModalidadEnum(int idModalidad) {
		
		Modalidad mod = null;
		
		switch(idModalidad) {
		case 1: mod = Modalidad.SistemaDeLiga;
		break;
		case 2: mod = Modalidad.SistemaDeEliminatoriaSimple;
		break;
		case 3: mod = Modalidad.SistemaDeEliminatoriaDoble;
		break;		
		}
		
		return mod;
	}
	
	
	public static Estado obtenerEstadoEnum (int idEstado) {
		
		Estado estado = null;
		
		switch (idEstado) {
		case 1: estado = Estado.Creada;
		break;
		case 2: estado = Estado.Planificada;
		break;
		case 3: estado = Estado.EnDisputa;
		break;
		case 4: estado = Estado.Finalizada;
		break;
		}
		
		return estado; 
	}
	
	
	//validarNombre retorna true si el nombre ingresado no es igual al nombre de otra competencia existente
	public static boolean validarNombre (String nombre) throws Exception {
		
		List<String> nombres = CompetenciaDAO.getNombresCompetencias();
		
		int tamList = nombres.size();
		int nombreRepetido = 0;
		int i = 0;
		
		// while se ejecuta siempre que no encuentre que el nombre ingresado sea igual al nombre de otra competencia existente
		while (nombreRepetido == 0 && i<tamList) {
			if (nombres.get(i) == nombre) {
				nombreRepetido++;
			}
			else {
				i++;
			}
		}
		
		if (nombreRepetido > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	

}

