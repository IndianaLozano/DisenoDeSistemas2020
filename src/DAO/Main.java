package DAO;

import java.util.ArrayList;
import java.util.List;

import DAO.Conexion;
import Entidades.ConsultaGenerica;



public class Main {

	public static void main(String[] args) {

		/*List<ConsultaGenerica> ls;
		try {
			ls = (List<ConsultaGenerica>)(Object)Conexion.consultar("SELECT id_modalidad FROM database.modalidad ;", ConsultaGenerica.class);
			
			for(int i=0; i<ls.size() ; i++) {
				System.out.println(ls.get(i).getValor("id_modalidad"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static List<Clase> getActividades() throws Exception{
		try {
			String query = "SELECT..";
			ArrayList<Clase> clases = (ArrayList<Clase>)((Object)Conexion.consultar(query, Clase.class));
			return clases;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}*/
	
	
	/*public static void altaActividad (String nombre, long idProfesor) throws Exception{
		String query="" ;
		try {
			Conexion.ejecutar(query);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	}
}
