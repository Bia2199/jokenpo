package br.com.desafio.jokenpo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.jokenpo.model.Player;
import br.com.desafio.jokenpo.model.Result;
import br.com.desafio.jokenpo.model.Round;
import br.com.desafio.jokenpo.service.PlayerService;
import br.com.desafio.jokenpo.service.RoundService;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class ControllerPlays {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private RoundService partidaService;
    
    @PostMapping("/increment/player/{name}")
    public Player createPlayer(@PathVariable final String name) {
    	
    	Player player = playerService.createPlayer(name);
    	
    	return player;
    }
    
    @DeleteMapping("/decrement/player/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable final String id) {
    	
    	playerService.deletePlayer(id);
    	
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @GetMapping("/players")
    public ArrayList<Player> getPlayers(){
    	
    	ArrayList<Player> players = playerService.getPlayers();
		
    	return players;
    }
    
    @PostMapping("/play")
    public Result verifyWinner(@RequestBody final Round[] json){
    	
    	Result teste = partidaService.verifyResult(json);
    	
    	return teste;
    }

}
