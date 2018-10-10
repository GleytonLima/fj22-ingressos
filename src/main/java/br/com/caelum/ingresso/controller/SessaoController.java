package br.com.caelum.ingresso.controller;

import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.form.SessaoForm;
import br.com.caelum.ingresso.model.validacao.GerenciadorDeSessoes;

@Controller
public class SessaoController {

	@Autowired
	private FilmeDao filmeDao;

	@Autowired
	private SalaDao salaDao;

	@Autowired
	private SessaoDao sessaoDao;

	@GetMapping("/admin/sessao")
	public ModelAndView form(@RequestParam("salaId") Integer salaId, SessaoForm sessaoForm) {

		ModelAndView modelAndView = new ModelAndView("sessao/sessao");

		List<Filme> filmes = filmeDao.findAll();

		Sala sala = salaDao.findOne(salaId);

		modelAndView.addObject("filmes", filmes);
		modelAndView.addObject("sala", sala);
		modelAndView.addObject("form", sessaoForm);

		return modelAndView;

	}

	@Transactional
	@PostMapping("/admin/sessao")
	public ModelAndView salvar(@Valid SessaoForm sessaoForm, BindingResult result) {

		if (result.hasErrors()) {
			return form(sessaoForm.getSalaId(), sessaoForm);
		}
		
		Sessao sessao = sessaoForm.toSessao(salaDao, filmeDao);
		
		List<Sessao> sessoesExistentes = sessaoDao.findAllBySala(sessaoForm.getSalaId());
		

		
		
		//Veriicar se Sessao cabe na sala
		GerenciadorDeSessoes gs = new GerenciadorDeSessoes();
		
		if(gs.cabe(sessao, sessoesExistentes)) {
			sessaoDao.save(sessao);

			ModelAndView modelAndView = new ModelAndView("redirect:/admin/sala/"+sessaoForm.getSalaId()+"/sessoes");

			return modelAndView;
		}
		
		return form(sessaoForm.getSalaId(), sessaoForm);

		
	}

}
