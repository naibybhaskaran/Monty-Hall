package com.example.montyhall.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.montyhall.domain.Box;
import com.example.montyhall.domain.GameResult;
import com.example.montyhall.exception.MontyHallException;
import com.example.montyhall.service.GameSimulator;


@RestController
@RequestMapping("/playgame/v1")
public class MontyHallController {
	
	private final GameSimulator gameSimulator = new GameSimulator();
	
	private List<Box> boxes;
	
	@GetMapping
	public ResponseEntity<GameResult> playMontyHall(
			@RequestParam(value="limit", name = "limit", defaultValue="10000") String limit) 
					throws MontyHallException {
		
		var numberOfGames = 0;

		try {
			numberOfGames = Integer.parseInt(limit);
		} catch (NumberFormatException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		if (numberOfGames <= 0) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		var stickWinCount = 0;
		var changeWinCount = 0;

		for(var i=0; i< numberOfGames; i++){

			boxes = gameSimulator.playGame();
			if (boxes.stream()
					.filter(b -> b.isSelectedByParticipant() && b.isContainsMoney())
					.findFirst().isEmpty()) {
				changeWinCount++;
			}else {
				stickWinCount++;
			}
		}

		return new ResponseEntity<>(gameSimulator.getGameResponse(numberOfGames, stickWinCount, changeWinCount), HttpStatus.OK);
	}

}
