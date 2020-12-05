package DAO;
import java.util.ArrayList;
import java.util.List;

import DAO.Conexion;
import Entidades.Resultado;

public class ResultadoDAO {
	
	
	public static List<Resultado> getResultadosEncuentro(int idEncuentro) throws Exception{
		try {
			String query = "SELECT * FROM database.resultado ORDER BY id_encuentro_actual DESC LIMIT 1;";
			ArrayList<Resultado> resultados = (ArrayList<Resultado>)((Object)Conexion.consultar(query, Resultado.class));
			return resultados;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
	

}
