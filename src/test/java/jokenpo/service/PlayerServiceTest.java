package jokenpo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.desafio.jokenpo.model.Player;
import br.com.desafio.jokenpo.service.PlayerService;

@RunWith(SpringRunner.class)
public class PlayerServiceTest {

	@Autowired
	private PlayerService playerService;

	@Test
	public void Should_increment_players() {
		Player player = new Player("", "");
		
		player = playerService.createPlayer("Bianca");
		
		assertEquals("1", player.getId());
		assertEquals("Bianca", player.getPlayer());
	}
}
