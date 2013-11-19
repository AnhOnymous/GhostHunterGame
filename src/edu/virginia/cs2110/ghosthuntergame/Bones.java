package edu.virginia.cs2110.ghosthuntergame;

import java.util.Random;

public class Bones {

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

	/*public void generateGhost() {
		ghost(longitude, latitude, teatherRadius);
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
	}*/

}
