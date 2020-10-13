package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Fixture{

	public int idFixture;
	public Date fecha;
	public Competencia competencia;
	public List<Fase> fases;
	
	
	//Creacion del constructor
	public Fixture() {
		
	}
	
	//Creacion del constructor con parametros
	public Fixture (int idFixture, Date fecha) {
		this.idFixture = idFixture;
		this.fecha = fecha;
		
	}
	
	//BDD envia datos todos juntos en un String. Separo y convierto los datos que no son String en su respectivo tipo.
	public Fixture (String datos) throws ParseException {
		String[] atributo = datos.split("\t");
		this.idFixture = Integer.parseInt(atributo[0]);
		Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(atributo[1]);  
		this.fecha = fecha;
	}
	
}
