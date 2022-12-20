package com.example.zup.application.controller;

import com.example.zup.application.model.dto.PessoaDTO;
import com.example.zup.application.model.entity.Pessoa;
import com.example.zup.application.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/endereco")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    private final ModelMapper mapper;

    public PessoaController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity findAll(){

        List<Pessoa> pessoas = pessoaService.findAll();

        if (pessoas.isEmpty()){
            return new ResponseEntity("Nenhum registro encontrado.", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(pessoas.stream().map(pessoa -> mapper.map(pessoa, PessoaDTO.class)).collect(Collectors.toList()));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity save(PessoaDTO pessoaDTO){

        Pessoa pessoa;

        try {
            pessoa = pessoaService.create(pessoaDTO);
        } catch(RuntimeException e){
            return new ResponseEntity("Erro ao salvar a pessoa" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity delete(@PathVariable Long id){

        try {
            pessoaService.delete(id);
            return new ResponseEntity("O regitro foi excluido com sucesso", HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity("Não foi possivel excluir o registro", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id, PessoaDTO pessoaDTO){
        pessoaService.update(id, pessoaDTO);
    }
}
