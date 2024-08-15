package ufrn.br.springrestweb2024.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.springrestweb2024.controller.EnderecoController;
import ufrn.br.springrestweb2024.controller.PessoaController;
import ufrn.br.springrestweb2024.domain.Endereco;
import ufrn.br.springrestweb2024.domain.Pessoa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponseDto extends RepresentationModel<PessoaResponseDto> {
    String nome;
    int idade;
    String sexo;
    Endereco endereco;

    public void addLinks(Pessoa p){
        this.add(linkTo(PessoaController.class).slash(p.getId()).withSelfRel());
        this.add(linkTo(EnderecoController.class).slash(p.getEndereco().getId()).withRel("endereco"));
    }
}









