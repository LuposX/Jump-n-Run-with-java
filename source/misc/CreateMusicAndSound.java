package misc;

import java.util.Random;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class CreateMusicAndSound {
	public static Music bgmusic;
	public static Music bgmusicLevel;
	public static Sound soundJump;
	public static Sound collectCoin;
	public static Sound MenuClick;
	public static Music YouWin;

	public static void musicMainMenu(){
		//setting and initzialize die bgmusic
		try {
			bgmusic = new Music("res/otherSounds/Menu.wav");
			bgmusic.loop(1f, 0.2f);
			//System.out.println(bgmusic.getVolume()); 	
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void musicFirstLevel(){
		//setting and initzialize die bgmusic
		try {
			bgmusicLevel = new Music("res/sound/firstLevel.wav");
			bgmusicLevel.loop(1f, 0.1f);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void soundGameOver(){
		try {
			MenuClick = new Sound("res/soundLiabary/Game_Over.wav");
			MenuClick.play(1f, 0.2f);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void soundMenuClick(){
		try {
			MenuClick = new Sound("res/soundLiabary/Menu_Navigate_03.wav");
			MenuClick.play(1f, 0.2f);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void soundCollectCoin(){
		try {
			collectCoin = new Sound("res/soundLiabary/Collect_Point_01.wav");
			collectCoin.play(1f, 0.1f);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void soundHit(){
		try {
			collectCoin = new Sound("res/soundLiabary/Hit_02.wav");
			collectCoin.play(1f, 0.2f);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void soundYouWin(){
		try {
			YouWin = new Music("res/sound/Pew.wav");
			YouWin.play(1f, 0.2f);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static void soundJump(){
		//setting and initzialize die bgmusic
		try {
			Random rand = new Random();
			 int randomNum = rand.nextInt((4 - 1) + 1) + 1;
			
			 if(randomNum == 1){
				 soundJump = new Sound("res/soundLiabary/Jump_00.wav");
				 soundJump.play(1f, 0.15f);
				 
			 } else if(randomNum == 2){
				 soundJump = new Sound("res/soundLiabary/Jump_01.wav");
				 soundJump.play(1f, 0.15f);
				 
			 }else if(randomNum == 3){
				 soundJump = new Sound("res/soundLiabary/Jump_02.wav");
				 soundJump.play(1f, 0.15f);
				 
			 }else if(randomNum == 4){
				 soundJump = new Sound("res/soundLiabary/Jump_03.wav");
				 soundJump.play(1f, 0.15f);
				 
			 }
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}

