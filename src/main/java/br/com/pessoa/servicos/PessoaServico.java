package br.com.pessoa.servicos;

import br.com.pessoa.repositorios.PessoaRepositorio;
import br.com.pessoa.repositorios.entidades.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServico {

    private PessoaRepositorio pessoaRepositorio;

    @Autowired
    public PessoaServico(PessoaRepositorio pessoaRepositorio){
        this.pessoaRepositorio = pessoaRepositorio;
    }

    public void save(Pessoa pessoa){
        if(validarCastro(pessoa))
            pessoaRepositorio.save(pessoa);
    }

    private boolean validarCastro(Pessoa pessoa){
        return Util.verificarCampoNull(pessoa.getNome())
                && Util.verificaAltura(pessoa.getAltura())
                && Util.verificaIdade(pessoa.getIdade());
    }

    public List<Pessoa> listarTodos(){
        return pessoaRepositorio.findAll();
    }

    public void deletaPessoa(Long idPessoa){
        pessoaRepositorio.deleteById(idPessoa);
    }
}
