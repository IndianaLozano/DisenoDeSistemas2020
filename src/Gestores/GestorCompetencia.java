package Gestores;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.CompetenciaDAO;
import DAO.DeporteDAO;
import DAO.LugarDeRealizacionDAO;
import DTO.CompetenciaDTO;
import DTO.DisponibilidadDTO;
import DTO.EliminatoriaDTO;
import DTO.LigaDTO;
import DTO.ParticipanteDTO;
import Entidades.Competencia;
import Entidades.Deporte;
import Entidades.Disponibilidad;
import Entidades.Eliminatoria;
import Entidades.Estado;
import Entidades.Liga;
import Entidades.LugarDeRealizacion;
import Entidades.MiExcepcion;
import Entidades.Modalidad;
import Entidades.Participante;
import Entidades.Puntuacion;
import Entidades.TipoDocumento;
import InterfazGrafica.PntCrearLiga;
import InterfazGrafica.VentanaAdmin;

public class GestorCompetencia {
	
	
	public static List<Competencia> obtenerUltimaCompetencia() throws Exception{
		return CompetenciaDAO.getUltimaCompetencia();
	}

	//Retorna competencia segun el idCompetencia pasado como parametro
	public static List<Competencia> obtenerCompetencia(int idCompetencia) throws Exception{
		return CompetenciaDAO.getCompetencia(idCompetencia);
	}

	//Retorna todas las instancias existentes de Deporte
	public static List<Deporte> obtenerDeportes() throws Exception{	
		return DeporteDAO.getAllDeportes();
	}
	
	//Retorna lugarDeRealizacion segun el idLugar pasado como parametro
	public static List<LugarDeRealizacion> obtenerLugarDeRealizacion(int idLugar) throws Exception{
		return LugarDeRealizacionDAO.getLugarById(idLugar);
	}
	
	//Retorna todas las instancias existentes de Modalidad
	public static List<Integer> obtenerIdModalidades() throws Exception {
		return CompetenciaDAO.getIdModalidades();
	}
	
	//Retorna todas las instancias de Participantes pertenecientes a una Competencia segun el idCompetencia pasado como parametro
	public static List<Participante> obtenerParticipantesCompetencia(int idCompetencia) throws Exception{
		return CompetenciaDAO.getParticipantesCompetencia(idCompetencia);
	}
	
	public static List<Participante> obtenerParticipante(int idPar) throws Exception{
		return CompetenciaDAO.getParticipante(idPar);
	}

	
	public static List<Participante> obtenerParticipantesCompetenciaOrdenados(int idCompetencia, int index, boolean orden) throws Exception{
		return CompetenciaDAO.getParticipantesCompetenciaOrdenados(idCompetencia, index, orden);
	}

	//Retorna deporte segun el idDeporte pasado como parametro
	public static List<Deporte> obtenerDeporte(int idDeporte) throws Exception{
		return DeporteDAO.getDeporte(idDeporte);
	}
	
	//Retorna todas las instancias de Disponibilidad pertenecientes a una Competencia segun el idCompetencia pasado como parametro
	public static List<Disponibilidad> obtenerDisponibilidadesCompetencia(int idCompetencia) throws Exception{
		return CompetenciaDAO.getDisponibilidadesCompetencia(idCompetencia);
	}
	 
	//Retorna lista de nombres de todas las Competencias existentes
	 public static List<String> obtenerNombresCompetencias() throws Exception {
		return CompetenciaDAO.getNombresCompetencias();
	}
	
	//Retorna lista de nombres de todas las Competencias existentes de un usuario segun el idUsuario pasado como parametro
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
	
	public static int obtenerIdDeporte(String deporte) {
		int idRetorno = 0;
		String nombre = deporte;
		if (nombre == "Voley") {
			idRetorno = 1;
		}
		else if (nombre == "Fútbol") {
			idRetorno = 2;
		}
		else if (nombre == "Tenis") {
			idRetorno = 3;
		}
		else if (nombre == "Básquet") {
			idRetorno = 4;
		}
		else if (nombre == "Handball") {
			idRetorno = 5;
		}
		else if (nombre == "Béisbol") {
			idRetorno = 6;
		}
		else if (nombre == "Paddle") {
			idRetorno = 7;
		}
		else if (nombre == "Ping Pong") {
			idRetorno = 8;
		}
		else if (nombre == "Ajedrez") {
			idRetorno = 9;
		}
		return idRetorno;
	}
	
