package ufrn.br.springrestweb2024.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.springrestweb2024.domain.Endereco;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponseDto extends RepresentationModel<PessoaResponseDto> {
    String nome;
    int idade;
    String sexo;
    Endereco endereco;
}
