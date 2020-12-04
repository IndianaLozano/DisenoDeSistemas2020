package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Competencia;
import Entidades.ConsultaGenerica;
import Entidades.Encuentro;
import Entidades.Fase;

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

	/*public static int getUltimoIdEncuentro() throws Exception{
		try {
			String query = "SELECT id_encuentro FROM database.encuentro ORDER BY id_encuentro DESC LIMIT 1;"; 
			List<ConsultaGenerica> ls1 = (List<ConsultaGenerica>)(Object)Conexion.consultar(query, ConsultaGenerica.class);
			if (ls1.size()==0) {
				return 0;
			}else {
			return Integer.parseInt(ls1.get(0).getValor("id_encuentro"));
			}
		}
		catch(Exception ex) {
			throw ex;
		}
	}*/
	
	public static List<Encuentro> getUltimoEncuentro() throws Exception{
		try {
			String query = "SELECT * FROM database.encuentro ORDER BY id_encuentro DESC LIMIT 1;";                            
			ArrayList<Encuentro> encuentro = (ArrayList<Encuentro>)((Object)Conexion.consultar(query, Encuentro.class));
			return encuentro;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static int getUltimoIdEncRondaGanador() throws Exception{
		try {
			String query = "SELECT id_encuentro FROM database.enc_ronda_ganador ORDER BY id_encuentro DESC LIMIT 1;"; 
			List<ConsultaGenerica> ls1 = (List<ConsultaGenerica>)(Object)Conexion.consultar(query, ConsultaGenerica.class);
			return Integer.parseInt(ls1.get(0).getValor("id_encuentro"));
		}
		catch(Exception ex) {
			throw ex;
		}
	}
}
