package ufrn.br.springrestweb2024.controller;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.springrestweb2024.domain.Endereco;
import ufrn.br.springrestweb2024.domain.Pessoa;
import ufrn.br.springrestweb2024.dto.PessoaRequestDto;
import ufrn.br.springrestweb2024.dto.PessoaResponseDto;
import ufrn.br.springrestweb2024.service.PessoaService;

import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;


@RestController
@RequestMapping("/pessoas/")
@AllArgsConstructor
public class PessoaController {

    private final PessoaService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<PessoaResponseDto> listAll() {

        return service.listAll().stream().map(this::convertToDto).collect(toList());

    }

    @PostMapping
    public ResponseEntity<PessoaResponseDto> create(@RequestBody PessoaRequestDto pessoa) {

        Pessoa created = service.create(convertToEntity(pessoa));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }


    @GetMapping("{id}")
    public ResponseEntity<PessoaResponseDto> listById(@PathVariable("id") Long id) {

        Pessoa p = service.listById(id);
        PessoaResponseDto dto = mapper.map(p, PessoaResponseDto.class);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<PessoaResponseDto> update(@RequestBody PessoaRequestDto requestDto, @PathVariable("id") Long id) {

        try {
            Pessoa p = service.listById(id);
        } catch (Exception e) {
            return this.create(requestDto);
        }

        Pessoa PessoaUpdated = service.update(mapper.map(requestDto, Pessoa.class), id);
        return ResponseEntity.ok(convertToDto(PessoaUpdated));
    }

    private PessoaResponseDto convertToDto(Pessoa created) {
        PessoaResponseDto pessoaResponseDto = mapper.map(created, PessoaResponseDto.class);
        pessoaResponseDto.addLinks(created);
        return pessoaResponseDto;
    }

    private Pessoa convertToEntity(PessoaRequestDto pessoa) {
        Pessoa entityPessoa = mapper.map(pessoa, Pessoa.class);
        Endereco entityEndereco = mapper.map(pessoa.getEndereco(), Endereco.class);
        entityPessoa.setEndereco(entityEndereco);
        return entityPessoa;
    }
}
