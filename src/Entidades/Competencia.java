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
	public List<LugarDeRealizacion> lugaresDeRealizacion;
	public Deporte deporte;
	
	
	
	
}
