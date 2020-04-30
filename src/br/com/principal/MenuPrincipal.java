/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.principal;

import br.com.facade.BibliotecaFacadeEmprestimo;
import br.com.facade.BibliotecaFacadeLivro;
import br.com.facade.BibliotecaFacadePessoa;
import br.com.iReport.IReport;
import br.com.model.bean.Aluno;
import br.com.model.bean.Autor;
import br.com.model.bean.Editora;
import br.com.model.bean.Emprestimo;
import br.com.model.bean.Endereco;
import br.com.model.bean.Funcionario;
import br.com.model.bean.Livro;
import br.com.model.bean.Pessoa;
import br.com.model.bean.Secao;
import br.com.util.Properties;
import br.com.util.Util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author amand
 */
public class MenuPrincipal {

    /**
     * @param args the command line arguments
     */
    private Scanner sc = new Scanner(System.in);
    private BibliotecaFacadePessoa facadePessoa = new BibliotecaFacadePessoa();
    private BibliotecaFacadeLivro facadeLivro = new BibliotecaFacadeLivro();
    private BibliotecaFacadeEmprestimo facadeEmprestimo = new BibliotecaFacadeEmprestimo();
    
    public void executar() throws Exception {
        String login,senha;
        do{
            
            System.out.println("INFORME O LOGIN:");
            login = sc.nextLine();
            System.out.println("INFORME A SENHA:");
            senha = sc.nextLine();
            
        }while(!facadePessoa.login(login, senha));
        
        int op;
        
        do{
            System.out.println("'--- MENU PRINCIPAL ---'");
            System.out.println("1- CADASTRAR: ");
            System.out.println("2- EDITAR: ");
            System.out.println("3- LISTAR: ");
            System.out.println("4- BUSCAR: ");
            System.out.println("5- REMOVER: ");
            System.out.println("6- EMPRESTIMO: ");
            System.out.println("7- RELATORIO: ");
            System.out.println("0- FINALIZAR O PROGRAMA.... ");
            op=sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:{
                    menuCadastrar();
                    break;
                }
                
                case 2:{
                    menuEditar();
                    break;
                }
                
                case 3:{
                    menuListar();
                    break;
                }
                
                case 4:{
                    menuBuscar();
                    break;
                }
                case 5:{
                    menuDeletar();
                    break;
                }
                
                case 6:{
                    MenuEmprestimo();
                    break;
                }
                
                case 7:{
                    IReport rp = new IReport();
                    
                    rp.iReport();
                    
                    break;
                }
                
                case 0:{
                    System.out.println("ENCERRANDO O PROGRAMA....");
                    break;
                }
                
                default:{
                    System.out.println("OPCAO INVALIDA TENTE NOVAMENTE....!");
                    break;
                }
                
            }
        }while(op!=0);
        
        
    }

    private void menuCadastrar(){
        int opCadastrar;
        System.out.println("1- CADASTRAR ENDERECO: ");
        System.out.println("2- CADASTRAR ALUNO: ");
        System.out.println("3- CADASTRAR FUNCIONARIO: ");
        System.out.println("4- CADASTRAR AUTOR: ");
        System.out.println("5- CADASTRAR EDITORA: ");
        System.out.println("6- CADASTRAR SECAO: ");
        System.out.println("7- CADASTRAR LIVRO: ");
        System.out.println("0- SAIR: ");
        opCadastrar = sc.nextInt();
        sc.nextLine();
        switch(opCadastrar){
                case 1:{
                    System.out.println("INFORME A CIDADE: ");
                    String cidade = sc.nextLine();
                    System.out.println("INFORME A RUA: ");
                    String rua = sc.nextLine();
                    System.out.println("INFORME O NUMERO: ");
                    String numero = sc.nextLine();
                    Endereco endereco = new Endereco();
                    endereco.setCidade(cidade);
                    endereco.setRua(rua);
                    endereco.setNumero(numero);
                    
                    try{
                        facadePessoa.cadastrarEndereco(endereco);
                        System.out.println(Properties.SUCESSO_INSERIR_ENDERECO);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 2:{
                    System.out.println("INFORME O ID: ");
                    int idAluno = sc.nextInt();
                    sc.nextLine();
                    System.out.println("INFORME O NOME: ");
                    String nome = sc.nextLine();
                    System.out.println("INFORME A DATA DE NASCIMENTO: ");
                    String dataNascimento = sc.nextLine();
                    System.out.println("INFORME A MATRICULA: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.println("INFORME O CURSO: ");
                    String curso = sc.nextLine();
                    System.out.println("INFORME O ID DO ENDERECO:");
                    int idEndereco = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Endereco e = facadePessoa.buscarEndereco(idEndereco);
                        if(e == null){
                            System.out.println("ENDERECO NÃO ENCONTRADO... !");
                        }
                        else{
                            Pessoa pessoa =  new Pessoa();
                            pessoa.setId(idAluno);
                            pessoa.setNome(nome);
                            pessoa.setNascimento(Util.stringToDate(dataNascimento));
                            pessoa.setEndereco(e);
                            facadePessoa.cadastrarPessoa(pessoa);

                            Aluno aluno = new Aluno();
                            aluno.setId(idAluno);
                            aluno.setNome(nome);
                            aluno.setNascimento(Util.stringToDate(dataNascimento));
                            aluno.setEndereco(e);
                            aluno.setCurso(curso);
                            aluno.setMatricula(matricula);
                            facadePessoa.cadastrarAluno(aluno);
                            System.out.println(Properties.SUCESSO_INSERIR_ALUNO);
                        }
                     }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("INFORME O ID DO FUNCIONARIO: ");
                    int idFuncionario = sc.nextInt();
                    sc.nextLine();
                    System.out.println("INFORME O NOME: ");
                    String nome = sc.nextLine();
                    System.out.println("INFORME A DATA DE NASCIMENTO: ");
                    String dataNascimento = sc.nextLine();
                    System.out.println("INFORME O CARGO: ");
                    String cargo = sc.nextLine();
                    System.out.println("INFORME O LOGIN: ");
                    String login = sc.nextLine();
                    System.out.println("INFORME A SENHA: ");
                    String senha = sc.nextLine();
                    System.out.println("INFORME O ID DO ENDERECO: ");
                    int idEndereco = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Endereco e = facadePessoa.buscarEndereco(idEndereco);
                        if(e == null){
                            System.out.println("ENDERECO NÃO ENCONTRADO!..... ");
                        }
                        else{
                            Pessoa pessoa =  new Pessoa();
                            pessoa.setId(idFuncionario);
                            pessoa.setNome(nome);
                            pessoa.setNascimento(Util.stringToDate(dataNascimento));
                            pessoa.setEndereco(e);
                            facadePessoa.cadastrarPessoa(pessoa);

                            Funcionario funcionario = new Funcionario();
                            funcionario.setId(pessoa.getId());
                            funcionario.setCargo(cargo);
                            funcionario.setLogin(login);
                            funcionario.setSenha(senha);
                            facadePessoa.cadastrarFuncionario(funcionario);
                            System.out.println(Properties.SUCESSO_INSERIR_FUNCIONARIO);
                        }
                     }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("INFORME O NOME DO AUTOR: ");
                    String nome = sc.nextLine();
                    
                    Autor autor = new Autor();
                    autor.setNome(nome);
                    try{
                        facadeLivro.cadastrarAutor(autor);
                        System.out.println(Properties.SUCESSO_INSERIR_AUTOR);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 5:{
                    System.out.println("INFORME O NOME DA EDITORA: ");
                    String nome = sc.nextLine();
                    
                    Editora editora = new Editora();
                    editora.setNome(nome);
                    try{
                        facadeLivro.cadastrarEditora(editora);
                        System.out.println(Properties.SUCESSO_INSERIR_EDITORA);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    System.out.println("INFORME A DESCRICAO DA SESSAO: ");
                    String descricao = sc.nextLine();
                    
                    Secao secao = new Secao();
                    secao.setDescricao(descricao);
                    try{
                        facadeLivro.cadastrarSecao(secao);
                        System.out.println(Properties.SUCESSO_INSERIR_SECAO);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 7:{
                    try{
                        System.out.println("INFORME O TITULO DO LIVRO: ");
                        String titulo = sc.nextLine();
                        System.out.println("INFORME O ID DO AUTOR: ");
                        int idAutor = sc.nextInt();
                        sc.nextLine();
                        System.out.println("INFORME O ID DA EDITORA: ");
                        int idEditora = sc.nextInt();
                        sc.nextLine();
                        System.out.println("INFORME O ID DA SECAO: ");
                        int idSecao = sc.nextInt();
                        sc.nextLine();
                        Secao secao = facadeLivro.buscarSecao(idSecao);
                        Editora editora = facadeLivro.buscarEditora(idEditora);
                        Autor autor = facadeLivro.buscarAutor(idAutor);
                        
                        if(editora == null || secao == null || autor == null){
                            System.out.println("DADOS INVALIDOS!...... ");
                        }
                       
                        else{
                            System.out.println("INFORME O NUMERO DE EXEMPLARES: ");
                            int numExemplares = sc.nextInt();
                            sc.nextLine();
                            
                            Livro livro = new Livro();
                            livro.setTitulo(titulo);
                            livro.setAutor(autor);
                            livro.setEditora(editora);
                            livro.setSecao(secao);
                            livro.setExemplares(numExemplares);
                            livro.setExemplaresDisponiveis(numExemplares);
                            
                            facadeLivro.cadastrarLivro(livro);
                            System.out.println(Properties.SUCESSO_INSERIR_LIVRO);
                        }
                    
                    }
                    catch (Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 0:{
                    System.out.println("FECHANDO O PROGRAMA.....");
                }
                
                default:{
                    System.out.println("OPCÃO INCORRENTA");
                    break;
                }
                
            }     
    }
    
    private void menuEditar(){
        System.out.println("1- EDITAR ENDERECO: ");
        System.out.println("2- EDITAR ALUNO: ");
        System.out.println("3- EDITAR FUNCIONARIO: ");
        System.out.println("4- EDITAR AUTOR: ");
        System.out.println("5- EDITAR EDITORA: ");
        System.out.println("6- EEDITAR SECAO: ");
        System.out.println("7- EDITAR LIVRO: ");
        System.out.println("0- SAIR: ");
        int opEditar = sc.nextInt();
        sc.nextLine();
        switch(opEditar){
                case 1:{
                    System.out.println("INFORME O ID DO ENDERECO:");
                    int idEndereco = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                        if(endereco == null){
                            System.out.println("ENDERECO NÃO ENCONTRADO");
                        }
                        else{
                            System.out.println("INFORME A CIDADE: ");
                            String cidade = sc.nextLine();
                            System.out.println("INFORME A RUA: ");
                            String rua = sc.nextLine();
                            System.out.println("INFORME O NUMERO: ");
                            String numero = sc.nextLine();

                            endereco.setCidade(cidade);
                            endereco.setRua(rua);
                            endereco.setNumero(numero);

                            facadePessoa.editarEndereco(endereco);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    
                    break;
                }
                
                case 2:{
                    System.out.println("INFORME O ID DO ALUNO: ");
                    int idAluno = sc.nextInt();
                    sc.nextLine();
                    try{
                        Aluno aluno = facadePessoa.buscarAluno(idAluno);
                        if(aluno == null){
                            System.out.println("ALUNO NÃO ENCONTRADO!....");
                        }
                        else{
                            System.out.println("INFORME O NOME: ");
                            String nome = sc.nextLine();
                            System.out.println("INFORME A DATA DE NASCIMENTO: ");
                            String dataNascimento = sc.nextLine();
                            System.out.println("INFORME A MATRICULA: ");
                            int matricula = sc.nextInt();
                            sc.nextLine();
                            System.out.println("INFORME O CURSO: ");
                            String curso = sc.nextLine();
                            System.out.println("INFORME O ID DO ENDERECO: ");
                            int idEndereco = sc.nextInt();
                            sc.nextLine();
                            
                            Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                            if(endereco == null){
                                System.out.println("ENDERECO NÃO ENCONTRADO!.....");
                            }
                            else{
                                Pessoa pessoa =  new Pessoa();
                                pessoa.setNome(nome);
                                pessoa.setNascimento(Util.stringToDate(dataNascimento));
                                pessoa.setEndereco(endereco);
                                facadePessoa.editarPessoa(pessoa);

                                aluno.setId(pessoa.getId());
                                aluno.setCurso(curso);
                                aluno.setMatricula(matricula);
                                facadePessoa.editarAluno(aluno);
                                }
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("INFORME O ID DO FUNCIONARIO: ");
                    int idFuncionario = sc.nextInt();
                    sc.nextLine();
                    try{
                        Funcionario funcionario = facadePessoa.buscarFuncionario(idFuncionario);
                        if(funcionario == null){
                            System.out.println("FUNCIONARIO NÃO ENCONTRADO! ");
                        }
                        else{
                            System.out.println("INFORME O NOME: ");
                            String nome = sc.nextLine();
                            System.out.println("INFORME A DATA DE NASCIMENTO: ");
                            String dataNascimento = sc.nextLine();
                            System.out.println("INFORME O CARGO: ");
                            String cargo = sc.nextLine();
                            System.out.println("INFORME O LOGIN: ");
                            String login = sc.nextLine();
                            System.out.println("INFORME A SENHA: ");
                            String senha = sc.nextLine();
                            System.out.println("INFORME O ID DO ENDERECO: ");
                            int idEndereco = sc.nextInt();
                            sc.nextLine();
                            
                            Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                            if(endereco == null){
                                System.out.println("ENDERECO NÃO ENCONTRADO! ");
                            }
                            else{
                                Pessoa pessoa =  new Pessoa();
                                pessoa.setNome(nome);
                                pessoa.setNascimento(Util.stringToDate(dataNascimento));
                                pessoa.setEndereco(endereco);
                                facadePessoa.editarPessoa(pessoa);

                                funcionario.setCargo(cargo);
                                funcionario.setLogin(login);
                                funcionario.setSenha(senha);
                                facadePessoa.editarFuncionario(funcionario);
                                }
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("INFORME O ID DO AUTOR: ");
                    int idAutor = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Autor autor = facadeLivro.buscarAutor(idAutor);
                        if(autor == null){
                            System.out.println("AUTOR NÃO ENCONTRADO! ");
                        }
                        else{
                            System.out.println("INFORME O NOME DO AUTOR: ");
                            String nome = sc.nextLine();
                            autor.setNome(nome);
                            
                            facadeLivro.editarAutor(autor);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 5:{
                    System.out.println("INFORME O ID DA EDITORA: ");
                    int idEditora = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Editora editora = facadeLivro.buscarEditora(idEditora);
                        if(editora == null){
                            System.out.println("EDITORA NÃO ENCONTRADA! ");
                        }
                        else{
                            System.out.println("INFORME O NOME DA EDITORA: ");
                            String nome = sc.nextLine();
                            editora.setNome(nome);
                            facadeLivro.editarEditora(editora);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    System.out.println("INFORME O ID DA SECAO: ");
                    int idSecao = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Secao secao = facadeLivro.buscarSecao(idSecao);
                        if(secao == null){
                            System.out.println("SECAO NÃO ENCONTRADA!");
                        }
                        else{
                            System.out.println("INFORME DESCRICAO DA SECAO: ");
                            String descricao = sc.nextLine();
                            secao.setDescricao(descricao);
                            
                            facadeLivro.editarSecao(secao);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 7:{
                    System.out.println("INFORME O ID DO LIVRO: ");
                    int idLivro = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Livro livro = facadeLivro.buscarLivro(idLivro);
                        if(livro == null){
                            System.out.println("LIVRO NÃO ENCONTRADO! ");
                        }
                        else{
                            System.out.println("INFORME O TITULO DO LIVRO: ");
                            String titulo = sc.nextLine();
                            System.out.println("INFORME O ID DO AUTOR: ");
                            int idAutor = sc.nextInt();  
                            sc.nextLine();
                            System.out.println("INFORME O ID DA EDITORA: ");
                            int idEditora = sc.nextInt();
                            sc.nextLine();
                            System.out.println("INFORME O ID DA SECAO: ");
                            int idSecao = sc.nextInt();
                            sc.nextLine();
                            
                            Secao secao = facadeLivro.buscarSecao(idSecao);
                            Editora editora = facadeLivro.buscarEditora(idEditora);
                            Autor autor = facadeLivro.buscarAutor(idAutor);

                            if(editora == null || secao == null || autor == null){
                                System.out.println("DADOS INVALIDOS! ");
                            }

                            else{
                                System.out.println("INFORME O NUMERO DE EXEMPLARES: ");
                                int numExemplares = sc.nextInt();
                                sc.nextLine();
                                
                                livro.setTitulo(titulo);
                                livro.setAutor(autor);
                                livro.setEditora(editora);
                                livro.setSecao(secao);
                                livro.setExemplares(numExemplares);
                                livro.setExemplaresDisponiveis(numExemplares);
                                
                                facadeLivro.editarLivro(livro);
                            }
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 0:{
                    System.out.println("SAINDO... ");
                    break;
                }
                
                default:{
                    System.out.println("OPCAO INVALIDA!.... ");
                    break;
                }
                
            }
    }
    
    private void menuBuscar(){
        System.out.println("1- BUSCAR ENDERECO: ");
        System.out.println("2- BUSCAR ALUNO: ");
        System.out.println("3- BUSCAR FUNCIONARIO: ");
        System.out.println("4- BUSCAR AUTOR: ");
        System.out.println("5- BUSCAR EDITORA: ");
        System.out.println("6- BUSCAR SECAO: ");
        System.out.println("7- BUSCAR LIVRO: ");
        System.out.println("0- SAIR: ");
        int opEditar = sc.nextInt();
        sc.nextLine();
        
        switch(opEditar){
                case 1:{
                    System.out.println("INFORME O ID DO ENDERECO: ");
                    int idEndereco = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                        if(endereco == null){
                            System.out.println("ENDERECO NÃO ENCONTRADO ");
                        }
                        else{
                            System.out.println(endereco.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 2:{
                    System.out.println("INFORME O ID DO ALUNO: ");
                    int idAluno = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Aluno aluno = facadePessoa.buscarAluno(idAluno);
                        if(aluno == null){
                            System.out.println("ALUNO NÃO ENCONTRADO! ");
                        }
                        else{
                            System.out.println(aluno.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("INFORME O ID DO FUNCIONARIO: ");
                    int idFuncionario = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Funcionario funcionario = facadePessoa.buscarFuncionario(idFuncionario);
                        if(funcionario == null){
                            System.out.println("FUNCIONARIO NÃO ENCONTRADO! ");
                        }
                        else{
                            System.out.println(funcionario.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("INFORME O ID DO AUTOR: ");
                    int idAutor = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Autor autor = facadeLivro.buscarAutor(idAutor);
                        if(autor == null){
                            System.out.println("AUTOR NÃO ENCONTRADO! ");
                        }
                        else{
                            System.out.println(autor.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 5:{
                    System.out.println("INFORME O ID DA EDITORA: ");
                    int idEditora = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Editora editora = facadeLivro.buscarEditora(idEditora);
                        if(editora == null){
                            System.out.println("EDITORA NÃO ENCONTRADA! ");
                        }
                        else{
                            System.out.println(editora.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    System.out.println("INFORME O ID DA SECAO: ");
                    int idSecao = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Secao secao = facadeLivro.buscarSecao(idSecao);
                        if(secao == null){
                            System.out.println("SECAO NÃO ENCONTRADA! ");
                        }
                        else{
                            System.out.println(secao.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 7:{
                    System.out.println("INFORME O ID DO LIVRO: ");
                    int idLivro = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Livro livro = facadeLivro.buscarLivro(idLivro);
                        if(livro == null){
                            System.out.println("LIVRO NÃO ENCONTRADO!");
                        }
                        else{
                            System.out.println(livro.toString());
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 0:{
                    System.out.println("SAINDO.....");
                    break;
                }
                
                default:{
                    System.out.println("OPCAO INVALIDA!...... ");
                    break;
                }
                
            }
    }
    
    private void menuListar(){
        System.out.println("1- LISTAR ENDERECO: ");
        System.out.println("2- LISTAR ALUNO: ");
        System.out.println("3- LISTAR FUNCIONARIO: ");
        System.out.println("4- LISTAR AUTOR: ");
        System.out.println("5- LISTAR EDITORA: ");
        System.out.println("6- LISTAR SECAO: ");
        System.out.println("7- LISTAR LIVRO: ");
        System.out.println("0- SAIR: ");
        int opListar = sc.nextInt();
        sc.nextLine();
        
        switch(opListar){
                case 1:{
                    try{
                        List<Endereco> lista = facadePessoa.listarEndereco();
                        for(Endereco e:lista){
                            System.out.println(e.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 2:{
                    try{
                        List<Aluno> lista = facadePessoa.listarAluno();
                        for(Aluno a:lista){
                            System.out.println(a.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 3:{
                    try{
                        List<Funcionario> lista = facadePessoa.listarFuncionario();
                        for(Funcionario f:lista){
                            System.out.println(f.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 4:{
                    try{
                        List<Autor> lista = facadeLivro.listarAutor();
                        for(Autor a:lista){
                            System.out.println(a.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 5:{
                    try{
                        List<Editora> lista = facadeLivro.listarEditora();
                        for(Editora e:lista){
                            System.out.println(e.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    try{
                        List<Secao> lista = facadeLivro.listarSecao();
                        for(Secao s:lista){
                            System.out.println(s.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 7:{
                    try{
                        List<Livro> lista = facadeLivro.listarLivro();
                        for(Livro l:lista){
                            System.out.println(l.toString());    
                        }
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 0:{
                    System.out.println("SAINDO..... ");
                    break;
                }
                
                default:{
                    System.out.println("OPCAO INVALIDA!..... ");
                    break;
                }
                
            }
    }
        
    public void menuDeletar(){
        System.out.println("1- DELETAR ENDERECO: ");
        System.out.println("2- DELETAR ALUNO: ");
        System.out.println("3- DELETAR FUNCIONARIO: ");
        System.out.println("4- DELETAR AUTOR: ");
        System.out.println("5- DELETAR EDITORA: ");
        System.out.println("6- DELETAR SECAO: ");
        System.out.println("7- DELETAR LIVRO: ");
        System.out.println("0- SAIR: ");
        int opEditar = sc.nextInt();
        sc.nextLine();
        switch(opEditar){
                case 1:{
                    System.out.println("INFORME O ID DO ENDERECO: ");
                    int idEndereco = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Endereco endereco = facadePessoa.buscarEndereco(idEndereco);
                        if(endereco == null){
                            System.out.println("ENDERECO NÃO ENCONTRADO.... ");
                        }
                        else{
                            facadePessoa.deletarEndereco(endereco);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 2:{
                    System.out.println("INFORME O ID DO ALUNO: ");
                    int idAluno = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Aluno aluno = facadePessoa.buscarAluno(idAluno);
                        if(aluno == null){
                            System.out.println("ALUNO NÃO ENCONTRADO! ");
                        }
                        else{
                            facadePessoa.deletarAluno(aluno);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 3:{
                    System.out.println("IINFORME O ID DO FUNCIONARIO: ");
                    int idFuncionario = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Funcionario funcionario = facadePessoa.buscarFuncionario(idFuncionario);
                        if(funcionario == null){
                            System.out.println("FUNCIONARIO NÃO ENCONTRADO!.... ");
                        }
                        else{
                            facadePessoa.deletarFuncionario(funcionario);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 4:{
                    System.out.println("INFORME O ID DO AUTOR: ");
                    int idAutor = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Autor autor = facadeLivro.buscarAutor(idAutor);
                        if(autor == null){
                            System.out.println("AUTOR NÃO ENCONTRADO! ");
                        }
                        else{
                            facadeLivro.deletarAutor(autor);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                case 5:{
                    System.out.println("INFORME O ID DA EDITORA: ");
                    int idEditora = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Editora editora = facadeLivro.buscarEditora(idEditora);
                        if(editora == null){
                            System.out.println("EDITORA NÃO ENCONTRADA! ");
                        }
                        else{
                            facadeLivro.deletarEditora(editora);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 6:{
                    System.out.println("INFORME O ID DA SECAO: ");
                    int idSecao = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Secao secao = facadeLivro.buscarSecao(idSecao);
                        if(secao == null){
                            System.out.println("SECAO NÃO ENCONTRADA! ");
                        }
                        else{
                            facadeLivro.deletarSecao(secao);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 7:{
                    System.out.println("INFORME O ID DO LIVRO: ");
                    int idLivro = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        Livro livro = facadeLivro.buscarLivro(idLivro);
                        if(livro == null){
                            System.out.println("LIVRO NÃO ENCONTRADO!...... ");
                        }
                        else{
                            facadeLivro.deletarLivro(livro);
                        }
                    }
                    catch(Exception ex){
                        ex.getMessage();
                    }
                    break;
                }
                
                case 0:{
                    System.out.println("SAINDO DO ACESSO...");
                    break;
                }
                
                default:{
                    System.out.println("OPCAO INVALIDA!.... ");
                    break;
                }
                
            }
    }
    private void MenuEmprestimo(){
        System.out.println("1- EMPRESTIMO: ");
        System.out.println("2- DEVOLUCAO: ");
        System.out.println("0- SAIR: ");
        int opEmprestimo = sc.nextInt();
        sc.nextLine();
        switch(opEmprestimo){
            case 1:{
                System.out.println("INFORME O ID DO ALUNO: ");
                int idAluno = sc.nextInt();
                sc.nextLine();
                System.out.println("INFORME O ID DO LIVRO: ");
                int idLivro = sc.nextInt();
                sc.nextLine();
                try{
                    Aluno aluno = facadePessoa.buscarAluno(idAluno);
                    Livro livro = facadeLivro.buscarLivro(idLivro);
                    if(aluno == null || livro == null){
                        System.out.println("DADOS INVALIDOS!.....");
                    }
                    else{
                        if(livro.getExemplaresDisponiveis()== 0){
                            System.out.println("O LIVRO NÃO TEM EXEMPLARES DISPONIVEIS!........");
                        }
                        else{
                            System.out.println("INFORME A QUANTIDADE DE DIAS DO EMPRESTIMO: ");
                            int entrega = sc.nextInt();
                            
                            Emprestimo emprestimo = new Emprestimo();
                            emprestimo.setAluno(aluno);
                            emprestimo.setLivro(livro);
                            emprestimo.setReserva(true);
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            Calendar calendar = new GregorianCalendar();
                            calendar= calendar.getInstance();
                            Date data = calendar.getTime();
                            formato.format(data);
                            calendar.add(Calendar.DATE, entrega);
                            
                            calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+1);
                            Date dataPrevista = calendar.getTime();
                            formato.format(dataPrevista);
                            emprestimo.setData(data);
                            emprestimo.setDataPrevista(dataPrevista);
                            
                            
                            facadeEmprestimo.cadastrarEmprestimo(emprestimo);
                            
                            livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis()-1);
                            facadeLivro.editarLivro(livro);
                        }
                        
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                    ex.getMessage();
                }
                
                break;
            }
   
            case 2:{
                System.out.println("INFORME O ID DO EMPRESTIMO: ");
                int idEmprestimo = sc.nextInt();
                sc.nextLine();
                try{
                    Emprestimo emprestimo = facadeEmprestimo.buscarEmprestimo(idEmprestimo);
                    if(emprestimo == null){
                        System.out.println("EMPRESTIMO NÃO EXISTE!......");
                    }
                    else{
                        emprestimo.setReserva(false);
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar calendar = new GregorianCalendar();
                        calendar = calendar.getInstance();
                        Date entrega = new Date(System.currentTimeMillis());
                        formato.format(entrega);
                        emprestimo.setEntrega(entrega);
                        if(entrega.getTime()>emprestimo.getDataPrevista().getTime()){
                            System.out.println("ENTREGA ATRASADA, DEVE-SE COBRAR MULTA!.....");
                        }
                        
                        facadeEmprestimo.editarEmprestimo(emprestimo);
                        
                        emprestimo.getLivro().setExemplaresDisponiveis(emprestimo.getLivro().getExemplaresDisponiveis()+1);
                        facadeLivro.editarLivro(emprestimo.getLivro());
                    }
                }catch (Exception ex){
                   ex.printStackTrace();
                    ex.getMessage();
                }
                
                break;
            }
            
            case 0:{
                System.out.println("ENCERRANDO O PROGRAMA ....");
                break;
            }
            
            default:{
                System.out.println("OPCAO INVALIDA!..... ");
                break;
            }
        }
    }     
}
