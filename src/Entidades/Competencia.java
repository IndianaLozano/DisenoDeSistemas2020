package Entidades;

import java.util.List;

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
		
		
		
	}
	
	
	
	
	
}
