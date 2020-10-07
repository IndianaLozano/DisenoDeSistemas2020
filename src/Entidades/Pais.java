package Entidades;

public class Pais {

	public int idPais;
	public String nombrePais;
	
	//Creacion del constructor
	public Pais() {
		
	}
	
	//Creacion del constructor con parametros
	public Pais(int idPais, String nombrePais) {
		this.idPais = idPais;
		this.nombrePais = nombrePais;
				
	}
	
	//BDD envia datos todos juntos en un String. Separo y convierto los datos que no son String en su respectivo tipo.
	public Pais(String datos) {
		String[] atributo = datos.split("\t");
		//parseInt conversor de String a Int
		this.idPais = Integer.parseInt(atributo[0]);
		this.nombrePais = atributo[1];
	}
}
