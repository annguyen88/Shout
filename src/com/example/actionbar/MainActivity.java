package com.example.actionbar;


import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MainActivity extends MapActivity {
	
	MapController mapController;
	
	@Override
	protected boolean isRouteDisplayed() {
	    return false;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	double latitude = 0;  //Storing GPS values
        double longitude = 0; //Storing GPS values
        
    	//Get message from intent
    	LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    	
    	Location loc = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    	
    	Intent intent = getIntent();
    	String message = intent.getStringExtra(MessageActivity.EXTRA_MESSAGE);
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);

       	mapController = mapView.getController();
        
       	
       	//List of People's Locations below
       	
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.sms);
        HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable, this);
        
        List<Overlay> mapOverlays2 = mapView.getOverlays();
        Drawable drawable2 = this.getResources().getDrawable(R.drawable.sms);
        HelloItemizedOverlay itemizedoverlay2 = new HelloItemizedOverlay(drawable2, this);
        
        List<Overlay> mapOverlays3 = mapView.getOverlays();
        Drawable drawable3 = this.getResources().getDrawable(R.drawable.sms);
        HelloItemizedOverlay itemizedoverlay3 = new HelloItemizedOverlay(drawable3, this);
        
        List<Overlay> mapOverlays4 = mapView.getOverlays();
        HelloItemizedOverlay itemizedoverlay4 = new HelloItemizedOverlay(drawable2, this);
        
        // Checks the GPS Coordinates are found or not.
        
        if(loc != null) { 						// Found GPS
	        latitude = loc.getLatitude()*1E6;
	        longitude = loc.getLongitude()*1E6;
        }
        else {									// Didn't find location and giving map random coordinates
        	latitude = 40.523064*1E6;
	        longitude = -74.456191*1E6;
	        message = "Location can't be found";
        }
        
        GeoPoint point = new GeoPoint((int)latitude, (int)longitude);
        OverlayItem overlayitem = new OverlayItem(point, "Andrew Nguyen", message);
        
		mapController.animateTo(point);
		mapController.setZoom(17);
		
		GeoPoint point2 = new GeoPoint(35410000, 139460000);
		OverlayItem overlayitem2 = new OverlayItem(point2, "Sean Penn", "I'm in Japan!");
		
		// Add more locations here
		
		GeoPoint point3 = new GeoPoint((int)((40.49644 * 1E6)), (int)((-74.444561 * 1E6)));
		OverlayItem overlayitem3 = new OverlayItem(point3, "Ivan Aguirre", "At work");
		
		GeoPoint point4 = new GeoPoint((int)(40.504272 * 1E6), (int)(-74.458723 * 1E6));
		OverlayItem overlayitem4 = new OverlayItem(point4, "Nicole Calo", "Out for a run");
		
		GeoPoint point5 = new GeoPoint((int)(40.502934 * 1E6), (int)(-74.449024 * 1E6));
		OverlayItem overlayitem5 = new OverlayItem(point5, "Ivan Dominguez", "Chillin back home");
		
		GeoPoint point6 = new GeoPoint((int)(40.498659 * 1E6), (int)(-74.451599 * 1E6));
		OverlayItem overlayitem6 = new OverlayItem(point6, "Laritza Lopez", "Working");
		
		GeoPoint point7 = new GeoPoint((int)(40.521727 * 1E6), (int)(-74.460837 * 1E6));
		OverlayItem overlayitem7 = new OverlayItem(point7, "Elvison Dominguez", "This is a test");
		
		
		// if location is added remember to add the bottom 2 lines below and create a new "overlayitem" variable
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
		
		itemizedoverlay2.addOverlay2(overlayitem2);
		mapOverlays2.add(itemizedoverlay2);
		
		itemizedoverlay3.addOverlay3(overlayitem3);
		mapOverlays3.add(itemizedoverlay3);
		
		itemizedoverlay4.addOverlay4(overlayitem4);
		mapOverlays4.add(itemizedoverlay4);
		
		itemizedoverlay2.addOverlay2(overlayitem5);
		mapOverlays2.add(itemizedoverlay2);
		
		itemizedoverlay2.addOverlay2(overlayitem6);
		mapOverlays2.add(itemizedoverlay2);
		
		itemizedoverlay2.addOverlay2(overlayitem7);
		mapOverlays2.add(itemizedoverlay2);
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return true;
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);			// Menu Layout
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {				// Conditions for each Menu Selection
    	AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
      switch (item.getItemId()) {
     case R.id.menu_friends:
    	 Intent intent = new Intent(this, FriendList.class);
         startActivity(intent);
         break;

      case R.id.menu_shout:
          Intent intent2 = new Intent(this, MessageActivity.class);
          startActivity(intent2);
          break;
          
      case R.id.menu_delete:
    	  Intent intent3 = new Intent(this, AboutActivity.class);
          startActivity(intent3);
          break;
          
      case R.id.menu_settings:
          Intent intent4 = new Intent(this, SettingsActivity.class);
          startActivity(intent4);
          break;
          
      case R.id.test:
    	  Intent TEST = new Intent(this, SearchBarActivity.class);
          startActivity(TEST);
          break;
          
      default:
        break;
      }

      return true;
    }
    
 
}
