package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDao {
	
	@PersistenceContext
	private EntityManager manager;

	public void save(Sessao sessao) {
		manager.persist(sessao);
	}
	
	public List<Sessao> findAllBySala(Integer salaId) {
		Query query = manager.createQuery("SELECT s FROM Sessao s WHERE s.sala.id = :salaId", Sessao.class);
		query.setParameter("salaId", salaId);
		return query.getResultList();
	}
}
