package Entidades;

public class Provincia {

	
		public int idProvincia;
		public String nombreProvincia;
		
		//Creacion del constructor
		public Provincia() {
			
		}
		
		//Creacion del constructor con parametros
		public Provincia(int idProvincia, String nombreProvincia) {
			this.idProvincia = idProvincia;
			this.nombreProvincia = nombreProvincia;
					
		}
		
		//BDD envia datos todos juntos en un String. Separo y convierto los datos que no son String en su respectivo tipo.
		public Provincia(String datos) {
			String[] atributo = datos.split("\t");
			//parseInt conversor de String a Int
			this.idProvincia = Integer.parseInt(atributo[0]);
			this.nombreProvincia = atributo[1];
		}
			
			
}
