package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Deporte;
import Entidades.Fase;

public class FaseDAO {
	
	
	public static List<Fase> getFaseByID(int idFase) throws Exception{
		try {
			String query = "SELECT * FROM database.fase WHERE fase.id_fase = " + idFase + " ;";
			ArrayList<Fase> fases = (ArrayList<Fase>)((Object)Conexion.consultar(query, Fase.class));
			return fases;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	
	public static List<Fase> getFasesFixture(int idFix) throws Exception{
		try {
			String query = "SELECT * FROM database.fase WHERE fase.id_fixture = " + idFix + " ;";
			ArrayList<Fase> fases = (ArrayList<Fase>)((Object)Conexion.consultar(query, Fase.class));
			return fases;
		}
		catch(Exception ex) {
			throw ex;
		}
	}

}
