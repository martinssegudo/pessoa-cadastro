package br.com.pessoa.repositorios;

import br.com.pessoa.repositorios.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {

}
