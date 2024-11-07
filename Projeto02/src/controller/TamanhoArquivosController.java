package controller;

import java.io.File;
import java.io.IOException;

public class TamanhoArquivosController {

	public void LerDiretorio(String caminho) throws IOException {
		File diretorio = new File(caminho);

		if (diretorio.exists() && diretorio.isDirectory()) {
			File[] arquivos = diretorio.listFiles();
			
			if (arquivos == null || arquivos.length < 1) {
				throw new IOException ("Arquivos inválidos");
				
			}
			
			for (int i = 0; i < arquivos.length - 1; i++) {
	            for (int j = i + 1; j < arquivos.length; j++) {
	                if (arquivos[i].length() < arquivos[j].length()) {
	                    File auxiliar = arquivos[j];
	                    arquivos[j] = arquivos[i];
	                    arquivos[i] = auxiliar;
	                }
	            }
	        }

			for (File a : arquivos) {

				if (a.isFile() && (double) (a.length() / (1024) / (1024)) >= 1.0) {
					Double tamanho = (double) (a.length() / (1024) / (1024));
					System.out.println("Nome do arquivo: " + a.getName() + " | Tamanho: " + tamanho);
				}
			}

		} else {
			throw new IOException("Diretório inválido");
		}
	}

}
