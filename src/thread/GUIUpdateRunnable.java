package thread;

import controller.UserBetController;

public class GUIUpdateRunnable extends Thread {
	
	private UserBetController lc;
	private String time;
	
	public GUIUpdateRunnable(UserBetController lc, String time){
		this.lc = lc;
		this.time = time;
	}
	
	@Override
	public void run(){
		lc.updateTime(time);
	}
}
