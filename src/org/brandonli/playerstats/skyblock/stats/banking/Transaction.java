package org.brandonli.playerstats.skyblock.stats.banking;

public class Transaction {
	
	int amount;
	
	String timestamp;
	String action;
	String initiator_name;
	
	public Transaction(int a, String ts, String ac, String in) {
		
		this.amount = a;
		this.timestamp = ts;
		this.action = ac;
		this.initiator_name = in;
		
	}

}
