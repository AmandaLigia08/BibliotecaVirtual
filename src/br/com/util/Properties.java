/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.util.ResourceBundle;

/**
 *
 * @author amand
 */
public class Properties {

    public static final ResourceBundle RESOURCE_CONFIGURACAO = ResourceBundle.getBundle("br\\com\\properties\\configuracao");
    public static final ResourceBundle RESOURCE_STRINGS_ERRO = ResourceBundle.getBundle("br\\com\\properties\\stringsErro");
    public static final ResourceBundle RESOURCE_STRINGS_SUCESSO = ResourceBundle.getBundle("br\\com\\properties\\stringsSucesso");

    public static final String JDBC_DRIVER = "jdbc_driver";
    public static final String JDBC_URL = "jdbc_url";
    public static final String JDBC_USER = "jdbc_user";
    public static final String JDBC_PASS = "jdbc_password";
    public static final String IREPORT = "iReport";

    public static String getConfiguracaoValue(String chave) {
        return RESOURCE_CONFIGURACAO.getString(chave);
    }

    public static final String ERRO_INSERIR_SECAO = "ERRO_INSERIR_SECAO";
    public static final String ERRO_EDITAR_SECAO = "ERRO_EDITAR_SECAO ";
    public static final String ERRO_DELETAR_SECAO = "ERRO_DELETAR_SECAO";
    public static final String ERRO_BUSCAR_SECAO = "ERRO_BUSCAR_SECAO";
    public static final String ERRO_LISTAR_SECAO = "ERRO_LISTAR_SECAO";

    public static final String ERRO_INSERIR_EDITORA = "ERRO_INSERIR_EDITORA";
    public static final String ERRO_EDITAR_EDITORA = "ERRO_EDITAR_EDITORA";
    public static final String ERRO_DELETAR_EDITORA = "ERRO_DELETAR_EDITORA";
    public static final String ERRO_BUSCAR_EDITORA = "ERRO_BUSCAR_EDITORA";
    public static final String ERRO_LISTAR_EDITORA = "ERRO_LISTAR_EDITORA";

    public static final String ERRO_INSERIR_AUTOR = "ERRO_INSERIR_AUTOR";
    public static final String ERRO_EDITAR_AUTOR = "ERRO_EDITAR_AUTOR";
    public static final String ERRO_DELETAR_AUTOR = "ERRO_DELETAR_AUTOR";
    public static final String ERRO_BUSCAR_AUTOR = "ERRO_BUSCAR_AUTOR";
    public static final String ERRO_LISTAR_AUTOR = "ERRO_LISTAR_AUTOR";

    public static final String ERRO_INSERIR_LIVRO = "ERRO_INSERIR_LIVRO";
    public static final String ERRO_EDITAR_LIVRO = "ERRO_EDITAR_LIVRO";
    public static final String ERRO_DELETAR_LIVRO = "ERRO_DELETAR_LIVRO";
    public static final String ERRO_BUSCAR_LIVRO = "ERRO_BUSCAR_LIVRO";
    public static final String ERRO_LISTAR_LIVRO = "ERRO_LISTAR_LIVRO";

    public static final String ERRO_INSERIR_ENDERECO = "ERRO_INSERIR_ENDERECO";
    public static final String ERRO_EDITAR_ENDERECO = "ERRO_EDITAR_ENDERECO";
    public static final String ERRO_DELETAR_ENDERECO = "ERRO_DELETAR_ENDERECO";
    public static final String ERRO_BUSCAR_ENDERECO = "ERRO_BUSCAR_ENDERECO";
    public static final String ERRO_LISTAR_ENDERECO = "ERRO_LISTAR_ENDERECO";

    public static final String ERRO_INSERIR_PESSOA = "ERRO_INSERIR_PESSOA";
    public static final String ERRO_EDITAR_PESSOA = "ERRO_EDITAR_PESSOA";
    public static final String ERRO_DELETAR_PESSOA = "ERRO_DELETAR_PESSOA";
    public static final String ERRO_BUSCAR_PESSOA = "ERRO_BUSCAR_PESSOA";
    public static final String ERRO_LISTAR_PESSOA = "ERRO_LISTAR_PESSOA";

    public static final String ERRO_INSERIR_ALUNO = "ERRO_INSERIR_ALUNO";
    public static final String ERRO_EDITAR_ALUNO = "ERRO_EDITAR_ALUNO";
    public static final String ERRO_DELETAR_ALUNO = "ERRO_DELETAR_ALUNO";
    public static final String ERRO_BUSCAR_ALUNO = "ERRO_BUSCAR_ALUNO";
    public static final String ERRO_LISTAR_ALUNO = "ERRO_LISTAR_ALUNO";

    public static final String ERRO_INSERIR_FUNCIONARIO = "ERRO_INSERIR_FUNCIONARIO";
    public static final String ERRO_EDITAR_FUNCIONARIO = "ERRO_EDITAR_FUNCIONARIO";
    public static final String ERRO_DELETAR_FUNCIONARIO = "ERRO_DELETAR_FUNCIONARIO";
    public static final String ERRO_BUSCAR_FUNCIONARIO = "ERRO_BUSCAR_FUNCIONARIO";
    public static final String ERRO_LISTAR_FUNCIONARIO = "ERRO_LISTAR_FUNCIONARIO";

