package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Music;

public interface MusicRepository extends JpaRepository<Music, Integer>{
	List<Music> findByTitle(String title);
	
	List<Music> findByArtist(String artist);
	
	List<Music> findByGenre(String genre);
	
	@Query("FROM Music WHERE title=:tit AND artist=:art AND genre=:gen")
	List<Music> findByFilter(String tit, String art, String gen);
}
