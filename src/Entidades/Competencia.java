package Entidades;

import java.util.List;

import DAO.CompetenciaDAO;
import Gestores.GestorCompetencia;
import Gestores.GestorUsuario;

public class Competencia {

	public int idCompetencia;
	public  String nombre;
	public  Modalidad modalidad; //*
	public  Estado estado;//*
	public  String reglamento;
	public  Puntuacion puntuacion;//* 
	public  boolean dadaDeBaja;
	public  int cantidadSets;
	public  int tantosGanadosAusenciaRival;
	
	public  List<Participante> participantes;//*
	public  Deporte deporte;//*
	public  List<Disponibilidad> disponibilidades; //*
	
	
	//Constructor sin parametros
	public Competencia() {}
	
	//Constructor con parametros
	public Competencia(int id, String nombre, Modalidad modalidad, Estado estado, String reglamento, Puntuacion puntuacion, boolean baja, int cantidadSets, int tantosGanadosAusenciaRival, List<Participante> participantes, Deporte deporte, List<Disponibilidad> disponibilidades) {
		this.idCompetencia = id;
		this.nombre = nombre;
		this.modalidad = modalidad;
		this.estado = estado;
		this.reglamento = reglamento;
		this.puntuacion = puntuacion;
		this.dadaDeBaja = baja;
		this.cantidadSets = cantidadSets;
		this.tantosGanadosAusenciaRival = tantosGanadosAusenciaRival;
		this.deporte=deporte;
		this.participantes=participantes;
		this.disponibilidades= disponibilidades;
	}
	
	
	public Competencia(String datos) {
		
		String[] atributo = datos.split("\t");
		this.idCompetencia = Integer.parseInt(atributo[0]);
		this.nombre = atributo[6];
		this.cantidadSets = Integer.parseInt(atributo[9]);
		this.reglamento = atributo[8];
		this.tantosGanadosAusenciaRival = Integer.parseInt(atributo[10]);
		
		if (Integer.parseInt(atributo[7]) == 0) {
			dadaDeBaja= false;
		}else {
			dadaDeBaja=true;
		}
	
		try {
			this.estado = GestorCompetencia.obtenerEstadoEnum(Integer.parseInt(atributo[3]));
			this.modalidad = GestorCompetencia.obtenerModalidadEnum(Integer.parseInt(atributo[2]));			
			this.deporte = GestorCompetencia.obtenerDeporte(Integer.parseInt(atributo[5])).get(0);
		
			this.puntuacion = GestorCompetencia.obtenerPuntuacionEnum(Integer.parseInt(atributo[4]));
			} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public List<Participante> getParticipantes() {
		if(this.participantes == null) {
			try {
				this.participantes = CompetenciaDAO.getParticipantesCompetencia(this.idCompetencia);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public List<Disponibilidad> getDisponibilidades() {
		
		if(this.disponibilidades == null) {
			try {
				this.disponibilidades = CompetenciaDAO.getDisponibilidadesCompetencia(this.idCompetencia);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return disponibilidades;
	}

	public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}
	
	
}
