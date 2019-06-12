package menu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entity.Player;
import misc.CreateMusicAndSound;

public class Settings extends BasicGameState{
	public static String ON = "off";
	
	public Settings(int settings) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Keyboard/Mouse", 300, 100);
		g.drawString("Walk Left: A", 300, 150);
		g.drawString("Walk Right: D", 300, 170);
		g.drawString("Jump: Space", 300, 190);
		g.drawString("Sprint: SHIFT", 300, 210);
		g.drawString("Back", 30, 430);
		g.drawString("License: CC-BY 4.0", 780, 450);
		g.drawString("Game Settings", 300, 260);
		g.drawString("Developer Modus: " + ON, 300, 300);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//System.out.println("X: " + posX + "Y: " + posY);
		
		//Developer modus button
		if((posX > 290 && posX < 475) && (posY > 160 && posY < 185)){
			//System.out.println("drauf");
			if(Mouse.isButtonDown(0)){
				if(ON == "off") {
					ON = "on";
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					ON = "off";
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
				
				
		//Back button
		if((posX > 25 && posX < 70) && (posY > 30 && posY < 55)){
			//System.out.println("drauf");
			if(Mouse.isButtonDown(0)){
				CreateMusicAndSound.soundMenuClick();
				sbg.enterState(0);
			}
		}
	} 

	public int getID() {
		return 4;
	}	
}
