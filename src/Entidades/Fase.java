package Entidades;

import java.util.List;

import DAO.EncuentroDAO;

public class Fase {
	
	public int idFase;
	public int numeroFase;
	public List<Encuentro> encuentros;
	
	
	public Fase () {
		
	}
	
	public Fase(int idFase, int numeroFase, List<Encuentro> enc) {
		this.idFase = idFase;
		this.numeroFase = numeroFase;
		this.encuentros=enc;
	}
	
	public Fase(String datos) {
		String[] atributo = datos.split("\t");
		this.idFase = Integer.parseInt(atributo[0]);
		this.numeroFase= Integer.parseInt(atributo[2]);
		
		
	}

	public List<Encuentro> getEncuentros() {
		
		if (encuentros == null) {
			try {
				this.encuentros=EncuentroDAO.getEncuentrosFase(idFase);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return encuentros;
	}

	
}
