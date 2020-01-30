package org.brandonli.playerstats.skyblock.stats.minions;

import java.util.HashMap;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Minions {

	/*
	 * Table ----------------------- M Level | 1 || 2 | I
	 * --------------------------- N I O N
	 * 
	 * 
	 * 
	 * 
	 */

	static HashMap<String, boolean[]> minions = new HashMap<>();
	
	public static void main(String[] args) throws JSONException, UnirestException {
		
		getMinions("PulseBeat_02", "Apple");
		
		for (String str : minions.keySet()) {
			
			System.out.println(str + ":");
			
			for (int i = 0; i < minions.get(str).length; i++) {
				
				System.out.println("Tier " + (i + 1) + ": " + minions.get(str)[i]);
				
			}
			
			System.out.println();
			
		}
		
	}

	public static HashMap<String, boolean[]> getMinions(String username, String profileName)
			throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONArray minion = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONArray("crafted_generators");

		for (int i = 0; i < minion.length(); i++) {
			
			String key = minion.getString(i);
			
			String[] array = key.split("_");
			
			String type = "";
			
			for (int j = 0; j < array.length - 1; j++) {
				
				type += array[j].substring(0, 1).toUpperCase() + array[j].substring(1) + " ";
				
			}
			
			int tier = Integer.parseInt(array[array.length - 1]);
			
			if (!minions.containsKey(type)) {
				
				boolean[] arr = new boolean[11];
				arr[tier - 1] = true;
				minions.put(type, arr);
				
			} else {
				
				boolean[] arr = minions.get(type);
				arr[tier - 1] = true;
				minions.put(type, arr);
				
			}
			
		}
		
		return minions;

	}

}
