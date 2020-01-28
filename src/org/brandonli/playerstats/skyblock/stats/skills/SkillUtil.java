package org.brandonli.playerstats.skyblock.stats.skills;

import java.util.HashMap;
import java.util.TreeMap;

public class SkillUtil {
	
	@SuppressWarnings("rawtypes")
	static HashMap<String, TreeMap> bonus_stats = new HashMap<>();

	public static TreeMap<Integer, Integer> getLevelingXP() {

		TreeMap<Integer, Integer> leveling_xp = new TreeMap<>();

		leveling_xp.put(1, 50);
		leveling_xp.put(2, 125);
		leveling_xp.put(3, 200);
		leveling_xp.put(4, 300);
		leveling_xp.put(5, 500);
		leveling_xp.put(6, 750);
		leveling_xp.put(7, 1000);
		leveling_xp.put(8, 1500);
		leveling_xp.put(9, 2000);
		leveling_xp.put(10, 3500);
		leveling_xp.put(11, 5000);
		leveling_xp.put(12, 7500);
		leveling_xp.put(13, 10000);
		leveling_xp.put(14, 15000);
		leveling_xp.put(15, 20000);
		leveling_xp.put(16, 30000);
		leveling_xp.put(17, 50000);
		leveling_xp.put(18, 75000);
		leveling_xp.put(19, 100000);
		leveling_xp.put(20, 200000);
		leveling_xp.put(21, 300000);
		leveling_xp.put(22, 400000);
		leveling_xp.put(23, 500000);
		leveling_xp.put(24, 600000);
		leveling_xp.put(25, 700000);
		leveling_xp.put(26, 800000);
		leveling_xp.put(27, 900000);
		leveling_xp.put(28, 1000000);
		leveling_xp.put(29, 1100000);
		leveling_xp.put(30, 1200000);
		leveling_xp.put(31, 1300000);
		leveling_xp.put(32, 1400000);
		leveling_xp.put(33, 1500000);
		leveling_xp.put(34, 1600000);
		leveling_xp.put(35, 1700000);
		leveling_xp.put(36, 1800000);
		leveling_xp.put(37, 1900000);
		leveling_xp.put(38, 2000000);
		leveling_xp.put(39, 2100000);
		leveling_xp.put(40, 2200000);
		leveling_xp.put(41, 2300000);
		leveling_xp.put(42, 2400000);
		leveling_xp.put(43, 2500000);
		leveling_xp.put(44, 2600000);
		leveling_xp.put(45, 2700000);
		leveling_xp.put(46, 2800000);
		leveling_xp.put(47, 3100000);
		leveling_xp.put(48, 3400000);
		leveling_xp.put(49, 3700000);
		leveling_xp.put(50, 4000000);

		return leveling_xp;

	}

	public static TreeMap<Integer, Integer> getRuneCraftingXP() {

		TreeMap<Integer, Integer> runecrafting_xp = new TreeMap<>();

		runecrafting_xp.put(1, 50);
		runecrafting_xp.put(2, 100);
		runecrafting_xp.put(3, 125);
		runecrafting_xp.put(4, 160);
		runecrafting_xp.put(5, 200);
		runecrafting_xp.put(6, 250);
		runecrafting_xp.put(7, 315);
		runecrafting_xp.put(8, 400);
		runecrafting_xp.put(9, 500);
		runecrafting_xp.put(10, 625);
		runecrafting_xp.put(11, 785);
		runecrafting_xp.put(12, 1000);
		runecrafting_xp.put(13, 1250);
		runecrafting_xp.put(14, 1600);
		runecrafting_xp.put(15, 2000);
		runecrafting_xp.put(16, 2465);
		runecrafting_xp.put(17, 3125);
		runecrafting_xp.put(18, 4000);
		runecrafting_xp.put(19, 5000);
		runecrafting_xp.put(20, 6200);
		runecrafting_xp.put(21, 7800);
		runecrafting_xp.put(22, 9800);
		runecrafting_xp.put(23, 12200);
		runecrafting_xp.put(24, 15300);

		return runecrafting_xp;

	}

	public static TreeMap<Integer, Integer> getSlayerXP() {

		TreeMap<Integer, Integer> slayer_xp = new TreeMap<>();

		slayer_xp.put(1, 5);
		slayer_xp.put(2, 15);
		slayer_xp.put(3, 200);
		slayer_xp.put(4, 1000);
		slayer_xp.put(5, 5000);
		slayer_xp.put(6, 20000);
		slayer_xp.put(7, 100000);
		slayer_xp.put(8, 400000);

		return slayer_xp;

	}

	public static TreeMap<String, Integer> getBaseStats() {

		TreeMap<String, Integer> base_stats = new TreeMap<>();

		base_stats.put("damage", 0);
		base_stats.put("health", 100);
		base_stats.put("defense", 0);
		base_stats.put("effective_health", 100);
		base_stats.put("strength", 0);
		base_stats.put("damage_increase", 0);
		base_stats.put("speed", 100);
		base_stats.put("crit_chance", 20);
		base_stats.put("crit_damage", 50);
		base_stats.put("intelligence", 0);

		return base_stats;

	}

