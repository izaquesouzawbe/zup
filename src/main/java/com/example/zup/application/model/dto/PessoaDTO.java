package com.example.zup.application.model.dto;

import com.example.zup.application.model.entity.TipoPessoa;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaDTO {

    private String nome;
    private String sobrenome;
    private TipoPessoa tipoPessoa;
    private String documento;
    private LocalDate nascimento;
    private LocalDate dataCadastro;
    private String email;
}
