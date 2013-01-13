package com.example.actionbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MessageActivity extends Activity {
	String message;
	int twitter = 0;
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_main);
        
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton1);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            	
                if (isChecked) {
                	twitter = 1;
                } else {
                    twitter = 0;
                }
            }
        });
       
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
    
    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        String number = "40404";
        if (twitter == 1) {
        	SmsManager.getDefault().sendTextMessage(number, null, message, null,null);
        }
        
        startActivity(intent);
        
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

      case R.id.menu_shout:
        Toast.makeText(this, "Already in Message View", Toast.LENGTH_SHORT)
            .show();
        break;
        
      case R.id.menu_map:
          Intent intent2 = new Intent(this, MainActivity.class);
          startActivity(intent2);
          break; 
          
      case R.id.menu_settings:
          Intent intent3 = new Intent(this, SettingsActivity.class);
          startActivity(intent3);
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
