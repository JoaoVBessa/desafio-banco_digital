package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {

	private final String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public List<Conta> getContas() {
		return Collections.unmodifiableList(contas);
	}

	protected void addConta(Conta conta) {
		if (!contas.contains(conta)) {
			contas.add(conta);
			conta.setBanco(this);
		} else {
			throw new IllegalArgumentException("Está conta já está vinculada.");
		}
	}

	@Override
	public String toString() {
		return " Banco = " + nome;
	}

}
