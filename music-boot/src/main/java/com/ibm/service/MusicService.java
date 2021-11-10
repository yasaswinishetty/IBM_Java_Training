package com.ibm.service;

import java.util.List;

import com.ibm.entity.Music;

public interface MusicService {
	
	void save(Music m);
	
	Music fetch(int id);
	
	List<Music> list();
	
	void delete(int id);
	
	List<Music> byTitle(String title);
	
	List<Music> byArtist(String Artist);
	
	List<Music> byGenre(String Genre);
	
	List<Music> byFilter(String title, String artist, String genre);

}
