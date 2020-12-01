package Gestores;

import java.util.List;

import DAO.EncuentroDAO;
import DAO.FaseDAO;
import DAO.FixtureDAO;
import Entidades.Competencia;
import Entidades.Disponibilidad;
import Entidades.Encuentro;
import Entidades.EncuentroRondaGanador;
import Entidades.Estado;
import Entidades.Fase;
import Entidades.Fixture;
import Entidades.MiExcepcion;
import Entidades.Participante;
import InterfazGrafica.VentanaAdmin;

public class GestorFixture {
	
	
	
	
	
	public static void generarFixture (Competencia c) throws MiExcepcion {
	
		Estado e = c.estado;
		
		
		if (e.name()== "Finalizada") {
			
			MiExcepcion ex= new MiExcepcion("10");
			throw ex;
			
		} else {
			if(e.name() == "EnDisputa") {
				
				MiExcepcion ex1 = new MiExcepcion("11");
				
			}else {
				if (e.name()=="Creada") {
					crearFixtureLiga(c);
					//TODO cambiar estado de la competencia a planificada
				}else {
					FixtureDAO.deleteFixture(c.idCompetencia); //elimina el fixture existente
					crearFixtureLiga(c);
					
				}
				
				
				
			}
		}
	}
	
	public static void crearFixtureLiga(Competencia c) throws MiExcepcion {
		Fixture fixture = new Fixture();
		
		int cantidadParticipantes = c.participantes.size();
		int cantidadFases;
		int encuentrosPorFase;
		boolean esPar = false;
		
		if(cantidadParticipantes % 2 == 0) {
			//Cantidad Par
			cantidadFases= cantidadParticipantes -1;
			encuentrosPorFase = cantidadParticipantes /2;
			esPar=true;
			
			
			
		}else {
			//Cantidad Impar
			cantidadFases= cantidadParticipantes;
			encuentrosPorFase= (cantidadParticipantes + 1)/2;
		}
		
		List<Disponibilidad> disponibilidades = c.disponibilidades;
		if (disponibilidades.size() >= encuentrosPorFase) {
				//inicio
			int contador1=0;
			int contador2 = cantidadParticipantes-1;
			
			if (esPar==true) {
				
				for (int i=0; i<cantidadFases ; i++) {
					Fase f = new Fase();
				
					for (int j=0 ; j<encuentrosPorFase; j++) {
						EncuentroRondaGanador enc = new EncuentroRondaGanador();
					
						if (contador1 == cantidadParticipantes -1) {
							contador1 =0;
						}
					
						if (contador2 ==0) {
							contador2 = cantidadParticipantes -1;
						}
					
						if (j==0) {
								enc.visitante = c.participantes.get(cantidadParticipantes -1);
								enc.local = c.participantes.get(contador1);
								contador1 ++;
								contador2 --;
								enc.lugar = disponibilidades.get(j).lugarDeRealizacion;
					
						}
						else{
								enc.visitante = c.participantes.get(contador2);
								enc.local= c.participantes.get(contador1);
						
								contador1++;
								contador2--;
								enc.lugar = disponibilidades.get(j).lugarDeRealizacion;
						}
					
						f.encuentros.add(enc);
					
					}
				
					fixture.fases.add(f);
					invertirlocalVisitante(fixture);
				}
			}
			else {
				for (int i=0; i<cantidadFases ; i++) {
					Fase f = new Fase();
				
					for (int j=0 ; j<encuentrosPorFase; j++) {
						EncuentroRondaGanador enc = new EncuentroRondaGanador();
					
						if (contador1 == cantidadParticipantes -1) {
							contador1 =0;
						}
					
						if (contador2 ==0) {
							contador2 = cantidadParticipantes -1;
						}
					
						if (j==0) {
							enc.local = c.participantes.get(contador1);
							contador1 ++;
							contador2 --;
					
						}
						else {
						
							enc.visitante = c.participantes.get(contador2);
							enc.local= c.participantes.get(contador1);
						
							contador1++;
							contador2--;
						}
					
						f.encuentros.add(enc);
					
					}
				
					fixture.fases.add(f);
				
				}
			
			}
			fixture.competencia= c;
			try {
				FixtureDAO.createFixture(fixture);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
			//fin
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


}
