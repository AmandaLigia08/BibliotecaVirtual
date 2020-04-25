/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.bean;

import java.util.Date;

/**
 *
 * @author amand
 */
public class Aluno {

    private int id;
    private int matricula;
    private String nome;
    private Date nascimento;
    private Endereco endereco;
    private String curso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String toString() {
        return "ALUNO {" + "ID=" + id + ", MATRICULA=" + matricula + ", NOME=" + nome + ", NASCIMENTO=" + nascimento + ", ENDERECO=" + endereco + ", CURSO=" + curso + '}';
    }
}
