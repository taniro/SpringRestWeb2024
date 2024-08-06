package ufrn.br.springrestweb2024.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.springrestweb2024.domain.Pessoa;
import ufrn.br.springrestweb2024.dto.PessoaRequestDto;
import ufrn.br.springrestweb2024.dto.PessoaResponseDto;
import ufrn.br.springrestweb2024.service.PessoaService;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/pessoas/")
@AllArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @GetMapping
    public List<Pessoa> listAll() {
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDto> create(@RequestBody PessoaRequestDto pessoa) {

        Pessoa entityPessoa = new Pessoa();
        entityPessoa.setNome(pessoa.getNome());
        entityPessoa.setSexo(pessoa.getSexo());
        entityPessoa.setDataNascimento(pessoa.getDataNascimento());

        Pessoa created = service.create(entityPessoa);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        PessoaResponseDto pessoaResponseDto = new PessoaResponseDto(created.getNome(), created.getIdade(), created.getSexo());

        return ResponseEntity.created(location).body(pessoaResponseDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pessoa> listById(@PathVariable("id") Long id) {
        Optional<Pessoa> pessoaOptional = service.listById(id);

        if (pessoaOptional.isPresent()) {
            return ResponseEntity.ok(pessoaOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        Optional<Pessoa> pessoaOptional = service.listById(id);
        if (pessoaOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa, @PathVariable("id") Long id) {
        Optional<Pessoa> pessoaOptional = service.listById(id);
        if (pessoaOptional.isPresent()) {
            return ResponseEntity.ok(service.update(pessoa, id));
        }
        Pessoa created = service.create(pessoa);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
}
