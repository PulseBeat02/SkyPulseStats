package org.brandonli.playerstats.skyblock.stats.kd;

import java.util.Arrays;
import java.util.HashMap;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Deaths {

	public static HashMap<String, Double> deaths = new HashMap<>();
	
	int deathCount = 0;

	public static void main(String[] args) throws JSONException, UnirestException {

		updateDeaths("PulseBeat_02", "Apple");

		for (String name : deaths.keySet()) {

			System.out.println(name + ": " + deaths.get(name));

		}

	}

	public static void updateDeaths(String username, String profileName) throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("stats");

		String[] keys = JSONObject.getNames(stats);

		System.out.println(Arrays.toString(keys));

		for (int i = 0; i < keys.length; i++) {

			String key = keys[i];

			if (key.contains("deaths")) {

				if (key.equals("deaths")) {

					double d = stats.getDouble("deaths");
					deaths.put(key.substring(0, 1).toUpperCase() + key.substring(1), d);

				} else {

					String str = "";

					String[] keyDiv = key.substring(7, key.length()).replace("_", " ").split(" ");

					for (int j = 0; j < keyDiv.length; j++) {

						str += (keyDiv[j].substring(0, 1).toUpperCase() + keyDiv[j].substring(1)) + " ";

					}

					double d = stats.getDouble(keys[i]);

					deaths.put(str.trim(), d);

				}

			}

		}

	}

}
