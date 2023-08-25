package com.boxxsoftwarehouse.hydro.services;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class WebScrappingService {
	private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/117.0";

	public Document searchOnGoogleShop (String searchTerm) {
		Document document = null;
		try {
			document = Jsoup.connect("https://google.com.br/search?q=" + searchTerm + "&tbm=shop&source=lnms").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
}
