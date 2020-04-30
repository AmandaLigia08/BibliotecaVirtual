/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.dao;

import br.com.facade.BibliotecaFacadeLivro;
import br.com.model.bean.Autor;
import br.com.model.bean.Editora;
import br.com.model.bean.Livro;
import br.com.model.bean.Secao;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author amand
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LivroDAOTest {

    private static BibliotecaFacadeLivro facade;
    private Livro livro;

    @BeforeClass
    public static void inicializar() {
        facade = new BibliotecaFacadeLivro();
    }

    @Before
    public void inicializarObjetos() throws Exception {
        livro = new Livro();
        facade.limparDadosLivro();
    }

    private void inserir() throws Exception {

        Autor autor = new Autor();
        autor.setId(46);

        Editora editora = new Editora();
        editora.setId(1);

        Secao secao = new Secao();
        secao.setId(1);

        livro.setTitulo("Teste VAAR");
        livro.setExemplares(2);
        livro.setExemplaresDisponiveis(2);
        livro.setAutor(autor);

        facade.cadastrarLivro(livro);
    }
}
