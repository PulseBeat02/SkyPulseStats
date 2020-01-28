package org.brandonli.playerstats.skyblock.stats.banking;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Balance {

	public static double balance;

	public static void main(String[] args) throws JSONException, UnirestException {

		updateBalance("PulseBeat_02", "Apple");

		balance = 0.01 * Math.floor(balance * 100.0);

		System.out.println("Balance: " + balance);

	}

	public static void updateBalance(String username, String profileName) throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);
		JSONObject stats = output.getJSONObject("profile").getJSONObject("banking");

		balance = stats.getDouble("balance");

	}

}
