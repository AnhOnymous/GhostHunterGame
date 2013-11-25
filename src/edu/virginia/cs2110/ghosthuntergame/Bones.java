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
		this.endLongitude = d;

		Random generator = new Random();

		int sectionNum = generator.nextInt(7 + 1);

		switch (sectionNum) {
		case 0:
			sectionNum = 0;
			longitude = startLongitude
					+ generator.nextInt((int) calculateLeftBound(userLongitude,
							startLongitude, userRadius) + 1);
			latitude = startLatitude
					+ generator.nextInt((int) calculateUpperBound(userLatitude,
							startLatitude, userRadius) + 1);
		case 1:
			sectionNum = 1;
			longitude = startLongitude
					+ generator.nextInt((int) calculateLeftBound(userLongitude,
							startLongitude, userRadius) + 1)
					+ calculateLeftBound(userLongitude, startLongitude,
							userRadius);
			latitude = startLatitude
					+ generator.nextInt((int) calculateUpperBound(userLatitude,
							startLatitude, userRadius) + 1);
		case 2:
			sectionNum = 2;
			longitude = startLongitude
					+ generator.nextInt((int) calculateLeftBound(userLongitude,
							startLongitude, userRadius) + 1)
					+ calculateRightBound(userLongitude, endLongitude,
							userRadius);
			// could use end latitude
			latitude = startLatitude
					+ generator.nextInt((int) calculateUpperBound(userLatitude,
							startLatitude, userRadius) + 1);
		case 3:
			sectionNum = 3;
			longitude = startLongitude
					+ generator.nextInt((int) calculateLeftBound(userLongitude,
							startLongitude, userRadius) + 1);
			latitude = startLatitude
					+ generator.nextInt((int) calculateUpperBound(userLatitude,
							startLatitude, userRadius) + 1)
					+ calculateUpperBound(userLatitude, startLatitude,
							userRadius);
		case 4:
			sectionNum = 4;
			longitude = startLongitude
					+ generator.nextInt((int) calculateLeftBound(userLongitude,
							startLongitude, userRadius) + 1)
					+ calculateRightBound(userLongitude, endLongitude,
							userRadius);
			latitude = startLatitude
					+ generator.nextInt((int) calculateUpperBound(userLatitude,
							startLatitude, userRadius) + 1)
					+ calculateUpperBound(userLatitude, startLatitude,
							userRadius);
		case 5:
			sectionNum = 5;
			longitude = startLongitude
					+ generator.nextInt((int) calculateLeftBound(userLongitude,
							startLongitude, userRadius) + 1);
			latitude = startLatitude
					+ generator.nextInt((int) calculateUpperBound(userLatitude,
							startLatitude, userRadius) + 1)
					+ calculateLowerBound(userLatitude, endLatitude, userRadius);
		case 6:
			sectionNum = 6;
			longitude = startLongitude
					+ generator.nextInt((int) calculateLeftBound(userLongitude,
							startLongitude, userRadius) + 1)
					+ calculateLeftBound(userLongitude, startLongitude,
							userRadius);
			latitude = startLatitude
					+ generator.nextInt((int) calculateUpperBound(userLatitude,
							startLatitude, userRadius) + 1)
					+ calculateLowerBound(userLatitude, endLatitude, userRadius);
		case 7:
			sectionNum = 7;
			longitude = startLongitude
					+ generator.nextInt((int) calculateLeftBound(userLongitude,
							startLongitude, userRadius) + 1)
					+ calculateRightBound(userLongitude, endLongitude,
							userRadius);
			latitude = startLatitude
					+ generator.nextInt((int) calculateUpperBound(userLatitude,
							startLatitude, userRadius) + 1)
					+ calculateLowerBound(userLatitude, endLatitude, userRadius);
		default:
			break;
		}

		// TODO: still need to physically put an image of the ghost on the map
	}

	// TODO: stub that checks to see if new bones being created overlapps with
	// existing bones???

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

	private double calculateLowerBound(double userLatitude, double endLatitude,
			double userRadius) {

		return endLatitude - userLatitude + userRadius;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

}
