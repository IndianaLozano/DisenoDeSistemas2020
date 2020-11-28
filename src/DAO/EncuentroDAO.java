package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Encuentro;

public class EncuentroDAO {
	
	
	public static List<Encuentro> getEncuentrosFase(long idFase) throws Exception{
		try {
			String query = "SELECT * FROM database.encuentro WHERE encuentro.id_fase =" + idFase + " ;";
			ArrayList<Encuentro> encuentros = (ArrayList<Encuentro>)((Object)Conexion.consultar(query, Encuentro.class));
			return encuentros;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	} 
	
	public static List<Encuentro> getEncuentroByID(int idEncuentro) throws Exception{
		try {
			String query = "SELECT * FROM database.encuentro WHERE encuentro.id_encuentro =" + idEncuentro + " ;";
			ArrayList<Encuentro> encuentros = (ArrayList<Encuentro>)((Object)Conexion.consultar(query, Encuentro.class));
			return encuentros;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	} 

}
