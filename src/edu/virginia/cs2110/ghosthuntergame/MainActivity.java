package edu.virginia.cs2110.ghosthuntergame;

import java.util.ArrayList;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends FragmentActivity {
	GoogleMap map;
	LatLng myPosition;
	LatLng bonePosition;
	LatLng ghostPosition;
	Player newPlayer;
	public ArrayList<Marker> boneMarkerList = new ArrayList<Marker>();
	public ArrayList<Marker> ghostMarkerList = new ArrayList<Marker>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// if Google Play Services are available then

		// Getting reference to the SupportMapFragment of activity_main.xml
		SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);

		// Getting GoogleMap object from the fragment
		map = fm.getMap();

		// Enabling MyLocation Layer of Google Map
		map.setMyLocationEnabled(true);

		// Getting LocationManager object from System Service LOCATION_SERVICE
		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		// Creating a criteria object to retrieve provider
		Criteria criteria = new Criteria();

		// Getting the name of the best provider
		String provider = locationManager.getBestProvider(criteria, true);

		// Getting Current Location
		Location location = locationManager.getLastKnownLocation(provider);

		if (location != null) {
			// Getting latitude of the current location
			double latitude = location.getLatitude();

			// Getting longitude of the current location
			double longitude = location.getLongitude();

			myPosition = new LatLng(latitude, longitude);
			// Gameplay area is 2500?x2500? feet around the user
			map.addMarker(new MarkerOptions().position(myPosition).title(
					"Start"));
		}
		// creates new player with current location to generate bones and ghosts
		newPlayer = new Player(myPosition.latitude, myPosition.longitude);

		newPlayer.generateBones();
		newPlayer.generateGhosts();

		// puts bones on map and markers into an arraylist
		for (int i = 0; i < 10; i++) {
			double boneLatitude = newPlayer.getBoneList().get(i).getLatitude();
			double boneLongitude = newPlayer.getBoneList().get(i)
					.getLongitude();
			bonePosition = new LatLng(boneLatitude, boneLongitude);

			Marker boneMarker = map.addMarker(new MarkerOptions().position(
					myPosition).title("bones"));

			boneMarkerList.add(boneMarker);
		}

		// puts ghosts on map and markers into an arraylist
		for (int i = 0; i < 10; i++) {
			double ghostLatitude = newPlayer.getGhostList().get(i)
					.getLatitude();
			double ghostLongitude = newPlayer.getGhostList().get(i)
					.getLongitude();
			ghostPosition = new LatLng(ghostLatitude, ghostLongitude);

			Marker ghostMarker = map.addMarker(new MarkerOptions().position(
					myPosition).title("ghost"));

			ghostMarkerList.add(ghostMarker);
		}

	}

	/**
	 * handles what happens when pick up bones button is pressed bone and ghost
	 * markers removed bone and ghost removed bomb added
	 */
	public void pickUpBones() {
		for (int i = 0; i < boneMarkerList.size(); i++) {
			if ((Math.abs(myPosition.latitude
					- boneMarkerList.get(i).getPosition().latitude)) < 5 * (0.00000274602523)
					&& (Math.abs(myPosition.longitude
							- boneMarkerList.get(i).getPosition().longitude)) < 5 * (0.0000034716614)) {
				boneMarkerList.get(i).remove();
				ghostMarkerList.get(i).remove();
				ghostMarkerList.remove(i);
				boneMarkerList.remove(i);
				newPlayer.removeBones(i);
				newPlayer.removeGhost(i);
				newPlayer.addBomb(1);
			}
		}
	}

	/**
	 * handles what happens when detonate bomb button is pressed
	 */
	public void detonateBomb() {
		if (newPlayer.getBombCount() > 0) {
			newPlayer.useBomb();

		}
		// wipes out all ghosts within certain surrounding area
		// remove ghost marker from map

	}

	
	private class AsyncTask1 extends AsyncTask<LatLng, void, boolean> {
	
		boolean xTrue;
		boolean yTrue;
		int index;
		double xRange;
		double yRange;
		
		@Override
		protected void onPreExecute(){
			
			xTrue = false;
			yTrue = false;
			index = 0;
			//may need to specify which bones we are picking up
			xRange = 0.0000034716614 * 5;
			yRange = 0.00000274602523 * 5;
			
		}
		
		@Override
		protected boolean doInBackground(Object... params){
			//will need to pass in the 
			
			double playerLong = params[0].getPlayerLongitude();
			double playerLat = params[0].getPlayerLatitude();
			
			for(int i = 0; i < params[1].size(); i++){
				if(Math.abs(params[1].get(i).getLongitude() - playerLong) <= xRange){
					xTrue = true;
				}
				if(Math.abs(params[1].get(i).getLatitude() - playerLat) <= yRange){
					yTrue = true;
				}
			}
			if(xTrue == true && yTrue == true){
				return true;
			}
			return false;
		}
		
		
	}
}
