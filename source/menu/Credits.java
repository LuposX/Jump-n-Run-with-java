package menu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entity.Player;
import misc.CreateMusicAndSound;

public class Credits extends BasicGameState{
	
	public Credits(int credits) {
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Programmer: Simon", 300, 100);
		g.drawString("Level Designer: Simon", 300, 150);
		g.drawString("Director: Simon", 300, 200);
		g.drawString("Music & Sound: Little Robot Sound Factory", 300, 250);
		g.drawString("Texture: spriters-resource.com", 300, 300);
		g.drawString("Countdown for Level Time: Lenni0451", 300, 350);
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
	} 

	public int getID() {
		return 3;
	}	
}
