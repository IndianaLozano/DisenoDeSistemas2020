package Entidades;

import java.util.List;

public class Filtros {
	
	
public static String generarConsultaFiltro (List<String> campos, List<String> valores, String tabla) {
		
		int tamanioCampos = campos.size();
		int i =0;
		
		String consulta = "SELECT * FROM " + tabla + " WHERE " + tabla + ".dada_de_baja=0 AND " ;
		
		
		if (tamanioCampos >1) {
			
			while (i<tamanioCampos-1) {
				String parte = campos.get(i) + " LIKE '%" + valores.get(i) + "%' AND ";
				
				consulta= consulta + parte ;
				
				i++;
			}
			
			if (i== tamanioCampos -1) {
				String ultimaParte = campos.get(i) + " LIKE '%" + valores.get(i) + "%' ;";
				consulta = consulta + ultimaParte ;
			}
			
		}else {
			
			String unicaParte= campos.get(0) + " LIKE '%" + valores.get(0) + "%' ;";
			consulta= consulta + unicaParte ;
			
		}
		
		return consulta ;
	}


}
