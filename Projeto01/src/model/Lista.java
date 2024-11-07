package model;

public class Lista<T> {
	
	private No<T> inicio = null;
	private No<T> fim = null;
	private int totalElementos;

	public void Append(T elemento) {
		No<T> celula = new No<T>(elemento);

		if (this.inicio == null) {
			this.inicio = celula;
			this.fim = celula;

		} else {
			No<T> atual = this.fim;
			this.fim.setProximo(celula);
			celula.setAnterior(atual);
			this.fim = celula;
		}
	}

	public No<T> Get(int endereco) throws Exception {
		if (inicio == null) {
			throw new Exception("Não existe nenhum item na lista");
		}

		No<T> atual = inicio;
		for (int i = 0; i < endereco; i++) {

			if (atual.getProximo() == null) {
				throw new Exception("Esse endereço não existe na lista");
			}
			atual = atual.getProximo();
		}
		return atual;
	}
	
	public void Insert(T elemento, int endereco) {
		No<T> celula = new No<T>(elemento);

		if (this.inicio == null || endereco == 0) {
			celula.setProximo(inicio);
			this.inicio = celula;

		} else {
			No<T> atual = inicio;

			for (int i = 0; i < endereco - 1; i++) {
				atual = atual.getProximo();
			}

			celula.setProximo(atual.getProximo());
			atual.setProximo(celula);
		}
	}

	public No<T> Last() throws Exception {
		if (this.inicio == null) {
			throw new Exception("Não existe item na lista");
		}
		No<T> atual = this.inicio;

		while (atual.getProximo() != null) {
			atual = atual.getProximo();
		}
		return atual;
	}

	public void Prepend(T elemento) {
		No<T> celula = new No<T>(elemento);

		if (this.fim == null) {
			this.fim = celula;
			this.inicio = celula;

		} else {
			No<T> atual = this.inicio;
			this.inicio = celula;
			celula.setProximo(atual);
			atual.setAnterior(celula);
		}
	}

	public void Remove(int endereco) throws Exception {
		if (this.inicio == null) {
			throw new Exception("Não existe item na lista");
		}

		if (endereco == 0) {
			this.inicio = this.inicio.getProximo();
			return;
		}

		No<T> anterior = Get(endereco - 1);
		No<T> atual = anterior.getProximo();

		if (atual == null) {
			throw new Exception("Esse endereço não existe na lista");
		}

		anterior.setProximo(atual.getProximo());
	}

	public int Total() {
		No<T> atual = this.inicio;
		totalElementos = 0;

		while (atual != null) {
			atual = atual.getProximo();
			totalElementos++;
		}
		return totalElementos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		No<T> atual = this.inicio;

		while (atual != null) {
			builder.append(atual.getElemento());
			atual = atual.getProximo();
			if (atual != null) {
				builder.append(",");
			}
		}

		builder.append("]");
		return builder.toString();
	}
}
