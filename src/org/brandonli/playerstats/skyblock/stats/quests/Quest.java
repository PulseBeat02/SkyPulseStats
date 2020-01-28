package org.brandonli.playerstats.skyblock.stats.quests;

public class Quest {
	
	String name;
	String status;
	
	String dateStart;
	String dateComp;
	
	public Quest(String n, String s, String ds, String dc) {
		
		this.name = n;
		this.status = s;
		this.dateStart = ds;
		this.dateComp = dc;
		
	}

}
