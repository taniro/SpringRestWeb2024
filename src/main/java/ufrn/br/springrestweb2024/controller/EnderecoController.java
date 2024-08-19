package ufrn.br.springrestweb2024.controller;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.springrestweb2024.domain.Endereco;
import ufrn.br.springrestweb2024.service.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@AllArgsConstructor
public class EnderecoController {

    EnderecoService service;

    @GetMapping
    public Page<Endereco> listaEnderecos(Pageable pageable){
        return service.listAll(pageable);
    }
}
