package org.brandonli.playerstats.skyblock.stats.inventory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;

import org.brandonli.playerstats.SkyBlockUtil;
import org.brandonli.playerstats.NBTParser.NBTParser;
import org.brandonli.playerstats.NBTParser.tags.CompoundTag;
import org.brandonli.playerstats.NBTParser.tags.Tag;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class GetInventory {

	public static void main(String[] args)
			throws JSONException, UnsupportedEncodingException, IOException, UnirestException {
		
		String data = SkyBlockUtil.decompress(getBinaryArmor("PulseBeat_02", "Apple"));
		
		System.out.println(data);

		NBTParser nbt = new NBTParser(new ByteArrayInputStream(data.getBytes()));
		nbt.parse();
		
		CompoundTag root = nbt.getRoot();
		ArrayList<Tag> tags = root.getContents(); // Returns a list of contained tags
		
		for (int i = 0; i < tags.size(); i++) {
			
			System.out.println(tags.get(i).getName());
			
		}

	}

	public static byte[] getBinaryArmor(String username, String profileName)
			throws JSONException, UnirestException, UnsupportedEncodingException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("inv_armor");

		String data = stats.getString("data");

		byte[] decoded = Base64.getDecoder().decode(data);

		return decoded;

	}

	public static byte[] getBinaryFishingBag(String username, String profileName)
			throws JSONException, UnirestException, UnsupportedEncodingException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("fishing_bag");

		String data = stats.getString("data");

		String encoded = Base64.getEncoder().encodeToString(data.getBytes("UTF-8"));
		byte[] decoded = Base64.getDecoder().decode(encoded);

		return decoded;
	}

	public static byte[] getBinaryQuiver(String username, String profileName)
			throws JSONException, UnirestException, UnsupportedEncodingException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("quiver");

		String data = stats.getString("data");

		String encoded = Base64.getEncoder().encodeToString(data.getBytes("UTF-8"));
		byte[] decoded = Base64.getDecoder().decode(encoded);

		return decoded;

	}
	
	public static byte[] decode(String data) throws UnsupportedEncodingException {
		
		String encoded = Base64.getEncoder().encodeToString(data.getBytes("UTF-8"));
		byte[] decoded = Base64.getDecoder().decode(encoded);
		
		return decoded;
		
	}

	public static byte[] getBinaryEnderChest(String username, String profileName)
			throws JSONException, UnirestException, UnsupportedEncodingException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("ender_chest_contents");

		String data = stats.getString("data");

		byte[] decoded = decode(data);

		return decoded;

	}

	public static byte[] getBinaryPotionBag(String username, String profileName)
			throws JSONException, UnirestException, UnsupportedEncodingException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("potion_bag");

		String data = stats.getString("data");

		byte[] decoded = decode(data);

		return decoded;

	}

	public static byte[] getBinaryTalismanBag(String username, String profileName)
			throws JSONException, UnirestException, UnsupportedEncodingException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("talisman_bag");

		String data = stats.getString("data");

		byte[] decoded = decode(data);

		return decoded;

	}

	public static byte[] getBinaryCandyInventory(String username, String profileName)
			throws JSONException, UnirestException, UnsupportedEncodingException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("quiver");

		String data = stats.getString("candy_inventory_contents");

		byte[] decoded = decode(data);

		return decoded;

	}

	public static byte[] getBinaryInventory(String username, String profileName)
			throws JSONException, UnirestException, UnsupportedEncodingException {

		JSONObject output = SkyBlockUtil.getSkyBlockProfileInfo(username, profileName);

		String id = output.getJSONObject("profile").getString("profile_id");

		JSONObject stats = output.getJSONObject("profile").getJSONObject("members").getJSONObject(id)
				.getJSONObject("inv_contents");

		String data = stats.getString("data");

		byte[] decoded = decode(data);

		return decoded;

	}

}
