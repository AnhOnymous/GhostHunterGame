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
	private double lo;
	private double la;

	public Bones(double a, double b, double c, double d) {

		this.startLongitude = a;
		this.startLatitude = b;
		this.endLongitude = c;		
		this.endLatitude = d;
		
		this.lo= (c-a)*(0.0000034716614);
		this.la= (d-b)*(0.00000274602523);
		Random generator = new Random();

		int sectionNum = generator.nextInt(7 + 1);
		double sect = 8 * Math.random();
		sectionNum = (int) sect;

		switch (sectionNum) {
		case 0:
			sectionNum = 0;
			longitude = startLongitude
					+ (lo)/3*Math.random();
			latitude = startLatitude
					+ (la)/3*Math.random();
			break;
		case 1:
			sectionNum = 1;
			longitude = startLongitude
					+ (lo)/3*(Math.random()+1);
			latitude = startLatitude
					+ (la)/3*Math.random();
			break;
		case 2:
			sectionNum = 2;
			longitude = startLongitude
					+ (lo)/3*(Math.random()+2);
			latitude = startLatitude
					+ (la)/3*Math.random();
			break;
		case 3:
			sectionNum = 3;
			longitude = startLongitude
					+ (lo)/3*Math.random();
			latitude = startLatitude
					+ (la)/3*(Math.random()+1);
			break;
//			longitude = startLongitude
//					+ generator.nextInt((int) calculateLeftBound(userLongitude,
//							startLongitude, userRadius) + 1);
//			latitude = startLatitude
//					+ generator.nextInt((int) calculateUpperBound(userLatitude,
//							startLatitude, userRadius) + 1)
//					+ calculateUpperBound(userLatitude, startLatitude,
//							userRadius);
			// longitude = startLongitude
			// + generator.nextInt((int) calculateLeftBound(userLongitude,
			// startLongitude, userRadius) + 1);
			// latitude = startLatitude
			// + generator.nextInt((int) calculateUpperBound(userLatitude,
			// startLatitude, userRadius) + 1)
			// + calculateUpperBound(userLatitude, startLatitude,
			// userRadius);

		case 4:
			sectionNum = 4;
			longitude = startLongitude
					+ (lo)/3*(2+Math.random());
			latitude = startLatitude
					+ (la)/3*(1+Math.random());
			break;
		case 5:
			sectionNum = 5;
			longitude = startLongitude
			+ (lo)/3*Math.random();
	latitude = startLatitude
			+ (la)/3*(Math.random()+2);
	break;
		case 6:
			sectionNum = 6;
			longitude = startLongitude
					+ (lo)/3*(1+Math.random());
			latitude = startLatitude
					+ (la)/3*(2+Math.random());
			break;
		case 7:
			sectionNum = 7;
			longitude = startLongitude
					+ (lo)/3*(2+Math.random());
			latitude = startLatitude
					+ (la)/3*(2+Math.random());
			break;
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
