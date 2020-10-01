package controle;

import repositorio.RepositorioServico;
import repositorio.Servico;

public class ControleServico {
	
	public static void CadastrarServico(Servico servico) {
		RepositorioServico.getServicos().add(servico);
		System.out.println(servico.getNome());
		
	}

}
