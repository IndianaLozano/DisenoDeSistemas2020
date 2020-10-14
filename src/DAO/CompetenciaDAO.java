package DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.ButtonGroup;

import Entidades.Competencia;
import Entidades.ConsultaGenerica;
import Entidades.Disponibilidad;
import Entidades.Estado;
import Entidades.Fixture;
import Entidades.Liga;
import Entidades.Modalidad;
import Entidades.Participante;
import Entidades.Puntuacion;
import Gestores.GestorCompetencia;
import javafx.scene.control.RadioButton;

public class CompetenciaDAO {

	//Metodos de consulta
	
	public static List<Integer> getIdModalidades() throws Exception {
		 
		List<Integer> idModalidades = new ArrayList<Integer> ();
		try {
			List<ConsultaGenerica> ls = (List<ConsultaGenerica>)(Object)Conexion.consultar("SELECT id_modalidad FROM database.modalidad ;", ConsultaGenerica.class);
			int tam = ls.size();
			int i=0;
			while(i<tam) {
				idModalidades.add(Integer.parseInt(ls.get(i).getValor("id_modalidad")));
			    i++;
			}

		} catch (Exception ex) {
			System.out.println("Entro al catch");
			throw ex;
		}
		return idModalidades;
		
	}
	
	public static List<Modalidad> getModalidad(int idModalidad) throws Exception{
		try {
			String query = "SELECT modal.id_deporte, modal.modalidad FROM database.competencia comp JOIN database.modalidad modal ON (comp.id_modalidad= modal.id_modalidad) WHERE id_modalidad = " + idModalidad + " ;";
			ArrayList<Modalidad> modalidad = (ArrayList<Modalidad>)((Object)Conexion.consultar(query, Modalidad.class));
			return modalidad;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	public static List<Puntuacion> getPuntuacion(int idPuntuacion) throws Exception{
		try {
			String query = "SELECT punt.id_puntuacion, punt.puntuacion FROM database.competencia comp JOIN database.puntuacion punt ON (comp.id_puntuacion = punt.id_puntuacion ) WHERE id_puntuacion = " + idPuntuacion + " ";                            
			ArrayList<Puntuacion> puntuacion = (ArrayList<Puntuacion>)((Object)Conexion.consultar(query, Puntuacion.class));
			return puntuacion;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	public static List<Participante> getParticipantesCompetencia(int idCompetencia) throws Exception{
		try {
			String query = "SELECT * FROM database.participante WHERE id_competencia = " + idCompetencia + " ;"  ;
			ArrayList<Participante> participantes = (ArrayList<Participante>)((Object)Conexion.consultar(query, Participante.class));
			return participantes;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	public static List<Disponibilidad> getDisponibilidadesCompetencia(int idCompetencia) throws Exception{
		try {
			//String query = "SELECT comp_lug.id_competencia, comp_lug.id_lugar, comp_lug.disponibilidad FROM database.competencia comp JOIN database.competencia_lugar comp_lug ON (comp.id_competencia=comp_lug.id_competencia) WHERE id_competencia = " + idCompetencia + " ;"  ;
			String query= "SELECT * FROM database.competencia_lugar WHERE id_competencia= " + idCompetencia + " ;";
			ArrayList<Disponibilidad> disponibilidades = (ArrayList<Disponibilidad>)((Object)Conexion.consultar(query, Disponibilidad.class));
			return disponibilidades;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	/*Metodo para traer todas las Competencias (enteras)
		public static List<Competencia> getAllCompetencias() throws Exception{
		try {
			String query = "SELECT * FROM database.competencia;";
			ArrayList<Competencia> competencias = (ArrayList<Competencia>)((Object)Conexion.consultar(query, Competencia.class));
			return competencias;
		}
		catch(Exception ex) {
			throw ex;
		}
	}*/
	
	
	public static List<Fixture> getFixture(int idFixture) throws Exception{
		try {
			String query = "SELECT * FROM database.fixture WHERE id_fixture = " + idFixture + " ;";                            
			ArrayList<Fixture> fixture = (ArrayList<Fixture>)((Object)Conexion.consultar(query, Fixture.class));
			return fixture;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	/* Este metodo retorna a una lista de nombres de todas las competencias existentes */
	public static List<String> getNombresCompetencias() throws Exception {
		
		List<String> nombresCompetencias = new ArrayList<String> ();
		try {
			List<ConsultaGenerica> ls1 = (List<ConsultaGenerica>)(Object)Conexion.consultar("SELECT nombre FROM database.competencia ;", ConsultaGenerica.class);
			int tam = ls1.size();
			int i = 0;
			while(i<tam) {
				nombresCompetencias.add(ls1.get(i).getValor("nombre"));
			    i++;
			}
		} catch (Exception ex) {
			System.out.println("Entro al catch");
			throw ex;
		}
		return nombresCompetencias;
	}
	
	
	public static List<Competencia> getCompetenciasUsuario(int idUsuario) throws Exception{
		try {
			String query = "SELECT comp.id_competencia, comp.id_usuario, comp.id_modalidad, comp.id_estado, comp.id_puntuacion, comp.id_deporte, comp.nombre, comp.dada_de_baja, comp.reglamento, comp.cantidad_sets, comp.tantosGanadosAusenciaRival FROM database.competencia comp JOIN database.usuario us ON (comp.id_usuario = us.id_usuario) WHERE id_usuario = " + idUsuario + "  ;";                            
			ArrayList<Competencia> competenciasUsuario = (ArrayList<Competencia>)((Object)Conexion.consultar(query, Competencia.class));
			return competenciasUsuario;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	
	//Metodo para ejecuciones
	
	
	public static void newCompetencia (String nombre, int idUsuario, int idModalidad, int idEstado, int idPuntuacion, int idDeporte, int dadaDeBaja, String reglamento, int cantSets, int tantosGanadosAusRival ) {
		String query= "INSERT INTO database.competencia (id_usuario, id_modalidad, id_estado, id_puntuacion, id_deporte, nombre, dada_de_baja, reglamento, cantidad_sets, tantos_ganados_ausencia_rival) VALUES ( " + idUsuario + ", " + idModalidad + ", " + idEstado + ", " + idPuntuacion + ", " + idDeporte + ", '" + nombre + "', " + dadaDeBaja + ", '" + reglamento + "', " + cantSets + ", " + tantosGanadosAusRival + " );"  ;
		try {
			Conexion.ejecutar(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void newLiga(Liga liga ) {
		
		int ep=0;
		if(liga.empatePermitido==true) {
			ep=1;
		}else {
			ep=0;
		}
		
		String query= "INSERT INTO database.liga (id_competencia, empate_permitido, puntos_pe, puntos_pg, puntos_por_presentarse) VALUES (" + liga.idCompetencia + ", " + ep + ", " + liga.puntosPE + ", " + liga.puntosPG + ", " + liga.puntosPorPresentarse + " );"  ;
		try {
			Conexion.ejecutar(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void newCompetencia_lugar(int idCompetencia, int idlugar, int disp) {
		String query = "INSERT INTO database.competencia_lugar (id_lugar, id_competencia, disponibilidad) VALUES ( " + idlugar + ", " + idCompetencia + ", " + disp + " );";
		try {
			Conexion.ejecutar(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static List<Competencia> getUltimaCompetencia() throws Exception{
		try {
			String query = "SELECT * FROM database.competencia ORDER BY id_competencia DESC LIMIT 1;";                            
			ArrayList<Competencia> competencia = (ArrayList<Competencia>)((Object)Conexion.consultar(query, Competencia.class));
			return competencia;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static List<Competencia> getCompetencia(int idCompetencia) throws Exception{
		try {
			String query = "SELECT * FROM database.competencia WHERE competencia.id_competencia= " + idCompetencia + " ;";                            
			ArrayList<Competencia> competencia = (ArrayList<Competencia>)((Object)Conexion.consultar(query, Competencia.class));
			return competencia;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

}
