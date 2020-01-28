package org.brandonli.playerstats.skyblock.stats;

import java.util.ArrayList;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class VisitedZones {
	
	public static ArrayList<String> visitedZones = new ArrayList<>();
	
	public static void main(String[] args) throws JSONException, UnirestException {
		
		updateVistedZones("PulseBeat_02", "Apple");
		
		for (int i = 0; i < visitedZones.size(); i++) {
			
			System.out.println(visitedZones.get(i));
			
		}
		
		
	}
	
	public static void updateVistedZones(String username, String profileName) throws JSONException, UnirestException {
		
		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONArray stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONArray("visited_zones");
		
		for (int i = 0; i < stats.length(); i++) {
			
			String str = "";
			
			String node = stats.getString(i);
			
			String[] keyDiv = node.replace("_", " ").split(" ");

			for (int j = 0; j < keyDiv.length; j++) {

				str += (keyDiv[j].substring(0, 1).toUpperCase() + keyDiv[j].substring(1)) + " ";

			}
			
			visitedZones.add(str.trim());
			
		}
		
	}

}
