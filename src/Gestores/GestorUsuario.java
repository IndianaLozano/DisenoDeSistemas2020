package Gestores;

import java.util.List;

import DAO.LocalidadDAO;
import DAO.UsuarioDAO;
import Entidades.Localidad;
import Entidades.Usuario;

public class GestorUsuario {
	
	//Retorna Localidades que tengan id_localidad igual al idLocalidad pasado como parametro
	public static List<Localidad> obtenerLocalidad(int idLocalidad ) throws Exception{
		return LocalidadDAO.getLocalidad(idLocalidad);
	}

	//Retorna Usuarios que tengan id_usuario igual al idUsuario pasado como parametro
	public static List<Usuario> obtenerUsuario(int idUsuario) throws Exception{
		return UsuarioDAO.getUsuario(idUsuario);
	}

	

}
