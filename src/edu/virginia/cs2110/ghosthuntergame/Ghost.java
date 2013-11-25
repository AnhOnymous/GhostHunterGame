package edu.virginia.cs2110.ghosthuntergame;

public class Ghost {

	private double ghostLong;
	private double ghostLat;
	private double tetherLat;
	private double tetherLong;
	private double boneLat;
	private double boneLong;

	// public Ghost() {
	// ghostLong = 10.0;
	// ghostLat = 10.0;
	// tetherLimit = 10.0;
	//
	// }

	// Constructor
	// TODO: takes the bone's lat and long and creates a ghost somewhere inside
	// the teather limit
	// ???how big would it be in terms of lat/long points to make it a constant
	// size in feet
	public Ghost(Bones bones) {

		boneLat = bones.getLatitude();
		boneLong = bones.getLongitude();
		tetherLat = 50 * 0.00000274602523;
		tetherLong = 50 * 0.0000034716614;
		ghostLat = boneLat+tetherLat*(2*Math.random()-1);
		ghostLong = boneLong+tetherLong*(2*Math.random()-1);
		// Anh: THIS IS WHERE YOU WRITE IT (THE METHOD THAT YOU NEED TO
		// WRITE)???????
	}

	// //PUT THIS IN ASYNC TASK
	// /**
	// * Returns true if player is less than one foot away from Toast. Should
	// * decrease player's health somewhere.
	// *
	// * @return
	// */
	// public boolean hurtPlayer() {
	// // 0.00000274602523 Degrees Latitude in ONE foot
	// // 0.0000034716614 Degrees Longitude in ONE foot
	// // 0.00000621768663 Those two numbers added up for no real reason, but
	// // we'll use it.
	//
	// // change back to ghosts
	// if ((Math.sqrt(Math.pow((player.getPlayerLatitude() - this.toastX), 2)
	// + (Math.pow(player.getPlayerLongitude() - this.toastY, 2)))) <=
	// 0.00000621768663) {
	// return true;
	// } else {
	// return false;
	// }
	// }

	public double getLongitude() {
		return ghostLong;
	}

	public double getLatitude() {
		return ghostLat;
	}

}
