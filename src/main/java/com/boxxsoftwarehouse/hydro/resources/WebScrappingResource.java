package com.boxxsoftwarehouse.hydro.resources;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boxxsoftwarehouse.hydro.models.WebScrappingShopModel;
import com.boxxsoftwarehouse.hydro.services.WebScrappingService;

@RestController
@RequestMapping("/scrapping")
public class WebScrappingResource {
	@Autowired
	private WebScrappingService webScrappingService;

	@GetMapping("/google")
	public ResponseEntity<List<WebScrappingShopModel>> searchResults(@RequestParam("term") String searchTerm) {
		Document document = this.webScrappingService.searchOnGoogleShop(searchTerm);

		
		Elements titleElements = document.getElementsByClass("aULzUe IuHnof");
		Elements merchantElements = document.getElementsByClass("E5ocAb");
        Elements priceElements = document.select("span.QIrs8:matches(^R\\$)");
        
		List<WebScrappingShopModel> shopModels = new ArrayList<>();
		 // Determine the maximum number of elements available for iteration
	    int maxIteration = Math.min(titleElements.size(), Math.min(priceElements.size(), merchantElements.size()));

	    for (int i = 0; i < maxIteration; i++) {
	        String title = titleElements.get(i).text();
	        String price = priceElements.get(i).text();
	        String merchant = merchantElements.get(i).text();

	        WebScrappingShopModel shopModel = new WebScrappingShopModel(title, price, merchant);
	        shopModels.add(shopModel);
	    }

		return ResponseEntity.ok().body(shopModels);
	}
}
