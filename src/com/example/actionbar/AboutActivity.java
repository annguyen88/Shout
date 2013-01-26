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
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AboutActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_main);
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
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
    /*  case R.id.friends:
      //  Toast.makeText(this, "Menu Item 1 selected", Toast.LENGTH_SHORT)
        //    .show();
        Intent intent = new Intent(this, FriendView.class);
        startActivity(intent);
        break; */

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
      }

      return true;
    }
    
}
