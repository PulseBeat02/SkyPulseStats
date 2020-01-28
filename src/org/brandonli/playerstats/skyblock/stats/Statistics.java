package org.brandonli.playerstats.skyblock.stats;

public class Statistics {
	
	int health;
	int defense;
	int effectiveHP;
	int strength;
	int speed;
	int critChance;
	int critDamage;
	int intelligence;
	
	public Statistics(int hp, int d, int eHP, int st, int s, int cC, int cD, int i) {
		
		this.health = hp;
		this.defense = d;
		this.effectiveHP = eHP;
		this.strength = st;
		this.speed = s;
		this.critChance = cC;
		this.critDamage = cD;
		this.intelligence = i;
		
	}

}
