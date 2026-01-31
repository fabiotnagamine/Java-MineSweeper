package com.fabio.cm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fabio.cm.model.Campo;

class CampoTeste {

	 private Campo campoCentral;

	    @BeforeEach
	    void iniciarCampo() {
	        campoCentral = new Campo(3, 3);
	    }

	    // =========================
	    // VIZINHOS VÁLIDOS (8)
	    // =========================

	    @Test
	    void deveAdicionarVizinhoCima() {
	        Campo vizinho = new Campo(2, 3);
	        assertTrue(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void deveAdicionarVizinhoBaixo() {
	        Campo vizinho = new Campo(4, 3);
	        assertTrue(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void deveAdicionarVizinhoEsquerda() {
	        Campo vizinho = new Campo(3, 2);
	        assertTrue(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void deveAdicionarVizinhoDireita() {
	        Campo vizinho = new Campo(3, 4);
	        assertTrue(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void deveAdicionarVizinhoDiagonalSuperiorEsquerda() {
	        Campo vizinho = new Campo(2, 2);
	        assertTrue(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void deveAdicionarVizinhoDiagonalSuperiorDireita() {
	        Campo vizinho = new Campo(2, 4);
	        assertTrue(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void deveAdicionarVizinhoDiagonalInferiorEsquerda() {
	        Campo vizinho = new Campo(4, 2);
	        assertTrue(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void deveAdicionarVizinhoDiagonalInferiorDireita() {
	        Campo vizinho = new Campo(4, 4);
	        assertTrue(campoCentral.adicionarVizinho(vizinho));
	    }

	    // =========================
	    // NÃO VIZINHOS
	    // =========================

	    @Test
	    void naoDeveAdicionarOProprioCampo() {
	        Campo vizinho = new Campo(3, 3);
	        assertFalse(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void naoDeveAdicionarCampoMuitoAcima() {
	        Campo vizinho = new Campo(1, 3);
	        assertFalse(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void naoDeveAdicionarCampoMuitoAbaixo() {
	        Campo vizinho = new Campo(5, 3);
	        assertFalse(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void naoDeveAdicionarCampoMuitoEsquerda() {
	        Campo vizinho = new Campo(3, 1);
	        assertFalse(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void naoDeveAdicionarCampoMuitoDireita() {
	        Campo vizinho = new Campo(3, 5);
	        assertFalse(campoCentral.adicionarVizinho(vizinho));
	    }

	    @Test
	    void naoDeveAdicionarDiagonalDistante() {
	        Campo vizinho = new Campo(5, 5);
	        assertFalse(campoCentral.adicionarVizinho(vizinho));
	    }

}
