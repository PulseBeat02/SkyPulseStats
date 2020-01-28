package org.brandonli.playerstats.skyblock.stats.auctions;

import java.util.Arrays;

import org.brandonli.playerstats.SkyBlockUtil;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class AuctionInfo {
	
	static double auctionBids;
	static double highestAuctionBid;
	static double auctionsCreated;
	static double auctionsFees;
	static double auctionsNoBids;
	static double auctionsCompleted;
	static double auctionsGoldEarned;
	static double auctionsWon;
	static double auctionsGoldSpent;
	
	static double auctionsSoldCommon;
	static double auctionsSoldUncommon;
	static double auctionsSoldRare;
	static double auctionsSoldEpic;
	static double auctionsSoldLegendary;
	
	static double auctionsBoughtCommon;
	static double auctionsBoughtUncommon;
	static double auctionsBoughtRare;
	static double auctionsBoughtEpic;
	static double auctionsBoughtLegendary;
	
	
	public static void updateAuctionInfo(String username, String profileName) throws JSONException, UnirestException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("stats");

		String[] keys = JSONObject.getNames(stats);

		System.out.println(Arrays.toString(keys));
		
		auctionBids = stats.getDouble("auctions_bids");
		highestAuctionBid = stats.getDouble("auctions_highest_bid");
		auctionsCreated = stats.getDouble("auctions_created");
		auctionsFees = stats.getDouble("auctions_fees");
		auctionsNoBids = stats.getDouble("auctions_no_bids");
		auctionsCompleted = stats.getDouble("auctions_completed");
		auctionsGoldEarned = stats.getDouble("auctions_gold_earned");
		auctionsWon = stats.getDouble("auctions_won");
		auctionsGoldSpent = stats.getDouble("auctions_gold_spent");
		
		auctionsSoldCommon = stats.getDouble("auctions_sold_common");
		auctionsSoldUncommon = stats.getDouble("auctions_sold_uncommon");
		auctionsSoldRare = stats.getDouble("auctions_sold_rare");
		auctionsSoldEpic = stats.getDouble("auctions_sold_epic");
		auctionsSoldLegendary = stats.getDouble("auctions_sold_legendary");
		
		auctionsBoughtCommon = stats.getDouble("auctions_bought_common");
		auctionsBoughtUncommon = stats.getDouble("auctions_bought_uncommon");
		auctionsBoughtRare = stats.getDouble("auctions_bought_rare");
		auctionsBoughtEpic = stats.getDouble("auctions_bought_epic");
		auctionsBoughtLegendary = stats.getDouble("auctions_bought_legendary");
		
	}


}
