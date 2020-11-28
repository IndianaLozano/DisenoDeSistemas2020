package Entidades;

import Gestores.GestorFixture;

public class EncuentroRondaGanador extends Encuentro{
	
	public EncuentroRondaGanador encuentro_ronda_Ganador;
	public EncuentroRondaPerdedor encuentro_ronda_Perdedor;
	
	public EncuentroRondaGanador() {
		
	}

	public EncuentroRondaGanador(EncuentroRondaGanador encuentro_ronda_Ganador,
			EncuentroRondaPerdedor encuentro_ronda_Perdedor) {
		this.encuentro_ronda_Ganador = encuentro_ronda_Ganador;
		this.encuentro_ronda_Perdedor = encuentro_ronda_Perdedor;
	}
	
	
	public EncuentroRondaGanador (String datos) {
		String[] atributo = datos.split("\t");
		
		try {
			Encuentro e= GestorFixture.getEncuentroByID(Integer.parseInt(atributo[0])).get(0);
			
			this.idEncuentro= e.idEncuentro;
			this.local=e.local;
			this.visitante=e.visitante;
			this.ganador=e.ganador;
			this.lugar=e.lugar;
			this.fecha=e.fecha;
			this.hora=e.hora;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
	
	
	

}
