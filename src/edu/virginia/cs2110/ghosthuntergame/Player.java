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
	
	public ArrayList<Ghost> ghostList = new ArrayList<Ghost>();
	public ArrayList<Bones> bonesList = new ArrayList<Bones>();
	
	double startLongitude;
	double startLatitude;
	double endLongitude;
	double endLatitude;
	
	
//	???
//	public void setStartLongitudeLatitude(double[] LatLang) {
//		this.startLongitude = LatLang[0];
//		this.startLatitude = LatLang[1];
//		this.endLongitude = LatLang[2];
//		this.endLatitude = LatLang[3];
//	}
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
	public ArrayList<Ghost> generateGhosts(){
		for(int i = 0; i < 10; i ++){
			Ghost ghost = new Ghost(bonesList.get(i));
			ghostList.add(ghost);
		}
		return ghostList;
	}
	
	public ArrayList<Bones> generateBones(){
		for(int i = 0 ; i < 10; i++){
			Bones bones = new Bones(startLongitude, startLatitude, endLongitude, endLatitude);
			bonesList.add(bones);
		}
		return bonesList;
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


	
	public int getCurrentHp() {
		return currentHp;
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
