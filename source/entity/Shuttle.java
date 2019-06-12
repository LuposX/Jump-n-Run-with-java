package entity;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

import level1.StaticLevel1;
import level2.StaticLevel2;
import misc.CreateMusicAndSound;
import misc.PlayerStats;
import time.Countdown;

public class Shuttle {
	private StaticLevel2 level;
	private float hitbox_size;
	private Shape HitboxShuttle;
	private float HitboxX;
	private float HitboxY;
	private Image shuttleimg;
	private float ShuttleImgX;
	private float ShuttleImgY;
	
	private float vX = 0;
	protected static float speed = 2;


	public Shuttle(StaticLevel2 level){
		this.level = level;
	}
	
	public void init(GameContainer gc) throws SlickException {
		
		shuttleimg = new Image("res/img/Mario.png");
		
		hitbox_size = shuttleimg.getHeight();;
		HitboxX = 100;
		HitboxY = 100;
		
		ShuttleImgX= 100;
		ShuttleImgY = 100;
		
		HitboxShuttle = new Rectangle(HitboxX, HitboxY, hitbox_size / 2, hitbox_size );
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.magenta);
		g.draw(HitboxShuttle);
		
		shuttleimg.draw(ShuttleImgX, ShuttleImgY);
	}


	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		ShuttleImgX = HitboxShuttle.getX();
		ShuttleImgY = HitboxShuttle.getY();
		
		//X-acceleration
		if(gc.getInput().isKeyDown(Input.KEY_A)){
			vX = -speed;
					
		} else if(gc.getInput().isKeyDown(Input.KEY_D)){
			vX = speed;
					
		} else {
			vX = 0;			
		}
	}
}
