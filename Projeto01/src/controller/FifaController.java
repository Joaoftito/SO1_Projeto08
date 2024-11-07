package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Lista;
import model.No;
import model.Pilha;

public class FifaController implements IFifaController {

	public FifaController() {
		super();
	}

	@Override
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		Pilha<String> pilha = new Pilha<String>();
		existenciaDiretorio(caminho);
		File arquivo = new File(caminho, nome);

		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) {

				if (linha.contains("Brazil")) {
					pilha.Push(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();

		} else {
			throw new IOException("Arquivo inválido");
		}
		System.out.println("Empilhamento concluído!\n");
		return pilha;
	}

	@Override
	public void desempilhaBonsBrasileiros(Pilha<String> pilha) throws IOException {
		String linha;
		String[] vetor;
		int overall;

		while (!pilha.VerificacaoPilhaVazia()) {
			try {
				linha = pilha.Pop();
				vetor = linha.split(",");
				overall = Integer.parseInt(vetor[7]);

				if (overall > 80) {
					System.out.println("Nome: " + vetor[2] + " | Overall: " + overall);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException {
		Lista<String> lista = new Lista<String>();
		existenciaDiretorio(caminho);
		File arquivo = new File(caminho, nome);
		String[] vetor;

		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();

			while (linha != null) {
				vetor = linha.split(",");
				int idade = Integer.parseInt(vetor[3]);

				if (idade <= 20) {
					lista.Append(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();

		} else {
			throw new IOException("Arquivo inválido");
		}
		System.out.println("Adição na lista concluída!\n");
		return lista;
	}

	@Override
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException {
		try {
			No<String> atual = lista.Last();
			String[] vetor;
			int idade;
			int overall;

			while (atual != null) {
				vetor = atual.getElemento().split(",");
				idade = Integer.parseInt(vetor[3]);
				overall = Integer.parseInt(vetor[7]);

				if (overall > 80) {
					System.out.println("Nome: " + vetor[2] + " | Idade: " + idade + " | Overall: " + overall);
				}
				atual = atual.getAnterior();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void existenciaDiretorio(String caminho) throws IOException {
		File diretorio = new File(caminho);

		if (diretorio.exists() && diretorio.isDirectory()) {
//			Diretório existente
		} else {
			throw new IOException("Diretório inválido");
		}
	}

}
