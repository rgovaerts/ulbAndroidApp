package com.example.ulbAndroidApp;

import com.agimind.widget.SlideHolder;


import android.os.Bundle;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
//import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity implements View.OnClickListener {

	private SlideHolder mSlideHolder;
	private TextView connectedStatus;
	private Button bNews; 
	private Button bHoraire;
	private Button bConnection;
	private Button bPlan;
	private Button bCours;
	private Button bWebmail;
	private Button bInfo;
	private ImageView startView;
	private WebView Gehol;
	private WebView Webmail;
	private TextView Info;
	private TabHost PlanTabHost;
	private Etudiant mEtudiant;
	private boolean connected;

	//selon un tuto on fait une liste de group mais ici comme on que 1 menu deroulant pour les plan 
	//ca sert un peu a rien de faire une liste, enfin bref on sait jamais dans un futur...
	SparseArray<Group> groups = new SparseArray<Group>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSlideHolder = (SlideHolder) findViewById(R.id.slideHolder);
		/*
		 * toggleView can actually be any view you want.
		 * Here, for simplicity, we're using TextView, but you can
		 * easily replace it with button.
		 * 
		 * Note, when menu opens our textView will become invisible, so
		 * it quite pointless to assign toggle-event to it. In real app
		 * consider using UP button instead. In our case toggle() can be
		 * replaced with open().
		 */
		
		View toggleView = findViewById(R.id.textView);
		toggleView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mSlideHolder.toggle();
			}
		});
		
		initializeVars();

	}
 
	private void initializeVars() {
		// TODO Auto-generated method stub
		
		mEtudiant = new Etudiant();
		connected = false;
		
		connectedStatus = (TextView) findViewById(R.id.connectedStatus);
		
		
		
		bConnection = (Button) findViewById(R.id.bConnection);
		bNews = (Button) findViewById(R.id.bNews);
		bHoraire = (Button) findViewById(R.id.bHoraire);
		bPlan = (Button) findViewById(R.id.bPlan);
		bCours = (Button) findViewById(R.id.bCours);
		bWebmail = (Button) findViewById(R.id.bWebmail);
		bInfo = (Button) findViewById(R.id.bInfo);

		bConnection.setOnClickListener(this);
		bNews.setOnClickListener(this);
		bHoraire.setOnClickListener(this);
		bPlan.setOnClickListener(this);
		bCours.setOnClickListener(this);
		bWebmail.setOnClickListener(this);
		//bFolklore.setOnClickListener(this);
		bInfo.setOnClickListener(this);
		
		updateConnectedStatus();
		/*
		createData();
		ExpandableListView listView = (ExpandableListView) findViewById(R.id.ListPlan);
	    MyExpandableListAdapter adapter = new MyExpandableListAdapter(this,
	        groups);
	    listView.setAdapter(adapter);
	    
	    //listener sur les 3 enfants
	    listView.getChildAt(1).setOnClickListener(this);
	    listView.getChildAt(2).setOnClickListener(this);
	    listView.getChildAt(3).setOnClickListener(this);
		*/
		startView = (ImageView) findViewById(R.id.startView);
		startView.setScaleType(ScaleType.FIT_CENTER);
		
		Gehol = (WebView) findViewById(R.id.webview_gehol);
		WebSettings geholWebSettings = Gehol.getSettings();
		geholWebSettings.setJavaScriptEnabled(true);
		Gehol.setWebViewClient(new WebViewClient());
		
		Webmail = (WebView) findViewById(R.id.webview_webmail);
		WebSettings webmailWebSettings = Webmail.getSettings();
		webmailWebSettings.setJavaScriptEnabled(true);
		Webmail.setWebViewClient(new WebViewClient());
		
		Info = (TextView) findViewById(R.id.textView);
		
		PlanTabHost = (TabHost) findViewById(R.id.tabhost);
		PlanTabHost.setup();
		TabSpec specs = PlanTabHost.newTabSpec("tag1");
		specs.setContent(R.id.Solbosch);
		specs.setIndicator("Solbosch");
		PlanTabHost.addTab(specs);
		specs = PlanTabHost.newTabSpec("tag2");
		specs.setContent(R.id.Plaine);
		specs.setIndicator("Plaine");
		PlanTabHost.addTab(specs);
		specs = PlanTabHost.newTabSpec("tag3");
		specs.setContent(R.id.Erasme);
		specs.setIndicator("Erasme");
		PlanTabHost.addTab(specs);

		loadHTML();
		
		startView.setVisibility(ImageView.VISIBLE);
		Info.setVisibility(TextView.GONE);
		Gehol.setVisibility(WebView.GONE);
		PlanTabHost.setVisibility(TabHost.GONE);
		Webmail.setVisibility(WebView.GONE);
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub

		startView.setVisibility(ImageView.GONE);
		Info.setVisibility(TextView.GONE);
		Gehol.setVisibility(WebView.GONE);
		PlanTabHost.setVisibility(TabHost.GONE);
		Webmail.setVisibility(WebView.GONE);
		
		switch (v.getId()){
		case R.id.bNews:
			Info.setVisibility(TextView.VISIBLE);
			break;
		case R.id.bHoraire:
			Gehol.setVisibility(WebView.VISIBLE);
			Gehol.loadUrl("http://gehol.ulb.ac.be/gehol/");
			break;
		case R.id.bCours:
			
			break;
		case R.id.bWebmail:
			Webmail.setVisibility(WebView.VISIBLE);
			Webmail.loadUrl("https://webmail.vub.ac.be/");
			break;
		case R.id.bFolklore:
			
			break;
		case R.id.bInfo:
			
			break;
		case R.id.bPlan:
			PlanTabHost.setVisibility(TabHost.VISIBLE);
			break;
		case R.id.bConnection:
			// custom dialog
			final Dialog dialog = new Dialog(this);
			dialog.setContentView(R.layout.dialog_connection);
			dialog.setTitle("Connection ULB");
 
			// set the custom dialog components - text, image and button
			final EditText username = (EditText) dialog.findViewById(R.id.username);
			
			final EditText password = (EditText) dialog.findViewById(R.id.password);
			
			Button dialogButton = (Button) dialog.findViewById(R.id.bConnection);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					//Connection de l'étudiant
					mEtudiant.setUserName(username.getText().toString());
					mEtudiant.setPassword(password.getText().toString());
					//reste de la connection...
					//...
					connected = true;
					updateConnectedStatus();
					dialog.dismiss();
				}
			});
			if(connected){
				//se deconnecter...
				//...
				connected = false;
				updateConnectedStatus();
			}
			else
				dialog.show();
			break;
			
		}
	}
	
	public void loadHTML() {
	    
	    WebView wvSolbosch = (WebView) findViewById(R.id.webViewPlanSolbosch);
	    wvSolbosch.loadUrl("file:///android_asset/solbosch.html");
	    
	    WebView wvPlaine = (WebView) findViewById(R.id.webViewPlanLaPlaine);
	    wvPlaine.loadUrl("file:///android_asset/plaine.html");
	    
	    WebView wvErasme = (WebView) findViewById(R.id.webViewPlanErasme);
	    wvErasme.loadUrl("file:///android_asset/erasme.html");
	}
	
	public void updateConnectedStatus(){
		if(connected){
			connectedStatus.setText("Connecté");
			bConnection.setText("Se Déconnecter");
		}
		else{
			connectedStatus.setText("Déconnecté");
			bConnection.setText("Se Connecter");
		}
		
	}

}


