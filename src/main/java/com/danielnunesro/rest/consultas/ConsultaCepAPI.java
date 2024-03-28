package com.danielnunesro.rest.consultas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consultarcep")
public class ConsultaCepAPI {
	
	@GetMapping("/{cep}")
	public ConsultResultDTO consultaCep(@PathVariable("cep") String cep) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ConsultResultDTO> resp = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep), ConsultResultDTO.class);
		return resp.getBody();
	}
	
}
