package ufrn.br.springrestweb2024.repository;

import org.springframework.data.repository.CrudRepository;
import ufrn.br.springrestweb2024.domain.SecurityUser;

public interface SecurityUserRerpository extends CrudRepository<SecurityUser, Long> {
    SecurityUser findByUsername(String username);
}
