package com.example.actionbar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.EditText;

public class SearchBarActivity extends Activity {

	private EditText mSearchTerm;
	private EditText mSearchLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_layout);
		setTitle("Search Yelp");
		mSearchTerm = (EditText)findViewById(R.id.searchTerm);
		mSearchLocation = (EditText)findViewById(R.id.searchLocation);
	}

	public void search(View v) {
		String term = mSearchTerm.getText().toString();
		String location = mSearchLocation.getText().toString();
		Intent intent = new Intent(this, YelpSearchListActivity.class);
		intent.setData(new Uri.Builder().appendQueryParameter("term", term).appendQueryParameter("location", location).build());
		startActivity(intent);
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

}
