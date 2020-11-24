package jokenpo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.desafio.jokenpo.model.Round;
import br.com.desafio.jokenpo.service.RoundService;

public class RoundServiceTest {
	
	@Autowired
	private RoundService roundService;
	
	Round[] rounds = new Round[2];
	
	@Test
	public void test() {
		Round r = new Round();
		r.setId("1");
		r.setPlay("TESOURA");
		rounds[0] = r;
		
		Round r1 = new Round();
		r1.setId("2");
		r1.setPlay("PEDRA");
		rounds[1] = r1;
		
		rounds = roundService.fillPlays(rounds);
		
		assertEquals("1", rounds[0].getId());
	}

}
