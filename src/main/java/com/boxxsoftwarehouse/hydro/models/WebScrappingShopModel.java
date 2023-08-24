package com.boxxsoftwarehouse.hydro.models;

public class WebScrappingShopModel {

	private String title;
	private String price;
	private String advertiser;

	public WebScrappingShopModel() {
	}

	public WebScrappingShopModel(String title, String price, String advertiser) {
		super();
		this.title = title;
		this.price = price;
		this.advertiser = advertiser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(String advertiser) {
		this.advertiser = advertiser;
	}

}
