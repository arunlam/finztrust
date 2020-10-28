package com.finztrust.githubapi.models;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.finztrust.githubapi.connections.Connectable;
import com.finztrust.githubapi.connections.GithubApiConneciton;
import com.finztrust.githubapi.helpers.Helpers;

public class UsersDAO {

	private Connectable conn = GithubApiConneciton.getInstance().getConnection(Helpers.HTTP_CLIENT);

	private HashMap<Integer, Users> usersList = new HashMap<Integer, Users>();

	public HashMap<Integer, Users> getUserList() {
		return usersList;
	}

	/*
	 * showUserDetail() function: is to get the detail of specific user by its ID .
	 * The data needed are in the details resource
	 */
	public String showUserDetail(int userId) {
		String output = "";
		if (usersList.size() > 0) {
			// CONNECT TO USER DETAILS
			String response = conn.getRequest(usersList.get(userId).getUrlUserApi());

			try {
				JSONObject userDetail = new JSONObject(response);

				output = String.format("  Login Name: %s\n", userDetail.get("login"));
				output += String.format("     User Profile's Link: %s\n", userDetail.get("html_url"));
				output += String.format("     Number of Repository: %s\n", userDetail.get("public_repos"));
				output += String.format("     Number of Followers: %s\n", userDetail.get("followers"));
				output += String.format("     Number of Following: %s", userDetail.get("following"));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return output;
		} else {
			return Helpers.ERR_NO_DATA;
		}

	}

	/*
	 * downloadData() function: is to pull the data from API Github User and return
	 * data only with # of DATA_LOAD.
	 * 
	 * In case of DATA_LOAD is greater than # of Users from API Github User
	 * DATA_LOAD have to be equal to # of API Github User
	 */
	public HashMap<Integer, Users> downloadData() {
		String response = conn.getRequest(Helpers.GITHUB_API_USERS);

		try {
			JSONArray jsonResponse = new JSONArray(response);

			if (Helpers.DATA_LOAD > jsonResponse.length()) {
				Helpers.DATA_LOAD = jsonResponse.length();
			}

			for (int i = 0; i < Helpers.DATA_LOAD; i++) {
				JSONObject objUser = jsonResponse.getJSONObject(i);
				Users user = new Users();
				user.setId(objUser.getInt("id"));
				user.setLoginName(objUser.getString("login"));
				user.setUrlProfile(objUser.getString("html_url"));
				user.setUrlUserApi(objUser.getString("url"));

				usersList.put(objUser.getInt("id"), user);
			}
		} catch (JSONException e) {
			// e.printStackTrace();
			Helpers.showMessage("Invalid resource [NOT JSON DATA]", "Please check the url or resource");
			return null;
		}

		return usersList;
	}
}
