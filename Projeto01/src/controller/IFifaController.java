package controller;

import java.io.IOException;
import model.Pilha;
import model.Lista;

public interface IFifaController {
	
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException;
	public void desempilhaBonsBrasileiros(Pilha<String> pilha) throws IOException;
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException;
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException;

}
