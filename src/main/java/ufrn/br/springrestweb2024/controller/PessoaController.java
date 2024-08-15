package ufrn.br.springrestweb2024.controller;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.springrestweb2024.domain.Pessoa;
import ufrn.br.springrestweb2024.dto.PessoaRequestDto;
import ufrn.br.springrestweb2024.dto.PessoaResponseDto;
import ufrn.br.springrestweb2024.service.PessoaService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/pessoas/")
@AllArgsConstructor
public class PessoaController {

    private final PessoaService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<PessoaResponseDto> listAll() {

        List<PessoaResponseDto> responseDtos = new ArrayList<>();
        List<Pessoa> pessoas = service.listAll();

        for (Pessoa p : pessoas){
            PessoaResponseDto responseDto = mapper.map(p, PessoaResponseDto.class);
            responseDto.addLinks(p);
            responseDtos.add(responseDto);
        }

        return responseDtos;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDto> create(@RequestBody PessoaRequestDto pessoa) {

        Pessoa entityPessoa = mapper.map(pessoa, Pessoa.class);
        Pessoa created = service.create(entityPessoa);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        PessoaResponseDto pessoaResponseDto = mapper.map(created, PessoaResponseDto.class);
        pessoaResponseDto.addLinks(created);

        return ResponseEntity.created(location).body(pessoaResponseDto);
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
        }catch (Exception e){
            return this.create(requestDto);
        }

        Pessoa PessoaUpdated =  service.update(mapper.map(requestDto, Pessoa.class), id);
        PessoaResponseDto pessoaResponseDto  = mapper.map(PessoaUpdated, PessoaResponseDto.class);

        pessoaResponseDto.addLinks(PessoaUpdated);

        return ResponseEntity.ok(pessoaResponseDto);
    }
}
