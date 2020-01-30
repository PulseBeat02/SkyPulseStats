package org.brandonli.playerstats.skyblock.stats.tutorial;

import java.util.ArrayList;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Tutorial {
	
	static ArrayList<String> tutorials = new ArrayList<>();
	
	public static void main(String[] args) throws JSONException, UnirestException {

		getTutorials("PulseBeat_02", "Apple");

		for (int i = 0; i < tutorials.size(); i++) {

			System.out.println(tutorials.get(i));

		}

	}
	
	public static ArrayList<String> getTutorials(String username, String profileName) throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONArray tutorial = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONArray("tutorial");

		for (int i = 0; i < tutorial.length(); i++) {

			String key = tutorial.getString(i);

			String str = "";

			String[] formatted = key.replaceAll("_", " ").split(" ");

			for (int k = 0; k < formatted.length; k++) {

				str += formatted[k].substring(0, 1).toUpperCase() + formatted[k].substring(1) + " ";

			}

			tutorials.add(str.trim());

		}
		
		return tutorials;

	}

}
