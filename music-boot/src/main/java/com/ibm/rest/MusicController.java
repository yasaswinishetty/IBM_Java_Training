package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Music;
import com.ibm.service.MusicService;

@RestController
public class MusicController {

	@Autowired
	private MusicService service;
	
	@PostMapping(value="/music", consumes = "application/json")
	public String addMusic(@RequestBody Music m) {
		service.save(m);
		return "Music added";
	}
	
	@GetMapping(value="/music/{id}", produces = "application/json")
	public Music getMusic(@PathVariable int id) {
		return service.fetch(id);
	}
	
	@GetMapping(value="/musics", produces="application/json")
	public List<Music> getAll() {
		return service.list();
	}
	
	@DeleteMapping(value="/music/{id}")
	public String delMusic(@PathVariable int id) {
		service.delete(id);
		return "Music deleted";
	}
	
	@GetMapping(value="/flights/{title}", produces="application/json")
	public List<Music> getByTitle(@PathVariable String Title) {
		return service.byTitle(Title);
	}
	
	@GetMapping(value="/flights/{artist}", produces="application/json")
	public List<Music> getByArtist(@PathVariable String Artist) {
		return service.byArtist(Artist);
	}
	
	@GetMapping(value="/flights/{genre}", produces="application/json")
	public List<Music> getByGenre(@PathVariable String Genre) {
		return service.byGenre(Genre);
	}
	
	@GetMapping(value="/flights/filter", produces="application/json")
	public List<Music> getByFilter(@RequestParam String title, @RequestParam String artist, @RequestParam String genre) {
		return service.byFilter(title, artist, genre);
	}
}
