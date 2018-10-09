package br.com.caelum.ingresso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;

@Controller
public class SessaoController {
	
	@Autowired
	private FilmeDao filmeDao;
	
	@Autowired
	private SalaDao salaDao;
	
	@GetMapping("/admin/sessao")
    public ModelAndView form(@RequestParam("salaId")Integer salaId){		
		
		ModelAndView modelAndView = new ModelAndView("sessao/sessao");
		
		List<Filme> filmes = filmeDao.findAll();
		
		Sala sala = salaDao.findOne(salaId);
		
		modelAndView.addObject("filmes", filmes);
		modelAndView.addObject("sala", sala);
		
        return modelAndView;
        
    }

}