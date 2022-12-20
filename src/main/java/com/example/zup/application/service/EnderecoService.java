package com.example.zup.application.service;

import com.example.zup.application.repository.EnderecoRepository;
import com.example.zup.application.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

}
