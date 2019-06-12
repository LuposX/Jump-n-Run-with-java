package time;

import java.util.Scanner;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


public class Countdown {

public static Thread thread;
public static int timerValue = 0;
private static int startTime = 30;
	
	public static void startListener(boolean StoppOrStar) {
		new Thread(new Runnable() {
			
			@SuppressWarnings({ "resource", "deprecation" })
			@Override
			public void run() {
				   if(StoppOrStar) {
					   //Damit startest du den thread
					   //achte immer darauf den Thread neu zu setzen damit keine Fehler passieren
					   thread = new Thread(new Timer(startTime));
					   thread.start();
					} else if(!StoppOrStar) {
						//So stoppst du den Thread
						thread.stop();
						thread = new Thread(new Timer(startTime));
						}
					}
				}).start();
			}
	
public static void createTimer(Graphics g) {
		
		if(timerValue > 0){
			g.setColor(Color.white);
			g.drawString("Rest Time: " + Integer.toString(timerValue), 830, 10);
		} else {
			g.setColor(Color.white);
			g.drawString("Rest Time: 0", 830, 10);
		}
	}

		}