package com.habaneros.kitchenette;
import java.net.MalformedURLException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;

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
		String name = ((EditText) findViewById(R.id.recipeNameInput)).getText().toString();
		
		Intent i = new Intent(this, AddStepActivity.class);
		i.putExtra("recname", name);
		startActivity(i);
	
//	Item item = new Item();
//	item.Text = "Awesome item";
//	mClient.getTable(Item.class).insert(item, new TableOperationCallback<Item>() {
//	      public void onCompleted(Item entity, Exception exception, ServiceFilterResponse response) {
//	            if (exception == null) {
//	                  // Insert succeeded
//	            } else {
//	                  // Insert failed
//	            }
//	      }
//	});


	}
}