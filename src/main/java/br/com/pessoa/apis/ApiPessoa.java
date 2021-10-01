package br.com.pessoa.apis;

import br.com.pessoa.exceptions.PessoaException;
import br.com.pessoa.repositorios.entidades.Pessoa;
import br.com.pessoa.servicos.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoa")
public class ApiPessoa {

    PessoaServico pessoaServico;

    @Autowired
    public ApiPessoa(PessoaServico pessoaServico){
        this.pessoaServico = pessoaServico;
    }

    @PostMapping(value = "/savar")
    public void salvaPessoa(@RequestBody Pessoa pessoa){
        pessoaServico.save(pessoa);
    }


    @GetMapping
    public List<Pessoa> listarTodos() throws PessoaException {
        return pessoaServico.listarTodos();
    }


    @DeleteMapping(value = "/delete/{id}")
    public void deletaPorId(@PathVariable("id") Long idPessoa) throws PessoaException {
        pessoaServico.deletaPessoa(idPessoa);
    }
}
