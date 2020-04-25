/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import java.util.List;
import br.com.model.bean.Secao;

/**
 *
 * @author amand
 */
public interface ISecaoDAO {

    int create(Secao secao) throws Exception;

    boolean delete(Secao secao) throws Exception;

    List<Secao> list() throws Exception;

    Secao search(int id) throws Exception;

    boolean update(Secao secao) throws Exception;

}
