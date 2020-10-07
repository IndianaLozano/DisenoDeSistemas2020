package Entidades;

public class Deporte {

	public int idDeporte;
	public String nombre;
	
	//Creacion del constructor
	public Deporte() {
		
	}
	
	//Creacion del constructor con parametros
	public Deporte(int idDeporte, String nombre) {
		this.idDeporte = idDeporte;
		this.nombre = nombre;
				
	}
	
	//BDD envia datos todos juntos en un String. Separo y convierto los datos que no son String en su respectivo tipo.
	public Deporte(String datos) {
		String[] atributo = datos.split("\t");
		//parseInt conversor de String a Int
		this.idDeporte = Integer.parseInt(atributo[0]);
		this.nombre= atributo[1];
		
		
		
	}
}
