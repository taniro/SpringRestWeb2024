package ufrn.br.springrestweb2024.service;


import org.springframework.stereotype.Service;
import ufrn.br.springrestweb2024.domain.Pessoa;
import ufrn.br.springrestweb2024.repository.PessoaRepository;
import ufrn.br.springrestweb2024.service.generic.GenericCrudService;


@Service
public class PessoaService extends GenericCrudService<Pessoa, Long, PessoaRepository> {
    public PessoaService(PessoaRepository repository) {
        super(repository);
    }
}
