package DTO;

import java.io.Serializable;

public class CompDTO implements Serializable {
	
	private int idCompetencia;
	private static String nombre;
	private static String modalidad;
	private static String estado;
	private DeporteDTO deporte;
	
	
	public int getIdCompetencia() {
		return idCompetencia;
	}
	public void setIdCompetencia(int idCompetencia) {
		this.idCompetencia = idCompetencia;
	}
	public static String getNombre() {
		return nombre;
	}
	public static void setNombre(String nombre) {
		CompDTO.nombre = nombre;
	}
	public static String getModalidad() {
		return modalidad;
	}
	public static void setModalidad(String modalidad) {
		CompDTO.modalidad = modalidad;
	}
	public static String getEstado() {
		return estado;
	}
	public static void setEstado(String estado) {
		CompDTO.estado = estado;
	}
	public DeporteDTO getDeporte() {
		return deporte;
	}
	public void setDeporte(DeporteDTO deporte) {
		this.deporte = deporte;
	}
	
	
	
}
