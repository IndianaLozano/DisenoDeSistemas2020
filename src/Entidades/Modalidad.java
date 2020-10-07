package Entidades;

public class Modalidad {

	public int idModalidad;
	public String modalidad;
	
	public Modalidad () {
		
	}
	
	public Modalidad (int id, String modalidad) {
		this.idModalidad=id;
		this.modalidad=modalidad;
	}
	
	public Modalidad (String datos) {
		String[] atributo = datos.split("\t");
		
		this.idModalidad= Integer.parseInt(atributo[0]);
		this.modalidad=atributo[1];
				
	}
	
	
}
