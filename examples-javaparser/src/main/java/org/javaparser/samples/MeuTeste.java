package org.javaparser.samples;

public class MeuTeste {

    private int idade;
    private String nome;

    //Sou um comentario de uma linha 01
    public MeuTeste(int idade) {
        //Sou um comentario de uma linha dentro do metodo 01
        this.idade = idade;
    }

    //Sou um comentario de uma linha 02

    public MeuTeste(String nome) {
        this.nome = nome;
    }

    //Sou um comentario de uma linha 03
    public MeuTeste(int idade, String nome) {
        //Sou um comentario de uma linha dentro do metodo 01
        this.idade = idade;
        this.nome = nome;
    }

    /*Sou um comentario de
    varias linha 01*/
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
          /*Sou um comentario de
    varias linha 01 dentro do metodo*/
        this.idade = idade;
    }
    /*Sou um comentario de
      varias linha 02*/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
