package DTO;

import java.io.Serializable;

public class DisponibilidadDTO {

	private int disponibilidad;
	private int idLugarDeRealizacion;
	
	/* gets para obtener datos ingresados por pantalla y
     * sets para setearlos en el DTO */
	
	public int getDisponibilidad() {
		return disponibilidad;
	}
	
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	public int getIdLugarDeRealizacion() {
		return idLugarDeRealizacion;
	}
	
	public void setIdLugarDeRealizacion(int idLugarDeRealizacion) {
		this.idLugarDeRealizacion = idLugarDeRealizacion;
	}
}
