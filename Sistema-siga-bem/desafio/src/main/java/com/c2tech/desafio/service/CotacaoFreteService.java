package com.c2tech.desafio.service;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.c2tech.desafio.model.CotacaoFrete;
import com.c2tech.desafio.model.exception.ResourceNotFoundException;
import com.c2tech.desafio.repository.CotacaoFreteRepository;
import com.c2tech.desafio.shared.CoordenadaCepDTO;
import com.c2tech.desafio.shared.CotacaoFreteDTO;

@Service
public class CotacaoFreteService {

    @Autowired
    private CotacaoFreteRepository cotacaoFreteRepository;

    public CotacaoFreteDTO getNovaCotacaoFrete(CoordenadaCepDTO cepOrigem, CoordenadaCepDTO cepDestino, String destinatario,
            Double peso) {
        CotacaoFrete cotacaoFrete = new CotacaoFrete();
        cotacaoFrete.setCepOrigem(cepOrigem.getCep());
        cotacaoFrete.setCepDestino(cepDestino.getCep());
        cotacaoFrete.setPeso(peso);
        cotacaoFrete.setDestinatario(destinatario);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cotacaoFrete.setDataConsulta(cal);
        boolean dddIgual = false;
        boolean ufIgual = false;
        if (cepOrigem.getDdd().equals(cepDestino.getDdd())) {
            dddIgual = true;
        }
        if (!dddIgual && cepOrigem.getUf().equals(cepDestino.getUf())) {
            ufIgual = true;
        }
        cotacaoFrete.calculaDataPrevistaEntrega(dddIgual, ufIgual, cal);
        cotacaoFrete.calculaValorFrete(dddIgual, ufIgual);
        CotacaoFreteDTO cotacaoFreteDTO = new ModelMapper().map(cotacaoFrete, CotacaoFreteDTO.class);
        adicionar(cotacaoFreteDTO);
        return cotacaoFreteDTO;

    }

    public List<CotacaoFreteDTO> buscarTodos() {

        List<CotacaoFrete> cotacoes = this.cotacaoFreteRepository.findAll();

        return cotacoes.stream()
                .map(cotacaoFrete -> new ModelMapper().map(cotacaoFrete, CotacaoFreteDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<CotacaoFreteDTO> buscarId(Integer id) {

        Optional<CotacaoFrete> cotacaoFrete = cotacaoFreteRepository.findById(id);

        if (!cotacaoFrete.isPresent()) {
            throw new ResourceNotFoundException("Produto id : " + id + " não foi encontrado");
        }

        CotacaoFreteDTO cotacaoFreteDTO = new ModelMapper().map(cotacaoFrete, CotacaoFreteDTO.class);

        return Optional.of(cotacaoFreteDTO);
    }

    public CotacaoFreteDTO adicionar(CotacaoFreteDTO cotacaoFreteDTO) {

        CotacaoFrete cotacaoFrete = new ModelMapper().map(cotacaoFreteDTO, CotacaoFrete.class);
        cotacaoFrete = cotacaoFreteRepository.save(cotacaoFrete);
        cotacaoFreteDTO.setId(cotacaoFrete.getId());
        return cotacaoFreteDTO;
    }

    public void deletar(Integer id) {

        Optional<CotacaoFrete> cotacaoFrete = this.cotacaoFreteRepository.findById(id);
        if (!cotacaoFrete.isPresent()) {
            throw new ResourceNotFoundException("Produto id : " + id + " não foi encontrado");
        }
        this.cotacaoFreteRepository.deleteById(id);
    }

    public CotacaoFreteDTO atualizar(CotacaoFreteDTO cotacaoFreteDTO, Integer id) {
        cotacaoFreteDTO.setId(id);
        CotacaoFrete cotacaoFrete = new ModelMapper().map(cotacaoFreteDTO, CotacaoFrete.class);
        this.cotacaoFreteRepository.save(cotacaoFrete);
        return cotacaoFreteDTO;
    }

}
