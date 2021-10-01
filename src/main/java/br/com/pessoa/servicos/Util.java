package br.com.pessoa.servicos;

public class Util {

    public static boolean verificarCampoNull(String campo){
        if(campo != null
            && !campo.isEmpty())
            return true;
        return false;
    }

    public static boolean verificaAltura(Double altura){
        return altura != null? true : false;
    }

    public static boolean verificaIdade(Long idade){
        return idade != null? true : false;
    }
}
