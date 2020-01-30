package org.brandonli.playerstats.skyblock.stats.bonus_stat;

import java.util.TreeMap;

import org.brandonli.playerstats.skyblock.stats.FairySoul;
import org.brandonli.playerstats.skyblock.stats.skills.FairySoulBoost;
import org.brandonli.playerstats.skyblock.stats.skills.Skill;
import org.brandonli.playerstats.skyblock.stats.skills.SkillUtil;
import org.brandonli.playerstats.skyblock.stats.slayers.SlayerBosses;
import org.json.JSONException;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Bonus {

	static int healthBonus = 0;
	static int defenseBonus = 0;
	static int effectiveHPBonus = 0;
	static int strengthBonus = 0;
	static int speedBonus = 0;
	static int critChanceBonus = 0;
	static int critDamageBonus = 0;
	static int intelligenceBonus = 0;

	public static int[] getBonusesFairySouls(String username, String profileName)
			throws JSONException, UnirestException {

		int fairySouls = FairySoul.getFairySoulCount(username, profileName).number;

		// health, defense, strength, speed

		TreeMap<Integer, FairySoulBoost> fairySoulBoosts = SkillUtil.getBonusStatsFairySoul();

		int totalFairySouls = 0;
		int totalExchanges = 0;

		for (int exchanges : fairySoulBoosts.keySet()) {

			if (totalFairySouls > fairySouls) {

				totalExchanges = exchanges - 1;

			} else {

				totalFairySouls += 5;

			}

		}

		for (int i = 0; i < totalExchanges; i++) {

			healthBonus += fairySoulBoosts.get(i).health;
			defenseBonus += fairySoulBoosts.get(i).defense;
			strengthBonus += fairySoulBoosts.get(i).strength;
			speedBonus += fairySoulBoosts.get(i).speed;

		}

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}

	public static int[] getBonusesFarmingSkill(String username, String profileName)
			throws JSONException, UnirestException {

		Skill farming = Skill.getSkillLevelNormal(username, profileName, "farming");
		int level = farming.level;

		int p1Bonus = 0;
		int p2Bonus = 0;
		int p3Bonus = 0;
		int p4Bonus = 0;

		if (level >= 1 && level < 15) {

			p1Bonus = level * 2;

		} else if (level >= 15 && level < 20) {

			p2Bonus = level * 3;

		} else if (level >= 20 && level < 26) {

			p3Bonus = level * 4;

		} else if (level >= 26) {

			p4Bonus = level * 5;

		}

		healthBonus += (p1Bonus + p2Bonus + p3Bonus + p4Bonus);

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}

	public static int[] getBonusesCombatSkill(String username, String profileName)
			throws JSONException, UnirestException {

		Skill farming = Skill.getSkillLevelNormal(username, profileName, "combat");
		int level = farming.level;

		critChanceBonus += (level * 1);

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}

	public static int[] getBonusesMiningSkill(String username, String profileName)
			throws JSONException, UnirestException {

		Skill farming = Skill.getSkillLevelNormal(username, profileName, "mining");
		int level = farming.level;

		int p1Bonus = 0;
		int p2Bonus = 0;

		if (level >= 1 && level < 15) {

			p1Bonus = level * 1;

		} else if (level >= 15) {

			p2Bonus = level * 2;

		}

		defenseBonus += (p1Bonus + p2Bonus);

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}

	public static int[] getBonusesForagingSkill(String username, String profileName)
			throws JSONException, UnirestException {

		Skill farming = Skill.getSkillLevelNormal(username, profileName, "foraging");
		int level = farming.level;

		int p1Bonus = 0;
		int p2Bonus = 0;

		if (level >= 1 && level < 15) {

			p1Bonus = level * 1;

		} else if (level >= 15) {

			p2Bonus = level * 2;

		}

		strengthBonus += (p1Bonus + p2Bonus);

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}

	public static int[] getBonusesFishingSkill(String username, String profileName)
			throws JSONException, UnirestException {

		Skill farming = Skill.getSkillLevelNormal(username, profileName, "fishing");
		int level = farming.level;

		int p1Bonus = 0;
		int p2Bonus = 0;
		int p3Bonus = 0;
		int p4Bonus = 0;

		if (level >= 1 && level < 15) {

			p1Bonus = level * 2;

		} else if (level >= 15 && level < 20) {

			p2Bonus = level * 3;

		} else if (level >= 20 && level < 26) {

			p3Bonus = level * 4;

		} else if (level >= 26) {

			p4Bonus = level * 5;

		}
		healthBonus += (p1Bonus + p2Bonus + p3Bonus + p4Bonus);

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}

	public static int[] getBonusesEnchantingSkill(String username, String profileName)
			throws JSONException, UnirestException {

		Skill farming = Skill.getSkillLevelNormal(username, profileName, "enchanting");
		int level = farming.level;

		int p1Bonus = 0;
		int p2Bonus = 0;

		if (level >= 1 && level < 15) {

			p1Bonus = level * 1;

		} else if (level >= 15) {

			p2Bonus = level * 2;

		}

		intelligenceBonus += (p1Bonus + p2Bonus);

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}

	public static int[] getBonusesAlchemySkill(String username, String profileName)
			throws JSONException, UnirestException {

		Skill farming = Skill.getSkillLevelNormal(username, profileName, "alchemy");
		int level = farming.level;

		int p1Bonus = 0;
		int p2Bonus = 0;

		if (level >= 1 && level < 15) {

			p1Bonus = level * 1;

		} else if (level >= 15) {

			p2Bonus = level * 2;

		}

		intelligenceBonus += (p1Bonus + p2Bonus);

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}

	public static int[] getBonusZombieSlayer(String username, String profileName)
			throws JSONException, UnirestException {

		int level = SlayerBosses.getSlayerLevel(username, profileName, "zombie");

		int addedBonus = 2;
		for (int i = 1; i < level; i++) {

			healthBonus += addedBonus;

			if (i == 3 || i == 5 || i == 7 || i == 9) {

				addedBonus++;

			}

		}

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}
	
	public static int[] getBonusSpiderSlayer(String username, String profileName)
			throws JSONException, UnirestException {

		int level = SlayerBosses.getSlayerLevel(username, profileName, "spider");

		int addedBonus = 2;
		for (int i = 1; i < level; i++) {

			critDamageBonus += addedBonus;

			if (i == 5 || i == 9) {

				addedBonus++;

			}

		}

		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}
	
	public static int[] getBonusWolfSlayer(String username, String profileName)
			throws JSONException, UnirestException {

		int level = SlayerBosses.getSlayerLevel(username, profileName, "wolf");

		// speed
		// health
		// speed
		// health
		// crit_damage
		// health
		// crit_damage;
		// speed
		
//		wolfslayer_bonus.put(1, 1);
//		wolfslayer_bonus.put(2, 2);
//		wolfslayer_bonus.put(3, 3);
//		wolfslayer_bonus.put(4, 1);
//		wolfslayer_bonus.put(5, 2);
//		wolfslayer_bonus.put(6, 3);
//		wolfslayer_bonus.put(7, 1);
//		wolfslayer_bonus.put(8, 2);
		
		if (level == 1) {
			
			speedBonus += 1;
			
		} else if (level == 2) {
			
			healthBonus += 2;
			
		} else if (level == 3) {
			
			speedBonus += 3;
			
		} else if (level == 4) {
			
			healthBonus += 1;
			
		} else if (level == 5) {
			
			critDamageBonus += 2;
			
		} else if (level == 6) {
			
			healthBonus += 3;
			
		} else if (level == 7) {
			
			critDamageBonus += 1;
			
		} else if (level == 8) {
			
			speedBonus += 2;
			
		}
		
		return new int[] { healthBonus, defenseBonus, effectiveHPBonus, strengthBonus, speedBonus, critChanceBonus,
				critDamageBonus, intelligenceBonus };

	}

}




