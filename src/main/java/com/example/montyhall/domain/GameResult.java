package com.example.montyhall.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameResult {
	
	@JsonProperty(value = "numberOfGames")
	private int numberOfGames;
	
	@JsonProperty(value = "stickWinProbability")
	private float stickWinProbability;
	
	@JsonProperty(value = "changeWinProbability")
	private float changeWinProbability;

	public GameResult() {
		
	}
	
	public GameResult(int numberOfGames, float stickWinProbability, float changeWinProbability) {
		this.numberOfGames = numberOfGames;
		this.stickWinProbability = stickWinProbability;
		this.changeWinProbability = changeWinProbability;
	}

	public int getNumberOfGames() {
		return numberOfGames;
	}

	public void setNumberOfGames(int numberOfGames) {
		this.numberOfGames = numberOfGames;
	}

	public float getStickWinProbability() {
		return stickWinProbability;
	}

	public void setStickWinProbability(float stickWinProbability) {
		this.stickWinProbability = stickWinProbability;
	}

	public float getChangeWinProbability() {
		return changeWinProbability;
	}

	public void setChangeWinProbability(float changeWinProbability) {
		this.changeWinProbability = changeWinProbability;
	}
	
}
