package br.com.pessoa.servicos;

public class Util {

    public static boolean verificarCampoNaoNull(String campo){
        if(campo != null
            && !campo.isEmpty())
            return true;
        return false;
    }

    public static boolean verificaAlturaPreenchida(Double altura){
        return altura != null? true : false;
    }

    public static boolean verificaIdadePreenchida(Long idade){
        return idade != null? true : false;
    }
}
