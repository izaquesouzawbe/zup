package com.example.zup.infra.dto;

import lombok.Data;

@Data
public class Cep {

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String uf;

    private Long ibge;

}
