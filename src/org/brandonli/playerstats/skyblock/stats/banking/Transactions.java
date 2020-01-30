package org.brandonli.playerstats.skyblock.stats.banking;

import java.util.ArrayList;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Transactions {

	public static ArrayList<Transaction> transactions = new ArrayList<>();
	
	public static void main(String[] args) throws JSONException, UnirestException {
		
		getTransactions("PulseBeat_02", "Apple");
		
		for (int i = 0; i < transactions.size(); i++) {
			
			Transaction t = transactions.get(i);
			
			System.out.println(t.action + ": " + t.amount + " Coins on " + t.timestamp + " by " + t.initiator_name);
			
		}
		
	}
	
	public static ArrayList<Transaction> getTransactions(String username, String profileName) throws JSONException, UnirestException {
		
		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);
		JSONArray stats = output.getJSONObject("profile").getJSONObject("banking").getJSONArray("transactions");
		
		for (int i = 0; i < stats.length(); i++) {
			
			JSONObject obj = stats.getJSONObject(i);
			
			int amount = obj.getInt("amount");
			int timestamp = obj.getInt("timestamp");
			
			String action = obj.getString("action");
			String initiator = obj.getString("initiator_name");
			
			transactions.add(new Transaction(amount, SkyBlockUtil.ConvertFromEpoc(timestamp), action, initiator));
			
			
		}
		
		return transactions;
		
	}
	

}
