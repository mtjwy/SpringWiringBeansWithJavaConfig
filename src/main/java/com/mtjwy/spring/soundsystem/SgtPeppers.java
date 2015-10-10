package com.mtjwy.spring.soundsystem;



public class SgtPeppers implements CompactDisc {
	
	private String title;
	private String artist;
	
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
