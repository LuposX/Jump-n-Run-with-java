package entity;

import java.lang.annotation.Documented;
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
import misc.CreateMusicAndSound;
import misc.PlayerStats;
import time.Countdown;

public class Player {
	public static boolean collisionCoin = false;
	private Image playerimg;
	private Image CoinBlockEmpty;
	
	protected static float gravity = 0.5f;
	protected static float jumpStrenght = -9.5f;
	protected static float speed = 2;
	
	public static boolean CoinBlockEmpty1= false;
	public static boolean CoinBlockEmpty2 = false;
	
	public static int interation;
	
	public static Shape HitboxPlayer;
	private StaticLevel1 level;
	private EnemyObject enemy;
	
	private float vX = 0;
	private float vY = 0;
	
	protected int hitbox_size;
	public static float PlayerImgX;
	public static float PlayerImgY;
	private float vYtemp;
	private float vXtemp;
	private boolean HitboxHit;
	private float HitboxX;
	private float HitboxY;
	public static boolean GameOverSound;
	private static boolean colideBlock1 = false;
	private static boolean colideBlock2 = false;
	
	public static int health;
	
	private static int coins;
	public static int points;
	private static int pointsBlock1;
	private static int pointsBlock2;
	
	
	public Player(StaticLevel1 level){
		this.level = level;
	}
	
	public void init(GameContainer gc) throws SlickException {
		health = 3;
		
		HitboxHit = true;
		GameOverSound = true;
		
		CoinBlockEmpty = new Image("res/img/CoinBlockEmpty.png");
		playerimg = new Image("res/img/Mario.png");
		
		PlayerImgX = 30;
		PlayerImgY = 420;
		
		HitboxX = 30;
		HitboxY = 420;
		
		hitbox_size = playerimg.getHeight();
		
		HitboxPlayer = new Rectangle(HitboxX, HitboxY, hitbox_size / 2, hitbox_size );
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
			
			//Camera
			//g.translate(-HitboxPlayer.getX(), -HitboxPlayer.getY());
			
			//draw Hitbox Player if Developer modus is on
			if(Settings.ON == "on"){
				g.draw(HitboxPlayer);
			}
		
			g.setColor(Color.red);
			playerimg.draw(PlayerImgX, PlayerImgY);
		
			g.setColor(Color.white);
			
			g.drawString("Health: " + Integer.toString(health), 10, 30);
			g.drawString("Points:" + points, 10, 50);
			g.drawString("Coins:" + coins, 10, 70);
		
			//optisch: if the player get a hit
			if(!HitboxHit){
				g.setColor(Color.red);
				g.drawString("-1 Health", HitboxPlayer.getX(), HitboxPlayer.getY() + -30);
			
			}
		
			//if player reach goal
			if(level.PlayerColidesWithGoal(HitboxPlayer)){
				PlayerStats.Win(g, sbg);
			}  
		
			//if Player Loose
			if(Countdown.timerValue <= 0 || health <= 0){
				PlayerStats.Loose(g, sbg);
			}
			 
			//optisch: zeigt +1coin an
			if(colideBlock1 && pointsBlock1 <= 4 || colideBlock2 && pointsBlock2 <= 1){
				g.setColor(Color.white);
				g.drawString("+1 Coin", HitboxPlayer.getX(), HitboxPlayer.getY() + -30);
			}
			
			//aded points wenn player mit block 1 colidiert
			if(Player.colideBlock1){
				if(pointsBlock1 <= 4){
					pointsBlock1++;
					points += 10;
					coins++;
					CreateMusicAndSound.soundCollectCoin();
				} else {
					CoinBlockEmpty1 = true;
				}
			}
			
			//when coinblock1 is empty
			if(CoinBlockEmpty1){
				g.drawImage(CoinBlockEmpty, 405, 362);
			}
			
			//when coinblock2 is empty
			if(CoinBlockEmpty2){
				g.drawImage(CoinBlockEmpty, 533, 330);
			}
			
			//aded points wenn player mit block 2 colidiert
			if(Player.colideBlock2){
				if(pointsBlock2 <= 1){
					pointsBlock2++;
					points += 10;
					coins++;
					CreateMusicAndSound.soundCollectCoin();
					CoinBlockEmpty2 = false;
			} else {
				CoinBlockEmpty2 = true;
			}
		}
	}


	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		PlayerImgX = HitboxPlayer.getX();
		PlayerImgY = HitboxPlayer.getY();
		
