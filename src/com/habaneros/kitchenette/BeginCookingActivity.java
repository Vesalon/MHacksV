package com.habaneros.kitchenette;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BeginCookingActivity extends Activity {

	TextToSpeech tts;
	TextView t;
	TextView step;
	Recipe recipe;
	ArrayList<Step> steps = new ArrayList<Step>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_begin_cooking);
		otherInit();
		
	}

	public void otherInit() {
		recipe = new Recipe("me", "apple pie");
		recipe.addTimedStep("beat the eggs", 30, 21, 13);
		
		step = (TextView) findViewById(R.id.steps);
		step.setText(recipe.getStep(0).toString());
		
		tts=new TextToSpeech(getApplicationContext(), 
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
	   public void onPause(){
	      if(tts !=null){
	         tts.stop();
	         tts.shutdown();
	      }
	      super.onPause();
	   }
	
	public void speakText(View view){
	      String toSpeak = recipe.getFirstStep().toString();
	      tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

	   }

}