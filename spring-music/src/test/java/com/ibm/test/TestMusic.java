package com.ibm.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.entity.Music;
import com.ibm.repo.MusicRepository;
import com.ibm.repo.MusicRepositoryImpl;
public class TestMusic {
	
	@Test
	public void testSaveMusic() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		MusicRepository repo = (MusicRepository) ctx.getBean("repo");
		Music m = new Music();
		m.setId(101);
		m.setArtist("S.P.Balasubramanyam");
		m.setGenre("Devotional");
		m.setRating(10);
		
		repo.save(m);
	}
	@Test
	public void testFetchById() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		MusicRepository repo = (MusicRepository) ctx.getBean("repo");
		Music m = repo.fetch(101);
		System.out.println(m.getArtist() + " " + m.getGenre() + " " + m.getRating());
	}

	@Test
	public void testFetchAll() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		MusicRepository repo = (MusicRepository) ctx.getBean("repo");
		List<Music> list = repo.fetchAll();
		for(Music music:list)
			System.out.println(music.getId() + " " + music.getArtist() + " " + music.getGenre()+ " " + music.getId());
	}
	
	@Test
	public void testFetchByGenre() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		MusicRepository repo = (MusicRepository) ctx.getBean("repo");
		List<Music> list = repo.fetchByGenre("Devotional");
		for(Music music:list)
			System.out.println(music.getId() + " " + music.getArtist() + " " + music.getRating());
		
	}
	
}
