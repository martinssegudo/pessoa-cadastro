package br.com.pessoa.servicos;

import br.com.pessoa.exceptions.PessoaException;
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

    public Pessoa save(Pessoa pessoa){
        if(validarCastro(pessoa))
            return pessoaRepositorio.save(pessoa);
        return null;
    }

    private boolean validarCastro(Pessoa pessoa){
        return Util.verificarCampoNaoNull(pessoa.getNome())
                && Util.verificaAlturaPreenchida(pessoa.getAltura())
                && Util.verificaIdadePreenchida(pessoa.getIdade());
    }

    public List<Pessoa> listarTodos() throws PessoaException {
        List<Pessoa> pessoas = pessoaRepositorio.findAll();
        if(pessoas == null
            || pessoas.isEmpty())
            throw new PessoaException("Nenhuma pessoa encontrada");
        return pessoas;
    }

    public void deletaPessoa(Long idPessoa) throws PessoaException{
        if(idPessoa == null || idPessoa <= 0)
            throw new PessoaException("Não exite pessoa a ser deletada com este id");
        pessoaRepositorio.deleteById(idPessoa);
    }
}
