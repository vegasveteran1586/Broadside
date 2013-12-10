package com.starboardstudios.broadside.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.starboardstudios.broadside.R;

public class CreditsController extends BaseController {
	int slide;
	
	final Context context = this;
	private Button exitButton;
	private Button nextButton;
	private TextView title;
	private TextView credits;
	
	//@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.credits_view);
		
		exitButton = (Button)findViewById(R.id.ExitButton);
		nextButton = (Button)findViewById(R.id.NextButton);
		title = (TextView)findViewById(R.id.TitleText);
		credits = (TextView)findViewById(R.id.CreditsText);
		
		exitButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				gotoMMenu();
			}
		});
		
		nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (slide) {
					case 0:
						slide++;
						setCreditsToDevelopers();
						break;
						
					case 1:
						slide++;
						setCreditsToMusic();
						break;
						
					default:
						slide = 0;
						gotoMMenu();
						break;
				}
			}
		});
		
		slide = 0;
		setCreditsToStudio();
	}
	
	public void gotoMMenu() {
		Intent optionsIntent = new Intent(this, HomeController.class);
		startActivity(optionsIntent);
	}
	
	public void setCreditsToMusic() {
		title.setText("Music and Sounds:");
		title.setTextSize(1, 30);
		credits.setText(Html.fromHtml("<p>Credits to the music and sounds we use need to be entered</p>"));
		credits.setTextSize(1,20);
	}
	
	public void setCreditsToDevelopers() {
		title.setText("Developers:");
		title.setTextSize(1, 24);
		credits.setText(Html.fromHtml("<p>Martin Dinkov &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Aaron Lamb &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Matthew LoGalbo</p> <p></p> <p>Graham Logan &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Connor McCoy &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Matt Patrick</p> <p></p>Daniel Rincon &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Alex Whiteside &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Kevin Win<p/>"));
		credits.setTextSize(1,20);
	}
	
	public void setCreditsToStudio() {
		title.setText("Brought to you by:");
		title.setTextSize(1, 24);
		credits.setText(Html.fromHtml("StarBoard Studios"));
		credits.setTextSize(1,20);
	}

	@Override
	public void playMusic() {
		//
	}
}
