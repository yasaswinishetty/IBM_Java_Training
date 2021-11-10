package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Music")
public class Music {
	
	@Id
	private int Id;
	@Column(length=20)
	private String Artist;
	@Column(length=20)
	private String genre;
	@Column
	private int rating;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) {
		Artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Music [Id=" + Id + ", Artist=" + Artist + ", genre=" + genre + ", rating=" + rating + "]";
	}
}
