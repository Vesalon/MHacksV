package com.habaneros.kitchenette;
import java.net.MalformedURLException;

import com.microsoft.windowsazure.mobileservices.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class CreateRecipeActivity extends Activity {
    private MobileServiceClient mClient;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
            try {
                mClient = new MobileServiceClient("https://kitchenettedata.azure-mobile.net/",
                        "zjMScFfArAtVBTMcVyCZwuqZOmekuS33",this);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

		setContentView(R.layout.activity_create_recipe);
	}
	
	public void toAddStep(View view) {
		Intent i = new Intent(this, AddStepActivity.class);
		startActivity(i);
	
	Item item = new Item();
	item.Text = "Awesome item";
	mClient.getTable(Item.class).insert(item, new TableOperationCallback<Item>() {
	      public void onCompleted(Item entity, Exception exception, ServiceFilterResponse response) {
	            if (exception == null) {
	                  // Insert succeeded
	            } else {
	                  // Insert failed
	            }
	      }
	});


	}
}