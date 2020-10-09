package Entidades;

import java.util.List;

public class Usuario {
	
	public int id_usuario;
	public String correo;
	public String contrasenia;
	public String nombre;
	public String apellido;
	public int documento;
	public TipoDocumento tipoDoc;
	public List<Competencia> competencias;
	public Localidad localidad;
	

	
	public Usuario() {
		
	}
	
	public Usuario(int id, String correo, String contra, String nomb, String ape, int doc, TipoDocumento td, List<Competencia> comp, Localidad loc) {
		this.id_usuario=id;
		this.correo=correo;
		this.nombre=nomb;
		this.apellido=ape;
		this.contrasenia=contra;
		this.documento=doc;
		this.localidad=loc;
		this.competencias=comp;
		this.tipoDoc=td;
	}
	
	public Usuario(String datos) {
		String[] atributo = datos.split("\t");

		this.id_usuario= Integer.parseInt(atributo[0]);
		this.correo= atributo[6];
		this.nombre=atributo[3];
		this.apellido=atributo[4];
		this.documento=Integer.parseInt(atributo[5]);
		
		//TODO: LOCALIDAD, tipoDocumento, competencias
		
}

	
}
