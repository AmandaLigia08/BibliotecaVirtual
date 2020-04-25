/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import java.util.List;
import br.com.model.bean.Livro;

/**
 *
 * @author amand
 */
public interface ILivroDAO {

    boolean create(Livro livro) throws Exception;

    boolean delete(Livro livro) throws Exception;

    List<Livro> list() throws Exception;

    Livro search(int id) throws Exception;

    void update(Livro livro) throws Exception;

    void limparDados() throws Exception;
}
