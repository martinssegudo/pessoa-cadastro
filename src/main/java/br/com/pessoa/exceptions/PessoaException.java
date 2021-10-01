package br.com.pessoa.exceptions;

public class PessoaException extends Exception{
    private String menssagem;

    public PessoaException(String menssagem){
        super(menssagem);
        this.menssagem = menssagem;
    }

}
