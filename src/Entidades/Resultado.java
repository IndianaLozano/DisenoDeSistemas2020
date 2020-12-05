package Entidades;

public class Resultado {

	public int idResultado;
	public boolean presentismoLocal;
	public boolean presentismoVisitante;
	public String fecha;
	public String hora;
	
	public Resultado(int idResultado, boolean presentismoLocal, boolean presentismoVisitante, String fecha,
			String hora) {
		
		this.idResultado = idResultado;
		this.presentismoLocal = presentismoLocal;
		this.presentismoVisitante = presentismoVisitante;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public Resultado() {
		
	}
	
	public Resultado(String datos) {
		String[] atributo = datos.split("\t");

		this.idResultado= Integer.parseInt(atributo[0]);
		this.fecha= atributo[4];
		this.hora=atributo[3];
		
		if (Integer.parseInt(atributo[5])==0) {
			this.presentismoLocal= false;
			
		}else {
			this.presentismoLocal=true;
		}
		
		
		if(Integer.parseInt(atributo[6]) ==1) {
			this.presentismoVisitante= true;
		}else {
			this.presentismoVisitante= false;
		}
		
	}
	
	
	
	
	
}
