package Entidades;

import Gestores.GestorCompetencia;

public class Liga extends Competencia {

	
	
	public boolean empatePermitido;
	public int puntosPE;
	public int puntosPG;
	public int puntosPorPresentarse;
	public TablaDePosiciones tablaDePosiciones;
	
	public Liga() {
		
	}
	
    public Liga( boolean empatePer, int ptosPE, int ptosPG, int ptosPP, TablaDePosiciones tabla ) {
		
		this.empatePermitido=empatePer;
		this.puntosPE=ptosPE;
		this.puntosPG=ptosPG;
		this.puntosPorPresentarse=ptosPP;
		this.tablaDePosiciones=tabla;
	}
	
	
     public Liga(String datos) {
 		String[] atributo = datos.split("\t");
 		try {
			Competencia competencia = GestorCompetencia.obtenerCompetencia(Integer.parseInt(atributo[1])).get(0);
			
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

 		
 		if (Integer.parseInt(atributo[2]) == 0) {
			this.empatePermitido= false;
		}else {
			this.empatePermitido=true;
		}
 		
 		this.puntosPE= Integer.parseInt(atributo[3]);
 		this.puntosPG= Integer.parseInt(atributo[4]);
 		this.puntosPorPresentarse=Integer.parseInt(atributo[5]);
 		
	}
	
}
