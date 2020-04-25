/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.factory.ConnectionFactory;
import br.com.factory.DAOFactory;
import br.com.model.bean.Livro;
import br.com.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.interfaces.ILivroDAO;

/**
 *
 * @author amand
 */
public class LivroDAO implements ILivroDAO {

    private Connection connection;

    @Override
    public boolean create(Livro livro) throws Exception {

        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("INSERT INTO livro (exemplares, autor, editora, secao, disponiveis,titulo) VALUES (?,?,?,?,?,?)");
            st.setInt(1, livro.getExemplares());
            st.setInt(2, livro.getAutor().getId());
            st.setInt(3, livro.getEditora().getId());
            st.setInt(4, livro.getSecao().getId());
            st.setInt(5, livro.getExemplaresDisponiveis());
            st.setString(6, livro.getTitulo());
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_INSERIR_LIVRO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

    }

    @Override
    public boolean delete(Livro livro) throws Exception {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("DELETE FROM livro WHERE id = ?");
            st.setInt(1, livro.getId());
            st.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_DELETAR_ENDERECO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public List<Livro> list() throws Exception {
        List<Livro> lista = new ArrayList<>();
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("SELECT id,exemplares, autor, editora, secao, disponiveis,titulo FROM public.livro");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setExemplares(rs.getInt("exemplares"));
                livro.setAutor(DAOFactory.createAutorDAO().search(rs.getInt("autor")));
                livro.setEditora(DAOFactory.createEditoraDAO().search(rs.getInt("editora")));
                livro.setSecao(DAOFactory.createSecaoDAO().search(rs.getInt("secao")));
                livro.setExemplaresDisponiveis(rs.getInt("disponiveis"));
                livro.setTitulo(rs.getString("titulo"));
                lista.add(livro);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_LISTAR_LIVRO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }

        return lista;
    }

    @Override
    public Livro search(int id) throws Exception {
        Livro livro = null;
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id,exemplares, autor, editora, secao, disponiveis,titulo FROM livro WHERE id=?;";
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setExemplares(rs.getInt("exemplares"));
                livro.setAutor(DAOFactory.createAutorDAO().search(rs.getInt("autor")));
                livro.setEditora(DAOFactory.createEditoraDAO().search(rs.getInt("editora")));
                livro.setSecao(DAOFactory.createSecaoDAO().search(rs.getInt("secao")));
                livro.setExemplaresDisponiveis(rs.getInt("disponiveis"));
                livro.setTitulo(rs.getString("titulo"));
            }
            return livro;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_BUSCAR_LIVRO));
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }
    }

    @Override
    public void update(Livro livro) throws Exception {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("UPDATE livro SET exemplares = ?, autor = ?, disponiveis = ?, secao = ?, editora = ?,titulo = ? WHERE id = ? ");
            st.setInt(1, livro.getExemplares());
            st.setInt(2, livro.getAutor().getId());
            st.setInt(3, livro.getExemplaresDisponiveis());
            st.setInt(4, livro.getSecao().getId());
            st.setInt(5, livro.getEditora().getId());
            st.setString(6, livro.getTitulo());
            st.setInt(7, livro.getId());
            st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_EDITAR_LIVRO));
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    public void limparDados() throws Exception {

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "delete from livro";
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(Properties.getStringErroValue(Properties.ERRO_DELETAR_LIVRO));
        } finally {
            connection.close();
        }

    }
}
