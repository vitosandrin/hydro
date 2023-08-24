package com.boxxsoftwarehouse.hydro.services;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class WebScrappingService {

	public Document connect (String link) {
		Document document = null;
		try {
			document = Jsoup.connect("https://google.com").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
}
