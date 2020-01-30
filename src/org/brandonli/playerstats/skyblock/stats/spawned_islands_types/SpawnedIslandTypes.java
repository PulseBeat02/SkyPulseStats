package org.brandonli.playerstats.skyblock.stats.spawned_islands_types;

import java.util.ArrayList;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class SpawnedIslandTypes {
	
	static ArrayList<String> spawnedIslandTypes = new ArrayList<>();
	
	public static void main(String[] args) throws JSONException, UnirestException {

		getIslandTypes("PulseBeat_02", "Apple");

		for (int i = 0; i < spawnedIslandTypes.size(); i++) {

			System.out.println(spawnedIslandTypes.get(i));

		}

	}
	
	
	
	public static ArrayList<String> getIslandTypes(String username, String profileName) throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONArray islands = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONArray("achievement_spawned_island_types");



		for (int i = 0; i < islands.length(); i++) {

			String keyLower = islands.getString(i).toLowerCase();

			String upper = keyLower.substring(0, 1).toUpperCase() + keyLower.substring(1);
			
			spawnedIslandTypes.add(upper);

		}
		
		return spawnedIslandTypes;

	}

}
