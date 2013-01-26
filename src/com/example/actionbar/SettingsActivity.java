/*
 * Project: Shout!
 * 
 * An Android Application
 * Created by Andrew Nguyen
 * December 2012
 * 
 */

package com.example.actionbar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SettingsActivity extends Activity {
	String message;
	int twitter = 0;
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);
        
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
        inflater.inflate(R.menu.context_menu, menu);
    }
    
    public void openWebURL(View view) {
    	String inURL = "http://www.twitter.com";
        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

        startActivity( browse );
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

       case R.id.menu_map:
           Intent intent5 = new Intent(this, MainActivity.class);
           startActivity(intent5);
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
    
    public void onToggleClicked(View view) {

    	String messageToSend = "This is a test";
    	String number = "7324767729";
    	
        boolean on = ((ToggleButton) view).isChecked();
        
        if (on) {
        	 SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null,null);
        } else {
            // Disable vibrate
        }
    }
    
}
