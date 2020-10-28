package com.finztrust.githubapi.helpers;

public class Helpers {
	public static String JAVAENV;
	// ENVIRONMENT
	public static final String DEV_ENVIRONMENT = "console";
	public static final String PROD_ENVIRONMENT = "production";

	// CONNECTIONS
	public static final String HTTP_CLIENT = "HttpClientConnection";
	public static final String HTTP_URL = "HttpURLConnection";

	// URL STRINGS
	public static int DATA_LOAD = 20;
	public static final String GITHUB_API_HOST = "https//api.github.com";
	public static final String GITHUB_API_USERS = "https://api.github.com/users";

	// ERROR MESSAGES
	public static final String ERR_URL_INVALID = "Invalid URL";
	public static final String ERR_NO_DATA = "There is no data to display.";

	public static final int CONNECTION_TIMEOUT = 5000;

	// UTILITIES - Functions or Methods
	public static boolean validateIneger(String input) {
		try {
			return Integer.parseInt(input) >= 0;
		} catch (NumberFormatException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean validateFloat(String input) {
		try {
			return Float.parseFloat(input) >= 0.0f;

		} catch (NumberFormatException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean validateUrl(String url) {
		String url_regex = "^(http|https|ftp)://.*$";
		return (url.matches(url_regex));
	}

	public static void showMessage(String message, Object... args) {
		System.out.println("\n============================================================");
		System.out.println("   " + message);

		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.println("   " + args[i].toString());
			}
		}

		System.out.println("  --------------------------------------------------------");
		System.out.println("   Type '0' or 'exit' to exit the program.");
		System.out.println("============================================================\n");

	}
}
