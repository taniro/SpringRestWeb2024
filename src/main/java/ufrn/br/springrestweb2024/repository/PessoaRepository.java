package ufrn.br.springrestweb2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.springrestweb2024.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
