package edu.virginia.cs2110.ghosthuntergame;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends FragmentActivity {
	GoogleMap map;
	LatLng myPosition;

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
	}
}
