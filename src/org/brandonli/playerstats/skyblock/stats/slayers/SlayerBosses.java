package org.brandonli.playerstats.skyblock.stats.slayers;

import java.util.ArrayList;
import java.util.TreeMap;

import org.brandonli.playerstats.SkyBlockUtil;
import org.brandonli.playerstats.skyblock.stats.skills.SkillUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class SlayerBosses {

	public static ArrayList<Slayer> slayers = new ArrayList<>();

	public static void main(String[] args) throws JSONException, UnirestException {

		getSlayerBosses("PulseBeat_02", "Apple");

		for (int i = 0; i < slayers.size(); i++) {

			System.out.println(slayers.get(i).boss);

			int j = 0;

			for (String name : slayers.get(i).bosses.keySet()) {

				System.out.println("Tier " + (j + 1) + " : " + slayers.get(i).bosses.get(name));
				j++;

			}

		}

	}

	public static ArrayList<Slayer> getSlayerBosses(String username, String profileName)
			throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject Slayers = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("slayer_bosses");

		String[] bosses = JSONObject.getNames(Slayers);

		for (int i = 0; i < bosses.length; i++) {

			String key = bosses[i];

			String upper = bosses[i].substring(0, 1).toUpperCase() + bosses[i].substring(1);

			Slayer s = new Slayer(upper);

			for (int j = 0; j < 4; j++) {

				try {

					s.bosses.put(upper + " Slayer " + (j + 1),
							Slayers.getJSONObject(key).getInt("boss_kills_tier_" + j));

				} catch (Exception e) {

					continue;

				}

			}

			slayers.add(s);

		}

		return slayers;

	}

	public static int getSlayerLevel(String username, String profileName, String slayer)
			throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject slayers = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("slayer_bosses").getJSONObject(slayer);
		
		double experience = slayers.getDouble("xp");
		
		TreeMap<Integer, Integer> table = SkillUtil.getSlayerXP();
		
		double currentAddedXP = 0;
		
		int skillLevel = 0;
		
		for (int level : table.keySet()) {
			
			if (table.get(level) + currentAddedXP <= experience) {
				
				currentAddedXP += table.get(level);
				
			} else {
				
				skillLevel = level - 1;
				break;
				
			}
			
		}
		
		return skillLevel;

	}

}
