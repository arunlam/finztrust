package com.finztrust.githubapi.connections;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.finztrust.githubapi.helpers.Helpers;

/*
 * HttpClientRequest Class: 
 * is used for connecting to resource through java.net.http.HttpClient class
 * which is supported in JRE 11 or higher
 * 
 */
public class HttpClientRequest implements Connectable {
	@Override
	public String getRequest(String strURL) {
		if (Helpers.validateUrl(strURL)) {

			try {
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(strURL)).build();
				return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
						.join();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Helpers.ERR_URL_INVALID;
			}
		} else {
			return Helpers.ERR_URL_INVALID;
		}
	}
}
