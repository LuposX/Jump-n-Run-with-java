package level2;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import entity.EnemyObject;
import entity.Shuttle;

public class StaticLevel2 {

	private static EnemyObject enemy;
	private Image BG;

	
	public void init(GameContainer gc) throws SlickException {
		BG = new Image("res/img/BGLevel2.jpg");
		
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {	
		BG.draw();
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {

	}	
	
	public boolean PlayerColidesWith(Shape s){
		return false;
	}
}