	public static TreeMap<Integer, FairySoulBoost> getBonusStatsFairySoul() { // health, defense, strength, speed

		TreeMap<Integer, FairySoulBoost> fairy_souls = new TreeMap<>();
		fairy_souls.put(5, new FairySoulBoost(3, 1, 1, 0));
		fairy_souls.put(10, new FairySoulBoost(3, 1, 1, 0));
		fairy_souls.put(15, new FairySoulBoost(4, 1, 1, 0));
		fairy_souls.put(20, new FairySoulBoost(4, 1, 1, 0));
		fairy_souls.put(25, new FairySoulBoost(5, 2, 2, 0));
		fairy_souls.put(30, new FairySoulBoost(5, 1, 1, 0));
		fairy_souls.put(35, new FairySoulBoost(6, 1, 1, 0));
		fairy_souls.put(40, new FairySoulBoost(6, 1, 1, 0));
		fairy_souls.put(45, new FairySoulBoost(7, 1, 1, 0));
		fairy_souls.put(50, new FairySoulBoost(7, 2, 2, 1));
		fairy_souls.put(55, new FairySoulBoost(8, 1, 1, 0));
		fairy_souls.put(60, new FairySoulBoost(8, 1, 1, 0));
		fairy_souls.put(65, new FairySoulBoost(9, 1, 1, 0));
		fairy_souls.put(70, new FairySoulBoost(9, 1, 1, 0));
		fairy_souls.put(75, new FairySoulBoost(10, 2, 2, 0));
		fairy_souls.put(80, new FairySoulBoost(10, 1, 1, 0));
		fairy_souls.put(85, new FairySoulBoost(11, 1, 1, 0));
		fairy_souls.put(90, new FairySoulBoost(11, 1, 1, 0));
		fairy_souls.put(95, new FairySoulBoost(12, 1, 1, 0));
		fairy_souls.put(100, new FairySoulBoost(12, 2, 2, 1));
		fairy_souls.put(105, new FairySoulBoost(13, 1, 1, 0));
		fairy_souls.put(110, new FairySoulBoost(13, 1, 1, 0));
		fairy_souls.put(115, new FairySoulBoost(14, 1, 1, 0));
		fairy_souls.put(120, new FairySoulBoost(14, 1, 1, 0));
		fairy_souls.put(125, new FairySoulBoost(15, 2, 2, 0));
		fairy_souls.put(130, new FairySoulBoost(15, 1, 1, 0));
		fairy_souls.put(135, new FairySoulBoost(16, 1, 1, 0));
		fairy_souls.put(140, new FairySoulBoost(16, 1, 1, 0));
		fairy_souls.put(145, new FairySoulBoost(17, 1, 1, 0));
		fairy_souls.put(150, new FairySoulBoost(17, 2, 2, 1));
		fairy_souls.put(155, new FairySoulBoost(18, 1, 1, 0));
		fairy_souls.put(160, new FairySoulBoost(18, 1, 1, 0));
		fairy_souls.put(165, new FairySoulBoost(19, 1, 1, 0));
		fairy_souls.put(170, new FairySoulBoost(19, 1, 1, 0));
		fairy_souls.put(175, new FairySoulBoost(20, 2, 2, 0));
		fairy_souls.put(180, new FairySoulBoost(20, 1, 1, 0));
		fairy_souls.put(185, new FairySoulBoost(21, 1, 1, 0));
		fairy_souls.put(190, new FairySoulBoost(21, 1, 1, 0));
		
		bonus_stats.put("Fairy Souls", fairy_souls);
		
		return fairy_souls;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsFarmingSkill() { // health
		
		TreeMap<Integer, Integer> farming_bonus = new TreeMap<>();
		
		farming_bonus.put(1, 2);
		farming_bonus.put(15, 3);
		farming_bonus.put(20, 4);
		farming_bonus.put(26, 5);
		
		bonus_stats.put("Farming", farming_bonus);
		
		return farming_bonus;
		
	}
	
	public static TreeMap<Integer, CombatSkillBoost> getBonusStatsCombatSkill() { // crit_chance
		
		TreeMap<Integer, CombatSkillBoost> combat_bonus = new TreeMap<>();
		combat_bonus.put(1, new CombatSkillBoost(1, 0.04));
		
		bonus_stats.put("Combat", combat_bonus);
		
		return combat_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsMiningSkill() { // defense
		
		TreeMap<Integer, Integer> mining_bonus = new TreeMap<>();
		mining_bonus.put(1, 1);
		mining_bonus.put(15, 2);
		
		bonus_stats.put("Mining", mining_bonus);
		
		return mining_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsForagingSkill() { // strength
		
		TreeMap<Integer, Integer> foraging_bonus = new TreeMap<>();
		foraging_bonus.put(1, 1);
		foraging_bonus.put(15, 2);
		
		bonus_stats.put("Foraging", foraging_bonus);
		
		return foraging_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsFishingSkill() { // health
		
		TreeMap<Integer, Integer> fishing_bonus = new TreeMap<>();
		fishing_bonus.put(1, 1);
		fishing_bonus.put(15, 3);
		fishing_bonus.put(20, 4);
		fishing_bonus.put(26, 5);
		
		bonus_stats.put("Fishing", fishing_bonus);
		
		return fishing_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsEnchantingSkill() { // intelligence
		
		TreeMap<Integer, Integer> enchanting_bonus = new TreeMap<>();
		enchanting_bonus.put(1, 1);
		enchanting_bonus.put(15, 2);
		
		bonus_stats.put("Enchanting", enchanting_bonus);
		
		return enchanting_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsAlchemySkill() { // intelligence
		
		TreeMap<Integer, Integer> alchemy_bonus = new TreeMap<>();
		alchemy_bonus.put(1, 1);
		alchemy_bonus.put(15, 2);
		
		bonus_stats.put("Alchemy", alchemy_bonus);
		
		return alchemy_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsCarpentrySkill() { // nothing
		
		TreeMap<Integer, Integer> carpentry_bonus = new TreeMap<>();
		carpentry_bonus.put(1, null);
		
		bonus_stats.put("Carpentry", carpentry_bonus);
		
		return carpentry_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsRuneCraftingSkill() { // nothing
		
		TreeMap<Integer, Integer> runecrafting_bonus = new TreeMap<>();
		runecrafting_bonus.put(1, null);
		
		bonus_stats.put("Runecrafting", runecrafting_bonus);
		
		return runecrafting_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsZombieSlayer() { // health
		
		TreeMap<Integer, Integer> zombieslayer_bonus = new TreeMap<>();
		zombieslayer_bonus.put(1, 2);
		zombieslayer_bonus.put(3, 3);
		zombieslayer_bonus.put(5, 4);
		zombieslayer_bonus.put(7, 5);
		zombieslayer_bonus.put(9, 6);
		
		bonus_stats.put("Zombie Slayer", zombieslayer_bonus);
		
		return zombieslayer_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsSpiderSlayer() { // crit_damage
		
		TreeMap<Integer, Integer> spiderslayer_bonus = new TreeMap<>();
		spiderslayer_bonus.put(1, 1);
		spiderslayer_bonus.put(5, 2);
		spiderslayer_bonus.put(9, 3);
		
		bonus_stats.put("Spider Slayer", spiderslayer_bonus);
		
		return spiderslayer_bonus;
		
	}
	
	public static TreeMap<Integer, Integer> getBonusStatsWolfSlayer() {
		
		// Complex:
		// speed
		// health
		// speed
		// health
		// crit_damage
		// health
		// crit_damage;
		// speed
		
		TreeMap<Integer, Integer> wolfslayer_bonus = new TreeMap<>();
		wolfslayer_bonus.put(1, 1);
		wolfslayer_bonus.put(2, 2);
		wolfslayer_bonus.put(3, 3);
		wolfslayer_bonus.put(4, 1);
		wolfslayer_bonus.put(5, 2);
		wolfslayer_bonus.put(6, 3);
		wolfslayer_bonus.put(7, 1);
		wolfslayer_bonus.put(8, 2);
		
		bonus_stats.put("Wolf Slayer", wolfslayer_bonus);
		
		return wolfslayer_bonus;
		
	}
	
	public static TreeMap<String, Double> getEnchantmentsBonus() {
		
		TreeMap<String, Double> enchantments_boost = new TreeMap<>();
		
		enchantments_boost.put("sharpness", 0.05); // damage_multiplicator
		enchantments_boost.put("ender", 0.12); // damage_multiplicator
		enchantments_boost.put("giant_killer", 0.05); // damage_multiplicator
		enchantments_boost.put("cubism", 0.1); // damage_multiplicator
		enchantments_boost.put("impaling", 0.125); // damage_multiplicator
		enchantments_boost.put("critical", (double) 10); // crit_damage
		enchantments_boost.put("first_strike", 0.25); // damage_multiplicator
		enchantments_boost.put("power", 0.08); // damage_multiplicator
		
		bonus_stats.put("Enchantments Boost", enchantments_boost);
		
		return enchantments_boost;
		
	}
	
	public static TreeMap<String, Integer> getStatTemplate() {
		
		TreeMap<String, Integer> stat_template = new TreeMap<>();
		
		stat_template.put("damage", 0);
		stat_template.put("health", 0);
		stat_template.put("defense", 0);
		stat_template.put("effective_health", 0);
		stat_template.put("strength", 0);
		stat_template.put("damage_increase", 0);
		stat_template.put("speed", 0);
		stat_template.put("crit_chance", 0);
		stat_template.put("crit_damage", 0);
		stat_template.put("intelligence", 0);
		
		return stat_template;
		
	}

}





