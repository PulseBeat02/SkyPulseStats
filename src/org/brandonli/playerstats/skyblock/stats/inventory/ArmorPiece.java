package org.brandonli.playerstats.skyblock.stats.inventory;

public class ArmorPiece {

	String name;

	int healthBoost;
	int defenseBoost;
	int speedBoost;
	int intelligenceBoost;

	String[] enchantments = {};

	String rune;
	String ability;

	public ArmorPiece(String n, int hb, int db, int sb, int ib, String[] ench, String r, String a) {

		this.name = n;
		this.healthBoost = hb;
		this.defenseBoost = db;
		this.speedBoost = sb;
		this.intelligenceBoost = ib;
		this.enchantments = ench;
		this.rune = r;
		this.ability = a;

	}

}

