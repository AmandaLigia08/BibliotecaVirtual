/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facade;

import java.util.List;
import br.com.factory.DAOFactory;
import br.com.model.bean.Emprestimo;
import br.com.interfaces.IEmprestimoDAO;

/**
 *
 * @author amand
 */
public class BibliotecaFacadeEmprestimo {

    private IEmprestimoDAO emprestimoDAO;

    public BibliotecaFacadeEmprestimo() {
        emprestimoDAO = DAOFactory.createEmprestimoDAO();
    }

    public void editarEmprestimo(Emprestimo emprestimo) throws Exception {
        emprestimoDAO.update(emprestimo);
    }

    public void cadastrarEmprestimo(Emprestimo emprestimo) throws Exception {
        emprestimoDAO.create(emprestimo);
    }

    public Emprestimo buscarEmprestimo(int id) throws Exception {
        Emprestimo emprestimo = emprestimoDAO.search(id);
        return emprestimo;
    }

    public void deletarEmprestimo(Emprestimo emprestimo) throws Exception {
        emprestimoDAO.delete(emprestimo);
    }

    public List<Emprestimo> listarEmprestimo() throws Exception {
        List<Emprestimo> lista = emprestimoDAO.list();
        return lista;
    }
}
