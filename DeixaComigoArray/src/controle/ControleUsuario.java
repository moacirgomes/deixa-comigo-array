package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import repositorio.GuardarSessao;
import repositorio.RepositorioUsuario;
import repositorio.Usuario;

public class ControleUsuario {
	
	public static void CadastrarUsuario(Usuario usuario) {
		RepositorioUsuario.usuarios.add(usuario);
		for(Usuario i: RepositorioUsuario.usuarios) {
 			System.out.println(i.getNome());
			System.out.println(i.getTipo());
			System.out.println(i.getSenha());
			System.out.println(i.getCpf());
		}
	}
	public static boolean checarLogin(String id, String senha) {
		ArrayList<Usuario> lista = RepositorioUsuario.getUsuarios();
		boolean logar = false;
		for(Usuario i: lista) {
			if(i.getCpf().equals(id) && i.getSenha().equals(senha)){
				logar = true;
				GuardarSessao.usuariologado(i);
			}
		}
		return logar;
	}
	
	public static void remover(Usuario usuario) {
		RepositorioUsuario.usuarios.remove(usuario);
	}
}
