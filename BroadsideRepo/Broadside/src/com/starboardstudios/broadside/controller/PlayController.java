package com.starboardstudios.broadside.controller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import com.starboardstudios.broadside.R;
import com.starboardstudios.broadside.gameunits.Model;
import com.starboardstudios.broadside.gameunits.ships.MainShip;

public class PlayController extends BaseController{

	@SuppressLint("NewApi")

	private Model model;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.play_view);
		name="PlayController";
		model = new Model(getBaseContext());
        model.setCurrentActivity(this);
        
        //Below is an example of how to add to the model without keylistener logic! Don't delete!
        model.addUnit(new MainShip(model));
       
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



	}
	
	public void init(){
		
	}

    public void addShip(View view)
    {
        model.addUnit(new MainShip(model));


    }
	
	
}