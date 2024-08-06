package ufrn.br.springrestweb2024.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ufrn.br.springrestweb2024.domain.Pessoa;
import ufrn.br.springrestweb2024.repository.PessoaRepository;


@Service
public class PessoaService extends GenericService<Pessoa, Long, PessoaRepository> {
    public PessoaService(PessoaRepository repository) {
        super(repository);
    }
}
