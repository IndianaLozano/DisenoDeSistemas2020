package Entidades;

import Gestores.GestorCompetencia;
import Gestores.GestorFixture;
import Gestores.GestorLugaresDeRealizacion;

public class Encuentro {
	
	public int idEncuentro;
	public Participante local ;
	public Participante visitante;
	public Participante ganador;
	public LugarDeRealizacion lugar;
	public String fecha;
	public String hora;
	
	
	public Encuentro(int idEncuentro, Participante local, Participante visitante, Participante ganador,
			LugarDeRealizacion lugar,  String fecha, String hora) {

		this.idEncuentro = idEncuentro;
		this.local = local;
		this.visitante = visitante;
		this.ganador = ganador;
		this.lugar = lugar;
		this.fecha = fecha;
		this.hora = hora;
	}


	public Encuentro() {
		
	}
	
	
	public Encuentro(String datos) {
		String[] atributo = datos.split("\t");
		
		this.idEncuentro = Integer.parseInt(atributo[0]);
		try {
			this.local= GestorCompetencia.obtenerParticipante(Integer.parseInt(atributo[1])).get(0);
			this.visitante=GestorCompetencia.obtenerParticipante(Integer.parseInt(atributo[2])).get(0);
			this.ganador= GestorCompetencia.obtenerParticipante(Integer.parseInt(atributo[3])).get(0);
			this.lugar= GestorLugaresDeRealizacion.obtenerLugarDeRealizacion(Integer.parseInt(atributo[4])).get(0);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.fecha= atributo[6];
		this.hora= atributo[7];
	}
	
	

}
