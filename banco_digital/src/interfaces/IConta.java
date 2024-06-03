package interfaces;

import entities.Conta;
import enums.TipoDeTransacao;

public interface IConta {

	void imprimirExtrato();

	void usarCredito(double valor);

	void executarTransacao(TipoDeTransacao tipo, double valor, Conta contaDestino);

}
