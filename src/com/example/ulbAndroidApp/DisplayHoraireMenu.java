package com.example.ulbAndroidApp;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DisplayHoraireMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_horaire_menu);
		WebView webviewGehol = new WebView(this);
		webviewGehol=(WebView)findViewById(R.id.webview_gehol);
		WebSettings webSettings = webviewGehol.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webviewGehol.setWebViewClient(new WebViewClient());
		webviewGehol.loadUrl("http://gehol.ulb.ac.be/gehol/");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_display_horaire_menu, menu);
		return true;
	}
	


}
