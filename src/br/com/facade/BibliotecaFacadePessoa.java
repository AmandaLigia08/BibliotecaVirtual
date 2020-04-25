/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facade;

import br.com.factory.DAOFactory;
import br.com.interfaces.IAlunoDAO;
import br.com.model.bean.Endereco;
import br.com.model.bean.Pessoa;
import br.com.interfaces.IEnderecoDAO;
import br.com.interfaces.IFuncionarioDAO;
import br.com.interfaces.IPessoaDAO;
import br.com.model.bean.Aluno;
import br.com.model.bean.Funcionario;
import java.util.List;

/**
 *
 * @author amand
 */
public class BibliotecaFacadePessoa {

    private IPessoaDAO pessoaDAO;
    private IEnderecoDAO enderecoDAO;
    private IAlunoDAO alunoDAO;
    private IFuncionarioDAO funcionarioDAO;

    public BibliotecaFacadePessoa() {
        this.pessoaDAO = DAOFactory.createPessoaDAO();
        this.enderecoDAO = DAOFactory.createEnderecoDAO();
        this.alunoDAO = DAOFactory.createAlunoDAO();
        this.funcionarioDAO = DAOFactory.createFuncionarioDao();
    }

    public void cadastrarPessoa(Pessoa pessoa) throws Exception {
        pessoaDAO.create(pessoa);
    }

    public void cadastrarEndereco(Endereco endereco) throws Exception {
        enderecoDAO.create(endereco);
    }

    public void cadastrarAluno(Aluno aluno) throws Exception {
        alunoDAO.create(aluno);
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws Exception {
        funcionarioDAO.create(funcionario);
    }

    public void editarEndereco(Endereco endereco) throws Exception {
        enderecoDAO.update(endereco);
    }

    public void editarPessoa(Pessoa pessoa) throws Exception {
        pessoaDAO.update(pessoa);
    }

    public void editarAluno(Aluno aluno) throws Exception {
        alunoDAO.update(aluno);
    }

    public void editarFuncionario(Funcionario funcionario) throws Exception {
        funcionarioDAO.update(funcionario);
    }

    public void deletarEndereco(Endereco endereco) throws Exception {
        enderecoDAO.delete(endereco);
    }

    public void deletarPessoa(Pessoa pessoa) throws Exception {
        pessoaDAO.delete(pessoa);
    }

    public void deletarAluno(Aluno aluno) throws Exception {
        alunoDAO.delete(aluno);
    }

    public void deletarFuncionario(Funcionario funcionario) throws Exception {
        funcionarioDAO.delete(funcionario);
    }

    public List<Pessoa> listarPessoa() throws Exception {
        List<Pessoa> lista = pessoaDAO.list();
        return lista;
    }

    public List<Endereco> listarEndereco() throws Exception {
        List<Endereco> lista = enderecoDAO.list();
        return lista;
    }

    public List<Aluno> listarAluno() throws Exception {
        List<Aluno> lista = alunoDAO.list();
        return lista;
    }

    public List<Funcionario> listarFuncionario() throws Exception {
        List<Funcionario> lista = funcionarioDAO.list();
        return lista;
    }

    public Pessoa buscarPessoa(int id) throws Exception {
        Pessoa pessoa = pessoaDAO.search(id);
        return pessoa;
    }

    public Endereco buscarEndereco(int id) throws Exception {
        Endereco endereco = enderecoDAO.search(id);
        return endereco;
    }

    public Aluno buscarAluno(int id) throws Exception {
        Aluno aluno = alunoDAO.search(id);
        return aluno;
    }

    public Funcionario buscarFuncionario(int id) throws Exception {
        Funcionario funcionario = funcionarioDAO.search(id);
        return funcionario;
    }

    public boolean login(String login, String senha) throws Exception {
        if (funcionarioDAO.verificarLogin(login, senha)) {
            return true;
        }
        return false;
    }
}
