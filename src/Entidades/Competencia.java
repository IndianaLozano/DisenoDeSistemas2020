package Entidades;

import java.util.List;

import Gestores.GestorCompetencia;
import Gestores.GestorUsuario;

public class Competencia {

	public int idCompetencia;
	public static String nombre;
	public static Modalidad modalidad; //*
	public static Estado estado;//*
	public static String reglamento;
	public static Puntuacion puntuacion;//* 
	public static boolean dadaDeBaja;
	public static int cantidadSets;
	public static int tantosGanadosAusenciaRival;
	
	public static List<Participante> participantes;//*
	public static Deporte deporte;//*
	public static List<Disponibilidad> disponibilidades; //*
	public static Usuario usuario;
	public static Fixture fixture;
	
	//Constructor sin parametros
	public Competencia() {}
	
	//Constructor con parametros
	public Competencia(int id, String nombre, Modalidad modalidad, Estado estado, String reglamento, Puntuacion puntuacion, boolean baja, int cantidadSets, int tantosGanadosAusenciaRival) {
		this.idCompetencia = id;
		this.nombre = nombre;
		this.modalidad = modalidad;
		this.estado = estado;
		this.reglamento = reglamento;
		this.puntuacion = puntuacion;
		this.dadaDeBaja = baja;
		this.cantidadSets = cantidadSets;
		this.tantosGanadosAusenciaRival = tantosGanadosAusenciaRival;
	}
	
	
	public Competencia(String datos) {
		
		String[] atributo = datos.split("\t");
		this.idCompetencia = Integer.parseInt(atributo[0]);
		this.nombre = atributo[6];
		this.cantidadSets = Integer.parseInt(atributo[9]);
		this.reglamento = atributo[8];
		this.tantosGanadosAusenciaRival = Integer.parseInt(atributo[10]);
		try {
			this.estado = GestorCompetencia.obtenerEstadoEnum(Integer.parseInt(atributo[3]));
			this.modalidad = GestorCompetencia.obtenerModalidadEnum(Integer.parseInt(atributo[2]));
			this.participantes = GestorCompetencia.obtenerParticipantesCompetencia(Integer.parseInt(atributo[0]));
			this.deporte = GestorCompetencia.obtenerDeporte(Integer.parseInt(atributo[5])).get(0);
			this.disponibilidades = GestorCompetencia.obtenerDisponibilidadesCompetencia(Integer.parseInt(atributo[0]));
			this.puntuacion = GestorCompetencia.obtenerPuntuacionEnum(Integer.parseInt(atributo[4]));
			this.usuario = GestorUsuario.getUsuario(Integer.parseInt(atributo[1])).get(0);
			} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
