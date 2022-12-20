package com.example.zup.application.service;

import com.example.zup.application.model.dto.PessoaDTO;
import com.example.zup.application.model.entity.Pessoa;
import com.example.zup.application.model.entity.TipoPessoa;
import com.example.zup.application.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    private final ModelMapper mapper;

    public PessoaService(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

    @Transactional
    public Pessoa create(PessoaDTO pessoaDTO) throws RuntimeException {

        if(pessoaDTO.getTipoPessoa().equals(TipoPessoa.FISICA) && pessoaDTO.getDocumento().length() == 11){
            throw new RuntimeException("Cpf não é valido");
        }

        if(pessoaDTO.getTipoPessoa().equals(TipoPessoa.JURIDICA) && pessoaDTO.getDocumento().length() == 15){
            throw new RuntimeException("CNPJ não é valido");
        }

        Pessoa pessoa = mapper.map(pessoaDTO, Pessoa.class);
        return pessoaRepository.save(pessoa);

    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }

    @Transactional
    public Pessoa update(Long id, PessoaDTO pessoaDTO){

        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setSobrenome(pessoaDTO.getSobrenome());
        pessoa.setNascimento(pessoaDTO.getNascimento());
        pessoa.setEmail(pessoaDTO.getEmail());

        return pessoaRepository.save(pessoa);

    }

}
