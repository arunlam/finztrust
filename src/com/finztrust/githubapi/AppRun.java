package com.finztrust.githubapi;

import com.finztrust.githubapi.helpers.Helpers;
import com.finztrust.githubapi.views.ViewBuilder;

public class AppRun {

	public static void main(String[] args) {

		String javaEnv = System.getProperty("java.version");
		if (javaEnv != null) {
			Helpers.JAVAENV = javaEnv;

			// Helpers.DEV_ENVIRONMENT (Console view),
			// Helpers.PROD_ENVIRONMENT (Production View)
			ViewBuilder.getView(Helpers.DEV_ENVIRONMENT).showView();
		} else {
			System.out.println("Please install JAVA Environment. Java Version 11 is recommended.");
		}
	}

}
