package org.brandonli.playerstats.skyblock.stats.collection;

import java.util.Arrays;
import java.util.TreeMap;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class CollectionTier {

	static TreeMap<String, Integer> collectionsTiers = new TreeMap<>();
	
	public static void main(String[] args) throws JSONException, UnirestException {
		
		updateCollectionTiers("PulseBeat_02", "Apple");
		
		for (String name : collectionsTiers.keySet()) {
			
			System.out.println(name + " Collection Tier: " + collectionsTiers.get(name));
			
		}
		
		
	}

	public static void updateCollectionTiers(String username, String profileName)
			throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONArray stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONArray("unlocked_coll_tiers");
		
		System.out.println(stats);
		
		String[] elements = SkyBlockUtil.toStringArray(stats);
		
		Arrays.parallelSort(elements);
		
		for (int i = 0; i < elements.length; i++) {
			
			String key = elements[i];
			
			String str = "";
			
			String[] formatted = key.replaceAll("_", " ").split(" ");
			
			for (int k = 0; k < formatted.length - 1; k++) { // skip last one because its the level
				
				str += formatted[k].substring(0, 1).toUpperCase() + formatted[k].substring(1) + " ";
				
			}
			
			int level = Integer.parseInt(formatted[formatted.length - 1]);
			
			collectionsTiers.put(str.trim(), level);
			
		}

	}

}


