package Entidades;

import java.util.List;

import Gestores.GestorLugaresDeRealizacion;

public class LugarDeRealizacion {

	public int idLugar;
	public int codigo;
	public String nombre;
	public String descripcion;
	public List<Deporte> deportes;
	
	
	public LugarDeRealizacion() {
		
	}
	
	
	public LugarDeRealizacion (int idLugar, int codigo, String nombre, String descripcion, List<Deporte> deportes) {
		this.idLugar=idLugar;
		this.codigo=codigo;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.deportes=deportes;
	}
	
	
	public LugarDeRealizacion (String datos) {
		String[] atributo = datos.split("\t");
		
		this.idLugar= Integer.parseInt(atributo[0]);
		//1- idUsuario
		this.codigo= Integer.parseInt(atributo[2]);
		this.nombre=atributo[3];
		this.descripcion=atributo[4];
			try {
				this.deportes= GestorLugaresDeRealizacion.obtenerDeportesLugar(Integer.parseInt(atributo[0]));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	
}
