package ufrn.br.springrestweb2024.service.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ufrn.br.springrestweb2024.domain.SecurityUser;
import ufrn.br.springrestweb2024.repository.SecurityUserRerpository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    SecurityUserRerpository repository;
    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecurityUser> credencials = Optional.ofNullable(repository.findByUsername(username));

        if(credencials.isPresent()){
            return credencials.get();
        } else {
            throw new UsernameNotFoundException("Usuário não cadastrado com username: " + username);
        }
    }
}