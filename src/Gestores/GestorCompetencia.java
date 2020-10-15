package Gestores;

import java.util.ArrayList;
import java.util.List;

import DAO.CompetenciaDAO;
import DAO.DeporteDAO;
import DTO.CompetenciaDTO;
import DTO.DisponibilidadDTO;
import DTO.EliminatoriaDTO;
import DTO.LigaDTO;
import Entidades.Competencia;
import Entidades.Deporte;
import Entidades.Disponibilidad;
import Entidades.Estado;
import Entidades.Liga;
import Entidades.Modalidad;
import Entidades.Participante;
import Entidades.Puntuacion;
import Entidades.TipoDocumento;
import InterfazGrafica.VentanaAdmin;

public class GestorCompetencia {
	
	public static List<Competencia> obtenerCompetencia(int idCompetencia) throws Exception{
		return CompetenciaDAO.getCompetencia(idCompetencia);
	}

	
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
	
	
	public static int obtenerIdEstado(Estado estado) {
		
		int idRetorno = 0;
		
		if (estado.name() == "Creada") {
			idRetorno=1;
		}
		if(estado.name() == "Planificada") {
			idRetorno= 2;
		}
		
		if(estado.name() == "EnDisputa") {
			idRetorno= 3;
		}
		
		if(estado.name() == "Finalizada") {
			idRetorno= 4;
		}
		return idRetorno;
		
	}
	
	public static int obtenerIdModalidad (Modalidad modalidad) {
		int idEstado=0;
		
		if( modalidad.name() == "SistemaDeLiga"){
			idEstado = 1;
		}
		if( modalidad.name() == "SistemaDeEliminatoriaSimple"){
			idEstado = 2;
		}if( modalidad.name() == "SistemaDeEliminatoriaDoble"){
			idEstado = 3;
		}
		
		return idEstado; 
	}
	
	
	public static int obtenerIdPuntuacion (Puntuacion puntuacion){
		int idRetorno=0;
		String nombre= puntuacion.name();
		if (puntuacion.name() == "Puntuacion" ){
			idRetorno = 1;
		}
	        if (puntuacion.name() == "ResultadoFinal"){
			idRetorno = 2;
		}
		if (puntuacion.name() == "Sets"){
			idRetorno = 3;
		}
		return idRetorno;
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
	
	
//_----------------------------------------------------------------------------------------------------------------------------------
	
	public static void crearLiga(CompetenciaDTO compDTO, LigaDTO ligaDTO) throws Exception {
		
		Liga liga= new Liga();
		
		liga.nombre= compDTO.getNombre();
		liga.modalidad= compDTO.getModalidad();
		liga.estado=Estado.Creada;
		liga.reglamento=compDTO.getReglamento();
		liga.puntuacion= ligaDTO.getPuntuacion();
		liga.dadaDeBaja= false;
		liga.cantidadSets= ligaDTO.getCantidadSets();
		liga.tantosGanadosAusenciaRival= ligaDTO.getTantosGanadosAusRival();
		liga.deporte= obtenerDeporte(compDTO.getIdDeporte()).get(0);
		

		liga.puntosPE=ligaDTO.getPtos_pe();
		liga.puntosPG=ligaDTO.getPtos_pg();
		liga.puntosPorPresentarse =ligaDTO.getPtos_pp();
		liga.empatePermitido = ligaDTO.isEmpatePermitido();
				
		
		int idModalidad= GestorCompetencia.obtenerIdModalidad(liga.modalidad);
		int idEstado= GestorCompetencia.obtenerIdEstado(liga.estado);
		int idPuntuacion= GestorCompetencia.obtenerIdPuntuacion(liga.puntuacion);
		
		//id_usuario = 1 hasta q ingresemos usuarios
		CompetenciaDAO.newCompetencia(liga.nombre, 2, idModalidad, idEstado, idPuntuacion, liga.deporte.idDeporte, 0, liga.reglamento, liga.cantidadSets, liga.tantosGanadosAusenciaRival );
		int idCompetencia= CompetenciaDAO.getUltimaCompetencia().get(0).idCompetencia;
		liga.idCompetencia=idCompetencia;
		
		
		List<DisponibilidadDTO> disponibilidadesDTO= compDTO.getDisponibilidadesDTO();
		List<Disponibilidad> disponibilidades= new ArrayList();
		int disp;
		int idLugar;
		for(int i=0; i<disponibilidadesDTO.size() ; i++) {
			disp= disponibilidadesDTO.get(i).getDisponibilidad();
			idLugar=disponibilidadesDTO.get(i).getIdLugarDeRealizacion();
			
			Disponibilidad disponibilidad= new Disponibilidad();
			disponibilidad.disponibilidad=disp;
			disponibilidad.id_competencia= idCompetencia;
			disponibilidad.id_lugar= idLugar;
			
			CompetenciaDAO.newCompetencia_lugar(idCompetencia, idLugar, disp);
			disponibilidades.add(disponibilidad);
			
		}
		
		liga.disponibilidades=disponibilidades;
		CompetenciaDAO.newLiga(liga);
		VentanaAdmin.mensajeExito("Competencia creada correctamente", "EXITO");
		
		
	}
	
	
	

	
	
	
		
		
		

	

}

