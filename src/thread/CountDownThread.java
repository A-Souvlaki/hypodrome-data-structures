package thread;

import controller.UserBetController;
import javafx.application.Platform;

public class CountDownThread extends Thread {
	
	private UserBetController ubc;

	private int SECONDS_TIME = 0;
	private int MINUTES_TIME = 3;

	private boolean outOfTime = false;
	
	public CountDownThread(UserBetController ubc) {
		this.ubc = ubc;
	}

	public void run() {
		String tR = "";
		while (!outOfTime) {
			
			try {
				CountDownThread.sleep(100);
				if (SECONDS_TIME == 0) {
					MINUTES_TIME--;
					SECONDS_TIME=60;
				}
				if(MINUTES_TIME<=1) {
					if (SECONDS_TIME < 10) {
						tR = "0"+MINUTES_TIME+":0";
					}else {
						tR = "0"+MINUTES_TIME+":";
					}
					 
				}else if(MINUTES_TIME==0){
					if (SECONDS_TIME < 10) {
						tR = "0"+MINUTES_TIME+":0";
					}else {
						tR = "0"+MINUTES_TIME+":";
					}
				}else {
					if (SECONDS_TIME < 10) {
						tR = "0"+MINUTES_TIME+":0";
					}else {
						tR = "0"+MINUTES_TIME+":";
					}
				}
				String time = (tR+SECONDS_TIME);
				GUIUpdateRunnable fx = new GUIUpdateRunnable(ubc, time);
				Platform.runLater(fx);
				SECONDS_TIME--;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (SECONDS_TIME == 0 && MINUTES_TIME == 0) {
				outOfTime = true;
			}

		}

	}

}
 