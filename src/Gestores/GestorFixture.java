package Gestores;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import DAO.CompetenciaDAO;
import DAO.EncuentroDAO;
import DAO.FaseDAO;
import DAO.FixtureDAO;
import DTO.EncuentrosProxDTO;
import DTO.ParticipanteDTO;
import DTO.ProxEncuentroDTO;
import Entidades.Competencia;
import Entidades.Disponibilidad;
import Entidades.Encuentro;
import Entidades.EncuentroRondaGanador;
import Entidades.Estado;
import Entidades.Fase;
import Entidades.Fixture;
import Entidades.LugarDeRealizacion;
import Entidades.MiExcepcion;
import Entidades.Participante;
import InterfazGrafica.VentanaAdmin;

public class GestorFixture {
	
	public static void generarFixture (Competencia c) throws Exception {
	
		Estado e = c.estado;
		
		if (e.name()== "Finalizada") {
			
			MiExcepcion ex= new MiExcepcion("10");
			throw ex;
			
		}
		else {
			if(e.name() == "EnDisputa") {
				
				MiExcepcion ex1 = new MiExcepcion("11");
				
			}
			else {
				if (e.name()=="Creada") {
					crearFixtureLiga(c);
				}
				else {
					FixtureDAO.deleteFixture(c.idCompetencia); //elimina el fixture existente
					crearFixtureLiga(c);
				}
			}
		}
	}
	
	public static void crearFixtureLiga(Competencia c) throws MiExcepcion, Exception {
		Fixture fixture = new Fixture();
		fixture.fases= new ArrayList();
		
		int cantidadParticipantes = c.getParticipantes().size();
		int cantidadFases;
		int encuentrosPorFase;
		boolean esPar = false;
		
		if(cantidadParticipantes % 2 == 0) {
			//Cantidad Par
			cantidadFases= cantidadParticipantes -1;
			encuentrosPorFase = cantidadParticipantes /2;
			esPar=true;
		}
		else{
			ParticipanteDTO participanteNulo = new ParticipanteDTO();
			GestorCompetencia.altaParticipanteNulo(participanteNulo, c);
			cantidadParticipantes++;
			cantidadFases= cantidadParticipantes -1;
			encuentrosPorFase = cantidadParticipantes /2;
		}
		
		ArrayList<LugarDeRealizacion> lugaresPorFase = new ArrayList();
		List<Disponibilidad> disponibilidades = c.getDisponibilidades();   // {(lugar, disp), (lugar, disp), ...}
		for (int a = 0; a < disponibilidades.size(); a++) {
			for (int b = 0; b < disponibilidades.get(a).disponibilidad; b++) {
				lugaresPorFase.add(disponibilidades.get(a).lugarDeRealizacion);
			}
		}
				
		if (lugaresPorFase.size() >= encuentrosPorFase) {
				//inicio
			if (esPar==true) {
				 for (int i=0; i<cantidadFases; i++) {
					Fase f = new Fase();
					f.encuentros= new ArrayList();
					List<Participante> participantes = c.getParticipantes();
					
					for (int j=0; j<encuentrosPorFase; j++) {
						int i2 = cantidadParticipantes-j-1;
						EncuentroRondaGanador enc = new EncuentroRondaGanador();
						enc.visitante = c.getParticipantes().get(j);
						enc.local= c.getParticipantes().get(i2);
						enc.lugar = lugaresPorFase.get(j);
						f.encuentros.add(enc);
					}
					participantes.add(participantes.remove(1));
					fixture.fases.add(f);
				 }
				invertirlocalVisitante(fixture);
			}
			fixture.competencia= c;
			FixtureDAO.createFixture(fixture);		
	 }
	 else {
		 MiExcepcion e12 = new MiExcepcion ("12");
		 throw e12;
	 }
}
		
		
	public static List<Fase> getFasesFixture(int idFix) throws Exception{
		return FaseDAO.getFasesFixture(idFix);
	}

	public static List<Fase> obtenerFasePorID(int idFase) throws Exception{
		return FaseDAO.getFaseByID(idFase);
	}
	
	public static List<Encuentro> getEncuentrosFase(long idFase) throws Exception{
		return EncuentroDAO.getEncuentrosFase(idFase);
	}
	
	public static List<Encuentro> getEncuentroByID(int idEncuentro) throws Exception{
		return EncuentroDAO.getEncuentroByID(idEncuentro);
	}
	

	public static void invertirlocalVisitante(Fixture f) {
		
		for (int i=0; i<f.fases.size() ;i++) {
			
			Participante local=f.fases.get(i).encuentros.get(0).local; 
			Participante visitante =f.fases.get(i).encuentros.get(0).visitante;
			
			f.fases.get(i).encuentros.get(0).local=visitante;
			f.fases.get(i).encuentros.get(0).visitante=local;
			
		}
	}
	
	
	public static EncuentrosProxDTO obtenerEncuentrosProximos(int idCompetencia) throws Exception{
	
		EncuentrosProxDTO epDTO = new EncuentrosProxDTO();
	
	Fixture fix = FixtureDAO.getFixtureCompetencia(idCompetencia).get(0);
	List<ProxEncuentroDTO> proxeDTO= new ArrayList();
	
	int cantidadFases= fix.fases.size();  
	
	for (int i=0; i<cantidadFases; i++) {
		
		Fase f= fix.fases.get(i);
		
		for (int j=0; j<f.getEncuentros().size(); j++) {
			
			Encuentro e= f.getEncuentros().get(j);
			
			if(e.actual == null ) {
				ProxEncuentroDTO  proxEncDTO = new ProxEncuentroDTO();
				proxEncDTO.setFecha(e.fecha);
				proxEncDTO.setHora(e.hora);
				proxEncDTO.setpLocal(e.local.nombre);
				proxEncDTO.setpVisitante(e.visitante.nombre);
				proxEncDTO.setIdEncuentro(e.idEncuentro);
				
				proxeDTO.add(proxEncDTO);
			}
			
		}
	}
		
		
		epDTO.setEncuentrosProxDTO(proxeDTO);
		
		return epDTO;
	}
	
	
	
	
	
}
