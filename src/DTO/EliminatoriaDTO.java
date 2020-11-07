package DTO;

import java.io.Serializable;

import Entidades.Puntuacion;

public class EliminatoriaDTO implements Serializable{
	
	public int cantidadSets;
	public int tantosGanadosAusRival;
	public Puntuacion puntuacion;
	public static boolean esDoble;
	
	
	public boolean isEsDoble() {
		return esDoble;
	}
	public void setEsDoble(boolean esDoble) {
		this.esDoble = esDoble;
	}
	public int getCantidadSets() {
		return cantidadSets;
	}
	public void setCantidadSets(int cantidadSets) {
		this.cantidadSets = cantidadSets;
	}
	public int getTantosGanadosAusRival() {
		return tantosGanadosAusRival;
	}
	public void setTantosGanadosAusRival(int tantosGanadosAusRival) {
		this.tantosGanadosAusRival = tantosGanadosAusRival;
	}
	public Puntuacion getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(Puntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
}
