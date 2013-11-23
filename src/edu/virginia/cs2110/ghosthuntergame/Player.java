package edu.virginia.cs2110.ghosthuntergame;

import java.util.ArrayList;


/**
 * Need an asynk task: constantly compare the players distance with nearby ghosts
 * 
 * need to store the bones and ghost arraylist inside of players, and access them from here
 *
 */
public class Player {

	private int points;
	//private int exp;
	//private int level;
	
	private int currentHp;
	private int bombCount;
	private double playerLatitude;
	private double playerLongitude;
	
	double startLongitude;
	double startLatitude;
	double endLongitude;
	double endLatitude;
	
	public void setStartLongitudeLatitude(double[] LatLang) {
		this.startLongitude = LatLang[0];
		this.startLatitude = LatLang[1];
		this.endLongitude = LatLang[2];
		this.endLatitude = LatLang[3];
	}
	//private ArrayList<String> powerUps;
	
	public Player( double lat, double l){
		this.points=0;
		//this.exp=0;
		//this.level=0;
	
		this.currentHp=3;
		this.bombCount=3;
		this.playerLatitude=lat;
		this.playerLongitude=l;	
	}
	
	//generate bones and ghosts
	public ArrayList<Ghosts> generateGhosts(){
		for(int i; i < 10; i ++){
			Ghost(this);
		}
	}
	
	public ArrayList<Bones> generateBones(){
		
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
