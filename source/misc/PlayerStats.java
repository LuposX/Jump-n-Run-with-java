package misc;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entity.Player;
import time.Countdown;

public class PlayerStats {
	
	public static void Win(Graphics g, StateBasedGame sbg){
		g.setColor(Color.black);
		g.drawString("You Win!", 400, 200);
		
		if(Player.GameOverSound){
			CreateMusicAndSound.soundYouWin();
			Player.GameOverSound = false;
		}
		
		Player.interation = 0;
		CreateMusicAndSound.bgmusicLevel.stop();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				sbg.enterState(0);
				
				//Setze den Player wieder auf anfangs posi
				Player.HitboxPlayer.setX(30);
				Player.HitboxPlayer.setY(420);
				
				//cancel den coundown timer
				try{
					Countdown.startListener(false);
				} catch(Error e){
					System.out.println(e);
				}
				
				//setze healt auf standart wert
				Player.health = 3;
				
				//Setze Points auf 0
				Player.points = 0;
				
			}
		}, 2000);
	}
	
	public static void Loose(Graphics g, StateBasedGame sbg){

		g.setColor(Color.black);
		g.drawString("Game Over!", 400, 200);
		
		if(Player.GameOverSound){
			CreateMusicAndSound.soundGameOver();
			Player.GameOverSound = false;
		}
		
		Player.interation = 0;
		CreateMusicAndSound.bgmusicLevel.stop();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				sbg.enterState(0);
				
				//Setze den Player wieder auf anfangs posi
				Player.HitboxPlayer.setX(30);
				Player.HitboxPlayer.setY(420);
				
				//cancel den coundown timer
				try{
					Countdown.startListener(false);
				} catch(Error e){
					System.out.println(e);
				}
				
				//setze healt auf standart wert
				Player.health = 3;
				
				//Setze Points auf 0
				Player.points = 0;
				
			}
		}, 2000);
	}
}