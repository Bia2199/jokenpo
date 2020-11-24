package br.com.desafio.jokenpo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.com.desafio.jokenpo.model.Player;

/**
 * This class is responsible for creating, deleting and getting all players to the frontend.
 */
@Service
public class PlayerService {
	
	private static ArrayList<Player> playerList = new ArrayList<Player>();

	public Player createPlayer(String name) {
		
		System.out.println();
		String id = getSpecificId(playerList);
		Player player = new Player(id, name);
			
		playerList.add(player);
		return player;
	}


	public void deletePlayer(final String id) {
		for (int i = 0; i < playerList.size() -1; i++) {
			if (playerList.get(i).getId().equals(id)) {
				playerList.remove(i);
				break;
			}
		}	
	}
	
	public ArrayList<Player> getPlayers() {

		return playerList;
	}

	/**
	 * Returns the total size of the playerList, which corresponds to the next player Id.
	 * 
	 * @param players The playerList.
	 * @return the Id.
	 */
	private String getSpecificId(ArrayList<Player> players) {
		if(players.isEmpty()) {
			return "1";
		}
		return Integer.toString(players.size()+1);
	}
}
