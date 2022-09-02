package com.c2tech.desafio.view.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.c2tech.desafio.service.CoordenadaCepService;
import com.c2tech.desafio.shared.CoordenadaCepDTO;
import com.c2tech.desafio.shared.CotacaoFreteDTO;

@Controller
@RequestMapping("/buscacep")
public class CoordenadaCepController {

	@Autowired
	private CoordenadaCepService coordenadaCepService;

	@GetMapping("/cepdetails")
	public String buscarCepConsultaFrete(@ModelAttribute("cotacaoFreteDTO") CotacaoFreteDTO cotacaoFreteDTO,
			RedirectAttributes redirectAttributes) {
		CoordenadaCepDTO coordenadaCepDTO = new ModelMapper().map(cotacaoFreteDTO, CoordenadaCepDTO.class);
		coordenadaCepDTO = coordenadaCepService.buscarCepConsultaFrete(coordenadaCepDTO);
		redirectAttributes.addFlashAttribute("coordenadaCepDTO", coordenadaCepDTO);
		return "redirect:/cotacao/calcular";
	}

}
