package org.brandonli.playerstats.skyblock.stats;

import java.util.TreeMap;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Collection {
	
	public static TreeMap<String, Integer> collection = new TreeMap<>();
	
	public static void main(String[] args) throws JSONException, UnirestException {
		
		getCollection("PulseBeat_02", "Apple");
		
		for (String s : collection.keySet()) {
			
			System.out.println(s + " Collection : " + collection.get(s));
			
		}
		
	}
	
	public static TreeMap<String, Integer> getCollection(String username, String profileName) throws JSONException, UnirestException {
		
		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject c = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("collection");
		
		String[] keys = JSONObject.getNames(c);
		
		for (int i = 0; i < keys.length; i++) {
			
			String str = "";
			
			String[] formatted = keys[i].replace("_", " ").toLowerCase().split(" ");
			
			for (int j = 0; j < formatted.length; j++) {
				
				str += Character.toUpperCase(formatted[j].charAt(0)) + formatted[j].substring(1) + " ";
				
			}
			
			collection.put(str.trim(), c.getInt(keys[i]));
			
		}
		
		return collection;
		
	}

}
