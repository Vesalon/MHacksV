package com.habaneros.kitchenette;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class LoginActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}
	
    public void toMainScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }	
    private boolean testUsername(String username) {
        return username.matches("\\w{6,12}");
    }
    private boolean testPassword(String password) {
        return password.matches("[0-9]*|[a-z]*");    
    }

}