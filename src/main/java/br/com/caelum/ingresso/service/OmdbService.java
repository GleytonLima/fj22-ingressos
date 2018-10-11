package br.com.caelum.ingresso.service;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Controller
public class OmdbService {

	public Optional<DetalhesDoFilme> fazRequisicao(Filme filme) {
		try {
			
			String url = "https://omdb-fj22.herokuapp.com/movie?title=" + filme.getNome().replaceAll(" ", "+");
			RestTemplate restTemplate = new RestTemplate();
			DetalhesDoFilme detalhesDoFilme = restTemplate.getForObject(url, DetalhesDoFilme.class);
			return Optional.of(detalhesDoFilme);
			
		}catch(Exception ex) {
			return Optional.empty();
		}
		
	}
}
