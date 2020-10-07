package Entidades;

public class Localidad {
	public int idLocalidad;
	public String nombreLocalidad;
	
	//Creacion del constructor
	public Localidad() {
		
	}
	
	//Creacion del constructor con parametros
	public Localidad(int idLocalidad, String nombreLocalidad) {
		this.idLocalidad = idLocalidad;
		this.nombreLocalidad = nombreLocalidad;
				
	}
	
	//BDD envia datos todos juntos en un String. Separo y convierto los datos que no son String en su respectivo tipo.
	public Localidad(String datos) {
		String[] atributo = datos.split("\t");
		//parseInt conversor de String a Int
		this.idLocalidad = Integer.parseInt(atributo[0]);
		this.nombreLocalidad= atributo[1];
	}
	
		
		
}