		//Y-acceleration
		vY += gravity;
		
		//if the player intersect with enemy than health--
		if(HitboxPlayer.intersects(EnemyObject.getEnemyHitbox())){
			System.out.println("colides");
			
			if(HitboxHit){
				CreateMusicAndSound.soundHit();
				health--;
				HitboxHit = false;
			}
		}
		
		 else {
			HitboxHit = true;
		}
		
		//Y-Movement-Collisison
		vYtemp = vY/interation;
		for(int i = 0; i < interation; i++){
			HitboxPlayer.setY(HitboxPlayer.getY() + vYtemp);
			
				if(level.CollisionForPlayer(HitboxPlayer)){
					HitboxPlayer.setY(HitboxPlayer.getY() - vYtemp);
					vY = 0; 
			  }
		}
		
		//Nur für coin blöcke
		//genau das gleiche wie bei vX nur halt Vx replact durch vY
		for(int i = 0; i < interation; i++){
			if(level.CollisionWithCoin1(HitboxPlayer)){
				Player.collisionCoin = true;
				colideBlock1 = true;
				
				HitboxPlayer.setY(HitboxPlayer.getY() - vYtemp);
				vY = 0;
				
			} else if(level.CollisionWithCoin2(HitboxPlayer)) {
				Player.collisionCoin = true;
				colideBlock2 = true;
				
				HitboxPlayer.setY(HitboxPlayer.getY() - vYtemp);
				vY = 0;
			
		  } else {
			  Timer timer = new Timer();
			  timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					collisionCoin = false;
					colideBlock1 = false;
					colideBlock2 = false;			
					}
			  	}, 1000);
		  	}
		}	
		
		//Make that the Player run
		if(gc.getInput().isKeyDown(Input.KEY_LSHIFT)){
			speed = 3;

		} else if(!gc.getInput().isKeyDown(Input.KEY_LSHIFT)){
			speed = 2;

		}
		
		//Make that the Player jump
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE)){
			HitboxPlayer.setY(HitboxPlayer.getY() + 0.5f);
			
			if(level.CollisionForPlayer(HitboxPlayer)){
				CreateMusicAndSound.soundJump();
				Player.collisionCoin = false;
				vY = jumpStrenght;
				
			} else if(level.CollisionWithCoin1(HitboxPlayer)){
				CreateMusicAndSound.soundJump();
				Player.collisionCoin = true;
				vY = jumpStrenght;
				
			} else if(level.CollisionWithCoin2(HitboxPlayer)){
				CreateMusicAndSound.soundJump();
				Player.collisionCoin = true;
				vY = jumpStrenght;

			}
			HitboxPlayer.setY(HitboxPlayer.getY() - 0.1f);
		}
		
		//X-acceleration
		if(gc.getInput().isKeyDown(Input.KEY_A)){
			vX = -speed;
			
		} else if(gc.getInput().isKeyDown(Input.KEY_D)){
			vX = speed;
			
		} else {
			vX = 0;
			
		}
		
		//X Movement Collision
		vXtemp = vX/interation;
		for(int i = 0; i < interation; i++){
			HitboxPlayer.setX(HitboxPlayer.getX() + vXtemp);	
				if(level.CollisionForPlayer(HitboxPlayer)){
					HitboxPlayer.setX(HitboxPlayer.getX() - vXtemp);
					vX = 0; 
			  }
		}
		
		//Nur für coin blöcke
		for(int i = 0; i < interation; i++){
				if(level.CollisionWithCoin1(HitboxPlayer)){
					HitboxPlayer.setX(HitboxPlayer.getX() - vXtemp);
					vX = 0;
					//System.out.println("dont get coin");
					Player.collisionCoin = false;
					
			  } else if(level.CollisionWithCoin2(HitboxPlayer)){
				  HitboxPlayer.setX(HitboxPlayer.getX() - vXtemp);
					vX = 0;
					//System.out.println("dont get coin");
					Player.collisionCoin = false;
					
			  } else {
				  Timer timer = new Timer();
				  timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						  Player.collisionCoin = false;					
					}
				}, 2000);  
			}
		}
	}	
}
