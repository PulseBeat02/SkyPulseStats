package org.brandonli.playerstats.skyblock.stats.objectives;

public class Objective {
	
	String name;
	
	String status;
	
	int progress;
	
	String dateCompl;
	
	public Objective(String n, String s, int p, String dc) {
		
		this.name = n;
		this.status = s;
		this.progress = p;
		this.dateCompl = dc;
		
	}

}
