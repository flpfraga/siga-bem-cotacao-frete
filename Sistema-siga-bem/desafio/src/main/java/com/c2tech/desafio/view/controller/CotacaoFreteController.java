package com.c2tech.desafio.view.controller;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.c2tech.desafio.service.CotacaoFreteService;
import com.c2tech.desafio.shared.CoordenadaCepDTO;
import com.c2tech.desafio.shared.CotacaoFreteDTO;
import com.c2tech.desafio.view.model.CoordenadaCepResponse;
import com.c2tech.desafio.view.model.CotacaoFreteRequest;
import com.c2tech.desafio.view.model.CotacaoFreteResponse;

@Controller
@RequestMapping("/cotacao")
public class CotacaoFreteController {
    
    @Autowired
    private CotacaoFreteService cotacaoFreteService;

    @Autowired
    private CoordenadaCepController coordenadaCepController;
//“peso”, “cepOrigem”, “cepDestino” e “nomeDestinatario“
    @GetMapping("/newCotacao")
    public ResponseEntity<CotacaoFreteResponse> getNovaCotacaoFrete(
        @RequestParam(value="nomeDestinatario") String nomeDestinatario,
        @RequestParam(value="cepOrigem") String cepOrigem,
        @RequestParam(value="cepDestino") String cepDestino,
        @RequestParam(value="peso") Double peso){
            
            Optional<CoordenadaCepResponse> coordenadaCepResponseOrigem = coordenadaCepController.buscarCep(cepOrigem).getBody();
            CoordenadaCepDTO coordenadaCepDTOOrigem = new ModelMapper().map(coordenadaCepResponseOrigem.get(), CoordenadaCepDTO.class);

            Optional<CoordenadaCepResponse> coordenadaCepResponseDestino = coordenadaCepController.buscarCep(cepDestino).getBody();
            CoordenadaCepDTO coordenadaCepDTODestino = new ModelMapper().map(coordenadaCepResponseDestino.get(), CoordenadaCepDTO.class);
            
            CotacaoFreteDTO cotacaoFreteDTO =  cotacaoFreteService.getNovaCotacaoFrete(coordenadaCepDTOOrigem,coordenadaCepDTODestino, nomeDestinatario, peso);

            CotacaoFreteResponse cotacaoFreteResponse = new ModelMapper().map(cotacaoFreteDTO, CotacaoFreteResponse.class);

        return new ResponseEntity<>(cotacaoFreteResponse, HttpStatus.OK);
    } 

    // @GetMapping
    // public ResponseEntity<List<CotacaoFreteResponse>> buscarTodos(){
    //     List<CotacaoFreteDTO> cotacoesDTO = this.cotacaoFreteService.buscarTodos();

    //     List<CotacaoFreteResponse> cotacoesFreteResponse = cotacoesDTO.stream()
    //     .map(cotacaoFrete -> new ModelMapper().map(cotacaoFrete, CotacaoFreteResponse.class))
    //     .collect(Collectors.toList());

    //     return new ResponseEntity<>(cotacoesFreteResponse, HttpStatus.OK);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CotacaoFreteResponse>> buscarId(@PathVariable Integer id){

        Optional<CotacaoFreteDTO> cotacaoFreteDTO = this.cotacaoFreteService.buscarId(id);

        CotacaoFreteResponse cotacaoFreteResponse = new ModelMapper().map(cotacaoFreteDTO.get(), CotacaoFreteResponse.class);
        return new ResponseEntity<>(Optional.of(cotacaoFreteResponse), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CotacaoFreteResponse> adicionar(@RequestBody CotacaoFreteRequest cotacaoFreteRequest){

        CotacaoFreteDTO cotacaoFreteDTO = new ModelMapper().map(cotacaoFreteRequest, CotacaoFreteDTO.class);
        cotacaoFreteDTO = this.cotacaoFreteService.adicionar(cotacaoFreteDTO);
        CotacaoFreteResponse cotacaoFreteResponse = new ModelMapper().map(cotacaoFreteDTO, CotacaoFreteResponse.class);
        return new ResponseEntity<>(cotacaoFreteResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Integer id){

        this.cotacaoFreteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CotacaoFreteResponse> atualizar (@PathVariable Integer id, @RequestBody CotacaoFreteRequest cotacaoFreteRequest){

        CotacaoFreteDTO cotacaoFreteDTO = new ModelMapper().map(cotacaoFreteRequest, CotacaoFreteDTO.class);
        cotacaoFreteDTO = this.cotacaoFreteService.atualizar(cotacaoFreteDTO, id);

        CotacaoFreteResponse cotacaoFreteResponse = new ModelMapper().map(cotacaoFreteDTO, CotacaoFreteResponse.class);
        return new ResponseEntity<>(cotacaoFreteResponse, HttpStatus.OK);
    }
 
}
