package com.starboardstudios.broadside.gameunits.projectile;

import android.content.Context;
import android.widget.ImageView;

import com.starboardstudios.broadside.R.drawable;
import com.starboardstudios.broadside.gameunits.BaseUnit;
import com.starboardstudios.broadside.gameunits.Model;

public abstract class Projectile extends BaseUnit {
	protected Context context;
	protected ImageView imageView;
	protected int damage;
	/** Added Z value for possible image scaling */
	protected int z, xSpeed, ySpeed, zSpeed;
	protected float xTarget, yTarget;
    public Model model;


    public Projectile(Model model)
	{
		this.model = model;
		this.context = model.context;
        imageView = new ImageView(context);
 	}
    public Projectile(Model model, int damage)
	{
		this.model = model;
		this.context = model.context;
		this.damage = damage;
        imageView = new ImageView(context);

    }
    public Projectile(Model model, int damage, int x, int y, int z)
	{
		this.model = model;
		this.context = model.context;
		this.damage = damage;
		this.x = x;
		this.y = y;
		this.z = z;
        imageView = new ImageView(context);

    }
    
    public Projectile(Model model, int damage, int x, int y, float xTarget, float yTarget)
  	{
  		this.model = model;
  		this.context = model.context;
  		this.damage = damage;
  		this.x = x;
  		this.y = y;
  		this.xTarget = xTarget;
  		this.yTarget = yTarget;
  		float m = (yTarget - y) / (xTarget-x);
  		xSpeed = 10;
  		if (yTarget < y)
  			ySpeed = (int) -m;
  		else
  			ySpeed = (int) m;
  		
          imageView = new ImageView(context);

      }
    public Projectile(Model model, int damage, int x, int y, int z, int xSpeed, int ySpeed, int zSpeed)
	{
		this.model = model;
		this.context = model.context;
		this.damage = damage;
		this.x = x;
		this.y = y;
		this.z = z;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.zSpeed = zSpeed;
        imageView = new ImageView(context);

    }

    public void collide(BaseUnit collidedWith)
    {
          this.destroy();
    }
    
    public void update() {

    	if(x == xTarget && y == yTarget)
			this.destroy();
    	
        x = x + xSpeed;
		y = y + ySpeed;
		z = z + zSpeed;

		model.runOnMain(new Runnable() {
			public void run() {
				imageView.setX(x);
				imageView.setY(y);
			}

		});

	}
    
    public ImageView getImage()
	{
		return imageView;
	}
    public void destroy()
    {
       model.removeUnit(this);

    }
    public int getDamage()
    {
    	return this.damage;
    }

    public int getX()
    {
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getZ()
	{
		return z;
	}
	public void setZ(int z)
	{
		this.z = z;
	}
	
	public int getxSpeed()
	{
		return xSpeed;
	}
	public void setxSpeed(int xVelo)
	{
		this.xSpeed = xVelo;
	}
	public int getySpeed()
	{
		return ySpeed;
	}
	public void setySpeed(int yVelo)
	{
		this.ySpeed = yVelo;
	}
	public int getzSpeed()
	{
		return zSpeed;
	}
	public void setzSpeed(int zVelo)
	{
		this.zSpeed = zVelo;
	}
	
	public abstract int getDefaultDamage();
	public abstract Projectile create(Model model, int x, int y, int z, int xFireSpeed, int yFireSpeed, int zFireSpeed);
	public abstract Projectile create(Model model, int damage, int x, int y, int z, int xFireSpeed, int yFireSpeed, int zFireSpeed);
	public abstract Projectile create(Model model2, int x, int y, float xTarget, float yTarget);
}
