package br.com.desafio.jokenpo.service;

import static br.com.desafio.jokenpo.utils.Constants.PAPEL;
import static br.com.desafio.jokenpo.utils.Constants.PEDRA;
import static br.com.desafio.jokenpo.utils.Constants.TESOURA;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import br.com.desafio.jokenpo.model.Result;
import br.com.desafio.jokenpo.model.Round;

@Service
public class RoundService {
	
	public Result verifyResult(Round[] rounds) {
		
    	rounds = fillPlays(rounds);    	
    	if(rounds.length == 0) {
    		return new Result();
    	}
    	
    	Result result = new Result();
    	result.setEmpates(getDraws(rounds));
    	
    	if(result.getEmpates().length == 0) {
    		result.setVencedores(getWinners(rounds));
    		result.setPerdedores(getLosers(rounds, result.getVencedores()));
    	}
    	return result;
    }

    public Round[] fillPlays(Round[] rounds) {
    	
    	ArrayList<Round> newRounds = new ArrayList<Round>();
    	
    	for(Round r : rounds) {
    		if(r.getId().length() > 0 && playIsValid(r.getPlay())) {
    			newRounds.add(r);
    		}
    	}
    	
    	return newRounds.toArray(new Round[newRounds.size()]);
    }
    
    private static String[] getWinners(Round[] rounds) {
    	ArrayList<String> winners = new ArrayList<String>();
  
    	Boolean hasPedra = hasPlay(rounds, PEDRA);
    	Boolean hasPapel = hasPlay(rounds, PAPEL);
    	Boolean hasTesoura = hasPlay(rounds, TESOURA);
    	
    	if(trueCounter(hasPedra, hasPapel, hasTesoura) != 2) {
    		return new String[] {}; // no winner
    	}
    	
    	String play1 = hasPedra ? PEDRA : (hasPapel ? PAPEL : TESOURA);
    	String play2 = "";

    	if(play1.equals(PEDRA)) {
    		play2 = hasPapel ? PAPEL : TESOURA;
    	}
    	else if(play1.equals(PAPEL)) {
    		play2 = hasTesoura ? TESOURA : PEDRA;
    	}
    	else if(play1.equals(TESOURA)) {
    		play2 = hasPedra ? PEDRA : PAPEL;
    	}

    	String winnerPlay = getWinner(play1, play2);
    	
    	for(int i = 0; i < rounds.length; i++) {
    		if(rounds[i].getPlay().equals(winnerPlay))
    			winners.add(rounds[i].getId());
    	} 	
    	
    	return winners.toArray(new String[winners.size()]);
    }
    
    private static String getWinner(String play1, String play2) {
    	
    	if(play1.equals(PEDRA) && play2.equals(TESOURA) 
    			|| play1.equals(PAPEL) && play2.equals(PEDRA) 
    			|| play1.equals(TESOURA) && play2.equals(PAPEL)) {
    		return play1;
    	}
    	
    	return play2;
    }
    
    protected static String[] getDraws(Round[] rounds) {
    	ArrayList<String> draws = new ArrayList<String>();
    	
    	Boolean hasPedra = hasPlay(rounds, PEDRA);
    	Boolean hasPapel = hasPlay(rounds, PAPEL);
    	Boolean hasTesoura = hasPlay(rounds, TESOURA);

    	if(trueCounter(hasPedra, hasPapel, hasTesoura) == 2) { 
    		return new String[] {}; // no draw
    	}
    	
    	for(Round r : rounds) {
    		draws.add(r.getId());
    	}
    	
    	return draws.toArray(new String[draws.size()]);
    }
    
    private String[] getLosers(Round[] rounds, String[] winners) {
    	ArrayList<String> losers = new ArrayList<String>();
    	
    	Boolean isWinner = false;
    	
    	for(Round r : rounds) {
    		for(String w : winners) {
    			if(r.getId() == w) {
    				isWinner = true;
    			}
    		}
    		
    		if(!isWinner) {
    			losers.add(r.getId());
    		}
    		isWinner = false;
    	}
    		
    	return losers.toArray(new String[losers.size()]);
    }
    
    private Boolean playIsValid(String play) {
    	// TODO Talvez tirar
    	if(play == null) {
    		return false;
    	}
    	
    	return play.equals(PEDRA) || play.equals(PAPEL) || play.equals(TESOURA);
    }

    private static Boolean hasPlay(Round[] rounds, String searchPlay) {
    	for(Round p : rounds) {
    		if(p.getPlay().equals(searchPlay)) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    private static int trueCounter(Boolean... obj) {
    	int result = 0;
    	
    	for(Boolean b : obj) {
    		if(b) result ++;
    	}
    	
    	return result;
    }

}
