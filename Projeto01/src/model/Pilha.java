package model;

public class Pilha<T> {

	private No<T> fim = null;
	private int tamanho = 0;

	public void Push(T elemento) {
		No<T> celula = new No<T>(elemento);

		if (this.fim != null) {
			No<T> atual = this.fim;
			celula.setAnterior(atual);
		}
		this.fim = celula;
		tamanho = tamanho + 1;

	}

	public T Pop() throws Exception {
		if (this.fim == null) {
			throw new Exception("Não existe item na lista");
		}

		T celula = this.fim.getElemento();
		this.fim = this.fim.getAnterior();
		tamanho = tamanho - 1;
		return celula;
	}

	public boolean VerificacaoPilhaVazia() {

		if (this.tamanho == 0) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		No<T> atual = this.fim;

		while (atual != null) {
			builder.append(atual.getElemento());
			atual = atual.getAnterior();
			if (atual != null) {
				builder.append(",");
			}
		}
		builder.append("]");
		return builder.toString();
	}

}
