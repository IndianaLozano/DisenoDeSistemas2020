package Entidades;

import java.util.List;

import DAO.ResultadoDAO;
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
	public Resultado actual;
	public List<Resultado> anterior;
	
	
	//--------------------------------------------------------------------
	public String[] atributo;
	
	
	
	
	public Participante getGanador() {
		if (this.ganador == null) {
			if (atributo[3].equals("null") == false ) {
				try {
					this.ganador= GestorCompetencia.obtenerParticipante(Integer.parseInt(atributo[3])).get(0);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
			
		}
		
		return ganador;
	}


	public void setGanador(Participante ganador) {
		this.ganador = ganador;
	}


	public LugarDeRealizacion getLugar() {
		if(this.lugar == null) {
			try {
				this.lugar= GestorLugaresDeRealizacion.obtenerLugarDeRealizacion(Integer.parseInt(atributo[4])).get(0);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return lugar;
	}


	public void setLugar(LugarDeRealizacion lugar) {
		this.lugar = lugar;
	}


	public Encuentro(int idEncuentro, Participante local, Participante visitante, Participante ganador,
			LugarDeRealizacion lugar,  String fecha, String hora, Resultado ac, List<Resultado> ant) {

		this.idEncuentro = idEncuentro;
		this.local = local;
		this.visitante = visitante;
		this.ganador = ganador;
		this.lugar = lugar;
		this.fecha = fecha;
		this.hora = hora;
		this.actual=ac;
		this.anterior=ant;
	}


	public Encuentro() {
		
	}
	
	
	public Encuentro(String datos) {
		atributo = datos.split("\t");
		
		this.idEncuentro = Integer.parseInt(atributo[0]);
		try {
			this.local= GestorCompetencia.obtenerParticipante(Integer.parseInt(atributo[1])).get(0);
			this.visitante=GestorCompetencia.obtenerParticipante(Integer.parseInt(atributo[2])).get(0);
			
			List<Resultado> res= ResultadoDAO.getResultadosEncuentro(idEncuentro);
			if(res.size() >0) {
			this.actual= res.get(0);
			}else {
				this.actual=null;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.fecha= atributo[6];
		this.hora= atributo[7];
	}
	
	
}
