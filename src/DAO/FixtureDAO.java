package DAO;

import Entidades.Fixture;

public class FixtureDAO {
	
	public static void createFixture (Fixture f) {
		
		String query1="INSERT INTO database.Fixture (id_competencia, fecha) VALUES (" + f.competencia.idCompetencia + ", CURDATE())";
		
		
		
	}
	

}
