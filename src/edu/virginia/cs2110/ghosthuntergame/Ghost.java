/*package edu.virginia.cs2110.ghosthuntergame;

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

 *//**
 * Empty Constructor
 */
/*
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

 *//**
 * Not so empty constructor
 */
/*
public Ghost(Player targetPlayer, ) {
//


//Conrad: the ghost constructor must implement the bones constructor
Bones(targetPlayer.getPlayerLongitude(), targetPlayer.getPlayerLatitude(), map.getLeft, map.getTop, map.getRight, map.getBottom)

<<<<<<< HEAD
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

	
	//the bones class created by conrad
	public class Bones extends Ghost{

		private double longitude;
		private double latitude;
		private boolean pickedUp;
		private double teatherRadius;
		private double startLongitude;
		private double startLatitude;
		private double endLongitude;
		private double endLatitude;

		public void setStartLongitudeLatitude(double[] LatLang) {
			this.startLongitude = LatLang[0];
			this.startLatitude = LatLang[1];
			this.endLongitude = LatLang[2];
			this.endLatitude = LatLang[3];
		}

		public Bones(double userLongitude, double userLatitude,
				double startLongitude, double startLatitude, double userRadius, double endLongitude, double endLatitude) {
			// User longitude/latitude is the point at which the user starts in the
			// game play
			// NOTE: assumed that the player is centered int the map
			// start long/lat is the top left corner of the gameplay field

			

			Random generator = new Random();

			int sectionNum = generator.nextInt(7 + 1);

			switch (sectionNum) {
			case 0:
				sectionNum = 0;
				longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
					userRadius) + 1);
				latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
					userRadius) + 1);
			case 1:
				sectionNum = 1;
				longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
					userRadius) + 1)
						+ calculateLeftBound(userLongitude, startLongitude,
					userRadius);
				latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
					userRadius) + 1);
			case 2:
				sectionNum = 2;
				longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
					userRadius) + 1)
						+ calculateRightBound(userLongitude, endLongitude,
					userRadius);
				//could use end latitude
				latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
					userRadius) + 1);
			case 3:
				sectionNum = 3;
				longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
					userRadius) + 1);
				latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
					userRadius) + 1)
						+ calculateUpperBound(userLatitude, startLatitude,
					userRadius);
			case 4:
				sectionNum = 4;
				longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
					userRadius) + 1)
						+ calculateRightBound(userLongitude, endLongitude,
					userRadius);
				latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
					userRadius) + 1)
						+ calculateUpperBound(userLatitude, startLatitude,
					userRadius);
			case 5:
				sectionNum = 5;
				longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
					userRadius) + 1);
				latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
					userRadius) + 1)
						+ calculateLowerBound(userLatitude, endLatitude,
					userRadius);
			case 6:
				sectionNum = 6;
				longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
					userRadius) + 1)
						+ calculateLeftBound(userLongitude, startLongitude,
					userRadius);
				latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
					userRadius) + 1)
						+ calculateLowerBound(userLatitude, endLatitude,
					userRadius);
			case 7:
				sectionNum = 7;
				longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
					userRadius) + 1)
						+ calculateRightBound(userLongitude, endLongitude,
					userRadius);
				latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
					userRadius) + 1)
						+ calculateLowerBound(userLatitude, endLatitude,
					userRadius);
			default:
				break;
			}

			// TODO: still need to physically put an image of the ghost on the map
		}

		private double calculateLeftBound(double userLongitude,
				double startLongitude, double userRadius) {

			return userLongitude - startLongitude - userRadius;
		}

		private double calculateRightBound(double userLongitude,
				double endLongitude, double userRadius) {

			return endLongitude - userLongitude + userRadius;
		}

		private double calculateUpperBound(double userLatitude,
				double startLatitude, double userRadius) {

			return userLatitude - startLatitude - userRadius;
		}

		private double calculateLowerBound(double userLatitude,
				double endLatitude, double userRadius) {

			return endLatitude - userLatitude  + userRadius;
		}
		
		
		//Conrad:
		//if the ghost is killed, the bones are destroyed
		public void onKilled(){
			this.setHasBones(false) ;
		}
		
		//if the bones are picked up, the bones are destroyed and the ghost is killed
		public void onPickUp(){
			this.setHasBones(false);
			this.onKill();
			
		}
		
		

		/*
		// when the bones are picked up, they are destroyed. when the bones are
		// destroyed, the ghost is also destroyed
		public void onPickUp() {
			// something like this...
			map.removeBones();
			// could use a serial number to keep track of each instance of bones

			// when the bones are picked up, the ghost is destroyed
			ghost.onPickedUp();
		}

		// when the ghost is killed, the ghost no longer exists on the map. When the
		// ghost is killed, the bones are destroyed
		public void onKilled() {
			map.removeBones();
		}*/

	}
