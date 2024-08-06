package ufrn.br.springrestweb2024.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponseDto {
    String nome;
    int idade;
    @JsonIgnore
    String sexo;
}
