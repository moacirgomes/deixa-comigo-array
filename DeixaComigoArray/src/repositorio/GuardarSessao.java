package repositorio;

public class GuardarSessao {
	public static Usuario logado;
	public static void usuariologado(Usuario usuario) {
		logado = usuario;
	}
	public static Usuario getLogado() {
		return logado;
	}

}
