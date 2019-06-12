package time;

public class Timer implements Runnable {
	
	double start = 0;
	int time;
	
	public Timer(int time) {
		this.time = time;
	}
	
	@Override
	public void run() {
		//Damit setzt du die Variable für die Zeit
		Countdown.timerValue = time;
		//Das zurücksetzen des TimeManager ist wichtig!
		reset();
		while(true) {
			if(timePassed(1000)) {
				if(Countdown.timerValue <= 0) {
					break;
				}
				Countdown.timerValue--;
				reset();
			}
		}
		System.out.println("Zeit abgelaufen!");
	}
	
	private boolean timePassed(int millis) {
		if((System.currentTimeMillis() - start) >= millis) {
			return true;
		}
		return false;
	}
	
	private void reset() {
		start = System.currentTimeMillis();
	}

}
