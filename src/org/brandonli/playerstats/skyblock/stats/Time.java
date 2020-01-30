package org.brandonli.playerstats.skyblock.stats;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Time {
	
	public static String getJoinDate(String username, String profileName) throws JSONException, UnirestException {
		
		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id);
		
		return SkyBlockUtil.ConvertFromEpoc(Integer.parseInt(stats.getString("first_join")));
		
	}
	
	public static String getLastSave(String username, String profileName) throws JSONException, UnirestException {
		
		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id);
		
		return SkyBlockUtil.ConvertFromEpoc(Integer.parseInt(stats.getString("last_save")));
		
	}

}
