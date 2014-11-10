package com.example.dbproject;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	   private EditText  username;
	   private EditText  password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    //Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    //Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
	    setContentView(R.layout.fragment_main);
	      username = (EditText)findViewById(R.id.etUserName);
	      password = (EditText)findViewById(R.id.etPass);
	}
	
	public void login(View view){
		InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
	    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
	      if(username.getText().toString().equals("admin") && 
	    	      password.getText().toString().equals("admin")){
	    	      Intent intent=new Intent(this, BookListActivity.class);
	    	      startActivity(intent);
	    	   }	
	    	   else{
	    	      Toast.makeText(getApplicationContext(), "Wrong Credentials",
	    	      Toast.LENGTH_SHORT).show();
	    	   }
		
	}
	public void signup(View view){
		Intent intent=new Intent(this, SignUpScreen.class);
		startActivity(intent);
		
	}
	


}


