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

	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	boolean adicionarVizinho(Campo vizinho) {
		if (ehVizinho(vizinho)) {
			vizinhos.add(vizinho);
			return true;
		}
		return false;
	}

	boolean ehVizinho(Campo c) {
		int dl = Math.abs(linha - c.linha);
		int dc = Math.abs(coluna - c.coluna);
		return dl <= 1 && dc <= 1 && !(dl == 0 && dc == 0);
	}

	void alternarMarcacao() {
		if (!aberto) {
			marcado = !marcado;
		}
	}

	boolean abrir() {
		if (aberto == false && marcado == false) {
			aberto = true;
			if (minado == true) {
				throw new ExplosaoException("Game Over");
			}

			if (checarVizinhos()) {
				vizinhos.forEach(vizinho -> vizinho.abrir());
			}

			return true;
		} else
			return false;
	}

	public boolean checarVizinhos() {
		return vizinhos.stream().noneMatch(vizinho -> vizinho.minado);
	}

	public void minar() {
		minado = true;
	}
	
	public boolean isMinado() {
		return minado;
	}

	public boolean isMarcado() {
		return marcado;
	}

	boolean objetivoCumprido() {
		boolean revelado = !minado && aberto;
		boolean protegido = minado && marcado;
		return revelado || protegido;
	}

	long minadoVizinhos() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}

	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	
	public String toString() {
		if(marcado) {
			return "x";
		}else if(aberto && minado) {
			return "#";
		}else if(aberto && minadoVizinhos() > 0) {
			return Long.toString(minadoVizinhos());
		}else if(aberto) {
			return " ";
		}else {
			return "?";
		}
	}

}
