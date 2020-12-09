package Entidades;

import Gestores.GestorCompetencia;

public class Disponibilidad {

	//public int id_competencia;
	public LugarDeRealizacion lugarDeRealizacion;
	public int disponibilidad;
	
	public Disponibilidad() {
		
	}
	
	public Disponibilidad(LugarDeRealizacion lugarDeRealizacion, int disp) {
		this.lugarDeRealizacion=lugarDeRealizacion;
		this.disponibilidad=disp;
	}

	public Disponibilidad(String datos) {
		String[] atributo = datos.split("\t");
		this.disponibilidad=Integer.parseInt(atributo[2]);
		
		
		try {
			this.lugarDeRealizacion = GestorCompetencia.obtenerLugarDeRealizacion(Integer.parseInt(atributo[0])).get(0);
			
			} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
