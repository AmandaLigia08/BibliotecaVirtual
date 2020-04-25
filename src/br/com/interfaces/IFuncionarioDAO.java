/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interfaces;

import java.util.List;
import br.com.model.bean.Funcionario;

/**
 *
 * @author amand
 */
public interface IFuncionarioDAO {

    boolean create(Funcionario funcionario) throws Exception;

    boolean delete(Funcionario funcionario) throws Exception;

    List<Funcionario> list() throws Exception;

    Funcionario search(int id) throws Exception;

    void update(Funcionario funcionario) throws Exception;

    boolean verificarLogin(String login, String senha) throws Exception;
}
