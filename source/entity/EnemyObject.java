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
import menu.Settings;

public class EnemyObject {
	public static boolean collision;
	private Image enemyimg;
	
	protected static float gravity = 0.5f;
	protected static float jumpStrenght = -9.5f;
	protected static float speed = -1.5f;
	
	public static int interation = 5;
	
	static Shape HitboxEnemy;
	private StaticLevel1 level;
	
	private float vX = 0;
	private float vY = 0;
	
	protected int hitbox_size;
	protected float x;
	private float y;
	private float vYtemp;
	
	public EnemyObject(StaticLevel1 level){
		this.level = level;
	}
	
	public void init(GameContainer gc) throws SlickException {
		enemyimg = new Image("res/img/Goomba.png");
		
		x=500;
		y=400;
		hitbox_size = enemyimg.getHeight();
		
		HitboxEnemy = new Rectangle(x, y, hitbox_size , hitbox_size );
		collision = false;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {	
		g.setColor(Color.red);
		enemyimg.draw(x, y);
		
		//draw Hitbox Enemy  if Developer modus is on
		if(Settings.ON == "on"){
			g.draw(HitboxEnemy);
		}
		
			
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		
		x = HitboxEnemy.getX();
		y = HitboxEnemy.getY();
		
		//Y-acceleration
		vY += gravity;
		
		//Y-Movement-Collisison
		vYtemp = vY/interation;
		for(int i = 0; i < interation; i++){
			HitboxEnemy.setY(HitboxEnemy.getY() + vYtemp);	
				if(level.CollisionForEnemy(HitboxEnemy)){
					collision = true;
					HitboxEnemy.setY(HitboxEnemy.getY() - vYtemp);
					vY = 0; 
				}
			}
		
		//X-acceleration
		vX = speed;	
		
		//X Movement Collision
		if(level.CollisionWithPipe(HitboxEnemy)){
			speed = 1.5f;
		} else if(level.CollisionWithStairs(HitboxEnemy)){
			speed = -1.5f;
		}
		
		float vXtemp = vX/interation;
		for(int i = 0; i < interation; i++){
			HitboxEnemy.setX(HitboxEnemy.getX() + vXtemp);	
				if(level.CollisionForEnemy(HitboxEnemy)){
					collision = true;
					HitboxEnemy.setX(HitboxEnemy.getX() - vXtemp);
					vX = 0; 
				 }
			}		
		}	
	
	public boolean CollisionWithEnemy(Shape s){
		return HitboxEnemy.intersects(s);
	}
	
	public static Shape getEnemyHitbox(){
		return EnemyObject.HitboxEnemy;
	}
}