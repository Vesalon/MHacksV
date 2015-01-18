package com.habaneros.kitchenette;

import java.net.MalformedURLException;

import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;

public class AddStepActivity extends Activity {
	
	private Integer stepNum;
	private String recname;
	private static Recipe recipe;
	private MobileServiceClient msclient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_step);
		Intent intent = getIntent();
		recname = intent.getStringExtra("recname");
		recipe = new Recipe(MainActivity.getName(), recname);
		stepNum = 1;
	}
	
	public void toNextStep(View view) {
		
		recipe.addStep(((EditText) findViewById(R.id.recipeStep)).getText().toString());
		stepNum++;
		TextView t = (TextView) findViewById(R.id.stepNumber);
		t.setText("Step " + String.valueOf(stepNum)+ ".");
		
		
		EditText e = (EditText) findViewById(R.id.recipeStep);
		e.setText("");
	}
	
	//get numbers for text box
	
	public void finishRecipe(View view) {
		
//		Recipe is complete here. Save to DB
		try {
			msclient = new MobileServiceClient("https://kitchenettedata.azure-mobile.net/","zjMScFfArAtVBTMcVyCZwuqZOmekuS33",
					this);
			msclient.getTable(Recipe.class).insert(recipe, new TableOperationCallback<Recipe>() {
			      public void onCompleted(Recipe entity, Exception exception, ServiceFilterResponse response) {
			            if (exception == null) {
			                  // Insert succeeded
			            	//display in long period of time
			            	Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_LONG).show();
			            } else {
			                  // Insert failed
			            	Toast.makeText(getApplicationContext(), "FAILURE", Toast.LENGTH_LONG).show();
			            }
			      }

			});

//			// Insert the new item
//			new AsyncTask<Void, Void, Void>() {
//			    @Override
//			    protected Void doInBackground(Void... params) {
//			        try {
//			            mToDoTable.insert(item).get();
//			            if (!item.isComplete()) {
//			                runOnUiThread(new Runnable() {
//			                    public void run() {
//			                        mAdapter.add(item);
//			                    }
//			                });
//			            }
//			        } catch (Exception exception) {
//			        	Toast.makeText(getApplicationContext(), "FAILURE", Toast.LENGTH_LONG).show();
//			        }
//			        return null;
//			    }
//			}.execute();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Intent intent = new Intent(this, BeginCookingActivity.class);
		intent.putExtra("RECIPE_OBJECT", recipe);
		//should actually go to an intermediate screen which lists time and crap
		startActivity(intent);
		
	}

}
