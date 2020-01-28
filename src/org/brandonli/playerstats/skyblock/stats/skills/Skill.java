package org.brandonli.playerstats.skyblock.stats.skills;

import java.util.TreeMap;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Skill {

	String name;

	int level;
	
	double xpCurrent;
	double xpForNext;
	double progress;

	public Skill(String s, int level, double xpCurrent, double xpForNext, double progress) {

		this.name = s;
		this.level = level;
		this.xpCurrent = xpCurrent;
		this.xpForNext = xpForNext;
		this.progress = progress;

	}
	
	public static void main(String[] args) throws JSONException, UnirestException {
		
		Skill s = getSkillLevelNormal("PulseBeat_02", "Apple", "combat");
		System.out.println(s.level);
		System.out.println(s.xpForNext);
		
	}
	
	public static Skill getSkillLevelNormal(String username, String profileName, String skill) throws JSONException, UnirestException {
		
		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id);
		
		double experience = stats.getDouble("experience_skill_" + skill);
		
		TreeMap<Integer, Integer> table = SkillUtil.getLevelingXP();
		
		double currentAddedXP = 0;
		
		int skillLevel = 0;
		double XPForNext = 0;
		double progress = 0;
		
		for (int level : table.keySet()) {
			
			if (table.get(level) + currentAddedXP <= experience) {
				
				currentAddedXP += table.get(level);
				
			} else {
				
				skillLevel = level - 1;
				XPForNext = currentAddedXP + table.get(level) - experience;
				progress = currentAddedXP - experience;
				break;
				
			}
			
		}
		
		return new Skill(skill, skillLevel, experience, XPForNext, progress);

	}
	
	public static Skill getSkillLevelRuneCrafting(String username, String profileName, String skill) throws JSONException, UnirestException {
		
		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id);
		
		double experience = stats.getDouble("experience_skill_runecrafting");
		
		TreeMap<Integer, Integer> table = SkillUtil.getRuneCraftingXP();
		
		double currentAddedXP = 0;
		
		int skillLevel = 0;
		double XPForNext = 0;
		double progress = 0;
		
		for (int level : table.keySet()) {
			
			if (table.get(level) + currentAddedXP <= experience) {
				
				currentAddedXP += table.get(level);
				
			} else {
				
				skillLevel = level - 1;
				XPForNext = currentAddedXP + table.get(level) - experience;
				progress = currentAddedXP - experience;
				break;
				
			}
			
		}
		
		return new Skill(skill, skillLevel, experience, XPForNext, progress);
		
	}



	public static int getEffectiveHealth(int health, int defense) {

		if (defense <= 0)
			return health;

		return Math.round(health * (1 + defense / 100));

	}


}
