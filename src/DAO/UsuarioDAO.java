package DAO;

import java.util.ArrayList;
import java.util.List;

import Entidades.Modalidad;
import Entidades.Usuario;

public class UsuarioDAO {
	
	public static List<Usuario> getUsuario(int idUsuario) throws Exception{
		try {
			String query = "SELECT * FROM database.usuario WHERE usuario.id_usuario= " + idUsuario + " ;";
			ArrayList<Usuario> usuario = (ArrayList<Usuario>)((Object)Conexion.consultar(query, Usuario.class));
			return usuario;
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	
}
