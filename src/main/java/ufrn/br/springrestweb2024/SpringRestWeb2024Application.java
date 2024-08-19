package ufrn.br.springrestweb2024;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ufrn.br.springrestweb2024.core.security.RsaKeyProperties;
import ufrn.br.springrestweb2024.domain.Endereco;
import ufrn.br.springrestweb2024.domain.Pessoa;
import ufrn.br.springrestweb2024.domain.SecurityUser;
import ufrn.br.springrestweb2024.repository.SecurityUserRerpository;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SpringRestWeb2024Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestWeb2024Application.class, args);
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    };

    @Autowired
    SecurityUserRerpository securityUserRerpository;

    @Autowired
    BCryptPasswordEncoder encoder;


    @PostConstruct
    public void started() {
        Pessoa p = new Pessoa();

        p.setNome("Joao");
        p.setAdmin(true);
        p.setDataNascimento("12/12/1920");

        Endereco e = new Endereco();
        e.setNumero(10);
        e.setRua("Natal");

        p.setEndereco(e);

        SecurityUser securityUser = new SecurityUser();
        securityUser.setPessoa(p);
        securityUser.setUsername("admin");
        securityUser.setPassword(encoder.encode("admin"));

        securityUserRerpository.save(securityUser);
    }
}
