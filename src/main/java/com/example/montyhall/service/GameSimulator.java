package com.example.montyhall.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.montyhall.domain.Box;
import com.example.montyhall.domain.GameResult;

public class GameSimulator {

	private List<Box> boxes;

	public List<Box> playGame(){

		boxes = new ArrayList<>(3);

		Box box = new Box(1, true);
		boxes.add(box);
		box = new Box(2, false);
		boxes.add(box);
		box = new Box(3, false);
		boxes.add(box);

		//shuffle the boxes
		Collections.shuffle(boxes);

		//set the first box as selected by participant
		boxes.stream().findFirst()
		.map(b -> {
			b.setSelectedByParticipant(true);
			return b;
		});

		//remove one of the vacant box from the boxes other than the one selected by the participant
		boxes.stream()
		.filter(b -> !b.isSelectedByParticipant() && !b.isContainsMoney())
		.findFirst()
		.ifPresent(b -> {boxes.remove(b);});

		return boxes;

	}

	public GameResult getGameResponse(int numberOfPlays, int stickCount, int changeCount) {

		float stickPercentage = (float)stickCount/numberOfPlays;

		float changePercentage = (float)changeCount/numberOfPlays;

		return new GameResult(numberOfPlays, stickPercentage, changePercentage);

	}

}
