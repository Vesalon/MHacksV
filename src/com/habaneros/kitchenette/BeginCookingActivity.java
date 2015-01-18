package com.habaneros.kitchenette;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class BeginCookingActivity extends Activity {

	TextToSpeech tts;
	Chronometer t;
	TextView step;
	Recipe recipe;
	ArrayList<Step> steps = new ArrayList<Step>();
	ArrayList<String> s = new ArrayList<String>();
	Bundle b;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Intent intent = getIntent();
		b = intent.getExtras();
		s = b.getStringArrayList("recipe");
		
		for(int j = 0; j < s.size(); j++){
			steps.add(new Step(s.get(j)));
		}
		recipe = new Recipe(steps);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_begin_cooking);
		otherInit();
		
	}

	public void otherInit() {
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