/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.factory;

import br.com.interfaces.IAlunoDAO;
import br.com.dao.AutorDAO;
import br.com.dao.EditoraDAO;
import br.com.dao.EmprestimoDAO;
import br.com.dao.EnderecoDAO;
import br.com.dao.LivroDAO;
import br.com.dao.PessoaDAO;
import br.com.dao.SecaoDAO;
import br.com.dao.AlunoDAO;
import br.com.dao.FuncionarioDAO;
import br.com.interfaces.IAutorDAO;
import br.com.interfaces.IEditoraDAO;
import br.com.interfaces.IEmprestimoDAO;
import br.com.interfaces.IEnderecoDAO;
import br.com.interfaces.IFuncionarioDAO;
import br.com.interfaces.ILivroDAO;
import br.com.interfaces.IPessoaDAO;
import br.com.interfaces.ISecaoDAO;

/**
 *
 * @author amand
 */
public class DAOFactory {

    public static IPessoaDAO createPessoaDAO() {
        return new PessoaDAO();
    }

    public static IAutorDAO createAutorDAO() {
        return new AutorDAO();
    }

    public static IEnderecoDAO createEnderecoDAO() {
        return new EnderecoDAO();
    }

    public static IEditoraDAO createEditoraDAO() {
        return new EditoraDAO();
    }

    public static ISecaoDAO createSecaoDAO() {
        return new SecaoDAO();
    }

    public static IEmprestimoDAO createEmprestimoDAO() {
        return new EmprestimoDAO();
    }

    public static ILivroDAO createLivroDAO() {
        return new LivroDAO();
    }

    public static IAlunoDAO createAlunoDAO() {
        return new AlunoDAO();
    }

    public static IFuncionarioDAO createFuncionarioDao() {
        return new FuncionarioDAO();
    }
}
