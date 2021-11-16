package com.example.montyhall.domain;


public class Box {
	
	private int boxNumber;
	
	private boolean containsMoney;
	
	private boolean selectedByParticipant = false;
	
	public Box(int boxNumber, boolean containsMoney) {
		this.boxNumber = boxNumber;
		this.containsMoney = containsMoney;
		
	}

	public int getBoxNumber() {
		return boxNumber;
	}

	public boolean isContainsMoney() {
		return containsMoney;
	}

	public boolean isSelectedByParticipant() {
		return selectedByParticipant;
	}

	public void setSelectedByParticipant(boolean selectedByParticipant) {
		this.selectedByParticipant = selectedByParticipant;
	}

}
