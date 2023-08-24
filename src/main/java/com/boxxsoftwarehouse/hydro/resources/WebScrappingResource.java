package com.boxxsoftwarehouse.hydro.resources;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boxxsoftwarehouse.hydro.services.WebScrappingService;

@RestController
public class WebScrappingResource {
	@Autowired
	private WebScrappingService webScrappingService;

	@GetMapping("/scrapping/google")
	public ResponseEntity<String> findFirstSearchResult(@RequestParam("term") String searchTerm) {
		Document document = this.webScrappingService.searchOnGoogleShop(searchTerm);

		String title = document.select(
				"div.sh-dgr__gr-auto:nth-child(7) > div:nth-child(1) > div:nth-child(2) > span:nth-child(2) > a:nth-child(1) > div:nth-child(1) > h3:nth-child(1)")
				.first().text();
		String price = document.select("span.QIrs8:nth-child(4)").first().text();
		return ResponseEntity.ok().body("First Result Title: " + title + " and your price is: " + price);
	}
}
