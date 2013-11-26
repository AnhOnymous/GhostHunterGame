package edu.virginia.cs2110.ghosthuntergame;

import java.util.Random;

public class Bones {

	private double latitude;
	private double longitude;
	private boolean pickedUp;
	private double teatherRadius;
	private double startLongitude;
	private double startLatitude;
	private double endLongitude;
	private double endLatitude;
	private double userLongitude;
	private double userRadius;
	private double userLatitude;

	public Bones(double a, double b, double c, double d) {

		this.startLongitude = a;
		this.startLatitude = b;
		this.endLongitude = c;
<<<<<<< HEAD
		this.endLongitude = d;
		
=======
		this.endLatitude = d;

>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git
		Random generator = new Random();

		int sectionNum = generator.nextInt(7 + 1);
		double sect = 8 * Math.random();
		sectionNum = (int) sect;

		switch (sectionNum) {
		case 0:
			sectionNum = 0;
			longitude = startLongitude
<<<<<<< HEAD
					+ (2500)/3*Math.random();
			latitude = startLatitude
					+ (2500)/3*Math.random();
=======
					+ (this.endLongitude - this.startLongitude) / 3
					* Math.random();
			latitude = startLatitude + (this.endLatitude - this.startLatitude)
					/ 3 * Math.random();
>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git
		case 1:
			sectionNum = 1;
			longitude = startLongitude
<<<<<<< HEAD
					+ (2500)/3*(Math.random()+1);
			latitude = startLatitude
					+ (2500)/3*Math.random();
=======
					+ (this.endLongitude - this.startLongitude) / 3
					* (Math.random() + 1);
			latitude = startLatitude + (this.endLatitude - this.startLatitude)
					/ 3 * Math.random();
>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git
		case 2:
			sectionNum = 2;
			longitude = startLongitude
<<<<<<< HEAD
					+ (2500)/3*(Math.random()+2);
			latitude = startLatitude
					+ (2500)/3*Math.random();
=======
					+ (this.endLongitude - this.startLongitude) / 3
					* (Math.random() + 2);
			latitude = startLatitude + (this.endLatitude - this.startLatitude)
					/ 3 * Math.random();
>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git
		case 3:
			sectionNum = 3;
			longitude = startLongitude
<<<<<<< HEAD
					+ (2500)/3*Math.random();
			latitude = startLatitude
					+ (2500)/3*(Math.random()+1);
//			longitude = startLongitude
//					+ generator.nextInt((int) calculateLeftBound(userLongitude,
//							startLongitude, userRadius) + 1);
//			latitude = startLatitude
//					+ generator.nextInt((int) calculateUpperBound(userLatitude,
//							startLatitude, userRadius) + 1)
//					+ calculateUpperBound(userLatitude, startLatitude,
//							userRadius);
=======
					+ (this.endLongitude - this.startLongitude) / 3
					* Math.random();
			latitude = startLatitude + (this.endLatitude - this.startLatitude)
					/ 3 * (Math.random() + 1);
			// longitude = startLongitude
			// + generator.nextInt((int) calculateLeftBound(userLongitude,
			// startLongitude, userRadius) + 1);
			// latitude = startLatitude
			// + generator.nextInt((int) calculateUpperBound(userLatitude,
			// startLatitude, userRadius) + 1)
			// + calculateUpperBound(userLatitude, startLatitude,
			// userRadius);
>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git
		case 4:
			sectionNum = 4;
			longitude = startLongitude
<<<<<<< HEAD
					+ (2500)/3*(2+Math.random());
			latitude = startLatitude
					+ (2500)/3*(1+Math.random());
=======
					+ (this.endLongitude - this.startLongitude) / 3
					* (2 + Math.random());
			latitude = startLatitude + (this.endLatitude - this.startLatitude)
					/ 3 * (1 + Math.random());
>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git
		case 5:
			sectionNum = 5;
			longitude = startLongitude
<<<<<<< HEAD
			+ (2500)/3*Math.random();
	latitude = startLatitude
			+ (2500)/3*(Math.random()+2);
=======
					+ (this.endLongitude - this.startLongitude) / 3
					* Math.random();
			latitude = startLatitude + (this.endLatitude - this.startLatitude)
					/ 3 * (Math.random() + 2);
>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git
		case 6:
			sectionNum = 6;
			longitude = startLongitude
<<<<<<< HEAD
					+ (2500)/3*(1+Math.random());
			latitude = startLatitude
					+ (2500)/3*(2+Math.random());
=======
					+ (this.endLongitude - this.startLongitude) / 3
					* (1 + Math.random());
			latitude = startLatitude + (this.endLatitude - this.startLatitude)
					/ 3 * (2 + Math.random());
>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git
		case 7:
			sectionNum = 7;
			longitude = startLongitude
<<<<<<< HEAD
					+ (2500)/3*(2+Math.random());
			latitude = startLatitude
					+ (2500)/3*(2+Math.random());
=======
					+ (this.endLongitude - this.startLongitude) / 3
					* (2 + Math.random());
			latitude = startLatitude + (this.endLatitude - this.startLatitude)
					/ 3 * (2 + Math.random());
>>>>>>> branch 'master' of https://github.com/AnhOnymous/GhostHunterGame.git
		default:
			break;
		}

		// TODO: still need to physically put an image of the ghost on the map
	}

	// TODO: stub that checks to see if new bones being created overlapps with
	// existing bones???

	// private double calculateLeftBound(double userLongitude,
	// double startLongitude, double userRadius) {
	//
	// return userLongitude - startLongitude - userRadius;
	// }
	//
	// private double calculateRightBound(double userLongitude,
	// double endLongitude, double userRadius) {
	//
	// return endLongitude - userLongitude + userRadius;
	// }
	//
	// private double calculateUpperBound(double userLatitude,
	// double startLatitude, double userRadius) {
	//
	// return userLatitude - startLatitude - userRadius;
	// }
	//
	// private double calculateLowerBound(double userLatitude, double
	// endLatitude,
	// double userRadius) {
	//
	// return endLatitude - userLatitude + userRadius;
	// }

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

}
