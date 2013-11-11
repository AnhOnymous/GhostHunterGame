package edu.virginia.cs2110.ghosthuntergame;

import java.util.Random;

public class Bones {

	private double longitude;
	private double latitude;
	private boolean pickedUp;
	private double teatherRadius;
	
	public Bones(double userLongitude, double userLatitude, double startLongitude, double startLatitude, double userRadius){
		//User longitude/latitude is the point at which the user starts in the game play
		//NOTE: assumed that the player is centered int the map
		//start long/lat is the top left corner of the gameplay field
		
		
		//these methods must calculate the distance between the internal boundry and the external boundry, respecting whether they are lat/long
		double left = calculateLeftBound(userLongitude, startLongitude, userRadius);
		double right = calculateRightBound(userLongitude, startLongitude, userRadius);
		double upper = calculateUpperBound(userLatitude, startLatitude, userRadius);
		double lower = calculateLowerBound(userLatitude, startLatitude, userRadius);
		
		Random generator = new Random();
		
		int sectionNum = generator.nextInt(7 + 1);
		
		switch(sectionNum){
		case 0: sectionNum = 0;
			longitude = startLongitude + generator.nextInt((int)left+ 1);
			latitude = startLatitude + generator.nextInt((int) upper + 1);
		case 1: sectionNum = 1;
		longitude = startLongitude + generator.nextInt((int)left + 1) + left;
		latitude = startLatitude + generator.nextInt((int) upper + 1);
		case 2: sectionNum = 2;
		longitude = startLongitude + generator.nextInt((int)left + 1) + right;
		latitude = startLatitude + generator.nextInt((int) upper + 1);
		case 3: sectionNum = 3;
		longitude = startLongitude + generator.nextInt((int)left + 1);
		latitude = startLatitude + generator.nextInt((int) upper + 1) + upper;
		case 4: sectionNum = 4;
		longitude = startLongitude + generator.nextInt((int)left + 1) + right;
		latitude = startLatitude + generator.nextInt((int) upper + 1) + upper;
		case 5: sectionNum = 5;
		longitude = startLongitude + generator.nextInt((int)left + 1);
		latitude = startLatitude + generator.nextInt((int) upper + 1) + lower;
		case 6: sectionNum = 6;
		longitude = startLongitude + generator.nextInt((int)left + 1) + left;
		latitude = startLatitude + generator.nextInt((int) upper + 1) + lower;
		case 7: sectionNum = 7;
		longitude = startLongitude + generator.nextInt((int)left + 1) + right;
		latitude = startLatitude + generator.nextInt((int) upper + 1) + lower;
		default: break;
		}
		
		//TODO: still need to physically put an image of the ghost on the map
	}

	private double calculateLeftBound(double userLongitude, double startLongitude, double userRadius) {
		
		return userLongitude - startLongitude - userRadius;
	}

	private double calculateRightBound(double userLongitude, double startLongitude, double userRadius) {
		
		return userLongitude - startLongitude + userRadius;
	}

	private double calculateUpperBound(double userLatitude, double startLatitude, double userRadius) {
		
		return userLatitude - startLatitude - userRadius;
	}

	private double calculateLowerBound(double userLatitude, double startLatitude, double userRadius) {
		
		return userLatitude - startLatitude - userRadius;
	}
	
	public void generateGhost(){
		ghost(longitude, latitude, teatherRadius);
	}
	
	//when the bones are picked up, they are destroyed. when the bones are destroyed, the ghost is also destroyed
	public void onPickUp(){
		//something like this...
		map.removeBones();
		//could use a serial number to keep track of each instance of bones
		
		//when the bones are picked up, the ghost is destroyed
		ghost.onPickedUp();
	}
	
	//when the ghost is killed, the ghost no longer exists on the map. When the ghost is killed, the bones are destroyed
	public void onKilled(){
		map.removeBones();
	}
	
	
}
