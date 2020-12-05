package Entidades;

public class ResultadoSets extends Resultado {
	
	
	public ResultadoSets(String datos) {
		String[] atributo = datos.split("\t");

		this.idResultado= Integer.parseInt(atributo[0]);
		
		
	}
	
	

}
