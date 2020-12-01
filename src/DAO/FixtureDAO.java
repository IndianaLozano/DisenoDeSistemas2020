package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Competencia;
import Entidades.ConsultaGenerica;
import Entidades.Fixture;

public class FixtureDAO {
	
	
	
	public static void createFixture (Fixture f) throws Exception {
		
		Connection con = Conexion.conectarBDD();
		
		
			try {
				con.setAutoCommit(false);
				
				String query1="INSERT INTO database.fixture (id_competencia, fecha, baja) VALUES (" + f.competencia.idCompetencia + ", CURDATE(), 0)";
				con.createStatement().executeUpdate(query1);
				
				String query2;
				String query3;
				String query4;
				
				
					int idUltimoFixture = (getUltimoIdFixture()) + 1;
					int idUltimaFase = (FaseDAO.getUltimoIdFase());
					int cantidadFases= f.fases.size();
					
					int idFaseActual;
					for (int i=0 ; i<cantidadFases; i++) {
						
						query2= "INSERT INTO database.fase (id_fixture, numero_fase, baja) VALUES ( " + idUltimoFixture + ", " + (i+1) + ", 0 )" ;	
						con.createStatement().executeUpdate(query2);
						idFaseActual= idUltimaFase +(i+1);
						int cantidadEncuentros = f.fases.get(i).encuentros.size();
					
						for(int j=0 ; j<cantidadEncuentros ; j++) {
							
						int idLocal= f.fases.get(i).encuentros.get(j).local.id;
						int idVisitante= f.fases.get(i).encuentros.get(j).visitante.id;
						
						query3 = "INSERT INTO database.encuentro (id_participante_local, id_participante_visitante, id_fase, fecha, hora) VALUES (" + idLocal + ", " + idVisitante + ", " + idFaseActual + ", CURDATE(), curTime() ) ;" ;	
							
							
						}
					
				
						
						}
				
				
			
				con.commit();
			} catch (SQLException e) {
				//TODO ROLLBACK
				e.printStackTrace();
			}
			
			
			
		
		
		
		
	}
	
	public static int getUltimoIdFixture() throws Exception{
		try {
			String query = "SELECT id_fixture FROM database.fixture ORDER BY id_fixture DESC LIMIT 1;"; 
			List<ConsultaGenerica> ls1 = (List<ConsultaGenerica>)(Object)Conexion.consultar(query, ConsultaGenerica.class);
			return Integer.parseInt(ls1.get(0).getValor("id_fixture"));
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	

}
