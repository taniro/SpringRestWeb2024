package ufrn.br.springrestweb2024.service;

import org.springframework.stereotype.Service;
import ufrn.br.springrestweb2024.domain.Endereco;
import ufrn.br.springrestweb2024.repository.EnderecoRepository;
import ufrn.br.springrestweb2024.service.generic.GenericCrudService;

@Service
public class EnderecoService extends GenericCrudService<Endereco, Long, EnderecoRepository> {
    public EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
}
