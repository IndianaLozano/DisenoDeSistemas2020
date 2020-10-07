package Entidades;

public class Estado {
	
	public int idEstado;
	public String estado;
	
	//Creacion del constructor
	public Estado() {
		
	}

	//Creacion del constructor con parametros
	public Estado (int idEstado, String estado) {
		this.idEstado = idEstado;
		this.estado = estado;
		
	}
	
	//BDD envia datos todos juntos en un String. Separo y convierto los datos que no son String en su respectivo tipo.
	public Estado (String datos) {
		String[] atributo = datos.split("\t");
		//parseInt es conversor de String a Int
		this.idEstado = Integer.parseInt(atributo[0]);
		this.estado = atributo[1];

	}
	
}
