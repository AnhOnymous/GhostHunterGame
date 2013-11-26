package edu.virginia.cs2110.ghosthuntergame;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MainActivity extends FragmentActivity {
	GoogleMap map;
	LatLng myPosition;
	LatLng bonePosition;
	LatLng ghostPosition;
	Player newPlayer;
	public ArrayList<Marker> boneMarkerList = new ArrayList<Marker>();
	public ArrayList<Marker> ghostMarkerList = new ArrayList<Marker>();
	boolean isHurt = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		// Getting reference to the SupportMapFragment of activity_main.xml
		SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);

		// Getting GoogleMap object from the fragment
		map = fm.getMap();

		map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		map.setBuildingsEnabled(true);
		map.setIndoorEnabled(true);

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

			map.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition,
					(float) 16.5));

			map.addPolygon(new PolygonOptions()
					.add(new LatLng(
							location.getLatitude() - 1300 * (0.00000274602523),
							location.getLongitude() - 1300 * (0.0000034716614)),
							new LatLng(
									location.getLatitude() - 1300 * (0.00000274602523),
									location.getLongitude() + 1300 * (0.0000034716614)),
							new LatLng(
									location.getLatitude() + 1300 * (0.00000274602523),
									location.getLongitude() + 1300 * (0.0000034716614)),
							new LatLng(
									location.getLatitude() + 1300 * (0.00000274602523),
									location.getLongitude() - 1300 * (0.0000034716614)),
							new LatLng(
									location.getLatitude() - 1300 * (0.00000274602523),
									location.getLongitude() - 1300 * (0.0000034716614)))
					.strokeColor(Color.BLUE));

			// creates new player with current location to generate bones and
			// ghosts
			newPlayer = new Player(myPosition.latitude, myPosition.longitude);

			newPlayer.generateBones();
			newPlayer.generateGhosts();

			// puts bones on map and markers into an arraylist
			for (int i = 0; i < 10; i++) {
				double boneLatitude = newPlayer.getBoneList().get(i)
						.getLatitude();
				double boneLongitude = newPlayer.getBoneList().get(i)
						.getLongitude();
				bonePosition = new LatLng(boneLatitude, boneLongitude);

				Marker boneMarker = map.addMarker(new MarkerOptions()
						.position(bonePosition)
						.icon(BitmapDescriptorFactory
								.fromResource(R.drawable.tinytoaster))
						.title("toaster"));

				boneMarkerList.add(boneMarker);
			}

			// puts ghosts on map and markers into an arraylist
			for (int i = 0; i < 10; i++) {
				double ghostLatitude = newPlayer.getGhostList().get(i)
						.getLatitude();
				double ghostLongitude = newPlayer.getGhostList().get(i)
						.getLongitude();
				ghostPosition = new LatLng(ghostLatitude, ghostLongitude);

				Marker ghostMarker = map.addMarker(new MarkerOptions()
						.position(ghostPosition)
						.icon(BitmapDescriptorFactory
								.fromResource(R.drawable.toast))
						.title("toast ghost"));

				ghostMarkerList.add(ghostMarker);
			}

			Context context = getApplicationContext();
			Toast toast = Toast.makeText(context, "you have 3 bombs!",
					Toast.LENGTH_SHORT);
			LinearLayout toastLayout = (LinearLayout) toast.getView();
			TextView toastTV = (TextView) toastLayout.getChildAt(0);
			toastTV.setTextSize(30);
			toast.show();

			new checkProximity().execute(newPlayer);
		}
	}

	private class checkProximity extends AsyncTask<Player, Integer, Integer> {

		protected Integer doInBackground(Player... params) {
			while (isHurt == false) {
				for (int i = 0; i < newPlayer.getGhostList().size(); i++) {
					if ((Math.sqrt(Math.pow(
							(newPlayer.getPlayerLatitude() - newPlayer
									.getGhostList().get(i).getLatitude()), 2)
							+ (Math.pow(newPlayer.getPlayerLongitude()
									- newPlayer.getGhostList().get(i)
											.getLongitude(), 2)))) <= (5 * 0.00000621768663)) {
						newPlayer.hurt();
						isHurt = true;

						GameOver();
					}
					if ((Math.sqrt(Math.pow(
							(newPlayer.getPlayerLatitude() - newPlayer
									.getGhostList().get(i).getLatitude()), 2)
							+ (Math.pow(newPlayer.getPlayerLongitude()
									- newPlayer.getGhostList().get(i)
											.getLongitude(), 2)))) <= (25 * 0.00000621768663)) {
						DangerMessage();
					}
				}
			}
			return null;
		}

		private void GameOver() {
			setContentView(R.layout.gameover);
		}

		private void DangerMessage() {
			Context context = getApplicationContext();
			Toast toast = Toast.makeText(context, "you're in danger!",
					Toast.LENGTH_SHORT);
			LinearLayout toastLayout = (LinearLayout) toast.getView();
			TextView toastTV = (TextView) toastLayout.getChildAt(0);
			toastTV.setTextSize(30);
			toast.show();
			new checkProximity().execute(newPlayer);
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

				Context context = getApplicationContext();
				Toast toast = Toast.makeText(context, "toaster grabbed!",
						Toast.LENGTH_SHORT);
				LinearLayout toastLayout = (LinearLayout) toast.getView();
				TextView toastTV = (TextView) toastLayout.getChildAt(0);
				toastTV.setTextSize(30);
				toast.show();

				boneMarkerList.get(i).remove();
				ghostMarkerList.get(i).remove();
				ghostMarkerList.remove(i);
				boneMarkerList.remove(i);
				newPlayer.removeBones(i);
				newPlayer.removeGhost(i);
				newPlayer.addBomb(1);
				newPlayer.addPoints(500);

				Context context2 = getApplicationContext();
				Toast toast2 = Toast.makeText(context, 1 + " bomb gained!",
						Toast.LENGTH_SHORT);
				LinearLayout toastLayout2 = (LinearLayout) toast.getView();
				TextView toastTV2 = (TextView) toastLayout.getChildAt(0);
				toastTV.setTextSize(30);
				toast2.show();
			}
		}
	}

	/**
	 * handles what happens when detonate bomb button is pressed
	 */
	public void detonateBomb() {

		if (newPlayer.getBombCount() > 0) {
			new checkProximity().execute(newPlayer);

			Context context = getApplicationContext();
			Toast toast = Toast.makeText(context, newPlayer.getBombCount() - 1
					+ " bombs remaining!", Toast.LENGTH_SHORT);
			LinearLayout toastLayout = (LinearLayout) toast.getView();
			TextView toastTV = (TextView) toastLayout.getChildAt(0);
			toastTV.setTextSize(30);
			toast.show();

			newPlayer.useBomb();
			for (int i = 0; i < ghostMarkerList.size(); i++) {
				if ((Math.abs(myPosition.latitude
						- boneMarkerList.get(i).getPosition().latitude)) < 50 * (0.00000274602523)
						&& (Math.abs(myPosition.longitude
								- boneMarkerList.get(i).getPosition().longitude)) < 50 * (0.0000034716614)) {
					boneMarkerList.get(i).remove();
					ghostMarkerList.get(i).remove();
					ghostMarkerList.remove(i);
					boneMarkerList.remove(i);
					newPlayer.removeBones(i);
					newPlayer.removeGhost(i);
					newPlayer.addPoints(500);
				}
			}
		}

		else {
			new checkProximity().execute(newPlayer);

			Context context = getApplicationContext();
			Toast toast = Toast.makeText(context, "you have no bombs left!",
					Toast.LENGTH_SHORT);
			LinearLayout toastLayout = (LinearLayout) toast.getView();
			TextView toastTV = (TextView) toastLayout.getChildAt(0);
			toastTV.setTextSize(30);
			toast.show();
		}
	}

	public void bombButton(View view) {
		detonateBomb();
	}

	public void boneButton(View view) {
		pickUpBones();
	}

	public void showPoints(View view) {
		Context context = getApplicationContext();
		Toast toast = Toast.makeText(context,
				"You have " + newPlayer.getPoints() + " points!",
				Toast.LENGTH_LONG);
		LinearLayout toastLayout = (LinearLayout) toast.getView();
		TextView toastTV = (TextView) toastLayout.getChildAt(0);
		toastTV.setTextSize(30);
		toast.show();
	}

	public class GameOver extends Activity {

		/** Called when the activity is first created. */
		@Override
		public void onCreate(Bundle icicle) {
			super.onCreate(icicle);
			setContentView(R.layout.gameover);
		}
	}
}
