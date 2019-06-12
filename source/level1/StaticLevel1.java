package level1;

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

import debugging.DebugLines;
import entity.EnemyObject;
import menu.Settings;

public class StaticLevel1 {
	private Shape ground, wall ,wall2, pipe, stairs,
				  itemblock, itemblock2, goal, protectBlock1,
				  protectBlock2;
	
	
	private TiledMap map;
	private int x,y;

	private static EnemyObject enemy;

	
	public void init(GameContainer gc) throws SlickException {
		
		//Level and the different object are created
		map = new TiledMap("res/tiledmaps/bg.tmx");
					
		float[] polygonPointsStairs = new float[] {705,460,
												   705,364,
												   612,460};
		
		float[] polygongoal = new float[] {828,443,
				   						   828,230};
		
		protectBlock1= new Rectangle(404, 361, 17, 1);
		protectBlock2 = new Rectangle(532, 331, 17, 1);
		goal = new Polygon(polygongoal);
		itemblock = new Rectangle(404, 362, 17 ,17);
		itemblock2 = new Rectangle(532, 330, 17 ,17);
		pipe = new Rectangle(278,412,30,50);
		stairs = new Polygon(polygonPointsStairs);
		wall = new Line(0, 0, 0, 500);
		wall2 = new Line(959, 0, 960, 1000);
		ground = new Rectangle(0, 460, 960, 30);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		map.render(0, 0);
		
		//if developer modus on
		if(Settings.ON == "on"){
			//DebugLines.drawDebugLines(g, 20);
			
			//draw hitbox for the lobjects in the game
			g.setColor(Color.magenta);
			g.draw(ground);
			g.draw(wall);
			g.draw(wall2);
			g.draw(itemblock);
			g.draw(itemblock2);
			g.draw(pipe);
			g.draw(stairs);
			g.draw(goal);
			g.draw(protectBlock1);
			g.draw(protectBlock2);
		}
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int t) throws SlickException {
		int objectLayer = map.getLayerIndex("graphic");
		
		map.getTileId(0, 0, objectLayer);
	}
	
	
	//Question if something interact/colides with a other thing zb. Player
	public boolean CollisionWithCoin1(Shape s){
		return itemblock.intersects(s);
	}
	
	public boolean CollisionWithCoin2(Shape s){
		return itemblock2.intersects(s);
	}
	
	public boolean CollisionWithCoin(Shape s){
		return itemblock2.intersects(s) || itemblock.intersects(s);
	}
	
	public boolean CollisionWithPipe(Shape s){
		return  pipe.intersects(s);
	}
	
	public boolean CollisionWithStairs(Shape s){
		return stairs.intersects(s);
	}
	
	public boolean CollisionForEnemy(Shape s){
		return ground.intersects(s) || wall.intersects(s) || wall2.intersects(s);
	}
	
	public boolean CollisionForPlayer(Shape s){
		return ground.intersects(s) 	|| wall.intersects(s) || wall2.intersects(s)
				|| stairs.intersects(s) || pipe.intersects(s) || protectBlock1.intersects(s)
				|| protectBlock2.intersects(s);
	}
	
	public boolean PlayerColidesWithGoal(Shape s){
		return goal.intersects(s);
	}
}
