package com.example.zup.infra;

import com.example.zup.infra.dto.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "cep", url = "https://viacep.com.br/ws/")
public interface CepClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/", produces = "application/json")
    Cep getCep(@PathVariable("cep") String cep);

}
