package com.finztrust.githubapi.views;

public class ProductView implements Viewable {
	@Override
	public boolean showView() {
		System.out.println("FOR PRODUCTION VIEW");
		return true;
	}
}
