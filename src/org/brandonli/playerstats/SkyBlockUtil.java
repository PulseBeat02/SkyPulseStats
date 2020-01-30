package org.brandonli.playerstats;

import org.brandonli.playerstats.skyblock.SkyBlockProfile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

public class SkyBlockUtil {

	static JSONObject profile;
	static JSONObject player;
	static JSONObject stats;
	static JSONObject allProfiles;
	
	static String key = "c71fdfbf-d6d3-4a02-aed8-da4a17e0929a";

	public static void main(String[] args) throws JSONException, UnirestException {

		System.out.println(getDisplayName("PulseBeat_02"));
		System.out.println(Arrays.toString(getPastNames("PulseBeat_02")));
		System.out.println(getStats("PulseBeat_02"));

		SkyBlockProfile[] array = getProfiles("PulseBeat_02");

		for (int i = 0; i < array.length; i++) {

			System.out.println("=============================");
			System.out.println("PROFILE NAME: " + array[i].name);
			System.out.println("PROFILE ID: " + array[i].id);

		}

		System.out.println("=============================");

	}

	public static SkyBlockProfile[] getProfiles(String username) throws JSONException, UnirestException {

		if (allProfiles == null) {

			JSONObject arr = getStats(username).getJSONObject("SkyBlock");
			JSONObject array = arr.getJSONObject("profiles");

			allProfiles = array;

		}

		String[] keys = JSONObject.getNames(allProfiles);

		SkyBlockProfile[] profiles = new SkyBlockProfile[keys.length];

		for (int i = 0; i < keys.length; i++) {

			JSONObject obj = allProfiles.getJSONObject(keys[i]);

			String id = obj.getString("profile_id");
			String cute_name = obj.getString("cute_name");

			profiles[i] = new SkyBlockProfile(id, cute_name);

		}

		return profiles;

	}

	public static JSONObject getStats(String username) throws JSONException, UnirestException {

		if (stats == null) {

			stats = getPlayer(username).getJSONObject("stats");

		}

		return stats;

	}

	public static String[] getPastNames(String username) throws JSONException, UnirestException {

		JSONArray arr = getPlayer(username).getJSONArray("knownAliases");

		String[] names = new String[arr.length()];

		for (int i = 0; i < names.length; i++) {

			names[i] = arr.getString(i);

		}

		return names;

	}

	public static String getDisplayName(String username) throws JSONException, UnirestException {

		return getPlayer(username).getString("displayname");

	}

	public static JSONObject getPlayer(String username) throws JSONException, UnirestException {

		if (player == null) {

			player = getProfile(username).getJSONObject("player");

		}

		return player;

	}

	public static String getUUID(String username) throws UnirestException {

		String url = "https://api.mojang.com/users/profiles/minecraft/" + username;

		HttpRequest req = Unirest.get(url);

		JsonNode node = req.asJson().getBody();
		String uuid = node.getObject().getString("id");

		return uuid;

	}

	public static JSONObject getProfile(String username) throws UnirestException {

		if (profile == null) {

			String url = "https://api.hypixel.net/player?uuid=" + getUUID(username) + "&key="
					+ key;
			HttpRequest req = Unirest.get(url);

			JsonNode node = req.asJson().getBody();

			profile = node.getObject();

		}

		return profile;

	}

	public static JSONObject getSkyBlockProfileInfo(String username, String profileName)
			throws JSONException, UnirestException {

		SkyBlockProfile[] profiles = getProfiles(username);

		String id = "";

		for (int i = 0; i < profiles.length; i++) {

			if (profiles[i].name.equals(profileName)) {

				id = profiles[i].id;
				break;

			}

		}

		String url = "https://api.hypixel.net/skyblock/profile?key=" + key + "&profile="
				+ id;

		System.out.println(url);

		HttpRequest req = Unirest.get(url);
		JsonNode node = req.asJson().getBody();

		return node.getObject();

	}

	public static String decompressString(String str) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DeflaterOutputStream dos = new DeflaterOutputStream(baos);
		dos.write(str.getBytes());
		dos.flush();
		dos.close();

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		InflaterInputStream iis = new InflaterInputStream(bais);

		String result = "";
		byte[] buf = new byte[5];
		int rlen = -1;
		while ((rlen = iis.read(buf)) != -1) {

			result += new String(Arrays.copyOf(buf, rlen));

		}

		return result;

	}

	public static String ConvertFromEpoc(int num) {

		Date date = new Date(num);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = format.format(date);
		format.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		formatted = format.format(date);

		return formatted;

	}

	public static String decompress(byte[] compressed) throws IOException {

		if (compressed == null || compressed.length == 0) {

			throw new IllegalArgumentException("Cannot Decrompress Null or Empty Bytes");

		}

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
		GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream);
		InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuilder output = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {

			output.append(line);

		}

		return output.toString();
	}

	public static String[] toStringArray(JSONArray array) {
		if (array == null)
			return null;

		String[] arr = new String[array.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = array.optString(i);
		}
		return arr;
	}

}
