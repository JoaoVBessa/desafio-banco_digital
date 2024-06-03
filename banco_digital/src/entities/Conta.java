package entities;

import enums.TipoDeTransacao;
import interfaces.IConta;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected double credito;
	protected Cliente cliente;
	protected Banco banco;

	public Conta(Cliente cliente, Banco banco) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		banco.addConta(this);
		this.credito = 500.0;
	}

	private void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			System.out.println("Saque realizado com sucesso. Seu saldo atual é de R$" + saldo);
		} else {
			System.out.println("Operação não realizada. Saldo insuficiente.");
		}

	}

	private void depositar(double valor, Conta contaDestino) {
		if (contaDestino == null) {
			throw new IllegalArgumentException("Conta de destino não não pode ser nula. Tente novamente.");
		}
		if (valor > 0) {
			contaDestino.saldo += valor;
			System.out.println("Depósito para a conta " + contaDestino
					+ " realizado com suceso. Seu saldo atual é de: R$" + saldo);
		} else {
			System.out.println("Valor inválido.");
		}

	}

	private void transferir(double valor, Conta contaDestino) {
		if (contaDestino == null) {
			throw new IllegalArgumentException("Conta de destino não não pode ser nula. Tente novamente.");
		}

		if (saldo >= valor && valor <= saldo) {
			saldo -= valor;
			depositar(valor, contaDestino);
		} else {
			System.out.println("Saldo insuficiente para realizar a operação.");
		}

	}

	@Override
	public void usarCredito(double valor) {
		if (credito >= valor) {
			credito -= valor;
			System.out.println("Seu crédito disponível agora é de R$" + credito);
		} else {
			throw new IllegalArgumentException("Crédito com saldo insuficiente.");
		}
	}

	@Override
	public void executarTransacao(TipoDeTransacao tipo, double valor, Conta contaDestino) {
		switch (tipo) {
		case SACAR:
			sacar(valor);
			break;
		case DEPOSITAR:
			depositar(valor, contaDestino);
			break;
		case TRANSFERIR:
			transferir(valor, contaDestino);
			break;
		default:
			throw new IllegalArgumentException("Tipo de transação desconhecida: " + tipo);
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getCredito() {
		return credito;
	}

	protected void setBanco(Banco banco) {
		this.banco = banco;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo disponível: %.2f", this.saldo));
		System.out.println(String.format("Crédito disponível: %.2f", this.credito));
	}

	@Override
	public String toString() {
		return "Conta " + this.numero;
	}

}
