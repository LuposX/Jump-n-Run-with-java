package level2;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entity.EnemyObject;
import entity.Player;
import entity.Shuttle;
import level1.StaticLevel1;
import misc.CreateMusicAndSound;
import time.Countdown;

public class WorldMapLevel2 extends BasicGameState {
	private StaticLevel2 level;
	private Shuttle shuttle;

	
	public WorldMapLevel2(int worldmap) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//timeOn = false;
		level = new StaticLevel2();
		level.init(gc);
		
		shuttle = new Shuttle(level);
		shuttle.init(gc);
		
		//enemy = new EnemyObject(level);
		//enemy.init(gc);
		
		//create the music for the level
		//CreateMusicAndSound.musicMainMenu();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		level.render(gc, g);
		//DebugLines.drawDebugLines(g, 50);	
		shuttle.render(gc, sbg , g);
		
		//enemy.render(gc, sbg, g);
		
		//HitboxIntersect.PlayerLevel(level, player, g);
		//Countdown.createTimer(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		level.update(gc,sbg, t);
		shuttle.update(gc,sbg, t);
		//enemy.update(gc,sbg , t);
	}

	@Override
	public int getID() {
		return 5;
	}
}
