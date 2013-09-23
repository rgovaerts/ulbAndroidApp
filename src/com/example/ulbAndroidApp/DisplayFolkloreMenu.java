package com.example.ulbAndroidApp;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.view.View;

public class DisplayFolkloreMenu extends Activity implements View.OnClickListener {

	Button bCP, bTD, bACE;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_folklore_menu);
		
		bCP = (Button) findViewById(R.id.bCP);
		bTD = (Button) findViewById(R.id.bTD);
		bACE = (Button) findViewById(R.id.bACE);
		
		bCP.setOnClickListener(this);
		bTD.setOnClickListener(this);
		bACE.setOnClickListener(this);
		
	}
	
	public void onClick(View v){
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.bCP:
			Intent browserCP = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cerclepolytechnique.be/"));
			startActivity(browserCP);
			break;
		case R.id.bTD:
			Intent browserTD = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ace-ulb.org/public/docs/Agenda_TDs_Fev-Mars_2013.pdf"));
			startActivity(browserTD);
			break;
		case R.id.bACE:
			Intent browserACE = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ace-ulb.org/page/index"));
			startActivity(browserACE);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_display_folklore_menu, menu);
		return true;
	}


}
