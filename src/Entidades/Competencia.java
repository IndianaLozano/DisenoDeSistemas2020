package Entidades;

import java.util.List;

import Gestores.GestorDeCompetencia;

public class Competencia {

	public int idCompetencia;
	public String nombre;
	public Modalidad modalidad;
	public Estado estado;
	public String reglamento;
	public Puntuacion puntuacion;
	public boolean dadaDeBaja;
	public int cantidadSets;
	public int tantosGanadosAusenciaRival;
	
	public List<Participante> participantes;
	public Deporte deporte;
	public List<Disponibilidad> disponibilidades; 
	public Usuario usuario;
	public Fixture fixture;
	
	//Constructor sin parametros
	public Competencia() {}
	
	//Constructor con parametros
	public Competencia(int id, String nombre, Modalidad modalidad, Estado estado, String reglamento, Puntuacion puntuacion, boolean baja, int cantidadSets, int tantosGanadosAusenciaRival) {
		this.idCompetencia=id;
		this.nombre=nombre;
		this.modalidad=modalidad;
		this.estado=estado;
		this.reglamento=reglamento;
		this.puntuacion=puntuacion;
		this.dadaDeBaja=baja;
		this.cantidadSets=cantidadSets;
		this.tantosGanadosAusenciaRival=tantosGanadosAusenciaRival;
	}
	
	
	public Competencia(String datos) {
		
		String[] atributo = datos.split("\t");
		this.idCompetencia= Integer.parseInt(atributo[0]);
		this.nombre=atributo[6];
		this.cantidadSets= Integer.parseInt(atributo[9]);
		this.reglamento= atributo[8];
		this.tantosGanadosAusenciaRival= Integer.parseInt(atributo[10]);
		try {
			this.estado= GestorDeCompetencia.obtenerEstado(Integer.parseInt(atributo[3])).get(0);
			this.modalidad= GestorDeCompetencia.obtenerModalidad(Integer.parseInt(atributo[2])).get(0);
			
			} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
