package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Competencia;
import Entidades.ConsultaGenerica;
import Entidades.Fixture;
import Entidades.MiExcepcion;

import javax.transaction.*;
import javax.transaction.xa.*;


public class FixtureDAO {
	
	
	
	public static void createFixture (Fixture f) throws Exception, MiExcepcion {
		
		Connection con = Conexion.conectarBDD();
		
		try {
			con.setAutoCommit(false);
			String query1="INSERT INTO database.fixture (id_competencia, fecha, baja) VALUES (" + f.competencia.idCompetencia + ", CURDATE(), 0)";
			con.createStatement().executeUpdate(query1);
			int idUltimoFixture = (getUltimoFixture().get(0).idFixture)+1;
			String query2;
			String query3;
			String query4;
				
				//int idUltimoEncuentro = EncuentroDAO.getUltimoIdEncuentro();
				int cantidadFases= f.fases.size();
				// int idFaseActual;
				for (int i=0 ; i<cantidadFases; i++) {
					// idFaseActual = idUltimaFase +(i+1);
					query2= "INSERT INTO database.fase (id_fixture, numero_fase, baja) VALUES ( " + idUltimoFixture + ", " + (i+1) + ", 0 )" ;	
					con.createStatement().executeUpdate(query2);
					int idUltimaFase = (FaseDAO.getUltimaFase().get(0).idFase)+(i+1);
					int cantidadEncuentros = f.fases.get(i).encuentros.size();
				
					for(int j=0 ; j<cantidadEncuentros ; j++) {
						
						int idLocal= f.fases.get(i).encuentros.get(j).local.id;
						int idVisitante= f.fases.get(i).encuentros.get(j).visitante.id;
						int idLugar = f.fases.get(i).encuentros.get(j).lugar.idLugar;
						int suma =(j+1)+(cantidadEncuentros*i);
						// idUltimoEncuentro++;
						query3 = "INSERT INTO database.encuentro (id_participante_local, id_participante_visitante, id_lugar, id_fase, fecha, hora) VALUES (" + idLocal + ", " + idVisitante + ", " + idLugar + ", " + idUltimaFase + ", CURDATE(), curTime() ) ;" ;	
						con.createStatement().executeUpdate(query3);
						int idUltimoEncuentro = (EncuentroDAO.getUltimoIdEncuentro())+(suma);
						query4 = "INSERT INTO database.enc_ronda_ganador (id_encuentro, id_encuentro_gan) VALUE (" + idUltimoEncuentro + ", " + idUltimoEncuentro + ");";
						con.createStatement().executeUpdate(query4);
					}
				}
			con.commit();
			MiExcepcion e1= new MiExcepcion("13");
			throw e1;
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		}
		
		
		
	}
	
	public static List<Fixture> getUltimoFixture() throws Exception{
		try {
			String query = "SELECT * FROM database.fixture ORDER BY id_fixture DESC LIMIT 1;";                            
			ArrayList<Fixture> fixture = (ArrayList<Fixture>)((Object)Conexion.consultar(query, Fixture.class));
			return fixture;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	/*public static int getUltimoIdFixture() throws Exception{
		try {
			String query = "SELECT id_fixture FROM database.fixture ORDER BY id_fixture DESC LIMIT 1;"; 
			List<ConsultaGenerica> ls1 = (List<ConsultaGenerica>)(Object)Conexion.consultar(query, ConsultaGenerica.class);
			if (ls1.size()==0) {
				return 0;
			}else {
			return Integer.parseInt(ls1.get(0).getValor("id_fixture"));
			}
		}
		catch(Exception ex) {
			throw ex;
		}
	}*/
	
	
	public static void deleteFixture(int idCompetencia) {
		String query = "UPDATE database.fixture SET baja= 1 WHERE id_competencia = " + idCompetencia + " ;";
		try {
			Conexion.ejecutar(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
