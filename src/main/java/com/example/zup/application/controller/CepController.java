package com.example.zup.application.controller;

import com.example.zup.infra.CepClient;
import com.example.zup.infra.dto.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    CepClient cepClient;

    @GetMapping(value = "/{cep}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Cep getCep(@PathVariable String cep){
        return cepClient.getCep(cep);
    }


}
