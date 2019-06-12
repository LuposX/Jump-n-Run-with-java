package menu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entity.Player;
import misc.CreateMusicAndSound;
import time.Countdown;

public class LevelMenu extends BasicGameState{
	
	public LevelMenu(int leveMenu) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Choose a Level!", 400, 10);
		g.drawString("Level1", 430, 50);
		g.drawString("Level2", 430, 90);
		g.drawString("Back", 30, 430);
		g.drawString("License: CC-BY 4.0", 780, 450);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//System.out.println("X:" + posX + "Y:" + posY);
		
		//Back button
		if((posX > 25 && posX < 70) && (posY > 30 && posY < 55)){
			//System.out.println("drauf");
			if(Mouse.isButtonDown(0)){
				CreateMusicAndSound.soundMenuClick();
				sbg.enterState(0);
			}
		}
				
		//Level1 button
		if((posX > 425 && posX < 490) && (posY > 410 && posY < 430)){
			//System.out.println("drauf");
			if(Mouse.isButtonDown(0)){
				CreateMusicAndSound.soundMenuClick();
				Player.interation = 5;
				CreateMusicAndSound.bgmusic.stop();
				sbg.enterState(2);
				CreateMusicAndSound.musicFirstLevel();
				
				//create time for the level
				try{
					Countdown.startListener(true);	
				} catch(Error e){
					System.out.println(e);
				}
			}
		}
		
		//Level2 Button
		if((posX > 424 && posX < 490) && (posY > 370 && posY < 395)){
			//System.out.println("drauf");
			if(Mouse.isButtonDown(0)){
				CreateMusicAndSound.soundMenuClick();
				Player.interation = 5;
				CreateMusicAndSound.bgmusic.stop();
				sbg.enterState(5);
				CreateMusicAndSound.musicFirstLevel();
				
				//create time for the level
				/*try{
					Countdown.startListener(true);
				} catch(Error e){
					System.out.println(e);
				} */
			}
		}
	} 

	public int getID() {
		return 1;
	}	
}
