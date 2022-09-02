package com.c2tech.desafio.view.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.c2tech.desafio.service.CotacaoFreteService;
import com.c2tech.desafio.shared.CoordenadaCepDTO;
import com.c2tech.desafio.shared.CotacaoFreteDTO;
import com.c2tech.desafio.view.model.CotacaoFreteRequest;
import com.c2tech.desafio.view.model.CotacaoFreteResponse;

@Controller
@RequestMapping("/cotacao")
public class CotacaoFreteController {

	@Autowired
	private CotacaoFreteService cotacaoFreteService;

	@PostMapping("/newCotation")
	public String requestNewCotation(@RequestBody CotacaoFreteRequest cotacaoFreteRequest, RedirectAttributes redirectAttributes) {
		CotacaoFreteDTO cotacaoFreteDTO = new ModelMapper().map(cotacaoFreteRequest, CotacaoFreteDTO.class);
		redirectAttributes.addFlashAttribute("cotacaoFreteDTO", cotacaoFreteDTO);		
		return "redirect:/buscacep/cepdetails";
	}
	
	@RequestMapping("/calcular")
	public ResponseEntity<CotacaoFreteResponse> getUfAndDdd(@ModelAttribute("coordenadaCepDTO") CoordenadaCepDTO coordenadaCepDTO) {
		CotacaoFreteDTO cotacaoFreteDTO = new ModelMapper().map(coordenadaCepDTO, CotacaoFreteDTO.class);
		cotacaoFreteDTO = cotacaoFreteService.getNovaCotacaoFrete(cotacaoFreteDTO);
		cotacaoFreteService.adicionar(cotacaoFreteDTO);
		CotacaoFreteResponse cotacaoFreteResponse = new ModelMapper().map(cotacaoFreteDTO, CotacaoFreteResponse.class);
	return new ResponseEntity<>(cotacaoFreteResponse, HttpStatus.OK);
	}


}
