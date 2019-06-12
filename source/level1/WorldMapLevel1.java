package level1;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entity.EnemyObject;
import entity.Player;
import misc.CreateMusicAndSound;
import time.Countdown;

public class WorldMapLevel1 extends BasicGameState {
	private StaticLevel1 level;
	private Player player;
	private EnemyObject enemy;
	public static int count;
	private static String countString;
	private boolean timeOn;
	
	public WorldMapLevel1(int worldmap) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		timeOn = false;
		level = new StaticLevel1();
		level.init(gc);
		
		player = new Player(level);
		player.init(gc);
		
		enemy = new EnemyObject(level);
		enemy.init(gc);
		
		//create the music for the level
		CreateMusicAndSound.musicMainMenu();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		level.render(gc, g);
		//DebugLines.drawDebugLines(g, 50);	
		player.render(gc, sbg , g);
		
		enemy.render(gc, sbg, g);
		
		//HitboxIntersect.PlayerLevel(level, player, g);
		Countdown.createTimer(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		level.update(gc,sbg, t);
		player.update(gc,sbg, t);
		enemy.update(gc,sbg , t);
	}

	@Override
	public int getID() {
		return 2;
	}
}
