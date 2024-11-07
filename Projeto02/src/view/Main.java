package view;

import java.io.IOException;

import controller.TamanhoArquivosController;

public class Main {
	
	public static void main(String[] args) throws IOException {
		TamanhoArquivosController arquivos = new TamanhoArquivosController();
		
//		Escolha o endereço da pasta desejada abaixo!
		
		String caminho = "C:\\Users\\joaoa\\OneDrive\\Imagens\\Arquivos CD e DVD\\Videos 2007";
		
		arquivos.LerDiretorio(caminho);
	}

}
