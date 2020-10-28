package com.finztrust.githubapi.models;

public class Users {
	private int id;
	private String loginName;
	private String urlProfile;
	private String urlUserApi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUrlProfile() {
		return urlProfile;
	}

	public void setUrlProfile(String urlProfile) {
		this.urlProfile = urlProfile;
	}

	public String getUrlUserApi() {
		return urlUserApi;
	}

	public void setUrlUserApi(String urlUserApi) {
		this.urlUserApi = urlUserApi;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", loginName=" + loginName + ", urlProfile=" + urlProfile + ", urlUserApi="
				+ urlUserApi + "]";
	}

}
