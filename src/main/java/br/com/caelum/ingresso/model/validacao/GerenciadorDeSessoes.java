package br.com.caelum.ingresso.model.validacao;

import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessoes {

	public boolean cabe(Sessao sessaoNova, List<Sessao> sessoes) {
		
		return sessoes.stream().noneMatch(sessaoExistente -> temConflito(sessaoNova, sessaoExistente));
		
	}

	private boolean temConflito(Sessao sessaoNova, Sessao sessaoExistente) {

		if (sessaoNova.getHorario().isBefore(sessaoExistente.getHorarioTermino())
				&& sessaoExistente.getHorario().isBefore(sessaoNova.getHorarioTermino())) {
			return true;
		}
		return false;
	}
}
