package model;

import javafx.beans.property.SimpleStringProperty;

public class Rider {
	private final SimpleStringProperty name_gr;
	private final SimpleStringProperty tracker_m;
	private final SimpleStringProperty horse_m;
	
	private boolean winner;
	
	public Rider(String name,String tracker_m,String horse_m) {
		this.name_gr = new SimpleStringProperty(name);
		this.tracker_m = new SimpleStringProperty(tracker_m);
		this.horse_m = new SimpleStringProperty(horse_m);
		this.winner = false;
		
	}
	
	public String getName_gr() {
		return name_gr.get();
	}
	
	public void setName_gr(String name) {
		this.name_gr.set(name);
	}
	
	public String getTracker_m() {
		return tracker_m.get();
	}
	
	public void setTracker_m(String name) {
		this.tracker_m.set(name);
	}
	
	public String getHorse_m() {
		return horse_m.get();
	}
	
	public void setHorse_m(String name) {
		this.horse_m.set(name);
	}
	
	public boolean getWinner() {
		return winner;
	}
	public void setWinner(boolean win) {
		this.winner = win;
	}
	
}
