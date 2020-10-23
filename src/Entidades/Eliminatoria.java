package Entidades;

import Gestores.GestorCompetencia;

public class Eliminatoria extends Competencia {
	
	public static boolean esDoble;
	
	public Eliminatoria () {
		
	}
	
	public Eliminatoria (boolean esDoble) {
		this.esDoble=esDoble;
		
	}
	
	public Eliminatoria (String datos) {
 		String[] atributo = datos.split("\t");
 		try {
			Competencia competencia = GestorCompetencia.obtenerCompetencia(Integer.parseInt(atributo[0])).get(0);
			
			this.nombre=competencia.nombre;
			this.modalidad=competencia.modalidad;
			this.estado= competencia.estado;
			this.reglamento= competencia.reglamento;
			this.puntuacion= competencia.puntuacion;
			this.dadaDeBaja=competencia.dadaDeBaja;
			this.cantidadSets=competencia.cantidadSets;
			this.tantosGanadosAusenciaRival= competencia.tantosGanadosAusenciaRival;
			this.participantes= competencia.participantes;
			this.disponibilidades=competencia.disponibilidades;
			this.deporte= competencia.deporte;
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

 		
 		if (Integer.parseInt(atributo[1]) == 0) {
			this.esDoble= false;
		}else {
			this.esDoble=true;
		}
	
 		
	}
}
