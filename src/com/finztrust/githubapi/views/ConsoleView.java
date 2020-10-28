package com.finztrust.githubapi.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.finztrust.githubapi.helpers.Helpers;
import com.finztrust.githubapi.models.Users;
import com.finztrust.githubapi.models.UsersDAO;

public class ConsoleView implements Viewable {
	private HashMap<Integer, Users> users;

	@Override
	public boolean showView() {
		System.out.println("<<<<< CONSOLE APPLICATION >>>>>");
		System.out.print("     Data is downloading... ");

		UsersDAO userDao = new UsersDAO();

		// PULL DATA FROM API GITHUB USER
		users = userDao.downloadData();

		if (users == null) {
			System.out.print("Program had been exit.");
			return false;
		}

		System.out.println("[done]");

		String existingUserID;
		if (users.size() == 0) {
			existingUserID = "";
			Helpers.showMessage("There is no data to display.");
		} else {
			// GETTING EXISTING USER ID
			existingUserID = users.keySet().stream().map(key -> key.toString())
					.collect(Collectors.joining(",", "[", "]"));
			Helpers.showMessage("Available USER ID to search:", existingUserID);
		}
		// DISPLAY EXISTING USER ID

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;

		do {
			try {
				System.out.print("Please type user id: ");
				input = reader.readLine().trim();

				// TO EXIT PROGRAM, TYPE '0' OR 'EXIT'
				if (input.equals("0") || input.equalsIgnoreCase("exit"))
					break;

				if (input.isEmpty())
					continue;

				if (Helpers.validateIneger(input) && users.containsKey(Integer.parseInt(input))) {
					Helpers.showMessage("User ID (" + input + ") Details: ",
							userDao.showUserDetail(Integer.parseInt(input)));

				} else {
					Helpers.showMessage("Please try the User ID within the list below:", existingUserID);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} while (true);
		System.out.println("***** HAVE A NICE DAY! *****");
		return true;
	}
}
