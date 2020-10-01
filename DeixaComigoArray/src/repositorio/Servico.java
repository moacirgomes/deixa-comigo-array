package repositorio;

public class Servico {
	//private int idSolicitacao;
	private String nome;
	private String tipoServico;
	private Usuario solicitante;
	private double valor;
	private String endereco;
	private int vagas;
	private String descricao;

	public Servico(String nome, String tipoServico, Usuario solicitante, String valor, String endereco, String vagas,
			String descricao) {
		//this.idSolicitacao = idSolicitacao;
		this.nome = nome;
		this.tipoServico = tipoServico;
		this.solicitante = solicitante;
		double valord = Double.parseDouble(valor);
		this.valor = valord;
		this.endereco = endereco;
		int vagasi = Integer.parseInt(vagas);
		this.vagas = vagasi;
		this.descricao = descricao;
	}
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Usuario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Servico() {
		// TODO Auto-generated constructor stub
	}

}
