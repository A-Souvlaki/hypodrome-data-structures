package model;

public class User {
	
	private String name;
	private int id;
	private int riderToBet;
	private double bet;
	
	public User(String name, int id,int riderToBet,double bet) {
		this.name = name;
		this.id = id;
		this.riderToBet = riderToBet;
		this.bet = bet;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public double getBet() {
		return bet;
	}
	
	public int getRiderToBet() {
		return riderToBet;
	}

}
