/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.factory;

import br.com.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amand
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            Class.forName(Properties.getConfiguracaoValue(Properties.JDBC_DRIVER));

            return DriverManager.getConnection(
                    //url
                    Properties.getConfiguracaoValue(Properties.JDBC_URL),
                    //user
                    Properties.getConfiguracaoValue(Properties.JDBC_USER),
                    //pass
                    Properties.getConfiguracaoValue(Properties.JDBC_PASS));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("ERRO DE CONEXAO COM O BANCO DE DADOS - VERIFIQUE.... ", e);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedSta) {

        closeConnection(connection);

        try {
            if (preparedSta != null) {
                preparedSta.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedSta, ResultSet resultSet) {

        closeConnection(connection, preparedSta);

        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
