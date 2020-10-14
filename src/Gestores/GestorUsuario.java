package Gestores;

import java.util.List;

import DAO.LocalidadDAO;
import DAO.UsuarioDAO;
import Entidades.Localidad;
import Entidades.Usuario;

public class GestorUsuario {
	
	public static List<Localidad> obtenerLocalidad(int idLocalidad ) throws Exception{
		return LocalidadDAO.getLocalidad(idLocalidad);
	}

	public static List<Usuario> obtenerUsuario(int idUsuario) throws Exception{
		return UsuarioDAO.getUsuario(idUsuario);
	}

	

}
