package com.starboardstudios.broadside.gameunits.turrets;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.starboardstudios.broadside.R.drawable;
import com.starboardstudios.broadside.gameunits.BaseUnit;
import com.starboardstudios.broadside.gameunits.Model;
import com.starboardstudios.broadside.gameunits.projectile.CannonBall;
import com.starboardstudios.broadside.gameunits.projectile.Projectile;
import com.starboardstudios.broadside.gameunits.projectile.Torpedo;

//Turret 3
public class TorpedoLauncher extends Turret {
	TorpedoLauncher me;

	public TorpedoLauncher(Model model) {
		super(model);
		turretNum = 3;
		me = this;
		this.projectile = new Torpedo(model, -1);
		projectile.setTurret(this);
		/* ARBITRARY VALUES */
		this.fireSpeed = 5;
		this.cooldown = currentCooldown = 180;
		spendSetCost(50);	
		size = (float) .125;
		
		/* Image */
		imageView.setImageResource(drawable.torpedo_launcher); // Set to image
		imageView.setAdjustViewBounds(true);
		imageView.setLayoutParams(new LinearLayout.LayoutParams((int) (model
				.getScreenX() * size), (int) (model.getScreenY() * size))); // Set size
			
		/* Dragging */
		imageView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				imageView.getParent().requestDisallowInterceptTouchEvent(true);
				if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
					System.out.println(view.toString());
					ClipData data = ClipData.newPlainText("", "");
					View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
							imageView);
					view.startDrag(data, shadowBuilder, me, 0);
					view.setVisibility(View.INVISIBLE);
					return true;
				}
				return false;
			}
		});
		System.out.println("TorpedoLauncher is Created");
	}
	
	public TorpedoLauncher(Model model, int x, int y) {
		super(model);
		turretNum = 3;
		me = this;
		this.projectile = new Torpedo(model, -1);
		/* ARBITRARY VALUES */
		this.fireSpeed = 5;
		this.cooldown = currentCooldown = 180;
		setCost(50);	
		size = (float) .125;
		
		this.x = x;
		this.y = y;
		
		/* Image */
		imageView.setImageResource(drawable.torpedo_launcher); // Set to image
		imageView.setAdjustViewBounds(true);
		imageView.setLayoutParams(new LinearLayout.LayoutParams((int) (model
				.getScreenX() * size), (int) (model.getScreenY() * size))); // Set size
	}

	public void update() {
		model.runOnMain(new Runnable() {
			@Override
			public void run() {
				imageView.setX(x);
				imageView.setY(y);
				if (currentCooldown > 0) {
					currentCooldown--;
				} else {
					imageView.setColorFilter(null);
					fire();
					imageView.setColorFilter(null);
				}
			}
		});	
	}

	@Override
	public ImageView getImage() {
		return imageView;
	}

	@Override
	public void collide(BaseUnit collidedWith) {
		// TODO: Turrent available drop.
	}

	@Override
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}


	@Override
	public void setImageView(ImageView image) {
		imageView = image;
	}

	public void setPosition(float x, float y) {
		this.x = (int) x;
		this.y = (int) y;
	}
}
