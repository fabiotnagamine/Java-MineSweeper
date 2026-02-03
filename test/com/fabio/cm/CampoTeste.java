//package com.fabio.cm;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.fabio.cm.exception.ExplosaoException;
//import com.fabio.cm.model.Campo;
//
//class CampoTeste {
//
//    private Campo campo;
//
//    @BeforeEach
//    void iniciarCampo() {
//        campo = new Campo(3, 3);
//    }
//
//    // =========================
//    // Testes de vizinhança
//    // =========================
//
//    @Test
//    void deveAdicionarVizinhoHorizontal() {
//        Campo vizinho = new Campo(3, 4);
//        assertTrue(campo.adicionarVizinho(vizinho));
//    }
//
//    @Test
//    void deveAdicionarVizinhoVertical() {
//        Campo vizinho = new Campo(4, 3);
//        assertTrue(campo.adicionarVizinho(vizinho));
//    }
//
//    @Test
//    void deveAdicionarVizinhoDiagonal() {
//        Campo vizinho = new Campo(4, 4);
//        assertTrue(campo.adicionarVizinho(vizinho));
//    }
//
//    @Test
//    void naoDeveAdicionarVizinhoDistante() {
//        Campo vizinho = new Campo(5, 5);
//        assertFalse(campo.adicionarVizinho(vizinho));
//    }
//
//    @Test
//    void naoDeveAdicionarEleMesmoComoVizinho() {
//        Campo vizinho = new Campo(3, 3);
//        assertFalse(campo.adicionarVizinho(vizinho));
//    }
//
//    // =========================
//    // Testes de marcação
//    // =========================
//
//    @Test
//    void deveAlternarMarcacao() {
//        campo.alternarMarcacao();
//        assertTrue(campo.isMarcado());
//
//        campo.alternarMarcacao();
//        assertFalse(campo.isMarcado());
//    }
//
//    @Test
//    void naoDeveMarcarCampoAberto() {
//        campo.abrir();
//        campo.alternarMarcacao();
//        assertFalse(campo.isMarcado());
//    }
//
//    // =========================
//    // Testes de abertura
//    // =========================
//
//    @Test
//    void deveAbrirCampoNaoMinadoENaoMarcado() {
//        assertTrue(campo.abrir());
//    }
//
//    @Test
//    void naoDeveAbrirCampoMarcado() {
//        campo.alternarMarcacao();
//        assertFalse(campo.abrir());
//    }
//
//    @Test
//    void naoDeveAbrirCampoJaAberto() {
//        campo.abrir();
//        assertFalse(campo.abrir());
//    }
//
//    // =========================
//    // Testes de explosão
//    // =========================
//
//    @Test
//    void deveLancarExplosaoAoAbrirCampoMinado() {
//        campo.minar();
//        assertThrows(ExplosaoException.class, () -> campo.abrir());
//    }
//
//    // =========================
//    // Testes de vizinhos minados
//    // =========================
//
//    @Test
//    void deveAbrirVizinhosQuandoNaoHaMinasAoRedor() {
//        Campo campo11 = new Campo(1, 1);
//        Campo campo12 = new Campo(1, 2);
//        Campo campo22 = new Campo(2, 2);
//
//        campo11.adicionarVizinho(campo12);
//        campo11.adicionarVizinho(campo22);
//
//        campo12.adicionarVizinho(campo11);
//        campo12.adicionarVizinho(campo22);
//
//        campo22.adicionarVizinho(campo11);
//        campo22.adicionarVizinho(campo12);
//
//        campo11.abrir();
//
//        assertTrue(campo12.abrir() == false); // já abriu via recursão
//        assertTrue(campo22.abrir() == false); // já abriu via recursão
//    }
//
//    @Test
//    void naoDeveAbrirVizinhosQuandoHaMinaAoRedor() {
//        Campo campoCentral = new Campo(2, 2);
//        Campo vizinho = new Campo(2, 3);
//
//        vizinho.minar();
//
//        campoCentral.adicionarVizinho(vizinho);
//
//        campoCentral.abrir();
//
//        assertFalse(vizinho.abrir()); // não abriu automaticamente
//    }
//
//
//	    
//}
