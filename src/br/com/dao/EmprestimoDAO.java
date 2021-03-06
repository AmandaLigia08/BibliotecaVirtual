/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.facade.BibliotecaFacadeLivro;
import br.com.facade.BibliotecaFacadePessoa;
import br.com.interfaces.IEmprestimoDAO;
import br.com.factory.ConnectionFactory;
import br.com.model.bean.Aluno;
import br.com.model.bean.Emprestimo;
import br.com.model.bean.Livro;
import br.com.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author amand
 */
public class EmprestimoDAO implements IEmprestimoDAO {

    private Connection connection;
    private BibliotecaFacadePessoa facadePessoa = new BibliotecaFacadePessoa();
    private BibliotecaFacadeLivro facadeLivro = new BibliotecaFacadeLivro();

    @Override
    public boolean create(Emprestimo emprestimo) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO emprestimo(reserva,data,dataPrevista,dateentrega, aluno, livro) VALUES (?,?,?,?,?,?)";
            st = connection.prepareStatement(sql);

            st.setBoolean(1, emprestimo.getReserva());
            st.setDate(2, Util.dateParaSql(emprestimo.getData()));
            st.setDate(3, Util.dateParaSql(emprestimo.getDataPrevista()));
            st.setDate(4, null);
            st.setInt(5, emprestimo.getAluno().getId());
            st.setInt(6, emprestimo.getLivro().getId());
            st.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public boolean update(Emprestimo emprestimo) {
        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "UPDATE emprestimo SET reserva = ?,data= ?,dataPrevista=?,dateentrega=?, aluno=?, livro=? WHERE id=?;";
            st = connection.prepareStatement(sql);

            st.setBoolean(1, emprestimo.getReserva());
            st.setDate(2, Util.dateParaSql(emprestimo.getData()));
            st.setDate(3, Util.dateParaSql(emprestimo.getDataPrevista()));
            st.setDate(4, Util.dateParaSql(emprestimo.getEntrega()));
            st.setInt(5, emprestimo.getAluno().getId());
            st.setInt(6, emprestimo.getLivro().getId());
            st.setInt(7, emprestimo.getId());

            st.executeUpdate();

            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }

    @Override
    public List<Emprestimo> list() {
        List<Emprestimo> lista = new ArrayList<>();

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id,reserva,data,dataPrevista,dateentrega,aluno,livro FROM Emprestimo;";
            st = connection.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                int id = rs.getInt("id");
                boolean reserva = rs.getBoolean("reserva");
                Date data = rs.getDate("data");
                Date dataP = rs.getDate("dataPrevista");
                Date entrega = rs.getDate("dateentrega");
                int idAluno = rs.getInt("aluno");
                int idLivro = rs.getInt("livro");

                emprestimo.setId(id);
                emprestimo.setReserva(reserva);
                emprestimo.setData(data);
                emprestimo.setDataPrevista(dataP);
                emprestimo.setEntrega(entrega);
                emprestimo.setAluno(facadePessoa.buscarAluno(idAluno));
                emprestimo.setLivro(facadeLivro.buscarLivro(idLivro));

                lista.add(emprestimo);
            }

        } catch (Exception ex) {
            //
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }

        return lista;
    }

    @Override
    public Emprestimo search(int id) {
        Emprestimo emprestimo = null;

        connection = ConnectionFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id,reserva,data,dataPrevista,dateentrega, aluno,livro FROM emprestimo WHERE id=?;";
            st = connection.prepareStatement(sql);

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                emprestimo = new Emprestimo();
                emprestimo.setId(rs.getInt("id"));
                emprestimo.setReserva(rs.getBoolean("reserva"));
                emprestimo.setData(rs.getDate("data"));
                emprestimo.setDataPrevista(rs.getDate("dataPrevista"));
                emprestimo.setEntrega(rs.getDate("dateentrega"));
                Aluno aluno = facadePessoa.buscarAluno(rs.getInt("aluno"));
                emprestimo.setAluno(aluno);
                Livro livro = facadeLivro.buscarLivro(rs.getInt("livro"));
                emprestimo.setLivro(livro);
            }

            return emprestimo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, st, rs);
        }
    }

    @Override
    public boolean delete(Emprestimo emprestimo) {
        connection = ConnectionFactory.getConnection();

        PreparedStatement st = null;

        try {
            String sql = "DELETE FROM emprestimo WHERE id=?;";

            st = connection.prepareStatement(sql);

            st.setInt(1, emprestimo.getId());

            st.executeUpdate();

            return true;

        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, st);
        }
    }
}
