package enums;

public enum TipoDeTransacao {

	SACAR("Saque"), DEPOSITAR("Depósito"), TRANSFERIR("Transferência");

	private String descricao;

	private TipoDeTransacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
