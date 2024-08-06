package ufrn.br.springrestweb2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.springrestweb2024.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
