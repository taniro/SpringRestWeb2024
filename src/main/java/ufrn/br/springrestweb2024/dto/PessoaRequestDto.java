package ufrn.br.springrestweb2024.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ufrn.br.springrestweb2024.domain.Endereco;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequestDto {
    String nome;
    String dataNascimento;
    String sexo;
    Endereco endereco;
}
