/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import java.util.List;
import br.com.model.bean.Pessoa;

/**
 *
 * @author amand
 */
public interface IPessoaDAO {

    boolean create(Pessoa pessoa) throws Exception;

    boolean delete(Pessoa pessoa) throws Exception;

    List<Pessoa> list() throws Exception;

    Pessoa search(int id) throws Exception;

    void update(Pessoa pessoa) throws Exception;
}
