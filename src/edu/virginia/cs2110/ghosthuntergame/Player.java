package edu.virginia.cs2110.ghosthuntergame;

import java.util.ArrayList;

public class Player {

	private int money;
	private int exp;
	private int level;
	private int maxHp;
	private int currentHp;
	private double playerLatitude;
	private double playerLongitude;
	private ArrayList<String> powerUps;
	
	public Player(){
		this.money=0;
		this.exp=0;
		this.level=0;
		this.maxHp=100;
		this.currentHp=0;
		this.playerLatitude=0.0;
		this.playerLongitude=0.0;
	}
	
	public void gainMoney(int x){
		money+=x;
		exp+=x;
	}
	
	public void hurt(){
		currentHp+= -10;
	}
	
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public ArrayList<String> getPowerUps() {
		return powerUps;
	}

	public void setPowerUps(ArrayList<String> powerUps) {
		this.powerUps = powerUps;
	}

	
}
