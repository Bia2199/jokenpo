package br.com.desafio.jokenpo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Round {

	@JsonProperty("playerId")
	private String id;
	
	@JsonProperty("newPlay")
	private String play;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlay() {
		return play;
	}

	public void setPlay(String jogada) {
		this.play = jogada.toUpperCase();
	}
	
}
