package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Competencia;
import Entidades.ConsultaGenerica;
import Entidades.Deporte;
import Entidades.Fase;
import Entidades.Fixture;

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
	
	public static List<Fase> getUltimaFase() throws Exception{
		try {
			String query = "SELECT * FROM database.fase ORDER BY id_fase DESC LIMIT 1;";                            
			ArrayList<Fase> fase = (ArrayList<Fase>)((Object)Conexion.consultar(query, Fase.class));
			return fase;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static int getUltimoIdFase() throws Exception{
		try {
			String query = "SELECT id_fase FROM database.fase ORDER BY id_fase DESC LIMIT 1;"; 
			List<ConsultaGenerica> ls1 = (List<ConsultaGenerica>)(Object)Conexion.consultar(query, ConsultaGenerica.class);
			if (ls1.size()==0) {
				return 0;
			}else {
			return Integer.parseInt(ls1.get(0).getValor("id_fase"));}
		}
		catch(Exception ex) {
			throw ex;
		}
	}

}
