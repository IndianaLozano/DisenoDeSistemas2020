package DTO;

import java.io.Serializable;
import java.util.List;

import Entidades.Modalidad;

public class CompetenciaDTO implements Serializable {
	
	//Declaro atributos del DTO
	
	private static String nombre;
	private int idDeporte;
	private Modalidad modalidad;
	private List<DisponibilidadDTO> disponibilidadesDTO; // chequear si esta bien esto
	private String reglamento;
	private int idUsuario=1;
    
    
    /* gets para obtener datos ingresados por pantalla y
     * sets para setearlos en el DTO */
    
    public static String getNombre() {
		return nombre;
	}
    
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getIdDeporte() {
		return idDeporte;
	}
	
	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}
	
	public Modalidad getModalidad() {
		return modalidad;
	}
	
	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public List<DisponibilidadDTO> getDisponibilidadesDTO() {
		return disponibilidadesDTO;
	}

	public void setDisponibilidadesDTO(List<DisponibilidadDTO> disponibilidadesDTO) {
		this.disponibilidadesDTO = disponibilidadesDTO;
	}

	public String getReglamento() {
		return reglamento;
	}

	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	//Constructor sin parametros
	public CompetenciaDTO() {
		
	}
	
	//Constructor con parametros
	public CompetenciaDTO(String nombre, int idDeporte, Modalidad modalidad,
			List<DisponibilidadDTO> disponibilidadesDTO, String reglamento) {
		super();
		this.nombre = nombre;
		this.idDeporte = idDeporte;
		this.modalidad = modalidad;
		this.disponibilidadesDTO = disponibilidadesDTO;
		this.reglamento = reglamento;
	}
		
	
	
}

	
