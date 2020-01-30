package org.brandonli.playerstats.skyblock.stats.objectives;

import java.util.ArrayList;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Objectives {

	public static ArrayList<Objective> objectives = new ArrayList<>();

	public static void main(String[] args) throws JSONException, UnirestException {

		getObjectives("PulseBeat_02", "Apple");

		for (int i = 0; i < objectives.size(); i++) {

			System.out.println(objectives.get(i).name);

		}

	}

	public static ArrayList<Objective> getObjectives(String username, String profileName) throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject Quests = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("objectives");

		String[] names = JSONObject.getNames(Quests);

		for (int i = 0; i < names.length; i++) {

			String key = names[i];

			String str = "";

			String[] formatted = key.replaceAll("_", " ").split(" ");

			for (int k = 0; k < formatted.length; k++) {

				str += formatted[k].substring(0, 1).toUpperCase() + formatted[k].substring(1) + " ";

			}

			String status = Quests.getJSONObject(key).getString("status");

			int progress = Quests.getJSONObject(key).getInt("progress");
			int completed = Quests.getJSONObject(key).getInt("completed_at");

			objectives.add(new Objective(str.trim(), status, progress, SkyBlockUtil.ConvertFromEpoc(completed)));

		}
		
		return objectives;

	}

}
