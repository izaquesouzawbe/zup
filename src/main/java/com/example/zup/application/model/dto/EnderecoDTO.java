package com.example.zup.application.model.dto;


import lombok.Data;

public class EnderecoDTO {

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String uf;

    private Long ibge;

    private String observacao;

    private PessoaDTO pessoa;
}
