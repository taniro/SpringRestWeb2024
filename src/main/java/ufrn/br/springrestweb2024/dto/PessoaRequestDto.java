package ufrn.br.springrestweb2024.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ufrn.br.springrestweb2024.domain.Pessoa;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequestDto {
    String nome;
    String dataNascimento;
    String sexo;
    EnderecoRequestDto endereco;

}
