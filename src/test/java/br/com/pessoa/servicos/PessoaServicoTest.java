package br.com.pessoa.servicos;

import br.com.pessoa.exceptions.PessoaException;
import br.com.pessoa.repositorios.PessoaRepositorio;
import br.com.pessoa.repositorios.entidades.Pessoa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class PessoaServicoTest {
    @Mock
    PessoaRepositorio pessoaRepositorio;
    @InjectMocks
    PessoaServico pessoaServico;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveComSucesso() throws Exception {
        Pessoa retorno = new Pessoa("Luiz", 34L, 1.70);
        when(pessoaRepositorio.save(any())).thenReturn(retorno);
        Assert.assertNotNull(pessoaServico.save(new Pessoa("abc",12L,1.84)));
    }


    @Test
    public void testSaveComFalhaNoNome() throws Exception {
        Pessoa retorno = new Pessoa("Luiz", 34L, 1.70);
        when(pessoaRepositorio.save(any())).thenReturn(retorno);
        Assert.assertNull(pessoaServico.save(new Pessoa(null,12L,1.84)));
    }

    @Test
    public void testSaveComFalhaNoIdade() throws Exception {
        Pessoa retorno = new Pessoa("Luiz", 34L, 1.70);
        when(pessoaRepositorio.save(any())).thenReturn(retorno);
        Assert.assertNull(pessoaServico.save(new Pessoa("Luiz",null,1.84)));
    }

    @Test
    public void testSaveComFalhaNoAltura() throws Exception {
        Pessoa retorno = new Pessoa("Luiz", 34L, 1.70);
        when(pessoaRepositorio.save(any())).thenReturn(retorno);
        Assert.assertNull(pessoaServico.save(new Pessoa("Luiz",16L,null)));
    }

    @Test
    public void testListarTodosQuandoExisteDados() throws Exception {
        when(pessoaRepositorio.findAll()).thenReturn(Arrays.asList(new Pessoa()));
        List<Pessoa> result = pessoaServico.listarTodos();
        Assert.assertEquals(1, result.size());
    }


    @Test(expected = PessoaException.class)
    public void testListarTodosQuandoNaoExisteDados() throws Exception {
        when(pessoaRepositorio.findAll()).thenReturn(null);
        List<Pessoa> result = pessoaServico.listarTodos();
    }

    @Test(expected = PessoaException.class)
    public void testDeletaPessoaComFalha() throws Exception {
        pessoaServico.deletaPessoa(null);
    }

    @Test(expected = PessoaException.class)
    public void testDeletaPessoaComFalhaNegativo() throws Exception {
        pessoaServico.deletaPessoa(-1L);
    }

    @Test
    public void testDeletaPessoaComSucesso() throws Exception {
        pessoaServico.deletaPessoa(1L);
    }
}