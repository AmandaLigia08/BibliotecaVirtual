/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.factory.ConnectionFactory;
import br.com.factory.DAOFactory;
import br.com.interfaces.IFuncionarioDAO;
import br.com.model.bean.Funcionario;
import br.com.model.bean.Pessoa;
import br.com.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amand
 */
public class FuncionarioDAO implements IFuncionarioDAO {

    private Connection connection;

    @Override
    public boolean create(Funcionario funcionario) throws Exception {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("INSERT INTO funcionario (id, cargo, login, senha) VALUES(?,?,?,?)");
            st.setInt(1, funcionario.getId());
            st.setString(2, funcionario.getCargo());
            st.setString(3, funcionario.getLogin());
            st.setString(4, funcionario.getSenha());

            st.executeUpdate();

            return true;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_INSERIR_FUNCIONARIO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean delete(Funcionario funcionario) throws Exception {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;
        try {
            st = connection.prepareStatement("DELETE FROM funcionario WHERE id = ?");
            st.setInt(1, funcionario.getId());
            st.executeUpdate();

            st = connection.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            st.setInt(1, funcionario.getId());
            st.executeUpdate();
            return true;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_DELETAR_FUNCIONARIO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public List<Funcionario> list() throws Exception {
        List<Funcionario> lista = new ArrayList<>();
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, cargo, login, senha FROM funcionario");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                Pessoa pessoa = DAOFactory.createPessoaDAO().search(funcionario.getId());
                funcionario.setEndereco(pessoa.getEndereco());
                funcionario.setNome(pessoa.getNome());
                funcionario.setNascimento(pessoa.getNascimento());
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                lista.add(funcionario);
            }
            return lista;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_LISTAR_FUNCIONARIO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public Funcionario search(int id) throws Exception {
        Funcionario funcionario = null;
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id, cargo, login, senha FROM funcionario WHERE id=?");

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Pessoa pessoa = DAOFactory.createPessoaDAO().search(id);
                funcionario = new Funcionario();
                funcionario.setId(id);
                funcionario.setNome(pessoa.getNome());
                funcionario.setEndereco(pessoa.getEndereco());
                funcionario.setNascimento(pessoa.getNascimento());
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
            }
            return funcionario;
        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_BUSCAR_FUNCIONARIO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

    }

    @Override
    public void update(Funcionario funcionario) throws Exception {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("UPDATE pessoa SET nome = ?, nascimento = ?, endereco = ? WHERE id = ? ");

            st.setString(1, funcionario.getNome());
            st.setDate(2, new java.sql.Date(funcionario.getNascimento().getTime()));
            st.setInt(3, funcionario.getEndereco().getId());
            st.setInt(4, funcionario.getId());

            st.executeUpdate();

            st = connection.prepareStatement("UPDATE funcionario SET cargo = ?, login = ?, senha = ? WHERE id = ?");

            st.setString(1, funcionario.getCargo());
            st.setString(2, funcionario.getLogin());
            st.setString(3, funcionario.getSenha());
            st.setInt(4, funcionario.getId());

            st.executeUpdate();

        } catch (Exception ex) {
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_EDITAR_FUNCIONARIO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean verificarLogin(String login, String senha) throws Exception {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT * FROM funcionario WHERE login=? AND senha = ?");

            st.setString(1, login);
            st.setString(2, senha);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
