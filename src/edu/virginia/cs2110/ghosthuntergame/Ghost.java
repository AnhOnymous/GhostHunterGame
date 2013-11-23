package edu.virginia.cs2110.ghosthuntergame;

public class Ghost {
	private boolean isActive;
	private boolean hasBones;
	private double ghostLong;
	private double ghostLat;
	private double tetherLimit;

	public Ghost() {
		isActive = true;
		hasBones = true;

		// temporary Ghost and Bones positions until
		// we figure out how we're gonna do this.

		ghostLong = 10.0;
		ghostLat = 10.0;
		tetherLimit = 10.0;
		
	}

	
	
	//Constructor
	public Ghost(Player targetPlayer) {

		
	}

	/**
	 * Returns true if player is less than one foot away from Toast. 
	 * Should decrease player's health somewhere.
	 * @return
	 */
	public boolean hurtPlayer() {
		// 0.00000274602523 Degrees Latitude in ONE foot
		// 0.0000034716614 Degrees Longitude in ONE foot
		// 0.00000621768663 Those two numbers added up for no real reason, but we'll use it.
		
		if ((Math.sqrt(Math.pow((player.getPlayerLatitude() - this.toastX), 2)
				+ (Math.pow(player.getPlayerLongitude() - this.toastY, 2)))) <= 0.00000621768663) {
			return true;
		} else{
			return false;
		}
	}
	
	
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isHasBones() {
		return hasBones;
	}

	public void setHasBones(boolean hasBones) {
		this.hasBones = hasBones;
	}

	public double getGhostLong() {
		return ghostLong;
	}

	public void setGhostLong(double ghostLong) {
		this.ghostLong = ghostLong;
	}

	public double getGhostLat() {
		return ghostLat;
	}

	public void setGhostLat(double ghostLat) {
		this.ghostLat = ghostLat;
	}

	public double getBonesLong() {
		return bonesLong;
	}

	public void setBonesLong(double bonesLong) {
		this.bonesLong = bonesLong;
	}

	public double getBonesLat() {
		return bonesLat;
	}

	public void setBonesLat(double bonesLat) {
		this.bonesLat = bonesLat;
	}



}
