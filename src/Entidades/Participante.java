package Entidades;

import Gestores.GestorCompetencia;

public class Participante {
	public int id;
	public String nombre;
	public String correo;
	
	
	public Participante(int id, String nombre, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
	}
	
	public Participante() {
		
	}
	
	public Participante(String datos)  {

		String[] atributo = datos.split("\t");
		this.id= Integer.parseInt(atributo[0]);
		this.nombre= atributo[2];
		this.correo=atributo[3];
		
		
	}
	
	

}
