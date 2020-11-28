package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Gestores.GestorCompetencia;
import Gestores.GestorFixture;

public class Fixture{

	public int idFixture;
	public String fecha;
	public Competencia competencia;
	public List<Fase> fases;
	
	
	//Creacion del constructor
	public Fixture() {
		
	}
	
	//Creacion del constructor con parametros
	public Fixture (int idFixture, String fecha) {
		this.idFixture = idFixture;
		this.fecha = fecha;
		
	}
	
	//BDD envia datos todos juntos en un String. Separo y convierto los datos que no son String en su respectivo tipo.
	public Fixture (String datos) throws ParseException {
		String[] atributo = datos.split("\t");
		this.idFixture = Integer.parseInt(atributo[0]);		
		this.fecha = atributo[2];
		try {
			this.competencia= GestorCompetencia.obtenerCompetencia(Integer.parseInt(atributo[1])).get(0);
			this.fases= GestorFixture.getFasesFixture(idFixture);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
