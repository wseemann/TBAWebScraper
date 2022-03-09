package com.wseemann.tbawebscraper;

import com.wseemann.tbawebscraper.models.BracketWithCompetitors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TBAWebScraper {
    public static void main(String[] args) {
        List<BracketWithCompetitors> bracketWithCompetitorsList;

        try {
            TBAWebScraper tbaWebScraper = new TBAWebScraper();
            bracketWithCompetitorsList = tbaWebScraper.scrape();
            System.out.println("Scrape was successful: " + bracketWithCompetitorsList.size());
        } catch (IOException ex) {
            System.out.println("An error occurred while scraping: " + ex.getMessage());
        }
    }

    public TBAWebScraper() {

    }

    public List<BracketWithCompetitors> scrape() throws IOException, NumberFormatException {
        List<BracketWithCompetitors> bracketWithCompetitorsList = new ArrayList<>();

        WebScraper webScraper = new WebScraperImpl();

        for (String url : Constants.urls) {
            bracketWithCompetitorsList.addAll(webScraper.scrape(url));
        }

        return bracketWithCompetitorsList;
    }
}
