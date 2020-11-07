package DTO;

import java.io.Serializable;

import Entidades.Puntuacion;

public class LigaDTO implements Serializable{

	private int ptos_pg;
	private int ptos_pp;
	private int ptos_pe;
	private int cantidadSets;
	private int tantosGanadosAusRival;
	private Puntuacion puntuacion;
	private boolean empatePermitido;
	
	public int getPtos_pg() {
		return ptos_pg;
	}
	public void setPtos_pg(int ptos_pg) {
		this.ptos_pg = ptos_pg;
	}
	public int getPtos_pp() {
		return ptos_pp;
	}
	public void setPtos_pp(int ptos_pp) {
		this.ptos_pp = ptos_pp;
	}
	public int getPtos_pe() {
		return ptos_pe;
	}
		public void setPtos_pe(int ptos_pe) {
		this.ptos_pe = ptos_pe;
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
	public boolean isEmpatePermitido() {
		return empatePermitido;
	}
	public void setEmpatePermitido(boolean empatePermitido) {
		this.empatePermitido = empatePermitido;
	}
	
	
	
}