=======
>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git

}

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

 *//**
 * 
 * @param elapsedTime
 *            time, in seconds, since drawMap() method was called last.
 *            We'll have to rework this if Android doesn't work the same as
 *            the zombie game from last year. Basically, we have to control
 *            the duration of the movement animation somehow.
 */
/*
public void ghostMove(double elapsedTime) {

// targets player

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


//the bones class created by conrad
public class Bones extends Ghost{

private double longitude;
private double latitude;
private boolean pickedUp;
private double teatherRadius;

public Bones(double userLongitude, double userLatitude,
		double startLongitude, double startLatitude, double userRadius, double endLongitude, double endLatitude) {
	// User longitude/latitude is the point at which the user starts in the
	// game play
	// NOTE: assumed that the player is centered int the map
	// start long/lat is the top left corner of the gameplay field

	

	Random generator = new Random();

	int sectionNum = generator.nextInt(7 + 1);

	switch (sectionNum) {
	case 0:
		sectionNum = 0;
		longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
			userRadius) + 1);
		latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
			userRadius) + 1);
	case 1:
		sectionNum = 1;
		longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
			userRadius) + 1)
				+ calculateLeftBound(userLongitude, startLongitude,
			userRadius);
		latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
			userRadius) + 1);
	case 2:
		sectionNum = 2;
		longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
			userRadius) + 1)
				+ calculateRightBound(userLongitude, endLongitude,
			userRadius);
		//could use end latitude
		latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
			userRadius) + 1);
	case 3:
		sectionNum = 3;
		longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
			userRadius) + 1);
		latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
			userRadius) + 1)
				+ calculateUpperBound(userLatitude, startLatitude,
			userRadius);
	case 4:
		sectionNum = 4;
		longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
			userRadius) + 1)
				+ calculateRightBound(userLongitude, endLongitude,
			userRadius);
		latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
			userRadius) + 1)
				+ calculateUpperBound(userLatitude, startLatitude,
			userRadius);
	case 5:
		sectionNum = 5;
		longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
			userRadius) + 1);
		latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
			userRadius) + 1)
				+ calculateLowerBound(userLatitude, endLatitude,
			userRadius);
	case 6:
		sectionNum = 6;
		longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
			userRadius) + 1)
				+ calculateLeftBound(userLongitude, startLongitude,
			userRadius);
		latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
			userRadius) + 1)
				+ calculateLowerBound(userLatitude, endLatitude,
			userRadius);
	case 7:
		sectionNum = 7;
		longitude = startLongitude + generator.nextInt((int) calculateLeftBound(userLongitude, startLongitude,
			userRadius) + 1)
				+ calculateRightBound(userLongitude, endLongitude,
			userRadius);
		latitude = startLatitude + generator.nextInt((int) calculateUpperBound(userLatitude, startLatitude,
			userRadius) + 1)
				+ calculateLowerBound(userLatitude, endLatitude,
			userRadius);
	default:
		break;
	}

	// TODO: still need to physically put an image of the ghost on the map
}

private double calculateLeftBound(double userLongitude,
		double startLongitude, double userRadius) {

	return userLongitude - startLongitude - userRadius;
}

private double calculateRightBound(double userLongitude,
		double endLongitude, double userRadius) {

	return endLongitude - userLongitude + userRadius;
}

private double calculateUpperBound(double userLatitude,
		double startLatitude, double userRadius) {

	return userLatitude - startLatitude - userRadius;
}

private double calculateLowerBound(double userLatitude,
		double endLatitude, double userRadius) {

	return endLatitude - userLatitude  + userRadius;
}


//Conrad:
//if the ghost is killed, the bones are destroyed
public void onKilled(){
	this.setHasBones(false) ;
}

//if the bones are picked up, the bones are destroyed and the ghost is killed
public void onPickUp(){
	this.setHasBones(false);
	this.onKill();
	
}


// when the bones are picked up, they are destroyed. when the bones are
// destroyed, the ghost is also destroyed
public void onPickUp() {
	// something like this...
	map.removeBones();
	// could use a serial number to keep track of each instance of bones

	// when the bones are picked up, the ghost is destroyed
	ghost.onPickedUp();
}

// when the ghost is killed, the ghost no longer exists on the map. When the
// ghost is killed, the bones are destroyed
public void onKilled() {
	map.removeBones();
}

}

}
 */

