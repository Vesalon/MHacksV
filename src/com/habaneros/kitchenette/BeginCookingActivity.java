package com.habaneros.kitchenette;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.TextView;

public class BeginCookingActivity extends Activity {

	TextToSpeech tts;
	TextView t;
	TextView s;
	Recipe recipe;
	ArrayList<Step> steps = new ArrayList<Step>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_begin_cooking);
		otherInit();
		
	}

	public void otherInit() {
		t = (TextView) findViewById(R.id.steps);
		s = (TextView) findViewById(R.id.timer);
		Log.d("mashal", "got done w textviews");
		
		recipe = new Recipe("me", "pie");
		recipe.addStep("this is a stepzzzzzz");
		Log.d("mashal", "got done with rec");
		Log.d("mashal", recipe.toString());
//
//		recipe set to recipe that is chosen from ChooseRecipeActivity
//		code should work after this
//
		tts=new TextToSpeech(getApplicationContext(),
		  new TextToSpeech.OnInitListener() {
		  @Override
		  public void onInit(int status) {
		     if(status != TextToSpeech.ERROR){
		         tts.setLanguage(Locale.US);
		        }
		     }
		  });

		
		for (int i = 0; i < recipe.size(); i++) {
			String text = recipe.getFirstStep().toString();
			t.setText(text);
			readStep(recipe, i);
		}
		Log.d("mashal", "tts done?");

	}


	private void textToSpeech(String text) {
		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}

	private void readStep(Recipe recipe, int index) {
		textToSpeech(recipe.getStep(index).toString());
		if(recipe.getFirstStep().isTimed()) {
			new CountDownTimer(recipe.getFirstStep().getDuration() * 1000, 1000) {

			     public void onTick(long millisUntilFinished) {
			         s.setText("seconds remaining: " + millisUntilFinished / 1000);
			     }

			     public void onFinish() {
			         textToSpeech("Done. Do you want to move on?");
			     }
			  }.start();
		}

	}
}