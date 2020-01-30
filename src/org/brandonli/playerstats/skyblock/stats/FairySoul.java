package org.brandonli.playerstats.skyblock.stats;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class FairySoul {

	public int number;

	public FairySoul(int num) {

		this.number = num;

	}

	public static FairySoul getFairySoulCount(String username, String profileName) throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("objectives");
		
		return new FairySoul(Integer.parseInt(stats.getString("fairy_souls_collected")));

	}

}

