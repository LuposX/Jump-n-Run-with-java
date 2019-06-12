package main;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import level1.WorldMapLevel1;
import level2.WorldMapLevel2;
import menu.Credits;
import menu.LevelMenu;
import menu.MainMenu;
import menu.Settings;

public class Game extends StateBasedGame {
	public static final String gameName = "My Jump´n Run Game";
	public static final int startMenu = 0;
	public static final int levelMenu = 1;
	public static final int worldMap1 = 2;
	public static final int credits = 3;
	public static final int settings = 4;
	public static final int worldMap2 = 5;
		
	public Game(String gameName) {
		super(gameName);
		this.addState(new MainMenu(startMenu));
		this.addState(new WorldMapLevel1(worldMap1));
		this.addState(new LevelMenu(levelMenu));
		this.addState(new Credits(credits));
		this.addState(new Settings(settings));
		this.addState(new WorldMapLevel2(worldMap2));
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(startMenu).init(gc, this);
		this.getState(worldMap1).init(gc, this);
		this.getState(levelMenu).init(gc, this);
		this.getState(credits).init(gc, this);
		this.getState(settings).init(gc, this);
		this.getState(worldMap2).init(gc, this);
		this.enterState(startMenu);
	}

}
