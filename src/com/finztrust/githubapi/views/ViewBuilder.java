package com.finztrust.githubapi.views;

import com.finztrust.githubapi.helpers.Helpers;

public class ViewBuilder {
	public static Viewable getView(String type) {
		switch (type) {
		case Helpers.DEV_ENVIRONMENT:
			return new ConsoleView();
		case Helpers.PROD_ENVIRONMENT:
			return new ProductView();

		default:
			return new ConsoleView();
		}
	}
}
