package com.ibm.repo;

import java.util.List;
import com.ibm.entity.Music;

public interface MusicRepository {
	
	void save(Music m);
	
	Music fetch(int id);
	
	List<Music> fetchAll();
	
	List<Music> fetchByGenre(String genre);
	

}
