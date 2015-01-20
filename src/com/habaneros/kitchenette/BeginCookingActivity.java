package com.habaneros.kitchenette;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class BeginCookingActivity extends Activity {

	private TextToSpeech tts;
	private Chronometer timer;
	private TextView step;
	private Recipe recipe;
	private ArrayList<Step> steps = new ArrayList<Step>();
	private ArrayList<String> s = new ArrayList<String>();
	private int counter;
	private Button startNext;
	private Button exit;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_begin_cooking);
		Intent intent = getIntent();
		int index = intent.getIntExtra("com.habaneros.Kitchenette.recname", 0);
		recipe = RecipeList.get(index);
		counter = 0;
		startNext = (Button) findViewById(R.id.cooking_startNext);
		exit = (Button) findViewById(R.id.cooking_end);
		step = (TextView) findViewById(R.id.cooking_step);
		timer = (Chronometer) findViewById(R.id.cooking_timer);		
		otherInit();	
	}

	public void otherInit() {
		tts = new TextToSpeech(getApplicationContext(), 
			new TextToSpeech.OnInitListener() {
				@Override
				public void onInit(int status) {
				    if(status != TextToSpeech.ERROR){
				        tts.setLanguage(Locale.UK);
				    }				
				}
			});
	}
	
	@Override
	public void onPause() {
	   if(tts != null){
	      tts.stop();
	      tts.shutdown();
	   }
	   super.onPause();
	}
	
	public void stopCook(View view) {
		if(tts != null){
		   tts.stop();
		   tts.shutdown();
		}
		Intent intent = new Intent(this, ChooseRecipeTypeActivity.class);
        startActivity(intent);
	}	
	
	public void speakText(View view){
		Step current = recipe.getStep(counter);
		step.setText(current.toString());
		if (counter == 0) {
	    	startNext.setText("Next Step");
	    } else if (counter == recipe.size() - 1) {
	    	startNext.setText("");
	    	startNext.setEnabled(false);
	    }
	    tts.speak(current.toString(), TextToSpeech.QUEUE_FLUSH, null);
	    if (current.isTimed()) {
	    	timer.start();
	    }
	    counter++;
	}

}