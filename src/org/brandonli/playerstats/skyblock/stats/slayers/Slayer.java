package org.brandonli.playerstats.skyblock.stats.slayers;

import java.util.TreeMap;

public class Slayer {

	String boss;
	
	TreeMap<String, Integer> bosses = new TreeMap<>();
	
	public Slayer(String boss) {
		
		this.boss = boss;
		
		for (int i = 1; i < 5; i++) {
			
			bosses.put(boss + " Slayer " + i, 0);
			
		}
		
	}

}
