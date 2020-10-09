package Entidades;

public class Disponibilidad {

	public int id_competencia;
	public int id_lugar;
	public int disponibilidad;
	
	public Disponibilidad() {
		
	}
	
	public Disponibilidad(int idComp, int idLugar, int disp) {
		this.id_competencia=idComp;
		this.id_lugar=idLugar;
		this.disponibilidad=disp;
	}

	public Disponibilidad(String datos) {
		String[] atributo = datos.split("\t");
		this.id_competencia= Integer.parseInt(atributo[0]);
		this.id_lugar=Integer.parseInt(atributo[1]);
		this.disponibilidad=Integer.parseInt(atributo[2]);

	}
	
}