    public static String getStringErroValue(String chave) {
        return RESOURCE_STRINGS_ERRO.getString(chave);
    }

    public static final String SUCESSO_INSERIR_SECAO = "SUCESSO_INSERIR_SECAO";
    public static final String SUCESSO_EDITAR_SECAO = "SUCESSO_EDITAR_SECAO";
    public static final String SUCESSO_DELETAR_SECAO = "SUCESSO_DELETAR_SECAO";
    public static final String SUCESSO_BUSCAR_SECAO = "SUCESSO_BUSCAR_SECAO";
    public static final String SUCESSO_LISTAR_SECAO = "SUCESSO_LISTAR_SECAO";

    public static final String SUCESSO_INSERIR_EDITORA = "SUCESSO_INSERIR_EDITORA";
    public static final String SUCESSO_EDITAR_EDITORA = "SUCESSO_EDITAR_EDITORA";
    public static final String SUCESSO_DELETAR_EDITORA = "SUCESSO_DELETAR_EDITORA";
    public static final String SUCESSO_BUSCAR_EDITORA = "SUCESSO_BUSCAR_EDITORA";
    public static final String SUCESSO_LISTAR_EDITORA = "SUCESSO_LISTAR_EDITORA";

    public static final String SUCESSO_INSERIR_AUTOR = "SUCESSO_INSERIR_AUTOR";
    public static final String SUCESSO_EDITAR_AUTOR = "SUCESSO_EDITAR_AUTOR";
    public static final String SUCESSO_DELETAR_AUTOR = "SUCESSO_DELETAR_AUTOR";
    public static final String SUCESSO_BUSCAR_AUTOR = "SUCESSO_BUSCAR_AUTOR";
    public static final String SUCESSO_LISTAR_AUTOR = "SUCESSO_LISTAR_AUTOR";

    public static final String SUCESSO_INSERIR_LIVRO = "SUCESSO_INSERIR_LIVRO";
    public static final String SUCESSO_EDITAR_LIVRO = "SUCESSO_EDITAR_LIVRO";
    public static final String SUCESSO_DELETAR_LIVRO = "SUCESSO_DELETAR_LIVRO";
    public static final String SUCESSO_BUSCAR_LIVRO = "SUCESSO_BUSCAR_LIVRO";
    public static final String SUCESSO_LISTAR_LIVRO = "SUCESSO_LISTAR_LIVRO";

    public static final String SUCESSO_INSERIR_ENDERECO = "SUCESSO_INSERIR_ENDERECO";
    public static final String SUCESSO_EDITAR_ENDERECO = "SUCESSO_EDITAR_ENDERECO";
    public static final String SUCESSO_DELETAR_ENDERECO = "SUCESSO_DELETAR_ENDERECO";
    public static final String SUCESSO_BUSCAR_ENDERECO = "SUCESSO_BUSCAR_ENDERECO";
    public static final String SUCESSO_LISTAR_ENDERECO = "SUCESSO_LISTAR_ENDERECO";

    public static final String SUCESSO_INSERIR_PESSOA = "SUCESSO_INSERIR_PESSOA";
    public static final String SUCESSO_EDITAR_PESSOA = "SUCESSO_EDITAR_PESSOA";
    public static final String SUCESSO_DELETAR_PESSOA = "SUCESSO_DELETAR_PESSOA";
    public static final String SUCESSO_BUSCAR_PESSOA = "SUCESSO_BUSCAR_PESSOA";
    public static final String SUCESSO_LISTAR_PESSOA = "SUCESSO_LISTAR_PESSOA";

    public static final String SUCESSO_INSERIR_ALUNO = "SUCESSO_INSERIR_ALUNO";
    public static final String SUCESSO_EDITAR_ALUNO = "SUCESSO_EDITAR_ALUNO";
    public static final String SUCESSO_DELETAR_ALUNO = "SUCESSO_DELETAR_ALUNO";
    public static final String SUCESSO_BUSCAR_ALUNO = "SUCESSO_BUSCAR_ALUNO";
    public static final String SUCESSO_LISTAR_ALUNO = "sucesso_listar_aluno";

    public static final String SUCESSO_INSERIR_FUNCIONARIO = "SUCESSO_INSERIR_FUNCIONARIO";
    public static final String SUCESSO_EDITAR_FUNCIONARIO = "SUCESSO_EDITAR_FUNCIONARIO";
    public static final String SUCESSO_DELETAR_FUNCIONARIO = "SUCESSO_DELETAR_FUNCIONARIO";
    public static final String SUCESSO_BUSCAR_FUNCIONARIO = "SUCESSO_BUSCAR_FUNCIONARIO";
    public static final String SUCESSO_LISTAR_FUNCIONARIO = "SUCESSO_LISTAR_FUNCIONARIO";

    public static String getStringSucessoValue(String chave) {
        return RESOURCE_STRINGS_SUCESSO.getString(chave);
    }
}
