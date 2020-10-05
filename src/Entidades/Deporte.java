package Entidades;

public class Deporte {

	public int idDeporte;
	public String nombre;
	
	//Creacion del constructor
	public Deporte() {
		
	}
	
	//creacion del constructor con parametros
	public Deporte(int idDeporte, String nombre) {
		this.idDeporte= idDeporte;
		this.nombre = nombre;
				
	}
	
	public Deporte(String datos) {
		String[] atributo = datos.split("\t");
		//parseInt convesor de String a Int
		this.idDeporte = Integer.parseInt(atributo[0]);
		this.nombre= atributo[1];
		
		
		
	}
}
