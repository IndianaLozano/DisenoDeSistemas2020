package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.ButtonGroup;

import Entidades.Competencia;
import Entidades.ConsultaGenerica;
import Entidades.Disponibilidad;
import Entidades.Eliminatoria;
import Entidades.Estado;
import Entidades.Fixture;
import Entidades.Liga;
import Entidades.MiExcepcion;
import Entidades.Modalidad;
import Entidades.Participante;
import Entidades.Puntuacion;
import Gestores.GestorCompetencia;
import InterfazGrafica.VentanaAdmin;
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
	
	public static List<Participante> getParticipante(int idPar) throws Exception{
		try {
			String query = "SELECT * FROM database.participante WHERE id_participante = " + idPar + " ;"  ;
			ArrayList<Participante> participantes = (ArrayList<Participante>)((Object)Conexion.consultar(query, Participante.class));
			return participantes;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	public static List<Participante> getParticipantesCompetenciaOrdenados(int idCompetencia, int index, boolean orden) throws Exception{
		try {
			
			String query = null ;
			switch (index) {
			case 0: if(orden == true) {
					query = "SELECT * FROM database.participante WHERE id_Competencia = " + idCompetencia + " ORDER BY nombre DESC;";
					}else {
						query = "SELECT * FROM database.participante WHERE  id_Competencia = " + idCompetencia + " ORDER BY nombre ASC;" ;
					}
			break;
			case 1: if(orden == true) {
				query = "SELECT * FROM database.participante WHERE id_Competencia = " + idCompetencia + " ORDER BY contacto DESC;";
				}else {
					query = "SELECT * FROM database.participante WHERE  id_Competencia = " + idCompetencia + " ORDER BY contacto ASC;" ;
				}
		break;
			}
			ArrayList<Participante> participantes = (ArrayList<Participante>)((Object)Conexion.consultar(query, Participante.class));
			return participantes;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static List<Disponibilidad> getDisponibilidadesCompetencia(int idCompetencia) throws Exception{
		try {
			
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
	public static void newCompetenciaLiga (Liga comp) throws Exception, MiExcepcion {
		
		int mod = GestorCompetencia.obtenerIdModalidad(comp.modalidad);  //obtiene el id de la modalidad
		int estado = GestorCompetencia.obtenerIdEstado(comp.estado);
		int puntuacion = GestorCompetencia.obtenerIdPuntuacion(comp.puntuacion);
		int deporte = DeporteDAO.getIdDeporte(comp.deporte.nombre);
		
		String query= "INSERT INTO database.competencia (id_usuario, id_modalidad, id_estado, id_puntuacion, id_deporte, nombre, dada_de_baja, reglamento, cantidad_sets, tantos_ganados_ausencia_rival) VALUES ( " + 2 + ", " + mod + ", " + estado + ", " + puntuacion + ", " + deporte + ", '" + comp.nombre + "', " + 0 + ", '" + comp.reglamento + "', " + comp.cantidadSets + ", " + comp.tantosGanadosAusenciaRival + " );"  ;
		//Conexion.ejecutar(query);
		Connection con = Conexion.conectarBDD();

		try {
			con.setAutoCommit(false);
			
			System.out.println("commit");
			con.createStatement().executeUpdate(query);
			System.out.println("comp");
			int idCompetencia= (CompetenciaDAO.getUltimaCompetencia().get(0).idCompetencia)+1 ;
			System.out.println("idcomp =" + idCompetencia);
			comp.idCompetencia = idCompetencia;
			
			int idLugar;
			int disp;

			for(int i=0; i< comp.disponibilidades.size(); i++) {
				idLugar = comp.disponibilidades.get(i).lugarDeRealizacion.idLugar;
				disp = comp.disponibilidades.get(i).disponibilidad;
				
				String query3 = "INSERT INTO database.competencia_lugar (id_lugar, id_competencia, disponibilidad) VALUES ( " + idLugar + ", " + idCompetencia + ", " + disp + " );";
				con.createStatement().executeUpdate(query3);
				
			}
			
			int ep=0;
			if(comp.empatePermitido==true) {
				ep=1;
			}else {
				ep=0;
			}
			 
			System.out.println("disp");
			String query2 = "INSERT INTO database.liga (id_competencia, empate_permitido, puntos_pe, puntos_pg, puntos_por_presentarse) VALUES (" + comp.idCompetencia + ", " + ep + ", " + comp.puntosPE + ", " + comp.puntosPG + ", " + comp.puntosPorPresentarse + " );"  ;
			con.createStatement().executeUpdate(query2);
			System.out.println("liga");
			
			con.commit();
			
			MiExcepcion exep = new MiExcepcion("6");
			throw exep;
			
			} 
		catch (Exception e) {
			//System.err.println("ERROR: " + e.getMessage());
			try {
				//deshace todos los cambios realizados en los datos
				con.rollback();
				} catch (SQLException ex1) {
					System.err.println( "No se pudo deshacer" + ex1.getMessage() );    
					}
			}     
		}
	
public static void newCompetenciaEliminatoria (Eliminatoria comp) throws Exception, MiExcepcion {
		
		int mod = GestorCompetencia.obtenerIdModalidad(comp.modalidad);  //obtiene el id de la modalidad
		int estado = GestorCompetencia.obtenerIdEstado(comp.estado);
		int puntuacion = GestorCompetencia.obtenerIdPuntuacion(comp.puntuacion);
		int deporte = DeporteDAO.getIdDeporte(comp.deporte.nombre);
		
		String query= "INSERT INTO database.competencia (id_usuario, id_modalidad, id_estado, id_puntuacion, id_deporte, nombre, dada_de_baja, reglamento, cantidad_sets, tantos_ganados_ausencia_rival) VALUES ( " + 2 + ", " + mod + ", " + estado + ", " + puntuacion + ", " + deporte + ", '" + comp.nombre + "', " + 0 + ", '" + comp.reglamento + "', " + comp.cantidadSets + ", " + comp.tantosGanadosAusenciaRival + " );"  ;
		Connection con = Conexion.conectarBDD();
		try {
			con.setAutoCommit(false);
			System.out.println("commit");
			con.createStatement().executeUpdate(query);
			System.out.println("comp");
			int idCompetencia= CompetenciaDAO.getUltimaCompetencia().get(0).idCompetencia + 1;
			comp.idCompetencia=idCompetencia;
			int idLugar;
			int disp;
			for(int i=0; i< comp.disponibilidades.size(); i++) {
				idLugar = comp.disponibilidades.get(i).lugarDeRealizacion.idLugar;
				disp = comp.disponibilidades.get(i).disponibilidad;
				
				String query3 = "INSERT INTO database.competencia_lugar (id_lugar, id_competencia, disponibilidad) VALUES ( " + idLugar + ", " + idCompetencia + ", " + disp + " );";
				con.createStatement().executeUpdate(query3);
			}
			int ed=0;
			if(comp.esDoble==true) {
				ed=1;
			}else {
				ed=0;
			}
			
			String query2= "INSERT INTO database.eliminatoria (id_competencia, es_doble) VALUES (" + comp.idCompetencia + ", " + ed + "); " ;
			con.createStatement().executeUpdate(query2);
			System.out.println("liga");
			con.commit();
			
			MiExcepcion exep = new MiExcepcion("6");
			throw exep;
		}
		catch (Exception e) {
		e.printStackTrace();
		System.err.println("ERROR: " + e.getMessage());
		try {
			//deshace todos los cambios realizados en los datos
			con.rollback();
			} catch (SQLException ex1) {
				System.err.println( "No se pudo deshacer" + ex1.getMessage() );    
				}
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
	
	
	public static List<Competencia> getCompetenciaByNombre(String nombre, int id_usuario) throws Exception{
		try {
			String query = "SELECT * FROM database.competencia WHERE nombre = '" + nombre + "' AND id_usuario = " + id_usuario +" ;" ;
			ArrayList<Competencia> competencias = (ArrayList<Competencia>)((Object)Conexion.consultar(query, Competencia.class));
			
			return competencias;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
		
	public static void newParticipanteCompetencia(Competencia c) throws Exception, MiExcepcion {
		Participante p= c.participantes.get(c.participantes.size()-1);
		
		String query= "INSERT INTO database.participante (id_Competencia, nombre, contacto) VALUES ("+ c.idCompetencia + ", '" + p.nombre + "', '" + p.correo + "' );";
		String query2= "UPDATE competencia SET competencia.id_estado = 1 WHERE competencia.id_competencia = " + c.idCompetencia + "; ";
		String query3= "DELETE FROM database.fixture WHERE id_competencia = "+ c.idCompetencia + " ;";
		Connection con = Conexion.conectarBDD();
		try {
			//Comienza transacción
			con.setAutoCommit(false);
			
			con.createStatement().executeUpdate(query);
			con.createStatement().executeUpdate(query2);
			con.createStatement().executeUpdate(query3);
			
			con.commit();
			
			MiExcepcion exep = new MiExcepcion("6");
			throw exep;
		}
		catch (Exception e) {
		System.err.println("ERROR: " + e.getMessage());
		try {
			//deshace todos los cambios realizados en los datos
			con.rollback();
			} catch (SQLException ex1) {
				System.err.println( "No se pudo deshacer" + ex1.getMessage() );    
				}
		}
	
			MiExcepcion e = new MiExcepcion("9");
			throw e;
			
		
	}
	
	public static void comenzarTransaccion() {
		String query = "START TRANSACTION;";
		try {
			Conexion.ejecutar(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void finalizarTransaccion() {
		String query = "COMMIT;";
		try {
			Conexion.ejecutar(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void errorTransaccion() {
		String query = "ROLLBACK;";
		try {
			Conexion.ejecutar(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Competencia> getCompetenciasUsuario(int idUsuario, String nombreComp, String deporte, String modalidad, String estado) throws Exception {
		try {
			String query = "SELECT comp.id_competencia, comp.id_modalidad, comp.id_estado, comp.id_deporte, comp.nombre FROM database.competencia comp JOIN database.usuario us ON (comp.id_usuario = us.id_usuario) WHERE id_usuario = " + idUsuario + "  ;";                            
			ArrayList<Competencia> competenciasUsuario = (ArrayList<Competencia>)((Object)Conexion.consultar(query, Competencia.class));
			return competenciasUsuario;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
		
	public static List<Competencia> getCompetenciasUsuarioSegunFiltro(int idUsuario, String nombreComp, String deporte, String modalidad, String estado) throws Exception {
			try {
				String query = "SELECT comp.id_competencia, comp.id_modalidad, comp.id_estado, comp.id_deporte, comp.nombre FROM database.competencia comp JOIN database.usuario us ON (comp.id_usuario = us.id_usuario) WHERE id_usuario = " + idUsuario + "  ;";                            
				ArrayList<Competencia> competenciasUsuario = (ArrayList<Competencia>)((Object)Conexion.consultar(query, Competencia.class));
				return competenciasUsuario;
			}
			catch(Exception ex) {
				throw ex;
			}
	}
		
		
	

}
