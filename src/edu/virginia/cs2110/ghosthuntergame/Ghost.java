package edu.virginia.cs2110.ghosthuntergame;

import java.util.Random;

public class Ghost {
	private boolean isActive;
	private boolean hasBones;
	private boolean playerInZone;
	private boolean isAggressive;
	private double ghostLong;
	private double ghostLat;
	private double longMove;
	private double latMove;
	private double speed;
	private double bonesLong;
	private double bonesLat;
	private double tetherLimit;
	private Player targetPlayer = null;

	/**
	 * Empty Constructor
	 */
	public Ghost() {
		isActive = true;
		hasBones = true;
		playerInZone = false;
		isAggressive = false;
		speed = 1.0;

		// temporary Ghost and Bones positions until
		// we figure out how we're gonna do this.

		ghostLong = 10.0;
		ghostLat = 10.0;
		tetherLimit = 10.0;
		bonesLong = 0.0;
		bonesLat = 0.0;
	}

	/**
	 * Not so empty constructor
	 */
	// public Ghost(Player targetPlayer, ) {
	//
	// }

	public void onBonesPickedUp() {
		onKill();
		// remove image of Bones from Map
		//
	}

	public void onKill() {
		this.isActive = false;
		// remove Ghost from Map
		// don't remove image of Bones so Player can pick them up
	}

	/**
	 * 
	 * @param elapsedTime
	 *            time, in seconds, since drawMap() method was called last.
	 *            We'll have to rework this if Android doesn't work the same as
	 *            the zombie game from last year. Basically, we have to control
	 *            the duration of the movement animation somehow.
	 */
	public void ghostMove(double elapsedTime) {

		// targets player
		/*
		 * if (isAggressive) { this.latMove = this.speed * elapsedTime;
		 * this.longMove = this.speed * elapsedTime;
		 * 
		 * if (targetPlayer.getLat < this.ghostLat) { latMove *= -1; } if
		 * (targetPlayer.getLong < this.ghostLong) { latMove *= -1; }
		 * 
		 * this.ghostLat += this.latMove; this.ghostLong += this.longMove; } //
		 * moves at random else { Random rand = new Random(); this.latMove =
		 * this.speed * elapsedTime; this.longMove = this.speed * elapsedTime;
		 * 
		 * 
		 * if (targetPlayer.getLat < this.ghostLat) { latMove *= -1; } if
		 * (targetPlayer.getLong < this.ghostLong) { latMove *= -1; }
		 * 
		 * this.ghostLat += this.latMove; this.ghostLong += this.longMove;
		 * 
		 * }
		 */
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

	public boolean isPlayerInZone() {
		return playerInZone;
	}

	public void setPlayerInZone(boolean playerInZone) {
		this.playerInZone = playerInZone;
	}

	public boolean isAggressive() {
		return isAggressive;
	}

	public void setAggressive(boolean isAggressive) {
		this.isAggressive = isAggressive;
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getTetherLimit() {
		return tetherLimit;
	}

	public void setTetherLimit(double tetherLimit) {
		this.tetherLimit = tetherLimit;
	}

	public Player getTargetPlayer() {
		return targetPlayer;
	}

	public void setTargetPlayer(Player targetPlayer) {
		this.targetPlayer = targetPlayer;
	}

}
