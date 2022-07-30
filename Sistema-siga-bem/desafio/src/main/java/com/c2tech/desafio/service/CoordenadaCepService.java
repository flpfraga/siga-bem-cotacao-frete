package com.c2tech.desafio.service;

import java.util.Optional;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.c2tech.desafio.model.CoordenadaCep;
import com.c2tech.desafio.model.exception.BadRequestException;
import com.c2tech.desafio.shared.CoordenadaCepDTO;
import org.modelmapper.ModelMapper;

@Service
public class CoordenadaCepService {

    public Optional<CoordenadaCepDTO> buscaCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        String path = "https://viacep.com.br/ws/" + cep + "/json";
        try {
            CoordenadaCep coordenadaCep = restTemplate.getForObject(path, CoordenadaCep.class);
            CoordenadaCepDTO coordenadaCepDTO = new ModelMapper().map(coordenadaCep, CoordenadaCepDTO.class);
            return Optional.of(coordenadaCepDTO);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

}
