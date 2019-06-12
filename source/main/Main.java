
package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import main.Game;

public class Main {
	public static void main(String[] args){
		try{
			AppGameContainer app = new AppGameContainer(new Game("Jump´n Run Game"));
			app.setDisplayMode(960, 480, false);
			app.setTargetFrameRate(60);
			app.setVSync(true);
			app.start();
			
		} catch(SlickException e){
			e.printStackTrace();
		}
	}
}
