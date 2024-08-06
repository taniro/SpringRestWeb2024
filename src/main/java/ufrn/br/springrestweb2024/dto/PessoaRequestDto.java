package ufrn.br.springrestweb2024.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    String nome;
    String dataNascimento;
    String sexo;
}
