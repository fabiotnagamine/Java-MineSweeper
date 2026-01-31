package com.fabio.cm.model;

import java.util.ArrayList;
import java.util.List;

import com.fabio.cm.exception.ExplosaoException;

public class Campo {
	private boolean minado = false;
	private boolean aberto = false;
	private boolean marcado = false; // Campo com a mina marcada

	private List<Campo> vizinhos = new ArrayList<>();

	private final int linha;
	private final int coluna;

	public Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public boolean adicionarVizinho(Campo vizinho) {
		if (ehVizinho(vizinho)) {
			vizinhos.add(vizinho);
			return true;
		}
		return false;
	}

	private boolean ehVizinho(Campo c) {
		int dl = Math.abs(linha - c.linha);
		int dc = Math.abs(coluna - c.coluna);
		return dl <= 1 && dc <= 1 && !(dl == 0 && dc == 0);
	}

	public void alternarMarcacao() {
		if (!aberto) {
			marcado = !marcado;
		}
	}

	public boolean abrir() {
		if (aberto == false && marcado == false) {
			aberto = true;
			if (minado == true) {
				throw new ExplosaoException("Game Over");
			}
			
			if(checarVizinhos()) {
				vizinhos.forEach(vizinho -> vizinho.abrir());
			}
			
			return true;
		}

		return false;
	}
	
	public boolean checarVizinhos() {
		return vizinhos.stream().noneMatch(vizinho -> vizinho.minado);
	}

}
