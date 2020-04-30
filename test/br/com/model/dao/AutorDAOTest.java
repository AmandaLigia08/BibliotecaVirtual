/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.facade.BibliotecaFacadeLivro;
import br.com.model.bean.Autor;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author amand
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AutorDAOTest {
    
    private static BibliotecaFacadeLivro facade;
    private Autor autor;
    
    @BeforeClass
    public static void inicializar(){
        facade = new BibliotecaFacadeLivro();
    }
    
    @Before
    public void inicializarObjetos() throws Exception{
        autor = new Autor();
        //facade.limparDadosAutor();
    }
    
    
    private void inserir() throws Exception{
        autor.setNome("Teste");
        
        facade.cadastrarAutor(autor);
    }
    
    @Test
    public void testeInserir() throws Exception{

        int tamanhoAnterior = facade.listarAutor().size();

        inserir();
        
        int tamanhoAtual = facade.listarAutor().size();
        
        assertEquals(tamanhoAnterior + 1, tamanhoAtual);
    }
    
    @Test
    public void testeEditar() throws Exception{
        
        autor = facade.listarAutor().get(0);
       
        autor.setNome("Teste Editado");
        
        facade.editarAutor(autor);
        
        autor = facade.listarAutor().get(0);
        
        assertEquals(autor.getNome(),"Teste Editado");
    }
    
    @Test
    public void testeExcluir() throws Exception{
        
        inserir();
        
        autor = facade.listarAutor().get(0);
       
        int tamanhoAnterior = facade.listarAutor().size();
        
        facade.deletarAutor(autor);
        
        assertEquals(tamanhoAnterior - 1, facade.listarAutor().size());
        
    }
    
}