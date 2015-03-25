package com.ted.rdcar;

import com.example.rdcar.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.ted.rdcar.map.Directions;
import com.ted.rdcar.map.Navigator;
import com.ted.rdcar.map.Navigator.OnPathSetListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	private GoogleMap map;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		        .getMap();
		Navigator nav = new Navigator(map,HAMBURG,KIEL);
		nav.findDirections(true);
		map.setMyLocationEnabled( true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 16));
		
		nav.setOnPathSetListener(new OnPathSetListener() {
			
			@Override
			public void onPathSetListener(Directions directions) {
				
				
			}
		});
		
//	        Marker nkut = map.addMarker(new MarkerOptions().position(NKUT)
//					.title("南開科技大學").snippet("數位生活創意系"));
//
//	        // Move the camera instantly to NKUT with a zoom of 16.
//	        map.moveCamera(CameraUpdateFactory.newLatLngZoom(NKUT, 16));
//	    
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
