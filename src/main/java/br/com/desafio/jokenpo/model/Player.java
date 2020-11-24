package br.com.desafio.jokenpo.model;

public class Player {
	
	private String id;
	
	private String player;

	public Player(String id, String player) {
		super();
		this.id = id;
		this.player = player;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
}
