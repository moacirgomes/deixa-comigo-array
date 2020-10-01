package repositorio;

import java.util.ArrayList;



public class RepositorioUsuario {

	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
}