	//validarNombre retorna true si el nombre ingresado no es igual al nombre de otra competencia existente
	public static boolean validarNombre (String nombre, int id_usuario) throws Exception {
		
		List<Competencia> competencia = CompetenciaDAO.getCompetenciaByNombre(nombre, id_usuario);
		
		int tamList = competencia.size();
		
		if(tamList > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
//_----------------------------------------------------------------------------------------------------------------------------------
	
	public static void crearLiga(CompetenciaDTO compDTO, LigaDTO ligaDTO) throws Exception, MiExcepcion {
		
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
		
		List<DisponibilidadDTO> disponibilidadesDTO = compDTO.getDisponibilidadesDTO();
		List<Disponibilidad> disponibilidades = new ArrayList();
		int disp;
		int idLugar;
		for(int i=0; i<disponibilidadesDTO.size() ; i++) {
			disp = disponibilidadesDTO.get(i).getDisponibilidad();
			idLugar = disponibilidadesDTO.get(i).getIdLugarDeRealizacion();
			
			Disponibilidad disponibilidad= new Disponibilidad();
			disponibilidad.disponibilidad=disp;
			disponibilidad.lugarDeRealizacion = obtenerLugarDeRealizacion(idLugar).get(0);
			disponibilidades.add(disponibilidad);
			
		} 
		
		liga.disponibilidades=disponibilidades;
		
		if(validarCamposLigaDTO(compDTO, ligaDTO)) {
			CompetenciaDAO.newCompetenciaLiga(liga);
			
		}
	}
	
	public static void crearEliminatoria (CompetenciaDTO compDTO, EliminatoriaDTO eliminatoriaDTO) throws Exception, MiExcepcion {
		
		Eliminatoria eliminatoria = new Eliminatoria();
		eliminatoria.nombre= compDTO.getNombre();
		eliminatoria.modalidad= compDTO.getModalidad();
		eliminatoria.estado=Estado.Creada;
		eliminatoria.reglamento=compDTO.getReglamento();
		eliminatoria.puntuacion= eliminatoriaDTO.getPuntuacion();
		eliminatoria.dadaDeBaja= false;
		eliminatoria.cantidadSets= eliminatoriaDTO.getCantidadSets();
		eliminatoria.tantosGanadosAusenciaRival= eliminatoriaDTO.getTantosGanadosAusRival();
		eliminatoria.deporte= obtenerDeporte(compDTO.getIdDeporte()).get(0);
		
		eliminatoria.esDoble=eliminatoriaDTO.isEsDoble();
				
		int idModalidad= GestorCompetencia.obtenerIdModalidad(eliminatoria.modalidad);
		int idEstado= GestorCompetencia.obtenerIdEstado(eliminatoria.estado);
		int idPuntuacion= GestorCompetencia.obtenerIdPuntuacion(eliminatoria.puntuacion);
		
		List<DisponibilidadDTO> disponibilidadesDTO= compDTO.getDisponibilidadesDTO();
		List<Disponibilidad> disponibilidades= new ArrayList();
		int disp;
		int idLug;
		
		for(int i=0; i<disponibilidadesDTO.size() ; i++) {
			disp= disponibilidadesDTO.get(i).getDisponibilidad();
			idLug = disponibilidadesDTO.get(i).getIdLugarDeRealizacion();
			Disponibilidad disponibilidad= new Disponibilidad();
			disponibilidad.disponibilidad=disp;
			disponibilidad.lugarDeRealizacion= obtenerLugarDeRealizacion(idLug).get(0);
			
			disponibilidades.add(disponibilidad);
		}
		
		eliminatoria.disponibilidades=disponibilidades;
		
		if(validarCamposEliminatoriaDTO(compDTO)) {
			CompetenciaDAO.newCompetenciaEliminatoria(eliminatoria);
		}	
	}
	
	private static boolean validarCamposLigaDTO(CompetenciaDTO competDTO, LigaDTO ligaDTO) throws MiExcepcion{
		boolean retorno = false;
					
		if (competDTO.getNombre().length()== 0) {
			
			MiExcepcion e1= new MiExcepcion("1");
			throw e1;
			
			//Si la validacion es verdadera muestra el mensaje de error y vuelve a la pantalla crearCompetencia
		} else {
			if (competDTO.disponibilidadesDTO.isEmpty()) {
				MiExcepcion e2= new MiExcepcion("2");
				throw e2;
				
				
			} else {
				
				Integer ptos_pg= new Integer (ligaDTO.getPtos_pg());
				Integer ptos_pp = new Integer (ligaDTO.getPtos_pp());
				Integer ptos_pe = new Integer (ligaDTO.getPtos_pe());
				
				if (ptos_pg == 0){
					MiExcepcion e3= new MiExcepcion("3");
					throw e3;
					
					
				} else {
					if (ptos_pp == 0){
						MiExcepcion e4= new MiExcepcion("4");
						throw e4;					
					} else {
						if ((ligaDTO.isEmpatePermitido() == true) && (ptos_pe == 0)) {
							MiExcepcion e5= new MiExcepcion("5");
							throw e5;
							
							
						} else {
							retorno= true;
						} 
					}
				}
				
			}
		}		
		return retorno;
	}
	

	private static boolean validarCamposEliminatoriaDTO(CompetenciaDTO competDTO) throws MiExcepcion {
		boolean retorno = false;
		
		if (competDTO.getNombre().length()== 0) {
			MiExcepcion e1= new MiExcepcion("1");
			throw e1;
			//Si la validacion es verdadera muestra el mensaje de error y vuelve a la pantalla crearCompetencia
		} else {
			if (competDTO.getDisponibilidadesDTO().isEmpty()) {
				MiExcepcion e2= new MiExcepcion("2");
				throw e2;
			} else {
				retorno = true;
			}
		}
		return retorno;
	}
	
	// Si la competencia esta en estado Finalizada o EnDisputa, retorna true
	public static boolean validarEstadoCompetencia(Competencia c) throws Exception {
		if (c.estado.name()=="Finalizada" || c.estado.name()=="EnDisputa") {
			return false;
		}else {return true;}
		
	}
	
	public static void altaParticipante (ParticipanteDTO pDto, Competencia c) throws MiExcepcion, Exception {
		Participante p= new Participante();
		p.nombre= pDto.getNombre();
		p.correo= pDto.getCorreo();
		
		c.participantes.add(p);
		
		if (c.estado.name()=="Planificada") {
			
			c.estado=Estado.Creada;
		}
		
		CompetenciaDAO.newParticipanteCompetencia(c);
	}
	
	public static boolean validarDatosParticipante(ParticipanteDTO pDTO, Competencia c) throws MiExcepcion {
		
		boolean result= true;
		
		Collator comparador = Collator.getInstance(); //compara mayusculas y minúsculas
		comparador.setStrength(Collator.TERTIARY);
		
		
		List<Participante> participantes = c.participantes;
		int i=0;
		while(i<participantes.size() && result == true) {
		if(comparador.equals(pDTO.getNombre(), participantes.get(i).nombre )) {
			result=false;
			MiExcepcion e= new MiExcepcion("7");
			throw e;
			
			}else {
				if(comparador.equals(pDTO.getCorreo(), participantes.get(i).correo)) {
					result=false;
					MiExcepcion e2= new MiExcepcion("8");
					throw e2;
				}
			}
		i++;
		}
		return result;
	}

	public static List<Competencia> obtenerMisCompetencias(int idUsuario, String nombreComp, String deporte, String modalidad, String estado) throws Exception {
		List<Competencia> competencias = CompetenciaDAO.getCompetenciasUsuario(idUsuario, nombreComp, deporte, modalidad, estado);
		return competencias;
	}
	
	
	 public static List<Competencia> obtenerMisCompetenciasSegunFiltro(int idUsuario, String nombreComp, String deporte, String modalidad, String estado) throws Exception {
		
		if((deporte == "Todos") && (modalidad != "Todos") && (estado != "Todos")) {
			//metodo del DAO que retorne las competencias de todos los deportes
		}
		if((deporte != "Todos") && (modalidad == "Todos") && (estado != "Todos")) {
			//metodo del DAO que retorne las competencias de todos las modalidades
		}
		if((deporte != "Todos") && (modalidad != "Todos") && (estado == "Todos")) {
			//metodo del DAO que retorne las competencias en cualquier estado
		}
		if((deporte == "Todos") && (modalidad == "Todos") && (estado == "Todos")) {
			//metodo del DAO que retorne todas las competencias sin ningun filtro
			
		}
		
		List<Competencia> competencias = CompetenciaDAO.getCompetenciasUsuarioSegunFiltro(idUsuario, nombreComp, deporte, modalidad, estado);
		return competencias;
	}
	
	

	
	
}



