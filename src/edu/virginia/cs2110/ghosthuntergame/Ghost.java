package edu.virginia.cs2110.ghosthuntergame;

public class Ghost {
	private boolean isActive;
	private boolean hasBones;
	private boolean playerInZone;
	private boolean isAggressive = false;
	private double ghostLong; 
	private double ghostLat;
	private double bonesLong;
	private double bonesLat;
	private Player targetPlayer = null;
	
	public Ghost() {
		isActive = true;
		
	}
}
