package com.c2tech.desafio.view.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.c2tech.desafio.service.CoordenadaCepService;
import com.c2tech.desafio.shared.CoordenadaCepDTO;
import com.c2tech.desafio.view.model.CoordenadaCepResponse;


@RestController
@RequestMapping("/buscacep")
public class CoordenadaCepController {

    @Autowired
    private CoordenadaCepService coordenadaCepService;
    
    @GetMapping("/{cep}")
    public ResponseEntity<Optional<CoordenadaCepResponse>> buscarCep(@PathVariable String cep){
        Optional<CoordenadaCepDTO> coordenadaCepDTO = coordenadaCepService.buscaCep(cep);
        CoordenadaCepResponse coordenadaCepResponse = new ModelMapper().map(coordenadaCepDTO.get(), CoordenadaCepResponse.class);
        return new ResponseEntity<>(Optional.of(coordenadaCepResponse), HttpStatus.OK);

    }

   

}
