package com.qa.cdlibrary.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CD {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String artistName;
	private String genre;
	private String albumTitle;

	public CD() {

	}

	public CD(String artistName, String genre, String albumTitle) {
		this.artistName = artistName;
		this.genre = genre;
		this.albumTitle = albumTitle;
	}

	public Long getId() {
		return id;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

}
