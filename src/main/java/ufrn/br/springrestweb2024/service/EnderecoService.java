package ufrn.br.springrestweb2024.service;

import org.springframework.stereotype.Service;
import ufrn.br.springrestweb2024.domain.Endereco;
import ufrn.br.springrestweb2024.repository.EnderecoRepository;

@Service
public class EnderecoService  extends GenericService<Endereco, Long, EnderecoRepository>{
    public EnderecoService(EnderecoRepository repository) {
        super(repository);
    }
}
