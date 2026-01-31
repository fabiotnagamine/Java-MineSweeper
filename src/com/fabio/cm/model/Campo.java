package com.fabio.cm.model;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	private boolean minado = false;
	private boolean aberto = false;
	private boolean marcado = false; //Campo com a mina marcada
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	private final int linha;
	private final int coluna;
	
	
	public Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public boolean adicionarVizinho(Campo vizinho) {
		/*
		 * boolean vizinhoLinha = linha != vizinho.linha; boolean vizinhoColuna = coluna
		 * != vizinho.coluna; boolean diagonal = vizinhoColuna && vizinhoLinha;
		 * 
		 * int deltaLinha = Math.abs(linha - vizinho.linha); int deltaColuna =
		 * Math.abs(coluna - vizinho.coluna);
		 * 
		 * if(deltaLinha == 1 && !diagonal) { vizinhos.add(vizinho); return true; }else
		 * if(deltaColuna == 1 && !diagonal){ vizinhos.add(vizinho); return true; }else
		 * if(diagonal == true) { vizinhos.add(vizinho); return true; }else { return
		 * false; }
		 */
		
		
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
}
