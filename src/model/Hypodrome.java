package model;

import dataStructures.IHashTable;
import dataStructures.GenericsClasses.HashTable;

public class Hypodrome {
	
	public final static int MAX_USER = 1000;

	private Career career;

	private IHashTable<User> users;

	public Hypodrome() {
		career = new Career();
		users = new HashTable<User>(User.class, 1000);
	}

	public void addAnUser(String name, int id, int riderToBet, double bet) {
		User one = new User(name, id, riderToBet, bet);
		users.insertTable(one, id);
	}

	public User searchUser(int id) {
		return users.search(id);
	}

	public Career getCareer() {
		return this.career;
	}

}
