package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ibm.entity.Music;

public class MusicRepositoryImpl implements MusicRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void save(Music m) {
		em.persist(m);
	}

	public Music fetch(int id) {
		return em.find(Music.class, id);
	}

	public List<Music> fetchAll() {
		return em.createQuery("from Music").getResultList();
	}

	public List<Music> fetchByGenre(String genre) {
		Query query = em.createQuery("from Music where Genre = '" + genre + "'");
		return query.getResultList();
	}
}
