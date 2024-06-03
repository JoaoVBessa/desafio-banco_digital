package teste;

import entities.Banco;
import entities.Cliente;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import enums.TipoDeTransacao;

public class Main {

	public static void main(String[] args) {

		Banco itau = new Banco("ITAÚ");
		Cliente c1 = new Cliente("JOÃO");
		ContaCorrente cc = new ContaCorrente(c1, itau);

		Banco santander = new Banco("SANTANDER");
		Cliente c2 = new Cliente("CARLOS");
		ContaPoupanca cp = new ContaPoupanca(c2, santander);

		// Depósito
		cp.executarTransacao(TipoDeTransacao.DEPOSITAR, 1000, cp);
		// Saque
		cp.executarTransacao(TipoDeTransacao.SACAR, 300, cp);
		// Transferência
		cp.executarTransacao(TipoDeTransacao.TRANSFERIR, 250, cc);

		// Utilizando crédito
		cc.usarCredito(250);

		// Pegando número da agência cc
		System.out.println(cc.getAgencia());
		// Pegando o número da conta cp
		System.out.println(cp.getNumero());

		// Imprimindo extrato
		cc.imprimirExtrato();

	}

}
