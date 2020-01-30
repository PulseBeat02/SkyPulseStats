package org.brandonli.playerstats.skyblock.stats.quests;

import java.util.ArrayList;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Quests {
	
	public static ArrayList<Quest> quests = new ArrayList<>();
	
	public static void main(String[] args) throws JSONException, UnirestException {
		
		getQuests("PulseBeat_02", "Apple");
		
		for (int i = 0; i < quests.size(); i++) {
			
			System.out.println(quests.get(i).name);
			
		}
		
	}
	
	public static ArrayList<Quest> getQuests(String username, String profileName) throws JSONException, UnirestException {
		
		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject Quests = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("quests");
		
		String[] names = JSONObject.getNames(Quests);

		for (int i = 0; i < names.length; i++) {
			
			String key = names[i];
			
			String str = "";
			
			String[] formatted = key.replaceAll("_", " ").split(" ");
			
			for (int k = 0; k < formatted.length; k++) {
				
				str += formatted[k].substring(0, 1).toUpperCase() + formatted[k].substring(1) + " ";
				
			}
			
			String status = Quests.getJSONObject(key).getString("status");
			
			int activated = Quests.getJSONObject(key).getInt("activated_at");
			int completed = Quests.getJSONObject(key).getInt("completed_at");
			
			quests.add(new Quest(str.trim(), status, SkyBlockUtil.ConvertFromEpoc(activated), SkyBlockUtil.ConvertFromEpoc(completed)));
			
			
		}
		
		return quests;
		
	}

}
