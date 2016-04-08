package contact.space.android;

import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactSpace extends Activity {
    /** Called when the activity is first created. */
	Button btnShow;
	Button btnLogin;
	ListView showConatctList;
	ProgressDialog dialog;
	ArrayAdapter adapter;
	Handler backHandler = new Handler(){
		public void handleMessage(Message msg){
			switch (msg.what) {
			case 1:
				if (dialog != null) {
					dialog.setTitle("Finished");
					dialog.dismiss();
				}
				showConatctList.setAdapter(adapter);
			}
			super.handleMessage(msg);
		}
		
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
          
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    	btnShow = (Button)findViewById(R.id.show);
    	btnLogin = (Button)findViewById(R.id.login);
    	showConatctList = (ListView)findViewById(R.id.contactList);
    	btnShow.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				showProgress();
		    	ReadContact();
		    	//NotifyHandler(1, 1000);
		    	
			}
    		
    	});
    	btnLogin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				;
				ContactSpaceAPI.decrypt(ContactSpaceAPI.encrypt("amit", "rEqrHrhdd9I1sg=="), "rEqrHrhdd9I1sg==");
				loginScreen();
			}
    		
    	});
    	showProgress();
    	Thread th = new Thread(){
    		public void run(){
    			
		    	ReadContact();
		    	
    		}
    	};
    	th.start();
    	
    }
    
   public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	menu.add(0, 1, Menu.NONE, "Settings");
    	menu.add(0, 2, Menu.NONE, "Upload Contact");
    	menu.add(0, 3, Menu.NONE, "Download Contact");

	   return true; 
   }
    
    public void ReadContact(){
    	Vector<String> listContact = new Vector();
    	ContentResolver cr = getContentResolver();

    	Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

    	if (cur.getCount() > 0) 
    	{

    	   while (cur.moveToNext()) 
    	    {

    	       String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
    	       Log.w("id:: ",id);
    	       String name = cur.getString(  cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));  
    	       Log.w("name::",name);
    	       
    	       if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
    	    {
    	          Cursor pCur = cr.query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?", new String[]{id}, null);    
    	          while (pCur.moveToNext())
    	          {
    	        	  String lname = pCur.getString( pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
    	        	  Log.w("Phone number:: ",lname);
    	        	  listContact.add(name +": "+ lname);
    	          } 
    	        pCur.close();
    	    }                  
    	    }
    	}
    	
    	adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listContact.toArray(new String[0]) );

    	NotifyHandler(1, 1000);
    }


    public void loginScreen(){
    	LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(250,
				160);

		LinearLayout layout = new LinearLayout(this.getBaseContext());
		layout.setOrientation(LinearLayout.VERTICAL);
		final EditText editSSID = new EditText(this.getBaseContext());
		editSSID.setWidth(250);
		TextView username = new TextView(this.getBaseContext());
		username.setText("Username");
		username.setWidth(250);
		EditText password = new EditText(this.getBaseContext());
		editSSID.setWidth(250);
		TextView pass = new TextView(this.getBaseContext());
		pass.setText("Password");
		pass.setWidth(250);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Login to contactSpace").setMessage(
				"Please enter username and password");
		layout.addView(username);
		layout.addView(editSSID);
		layout.addView(pass);
		layout.addView(password);
		layout.setLayoutParams(params1);
		builder.setView(layout).setPositiveButton("Login",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
							Toast.makeText(
									ContactSpace.this
											.getApplicationContext(),
									"SSID should not be blank!", 500).show();
						
					}
				});

		builder.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dlg, int which) {
						dlg.cancel();
					}
				}).show();
    }
    
    public void showProgress() {
		dialog = new ProgressDialog(this);
		dialog = ProgressDialog.show(this, "Please wait..",
				"Fetching contacts...", true, true,
				new DialogInterface.OnCancelListener() {
					@Override
					public void onCancel(DialogInterface dilog) {

					}
				});

		// handler.removeCallbacks(sendUpdatesToUI);
		// handler.postDelayed(sendUpdatesToUI, 1000); // 1 second

		dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

			@Override
			public void onDismiss(DialogInterface dialog) {
				if (dialog != null)
					dialog.dismiss();
			}
		});
	}
   public void NotifyHandler(int mssg, long delay) {
		Message msg = new Message();
		msg.what = mssg;
		backHandler.sendMessageDelayed(msg, delay);

	}
}