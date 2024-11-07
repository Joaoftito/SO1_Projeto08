package view;

import controller.FifaController;
import java.io.IOException;
import model.Pilha;
import model.Lista;

public class Main {
	
	public static void main(String[] args) {
		FifaController controller = new FifaController();
		String caminho = "C:\\TEMP";
		String nome = "data.csv";
		
		try {
			Pilha<String> pilha = controller.empilhaBrasileiros(caminho, nome);
			controller.desempilhaBonsBrasileiros(pilha);
			
			Lista<String> lista = controller.listaRevelacoes(caminho, nome);
			controller.buscaListaBonsJovens(lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
