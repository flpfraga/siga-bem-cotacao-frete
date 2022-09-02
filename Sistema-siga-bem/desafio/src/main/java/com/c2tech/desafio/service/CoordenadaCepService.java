package com.c2tech.desafio.service;

import java.util.ArrayList;
import java.util.List;
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

   
    public CoordenadaCepDTO buscarCepConsultaFrete(CoordenadaCepDTO coordenadaCepDTO){
    	
    	RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        String pathOrigem = "https://viacep.com.br/ws/" + coordenadaCepDTO.getCepOrigem() + "/json";
        String pathDestino = "https://viacep.com.br/ws/" + coordenadaCepDTO.getCepDestino() + "/json";
        try {
            CoordenadaCep coordenadaCepOrigem = restTemplate.getForObject(pathOrigem, CoordenadaCep.class);
            coordenadaCepDTO.setDddOrigem(coordenadaCepOrigem.getDdd());
            coordenadaCepDTO.setUfOrigem(coordenadaCepOrigem.getUf());
            CoordenadaCep coordenadaCepDestino = restTemplate.getForObject(pathDestino, CoordenadaCep.class);
            coordenadaCepDTO.setDddDestino(coordenadaCepDestino.getDdd());
            coordenadaCepDTO.setUfDestino(coordenadaCepDestino.getUf());
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
        return coordenadaCepDTO;
    }

}
