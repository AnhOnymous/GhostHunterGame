package edu.virginia.cs2110.ghosthuntergame;

import java.util.Random;

public class Bones {

	private double latitude;
	private double longitude;
	private boolean pickedUp;


	public Bones(double a, double b) {

//		this.startLongitude = a;
//		this.startLatitude = b;


		this.longitude = a +(0.0000034716614)*(1250)*(2*Math.random()-1);
		this.latitude = b +(0.00000274602523)*(1250)*(2*Math.random()-1);


		// TODO: still need to physically put an image of the ghost on the map
	}

	// TODO: stub that checks to see if new bones being created overlapps with
	// existing bones???

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

}
