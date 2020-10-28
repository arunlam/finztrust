package com.finztrust.githubapi.connections;

import com.finztrust.githubapi.helpers.Helpers;

public class GithubApiConneciton {
	private GithubApiConneciton() {

	}

	private static GithubApiConneciton instance = new GithubApiConneciton();

	public static GithubApiConneciton getInstance() {
		return instance;
	}

	public Connectable getConnection(String type) {

		// Checking JRE 11 or higher - HttpClient supported
		int javaenv = Integer.parseInt(Helpers.JAVAENV.substring(0, Helpers.JAVAENV.indexOf(".")));

		if (javaenv < 11) {
			return new HttpUrlRequest();
		} else {
			switch (type) {
			case Helpers.HTTP_CLIENT:
				return new HttpClientRequest();
			case Helpers.HTTP_URL:
				return new HttpUrlRequest();
			default:
				return new HttpClientRequest();
			}
		}

	}
}
