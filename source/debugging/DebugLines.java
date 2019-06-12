package debugging;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class DebugLines {
	
	//draw grid on the screen for debugging
	public static void drawDebugLines(Graphics g, int size){
		int resolution = 960;
		g.setColor(Color.darkGray);
		for(int i = 0; i < resolution; i += size){
			g.drawLine(i, 0, i, resolution);
			g.drawLine(0, i, resolution, i);
		}
	}
}
