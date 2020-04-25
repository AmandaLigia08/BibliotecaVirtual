/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import java.util.List;
import br.com.model.bean.Aluno;

/**
 *
 * @author amand
 */
public interface IAlunoDAO {

    boolean create(Aluno aluno) throws Exception;

    boolean delete(Aluno aluno) throws Exception;

    List<Aluno> list() throws Exception;

    Aluno search(int id) throws Exception;

    void update(Aluno aluno) throws Exception;
}
