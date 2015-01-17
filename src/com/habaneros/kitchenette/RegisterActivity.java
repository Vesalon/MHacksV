package com.habaneros.kitchenette;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class RegisterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}
	
    public void toChooseRecipeTypeScreen(View view) {
        Intent intent = new Intent(this, ChooseRecipeTypeActivity.class);
        startActivity(intent);
    }   
	
    private boolean testUsername(String username) {
        return username.matches("\\w{6,12}");
    }
    private boolean testPassword(String password) {
        return password.matches("[0-9]*|[a-z]*");    
    }
	

}
