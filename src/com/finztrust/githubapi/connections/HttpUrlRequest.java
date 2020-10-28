package com.finztrust.githubapi.connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.finztrust.githubapi.helpers.Helpers;

/*
 * HttpUrlRequest Class: 
 * is used for connecting to resource through java.net.HttpURLConnection class
 * which is supported in JRE 8.
 * 
 */
public class HttpUrlRequest implements Connectable {
	private static HttpURLConnection connection;

	@Override
	public String getRequest(String strURL) {
		StringBuffer response = new StringBuffer();
		try {
			URL url = new URL(strURL);
			connection = (HttpURLConnection) url.openConnection();

			// Request Setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(Helpers.CONNECTION_TIMEOUT);
			connection.setReadTimeout(Helpers.CONNECTION_TIMEOUT);

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
					// line = reader.readLine();
				}
				reader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		return response.toString();
	}

}
