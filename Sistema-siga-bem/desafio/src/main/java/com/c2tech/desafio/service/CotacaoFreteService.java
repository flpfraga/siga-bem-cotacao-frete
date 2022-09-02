package com.c2tech.desafio.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2tech.desafio.model.CotacaoFrete;
import com.c2tech.desafio.model.exception.ResourceNotFoundException;
import com.c2tech.desafio.repository.CotacaoFreteRepository;
import com.c2tech.desafio.shared.CotacaoFreteDTO;

@Service
public class CotacaoFreteService {

    @Autowired
    private CotacaoFreteRepository cotacaoFreteRepository;

    public CotacaoFreteDTO getNovaCotacaoFrete(CotacaoFreteDTO cotacaoFreteDTO) {
    	
    	if (cotacaoFreteDTO.getDddOrigem().equals(cotacaoFreteDTO.getDddDestino())) {
    		cotacaoFreteDTO.setDataPrevistaEntrega(LocalDate.now().plusDays(1));
    		cotacaoFreteDTO.setVlTotalFrete(cotacaoFreteDTO.getPeso()*0.5);
    		return cotacaoFreteDTO;
    	}
    	if (cotacaoFreteDTO.getUfOrigem().equals(cotacaoFreteDTO.getUfDestino())) {
    		cotacaoFreteDTO.setDataPrevistaEntrega(LocalDate.now().plusDays(3));
    		cotacaoFreteDTO.setVlTotalFrete(cotacaoFreteDTO.getPeso()*0.75);
    		return cotacaoFreteDTO;
    	}
    	cotacaoFreteDTO.setDataPrevistaEntrega(LocalDate.now().plusDays(10));
		cotacaoFreteDTO.setVlTotalFrete(cotacaoFreteDTO.getPeso()*1.0);
		
		
		return cotacaoFreteDTO;
    
    }

  

    public CotacaoFreteDTO adicionar(CotacaoFreteDTO cotacaoFreteDTO) {
        CotacaoFrete cotacaoFrete = new ModelMapper().map(cotacaoFreteDTO, CotacaoFrete.class);
        cotacaoFrete.setDataConsulta(LocalDate.now());
        cotacaoFrete = cotacaoFreteRepository.save(cotacaoFrete);
        return cotacaoFreteDTO;
    }


}
