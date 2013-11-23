package edu.virginia.cs2110.ghosthuntergame;

import java.util.ArrayList;

public class Player {

	private int points;
	//private int exp;
	//private int level;
	private int maxHp;
	private int currentHp;
	private int bombCount;
	private double playerLatitude;
	private double playerLongitude;
	//private ArrayList<String> powerUps;
	
	public Player(){
		this.points=0;
		//this.exp=0;
		//this.level=0;
		this.maxHp=3;
		this.currentHp=0;
		this.bombCount=3;
		this.playerLatitude=0.0;
		this.playerLongitude=0.0;	
	}
	
//	public void gainMoney(int x){
//		money+=x;
//		exp+=x;
//	}
	
	public void hurt(){
		currentHp+= -1;
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}


	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public double getPlayerLatitude() {
		return playerLatitude;
	}

	public void setPlayerLatitude(double playerLatitude) {
		this.playerLatitude = playerLatitude;
	}

	public double getPlayerLongitude() {
		return playerLongitude;
	}

	public void setPlayerLongitude(double playerLongitude) {
		this.playerLongitude = playerLongitude;
	}
	
}
