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
public class Emprestimo {

    private int id;
    private boolean reserva;
    private Date data;
    private Date dataPrevista;
    private Date Entrega;
    private Aluno aluno;
    private Livro livro;

    public Emprestimo() {
    }

    public Emprestimo(int id, boolean reserva, Date data, Date dataPrevista, Date Entrega) {
        this.id = id;
        this.reserva = reserva;
        this.data = data;
        this.dataPrevista = dataPrevista;
        this.Entrega = Entrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getReserva() {
        return reserva;
    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Date getEntrega() {
        return Entrega;
    }

    public void setEntrega(Date Entrega) {
        this.Entrega = Entrega;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String toString() {
        return "EMPRESTIMO{" + "ID=" + id + ", RESERVA=" + reserva + ", DATA=" + data + ", DATA PREVISTA=" + dataPrevista + ", ENTREGA=" + Entrega + ", ALUNO=" + aluno + ", LIVRO=" + livro + '}';
    }

}
