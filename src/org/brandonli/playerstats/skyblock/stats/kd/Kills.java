package org.brandonli.playerstats.skyblock.stats.kd;

import java.util.Arrays;
import java.util.HashMap;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Kills {

	public static HashMap<String, Double> kills = new HashMap<>();

	public static void main(String[] args) throws JSONException, UnirestException {

		updateKills("PulseBeat_02", "Apple");

		for (String name : kills.keySet()) {

			System.out.println(name + ": " + kills.get(name));

		}

	}

	public static void updateKills(String username, String profileName) throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("stats");

		String[] keys = JSONObject.getNames(stats);

		System.out.println(Arrays.toString(keys));

		for (int i = 0; i < keys.length; i++) {

			String key = keys[i];

			if (key.contains("kills")) {

				if (key.equals("kills")) {

					double d = stats.getDouble("kills");
					kills.put(key.substring(0, 1).toUpperCase() + key.substring(1), d);

				} else {

					String str = "";

					String[] keyDiv = key.substring(6, key.length()).replace("_", " ").split(" ");

					for (int j = 0; j < keyDiv.length; j++) {

						str += (keyDiv[j].substring(0, 1).toUpperCase() + keyDiv[j].substring(1)) + " ";

					}

					double d = stats.getDouble(keys[i]);

					kills.put(str.trim(), d);

				}

			}

		}

	}

}
